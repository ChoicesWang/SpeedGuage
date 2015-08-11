package com.choices.animdemo.interpolator;

import android.animation.TimeInterpolator;

public class EaseInBackInterpolator implements TimeInterpolator {

    private static final float s = 1.70158f;

    @Override
    public float getInterpolation(float input) {
        return input * input * ((s + 1) * input - s);
    }

}
