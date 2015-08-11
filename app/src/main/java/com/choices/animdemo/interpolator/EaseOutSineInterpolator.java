package com.choices.animdemo.interpolator;

import android.animation.TimeInterpolator;


public class EaseOutSineInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolation(float input) {
        return (float) (Math.sin(input * (Math.PI / 2)));
    }

}
