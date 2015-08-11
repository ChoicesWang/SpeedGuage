package com.choices.animdemo.interpolator;

import android.animation.TimeInterpolator;


public class EaseOutQuadInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolation(float input) {
        return input * (2 - input);
    }

}
