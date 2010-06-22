package com.launchtime.palindrome;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View.*;
import android.view.View;
import android.widget.*;

public class PalindromeTip extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.xml.main);

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        final TextView tip = (TextView) findViewById(R.id.tip);
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    final EditText amount = (EditText) findViewById(R.id.amount);
                    final String amt = amount.getText().toString();
                    if ("".equals(amt)) return;

                    String pct = prefs.getString("tipPct", "15");
                    TipCalculator c = new TipCalculator(pct);
                    final String tipAmt = c.compute(amt);
                    tip.setText(tipAmt);
                }
            });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
      MenuInflater inflater = getMenuInflater();
      Log.d("Palindrome Tipper", "getMenuInflater");
      inflater.inflate(R.menu.menu, menu);
      Log.d("Palindrome Tipper", "inflater.inflate");
      return true;
    }

    // Called when menu item is selected //
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId()) {

        case R.id.menuPrefs:
            // Launch Prefs activity
            Intent i = new Intent(this, Prefs.class);
            startActivity(i);
            Log.d("Palindrome Tipper", "MenuPrefs starting Prefs");
            break;
        }
      return true;
    }
}
