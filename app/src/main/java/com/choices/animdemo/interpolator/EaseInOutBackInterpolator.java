package com.choices.animdemo.interpolator;

import android.animation.TimeInterpolator;

public class EaseInOutBackInterpolator implements TimeInterpolator {

    private static final float s = 1.70158f * 1.525f;

    @Override
    public float getInterpolation(float input) {
        if ((input *= 2) < 1.0f) {
            return 0.5f * (input * input * ((s + 1) * input - s));
        }

        input -= 2;
        return 0.5f * (input * input * ((s + 1) * input + s) + 2);
    }

}
