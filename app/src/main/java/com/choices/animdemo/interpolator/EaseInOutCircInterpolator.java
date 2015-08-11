package com.choices.animdemo.interpolator;

import android.animation.TimeInterpolator;

public class EaseInOutCircInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolation(float input) {
        if ((input *= 2) < 1.0f) {
            return (float) (0.5 * (1 - Math.sqrt(1 - input * input)));
        }
        input -= 2;
        return (float) (0.5 * (Math.sqrt(1 - input * input) + 1));
    }

}
