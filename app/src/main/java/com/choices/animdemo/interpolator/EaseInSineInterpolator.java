package com.choices.animdemo.interpolator;

import android.animation.TimeInterpolator;

public class EaseInSineInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolation(float input) {
        return (float) (1 - Math.cos(input * (Math.PI / 2)));
    }

}
