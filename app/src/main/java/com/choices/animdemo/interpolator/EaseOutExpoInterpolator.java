package com.choices.animdemo.interpolator;

import android.animation.TimeInterpolator;

public class EaseOutExpoInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolation(float input) {
        if (input == 1.0f) {
            return 1.0f;
        }
        return (float) (1 - Math.pow(2, -10 * input));
    }

}
