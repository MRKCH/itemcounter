package com.kch.itemcounter;

import android.util.Log;

/**
 * Created by kch on 2016/9/22.
 */

public class MyUtils {
    public static String timeToString(int timeLength) {
        int min = Math.round((timeLength/1000)/ 60);
        int second = Math.round((timeLength/1000) % 60);
        Log.e("min",min+"");
        Log.e("second",second+"");

        if (timeLength <=0) {
            return "00:00";
        } else if (timeLength >0) {
            if (min < 10 && second < 10)
                return "0" + min +":"+ "0" + second;
            if (min < 10 && second >= 10)
                return "0" + min +":"+ second;
            if (min >= 10 && second < 10)
                return min +":"+ "0" + second;
            if (min >= 10 && second >= 10)
                return min  +":" + second;
        }
        return null;
    }
}
