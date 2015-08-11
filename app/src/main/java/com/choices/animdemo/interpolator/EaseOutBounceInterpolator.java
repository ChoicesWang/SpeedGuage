package com.choices.animdemo.interpolator;

import android.animation.TimeInterpolator;

public class EaseOutBounceInterpolator implements TimeInterpolator {

    private static final float s = 1.70158f;

    @Override
    public float getInterpolation(float input) {
        if (input < 1 / 2.75f) {
            return 7.5625f * input * input;
        } else if (input < 2 / 2.75f) {
            input -= 1.5f / 2.75f;
            return 7.5625f * input * input + 0.75f;
        } else if (input < 2.5f / 2.75f) {
            input -= 2.25f / 2.75f;
            return 7.5625f * input * input + 0.9375f;
        } else {
            input -= 2.625f / 2.75f;
            return 7.5625f * input * input + 0.984375f;
        }
    }

}
