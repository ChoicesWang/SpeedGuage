package com.choices.animdemo.interpolator;

import android.animation.TimeInterpolator;


public class EaseOutQuintInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolation(float input) {
        input -= 1;
        return 1 + input * input * input * input * input;
    }

}
