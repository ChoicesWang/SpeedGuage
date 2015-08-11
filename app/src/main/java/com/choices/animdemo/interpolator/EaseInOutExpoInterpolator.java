package com.choices.animdemo.interpolator;

import android.animation.TimeInterpolator;

public class EaseInOutExpoInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolation(float input) {
        if (input == 0f) {
            return 0f;
        }
        if (input == 1.0f) {
            return 1.0f;
        }
        if ((input *= 2) < 1.0f) {
            return (float) (0.5 * Math.pow(2, 10 * (input - 1)));
        }
        return (float) (0.5 * (2 - Math.pow(2, -10 * (input - 1))));
    }

}
