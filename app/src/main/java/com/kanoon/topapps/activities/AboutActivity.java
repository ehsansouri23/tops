package com.kanoon.topapps.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.kanoon.topapps.R;

public class AboutActivity extends AppCompatActivity {

    private TextView aboutHelp, aboutTopsTitle, aboutCredits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        aboutHelp = (TextView) findViewById(R.id.about_help);
        aboutTopsTitle = (TextView) findViewById(R.id.about_tops_title);
        aboutCredits = (TextView) findViewById(R.id.about_credits);

        aboutHelp.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/sl.ttf"));
        aboutTopsTitle.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/sl.ttf"));
        aboutCredits.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/sl.ttf"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_back:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
