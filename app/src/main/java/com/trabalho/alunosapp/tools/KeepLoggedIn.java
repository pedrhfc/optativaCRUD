package com.trabalho.alunosapp.tools;

import android.content.Context;
import android.content.SharedPreferences;

public class KeepLoggedIn {

    private static final String PREF_ID = "alunosapp";

    public static void setValuesBoolean(Context context, String key, boolean value) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_ID, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static boolean getValuesBoolean(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_ID, 0);
        return preferences.getBoolean(key, false);
    }

    public static void setValuesString(Context context, String key, String value) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_ID, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getValuesString(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_ID, 0);
        return preferences.getString(key, "");
    }
}
