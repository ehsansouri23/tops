package com.kanoon.topapps.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kanoon.topapps.R;
import com.kanoon.topapps.configs.Prefs;
import com.kanoon.topapps.data.model.Login;
import com.kanoon.topapps.data.remote.APIService;
import com.kanoon.topapps.data.remote.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    private TextInputLayout inputUsename, inputPassword;
    private EditText username, password;
    private Button submitButton;

    private APIService apiService;
    private Login loginInfo;
    private SharedPreferences appPrefs;
    private SharedPreferences.Editor appPrefsEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        apiService = ApiUtils.getAPIService();
        appPrefs = Prefs.getAppPrefs(getApplicationContext());
        appPrefsEditor = appPrefs.edit();

        username = (EditText) findViewById(R.id.username_edittext);
        username.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/sl.ttf"));
        password = (EditText) findViewById(R.id.password_edittext);
        password.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/sl.ttf"));
        inputUsename = (TextInputLayout) findViewById(R.id.input_layout_username);
        inputPassword = (TextInputLayout) findViewById(R.id.input_layout_password);
        inputUsename.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/sl.ttf"));
        inputPassword.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/sl.ttf"));

        submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/sl.ttf"));
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiService.loginUser(username.getText().toString(), password.getText().toString()).enqueue(new Callback<Login>() {
                    @Override
                    public void onResponse(Call<Login> call, Response<Login> response) {
                        loginInfo = response.body();
                        if (loginInfo.getStatus() == 0){
                            appPrefsEditor.putBoolean(Prefs.PREF_IS_LOGGED_IN, true);
                            appPrefsEditor.putString(Prefs.PREF_FIRST_NAME, loginInfo.getData().getUser().getName());
                            appPrefsEditor.putString(Prefs.PREF_LAST_NAME, loginInfo.getData().getUser().getLastName());
                            appPrefsEditor.putString(Prefs.PREF_UNIVERSITY, loginInfo.getData().getUser().getAuxCourseUni());
                            appPrefsEditor.putString(Prefs.PREF_AVATAR, "http://insp.kanoon.ir/Top/File/ShowUserPic?file=" + loginInfo.getData().getUser().getProfilePic());
                            appPrefsEditor.putString(Prefs.PREF_NATIONAL_CODE, loginInfo.getData().getUser().getNationalCode());
                            appPrefsEditor.putString(Prefs.PREF_MOBILE_NUMBER, loginInfo.getData().getUser().getMobile());
                            appPrefsEditor.putString(Prefs.PREF_EMAIL, loginInfo.getData().getUser().getEmail());
                            appPrefsEditor.putString(Prefs.PREF_IDENTITY_PIC, "http://insp.kanoon.ir/Top/File/ShowIdCard?file=" + loginInfo.getData().getUser().getIdCardPic());
                            appPrefsEditor.putString(Prefs.PREF_RESULT_PIC, loginInfo.getData().getUser().getResultPic());
                            appPrefsEditor.putString(Prefs.PREF_TOKEN, loginInfo.getData().getToken());
                            appPrefsEditor.commit();
                            Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(mainIntent);
                            finish();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "invalid pass", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Login> call, Throwable t) {

                    }
                });
            }
        });
    }

}
