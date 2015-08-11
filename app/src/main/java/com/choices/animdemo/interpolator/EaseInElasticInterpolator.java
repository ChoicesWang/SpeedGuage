package com.choices.animdemo.interpolator;

import android.animation.TimeInterpolator;

public class EaseInElasticInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolation(float input) {
        if (input == 0f) {
            return 0f;
        }
        if (input == 1.0f) {
            return 1.0f;
        }
        float p = 0.3f;
        float s = p / 4;
        input -= 1;
        return (float) (-Math.pow(2, 10 * input) * Math.sin((input - s) * (2 * Math.PI / p)));

    }

}
