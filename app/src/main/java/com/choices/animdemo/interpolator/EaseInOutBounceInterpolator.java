package com.choices.animdemo.interpolator;

import android.animation.TimeInterpolator;

public class EaseInOutBounceInterpolator implements TimeInterpolator {

    EaseOutBounceInterpolator out = new EaseOutBounceInterpolator();

    @Override
    public float getInterpolation(float input) {
        if (input < 0.5f) {

            return 0.5f * (1 - out.getInterpolation(1 - input * 2));
        }
        return 0.5f * (1 + out.getInterpolation(input * 2 - 1));
    }

}
