package com.choices.animdemo.interpolator;

import android.animation.TimeInterpolator;

public class EaseInQuintInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolation(float input) {
        return input * input * input * input * input;
    }

}
