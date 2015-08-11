package com.choices.animdemo.interpolator;

import android.animation.TimeInterpolator;

public class EaseInOutQuadInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolation(float input) {
        if ((input *= 2) < 1.0f) {
            return 0.5f * input * input;
        }

        return 0.5f * (1 - (--input) * (input - 2));
    }

}
