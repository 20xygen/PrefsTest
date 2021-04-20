package com.example.prefstest;

import android.content.Context;
import android.content.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ValuesHolder {
    public static final String APP_PREFERENCES = "mysettings";

    public static final String APP_PREFERENCES_NAME = "Nickname"; // имя кота
    public static final String APP_PREFERENCES_AGE = "Age"; // возраст кота
    public static final String APP_PREFERENCES_INTEGER = "IntValue"; // возраст кота

    SharedPreferences mSettings;
    SharedPreferences.Editor editor;

    public ValuesHolder(Context context){
        mSettings = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSettings.edit();
        editor.apply();
    }

    public void saveValue(Integer integer, String string){
        switch (integer){
            case 1:
                System.out.println("Save path 1");
                System.out.println(string);
                System.out.println(editor);
                SharedPreferences.Editor editor1 = mSettings.edit();
                editor1.putString(APP_PREFERENCES_NAME, string);
                editor1.apply();
                break;
            case 2:
                System.out.println("Save path 2");
                SharedPreferences.Editor editor2 = mSettings.edit();
                editor2.putString(APP_PREFERENCES_AGE, string);
                editor2.apply();
                break;
            default:
                System.out.println("Save path 3");
                break;
        }
    }

    public void saveInt(Integer value){
        SharedPreferences.Editor editor3 = mSettings.edit();
        editor3.putInt(APP_PREFERENCES_INTEGER, value);
        editor3.apply();
    }

    public String loadValue(Integer integer){
        switch (integer){
            case 1:
                System.out.println("Load path 1");
                if(mSettings.contains(APP_PREFERENCES_NAME)) {
                    System.out.println("contains");
                    return mSettings.getString(APP_PREFERENCES_NAME, "");
                }
                break;
            case 2:
                System.out.println("Load path 2");
                if(mSettings.contains(APP_PREFERENCES_AGE)) {
                    System.out.println("contains");
                    return mSettings.getString(APP_PREFERENCES_AGE, "");
                }
                break;
            default:
                System.out.println("Load path 3");
                return "default";
        }
        return "default";
    }

    public Integer loadInt(){
        if(mSettings.contains(APP_PREFERENCES_INTEGER)) {
            return mSettings.getInt(APP_PREFERENCES_INTEGER, 0);
        }
        return 0;
    }
}
