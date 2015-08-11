package com.choices.animdemo.interpolator;

import android.animation.TimeInterpolator;

public class EaseInOutElasticInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolation(float input) {
        if (input == 0f) {
            return 0f;
        }
        if ((input *= 2) >= 2.0f) {
            return 1.0f;
        }

        float p = 0.3f * 1.5f;
        float s = p / 4;
        if (input < 1.0f) {
            return (float) (-0.5 * Math.pow(2, 10 * (input -= 1)) * Math.sin((input - s) * (2 * Math.PI) / p));
        } else {
            return (float) (0.5f * Math.pow(2, -10 * (input -= 1)) * Math.sin((input - s) * (2 * Math.PI) / p)) + 1;
        }

    }

}
