package com.kanoon.topapps.activities;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kanoon.topapps.R;
import com.kanoon.topapps.configs.Prefs;
import com.kanoon.topapps.modal.PictureViewerDialog;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";

    private TextView university, name;
    private TextView nationalCode, nationalCodeTitle, mobileNumberTitle, mobileNumber, email, emailTitle;
    private CircleImageView userAvatar;
    private ImageView identityIcon, resultIcon;

    SharedPreferences appPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        appPrefs = Prefs.getAppPrefs(getApplicationContext());

        userAvatar = (CircleImageView) findViewById(R.id.profile_avatar);
        name = (TextView) findViewById(R.id.name);
        university = (TextView) findViewById(R.id.university);
        nationalCode = (TextView) findViewById(R.id.national_code);
        nationalCodeTitle = (TextView) findViewById(R.id.national_code_title);
        mobileNumber = (TextView) findViewById(R.id.mobile_number);
        mobileNumberTitle = (TextView) findViewById(R.id.mobile_number_title);
        email = (TextView) findViewById(R.id.email);
        emailTitle = (TextView) findViewById(R.id.email_title);
        identityIcon = (ImageView) findViewById(R.id.ic_identity);
        resultIcon = (ImageView) findViewById(R.id.ic_result);

        setupFonts();

        Glide.with(getApplicationContext())
                .load(appPrefs.getString(Prefs.PREF_AVATAR, ""))
                .into(userAvatar);

        name.setText(appPrefs.getString(Prefs.PREF_FIRST_NAME, "") + " " + appPrefs.getString(Prefs.PREF_LAST_NAME, ""));
        university.setText(appPrefs.getString(Prefs.PREF_UNIVERSITY, ""));

        String nationalCodeString = appPrefs.getString(Prefs.PREF_NATIONAL_CODE, "");
        String mobileNumberString = appPrefs.getString(Prefs.PREF_MOBILE_NUMBER, "");
        String emailString = appPrefs.getString(Prefs.PREF_EMAIL, "");
        if (!nationalCodeString.equals("")) {
            nationalCodeTitle.setVisibility(View.VISIBLE);
            nationalCode.setVisibility(View.VISIBLE);
            nationalCode.setText(number2farsi(nationalCodeString));
        }
        if (!mobileNumberString.equals("")) {
            mobileNumberTitle.setVisibility(View.VISIBLE);
            mobileNumber.setVisibility(View.VISIBLE);
            mobileNumber.setText(number2farsi(mobileNumberString));
        }
        if (!emailString.equals("")) {
            emailTitle.setVisibility(View.VISIBLE);
            email.setVisibility(View.VISIBLE);
            email.setText(emailString);
        }

        identityIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PictureViewerDialog pictureViewerDialog = new PictureViewerDialog(ProfileActivity.this, appPrefs.getString(Prefs.PREF_IDENTITY_PIC, ""));
                pictureViewerDialog.show();
            }
        });
    }

    private void setupFonts() {
        name.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/sl.ttf"));
        university.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/sl.ttf"));
        nationalCode.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/sl.ttf"));
        nationalCodeTitle.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/sl.ttf"));
        mobileNumberTitle.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/sl.ttf"));
        mobileNumber.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/sl.ttf"));
        email.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/sl.ttf"));
        emailTitle.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/sl.ttf"));
    }

    private static String number2farsi(String b) {

        Map<String, String> replaceMap = new HashMap<>();
        replaceMap.put("0", "۰");
        replaceMap.put("1", "۱");
        replaceMap.put("2", "۲");
        replaceMap.put("3", "۳");
        replaceMap.put("4", "۴");
        replaceMap.put("5", "۵");
        replaceMap.put("6", "۶");
        replaceMap.put("7", "۷");
        replaceMap.put("8", "۸");
        replaceMap.put("9", "۹");

        for (Map.Entry<String, String> entry : replaceMap.entrySet()) {
            b = b.replaceAll(entry.getKey(), entry.getValue());
        }

        return b;
    }
}
