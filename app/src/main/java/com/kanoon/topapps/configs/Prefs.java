package com.kanoon.topapps.configs;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ehsan on 2/19/2018.
 */

public class Prefs {
    private static SharedPreferences appPrefs;
    private static String s = "AppPrefs";

    public static final String PREF_IS_LOGGED_IN = "isLoggedIn";
    public static final String PREF_FIRST_NAME = "firstName";
    public static final String PREF_LAST_NAME = "lastName";
    public static final String PREF_UNIVERSITY = "university";
    public static final String PREF_AVATAR = "avatarPath";
    public static final String PREF_NATIONAL_CODE = "nationalCode";
    public static final String PREF_MOBILE_NUMBER = "mobileNumber";
    public static final String PREF_EMAIL = "email";
    public static final String PREF_IDENTITY_PIC = "identityPic";
    public static final String PREF_RESULT_PIC = "resultPic";
    public static final String PREF_TOKEN = "token";


    public static SharedPreferences getAppPrefs(Context context) {
        appPrefs = context.getSharedPreferences(s, Context.MODE_PRIVATE);
        return appPrefs;
    }
}
