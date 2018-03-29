package com.kanoon.topapps.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kanoon.topapps.R;
import com.kanoon.topapps.configs.Prefs;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private View header;

    private TextView nameHeader;
    private TextView uniHeader;
    private ImageView avatarHeader;

    private SharedPreferences appPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        appPrefs = Prefs.getAppPrefs(getApplicationContext());

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        View header = navigationView.getHeaderView(0);
        nameHeader = (TextView) header.findViewById(R.id.name);
        uniHeader = (TextView) header.findViewById(R.id.university);
        avatarHeader = (ImageView) header.findViewById(R.id.profile_avatar);

        setupHeader();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddTaskActivity.class);
                startActivity(i);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.mainFragment, new Activities()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_add) {
            Intent i = new Intent(MainActivity.this, AddTaskActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_activities) {

        } else if (id == R.id.nav_profile) {

        } else if (id == R.id.nav_aboutus) {
            Intent i = new Intent(MainActivity.this, AddTaskActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_help) {

        } else if (id == R.id.nav_logout) {
            SharedPreferences.Editor editor = appPrefs.edit();
            editor.putBoolean("isNotLoggedin", true);
            editor.commit();
            Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(loginIntent);
            finish();
        } else if (id == R.id.nav_exit) {
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    void setupHeader() {
        nameHeader.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/sl.ttf"));
        uniHeader.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/sl.ttf"));
        nameHeader.setText(appPrefs.getString("name", "") + " " + appPrefs.getString("lastName",""));
        uniHeader.setText(appPrefs.getString("uni", ""));

        Glide.with(getApplicationContext())
                .load(appPrefs.getString("avatarPath", ""))
                .into(avatarHeader);
    }
}
