package com.blackphoenix.phoenixdatabase.v1;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * Created by kodwell on 1/30/2017.
 */

public class SharedPreferenceManager {

    private Context context;
    private SharedPreferences prefs;
    private Editor editor;
    private String PREFS_NAME = "esos";


    public SharedPreferenceManager(Context context, String prefName)
    {
        this.context = context;
        this.PREFS_NAME = prefName;
    }

    public void connect()
    {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public boolean commit()
    {
        return editor.commit();
    }

    public void apply()
    {
        editor.apply();

    }

    public void clear()
    {
        editor.clear();
    }

    public void remove(String key){
        editor.remove(key);
        editor.apply();
    }

    /*
        INTEGER
     */
    public void setInt(String key, int value)
    {
        editor.putInt(key, value);
        editor.apply();
    }

    public int getInt(String key)

    {
        return prefs.getInt(key, 1);
    }

    /*
        FLOAT
     */


    public void setFloat(String key, float value)
    {
        editor.putFloat(key, value);
        editor.apply();
    }

    public float getFloat(String key)
    {
        return prefs.getFloat(key,0);
    }


    /*
        BOOLEAN
     */



    public void setBoolean(String key, boolean value)
    {
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBoolean(String key)
    {
        return prefs.getBoolean(key, false);
    }


    /*
        STRING
     */


    public void setString(String key, String value)
    {
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key)
    {
        return prefs.getString(key, "");
    }


    public boolean containsKey(String key){
        return prefs.contains(key);
    }
}
