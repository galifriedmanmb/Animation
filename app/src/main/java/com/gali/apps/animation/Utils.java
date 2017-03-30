package com.gali.apps.animation;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;

/**
 * Created by 1 on 3/30/2017.
 */

public class Utils {

    private static int colorCounter = 1;

    public static float convertDpToPixel(float dp, Activity activity){
        Resources resources = activity.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    public static int getRandomBaloonBitmap() {
        //int i = (int)Math.ceil(Math.random()*7);
        int i = colorCounter;
        colorCounter++;
        if (colorCounter==8)
            colorCounter = 0;
        switch (i) {
            case 1:
                return R.drawable.baloon_black;
            case 2:
                return R.drawable.baloon_blue;
            case 3:
                return R.drawable.baloon_green;
            case 4:
                return R.drawable.baloon_orange;
            case 5:
                return R.drawable.baloon_purple;
            case 6:
                return R.drawable.baloon_red;
            case 7:
                return R.drawable.baloon_white;
            default:
                return R.drawable.baloon_orange;
        }
    }
}
