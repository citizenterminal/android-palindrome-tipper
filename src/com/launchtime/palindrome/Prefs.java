package com.launchtime.palindrome;

import android.os.Bundle;
import android.preference.PreferenceActivity;


public class Prefs extends PreferenceActivity
{

    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.prefs);
    }

}


