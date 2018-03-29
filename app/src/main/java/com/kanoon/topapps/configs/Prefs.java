package com.kanoon.topapps.configs;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ehsan on 2/19/2018.
 */

public class Prefs {
    private static SharedPreferences appPrefs;
    private static String s = "AppPrefs";

    public static SharedPreferences getAppPrefs(Context context) {
        appPrefs = context.getSharedPreferences(s, Context.MODE_PRIVATE);
        return appPrefs;
    }
}
