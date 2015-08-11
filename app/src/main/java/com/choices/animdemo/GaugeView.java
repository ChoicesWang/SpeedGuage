package com.choices.animdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * 仪表
 * Created by Administrator on 2015/8/11.
 */
public class GaugeView extends View {


    private Paint mLinePaint;
    private Paint mLineHeader;
    private Paint mBallPaint;
    private Paint mBlackPaint;

    private Path mPath;
    private Rect mFrame;

    private float mAnimX;
    private float mAnimY;
    private boolean mStartAnim;

    public GaugeView(Context context) {
        this(context, null);
    }

    public GaugeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GaugeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }

    private void init() {

        mLinePaint = new Paint();
        mLinePaint.setColor(0xFFE91E63); // 粉色
        mLinePaint.setAntiAlias(true);
        mLinePaint.setStyle(Paint.Style.STROKE);
        mLinePaint.setStrokeMiter(5);
        mLinePaint.setPathEffect(new CornerPathEffect(2.5f));

        mLineHeader = new Paint();
        mLineHeader.setColor(0xFFF44336); //红色
        mLineHeader.setAntiAlias(true);
        mLineHeader.setStyle(Paint.Style.FILL);

        mBallPaint = new Paint();
        mBallPaint.setColor(0xFF00B0FF); // 蓝色
        mBallPaint.setAntiAlias(true);
        mBallPaint.setStyle(Paint.Style.FILL);

        mBlackPaint = new Paint();
        mBlackPaint.setColor(Color.BLACK);
        mBlackPaint.setAntiAlias(true);
        mBlackPaint.setStyle(Paint.Style.STROKE);
        mBlackPaint.setStrokeMiter(7);
        mBlackPaint.setTextSize(20);

        mFrame = new Rect();
        mPath = new Path();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        int left = 70;
        int cWidth = width - left * 2;
        int cHeight = cWidth * 9 / 16;
        int top = (height - cHeight) / 2;
        int right = left + cWidth;
        int bottom = top + cHeight;

        mFrame.set(left, top, right, bottom);

        mAnimX = mFrame.left;
        mAnimY = mFrame.top;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(mFrame, mBlackPaint);
        canvas.drawPath(mPath, mLinePaint);
        canvas.drawCircle(mAnimX, mAnimY, 10, mLineHeader);
        canvas.drawCircle(mFrame.left, mAnimY, 20, mBallPaint);

        canvas.drawText("Y-axis", 8, mFrame.bottom - mFrame.top - 25, mBlackPaint);
        canvas.drawText("Time", mFrame.width() / 2 + 50, mFrame.bottom + 25, mBlackPaint);
    }


    public void onAnimate(float timeFraction, float animFraction) {

        if (timeFraction < 0) {
            timeFraction = 0;
        } else if (timeFraction > 1) {
            timeFraction = 1;
        }

        mAnimX = timeFraction * mFrame.width() + mFrame.left;
        mAnimY = animFraction * mFrame.height() + mFrame.top;
        if (!mStartAnim) {
            mStartAnim = true;
            mPath.moveTo(mAnimX, mAnimY);
        }

        mPath.lineTo(mAnimX, mAnimY);
        invalidate();
    }

    public void reset() {
        mPath.reset();
        mAnimY = mFrame.top;
        mStartAnim = false;
        invalidate();
    }
}
