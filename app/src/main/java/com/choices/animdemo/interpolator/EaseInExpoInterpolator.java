package com.choices.animdemo.interpolator;

import android.animation.TimeInterpolator;

public class EaseInExpoInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolation(float input) {
        if (input == 0f) {
            return 0;
        }
        return (float) Math.pow(2, 10 * (input - 1));
    }

}
