package com.choices.animdemo.interpolator;

import android.animation.TimeInterpolator;

public class EaseInOutQuartInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolation(float input) {
        if ((input *= 2) < 1.0f) {
            return 0.5f * input * input * input * input;
        }
        input -= 2;
        return 0.5f * (2 - input * input * input * input);
    }

}
