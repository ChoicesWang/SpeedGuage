package com.choices.animdemo;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private static final String IN_PG_NAME = "com.choices.animdemo.interpolator.";

    private GaugeView mGaugeView;

    private ValueAnimator mAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, mInterpolators));
        mListView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectDrawerItem(position);
            }
        });


        mGaugeView = (GaugeView) findViewById(R.id.gaugeView);


        mAnimator = ValueAnimator.ofFloat(1.0f);
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float timeFraction = animation.getCurrentPlayTime() / (float) animation.getDuration();
                float animFraction = (Float) animation.getAnimatedValue();
                mGaugeView.onAnimate(timeFraction, animFraction);

            }
        });
        mAnimator.setDuration(1000);
    }

    private void selectDrawerItem(int position) {
        String name = mInterpolators[position];
        TimeInterpolator interpolator = null;
        try {
            Class clazz = Class.forName(IN_PG_NAME + name);
            interpolator = (TimeInterpolator) clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            Log.e("Choices", "Java 反射异常 ：", e);
        }

        if (interpolator != null) {
            mAnimator.cancel();
            mAnimator.setInterpolator(interpolator);
            mGaugeView.reset();
            mAnimator.start();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private static final String[] mInterpolators = new String[]{
            "EaseInQuadInterpolator",
            "EaseOutQuadInterpolator",
            "EaseInOutQuadInterpolator",
            "EaseInQuartInterpolator",
            "EaseOutQuartInterpolator",
            "EaseInOutQuartInterpolator",
            "EaseInQuintInterpolator",
            "EaseOutQuintInterpolator",
            "EaseInOutQuintInterpolator",
            "EaseInCircInterpolator",
            "EaseOutCircInterpolator",
            "EaseInOutCircInterpolator",
            "EaseInCubicInterpolator",
            "EaseOutCubicInterpolator",
            "EaseInOutCubicInterpolator",
            "EaseInExpoInterpolator",
            "EaseOutExpoInterpolator",
            "EaseInOutExpoInterpolator",
            "EaseInBackInterpolator",
            "EaseOutBackInterpolator",
            "EaseInOutBackInterpolator",
            "EaseInElasticInterpolator",
            "EaseOutElasticInterpolator",
            "EaseInOutElasticInterpolator",
            "EaseInBounceInterpolator",
            "EaseOutBounceInterpolator",
            "EaseInOutBounceInterpolator",
    };
}
