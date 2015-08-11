package com.choices.animdemo.interpolator;

import android.animation.TimeInterpolator;

public class EaseOutCircInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolation(float input) {
        input -= 1;
        return (float) (Math.sqrt(1 - input * input));
    }

}
