package com.choices.animdemo.interpolator;

import android.animation.TimeInterpolator;


public class EaseInQuadInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolation(float input) {
        return input * input;
    }

}
