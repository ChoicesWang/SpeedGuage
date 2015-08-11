package com.choices.animdemo.interpolator;

import android.animation.TimeInterpolator;


public class EaseInCircInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolation(float input) {
        return (float) (1 - Math.sqrt(1 - input * input));
    }

}
