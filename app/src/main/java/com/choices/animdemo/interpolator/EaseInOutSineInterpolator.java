package com.choices.animdemo.interpolator;

import android.animation.TimeInterpolator;

public class EaseInOutSineInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolation(float input) {
        return (float) (0.5 * (1 - Math.cos(Math.PI * input)));
    }

}
