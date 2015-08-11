package com.choices.animdemo.interpolator;

import android.animation.TimeInterpolator;

public class EaseOutBackInterpolator implements TimeInterpolator {

    private static final float s = 1.70158f;

    @Override
    public float getInterpolation(float input) {
        input -= 1;
        return input * input * ((s + 1) * input + s) + 1;
    }

}
