package com.choices.animdemo.interpolator;

import android.animation.TimeInterpolator;

public class EaseOutCubicInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolation(float input) {
        input -= 1;
        return input * input * input + 1;
    }

}
