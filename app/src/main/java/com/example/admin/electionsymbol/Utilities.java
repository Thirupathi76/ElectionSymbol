package com.example.admin.electionsymbol;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static android.content.Context.MODE_PRIVATE;

public class Utilities {

   /* public static void setPreferncLogin(Context context, String TAG, String value) {
        System.out.println("ContextSet=" + context);
        SharedPreferences preferences = context.getApplicationContext().getSharedPreferences(Constants.LOGIN_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(TAG, value);
        editor.apply();
    }*/

    /*public static String getPreferncLogin(Context context, String TAG) {
        System.out.println("Contextget=" + context);
        SharedPreferences preferences = context.getApplicationContext().getSharedPreferences(Constants.LOGIN_PREFERENCES, MODE_PRIVATE);
        String value = preferences.getString(TAG, "");
        return value;
    }*/

    public static void setBoolean(Context context, String TAG, boolean val){
        SharedPreferences preferences = context.getSharedPreferences(Constants.MYPREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(TAG, val);
        editor.apply();
    }

    public static boolean getBoolean(Context context, String TAG){
        SharedPreferences preferences = context.getSharedPreferences(Constants.MYPREFERENCES, MODE_PRIVATE);
        return preferences.getBoolean(TAG, false);
    }

    public static void setPreference(Context context, String TAG, String value) {
        System.out.println("ContextSet=" + context);
        SharedPreferences preferences = context.getApplicationContext().getSharedPreferences(Constants.MYPREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(TAG, value);
        editor.apply();
    }

    public static void setArrayPreference(Context context, String TAG, ArrayList<String> value) {
        System.out.println("ContextSet=" + context);
        Set<String> data = new HashSet<>();
        data.addAll(value);
        SharedPreferences preferences = context.getApplicationContext().getSharedPreferences(Constants.MYPREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putStringSet(TAG, data);
        editor.apply();
    }

    public static String getPreference(Context context, String TAG) {
        System.out.println("Contextget=" + context);
        SharedPreferences preferences = context.getApplicationContext().getSharedPreferences(Constants.MYPREFERENCES, MODE_PRIVATE);
        String value = preferences.getString(TAG, "");
        return value;
    }

    public static ArrayList<String> getArrayPreference(Context context, String TAG) {
        SharedPreferences preferences = context.getApplicationContext().getSharedPreferences(Constants.MYPREFERENCES, MODE_PRIVATE);
        Set<String> value = preferences.getStringSet(TAG, null);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(arrayList);
        return arrayList;
    }

    public static void clearAllPrefernces(Context context) {
        System.out.println("Contextclear=" + context);
        /*if(Constants.clearing_context!=null)
            context=Constants.clearing_context;*/

        if (context != null) {
            SharedPreferences.Editor editor = context.getApplicationContext().getSharedPreferences(Constants.MYPREFERENCES, Context.MODE_PRIVATE).edit();
            editor.clear();
            editor.apply();
            editor.apply();
        }
        if (context != null) {
            SharedPreferences.Editor editor = context.getApplicationContext().getSharedPreferences("PROJECT_NAME", Context.MODE_PRIVATE).edit();
            editor.clear();
            editor.apply();
            editor.apply();
        }

    }

    public static boolean isFirstRun(Context context, String CHECK){
        SharedPreferences pref = context.getSharedPreferences(CHECK, Context.MODE_PRIVATE);

        boolean isFirst = pref.getBoolean(CHECK, false);
        if (!isFirst) {
            // here you can launch another activity if you like

            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean(CHECK, true);
            editor.apply(); // Very important to save the preference

        }
        return isFirst;
    }

}
