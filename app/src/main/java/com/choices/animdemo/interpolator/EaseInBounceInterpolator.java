package com.choices.animdemo.interpolator;

import android.animation.TimeInterpolator;

public class EaseInBounceInterpolator implements TimeInterpolator {

    EaseOutBounceInterpolator out = new EaseOutBounceInterpolator();

    @Override
    public float getInterpolation(float input) {
        return 1 - out.getInterpolation(1 - input);
    }

}
