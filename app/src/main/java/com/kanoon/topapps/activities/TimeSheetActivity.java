package com.kanoon.topapps.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.kanoon.topapps.R;
import com.kanoon.topapps.adapter.TimeSheetAdapter;
import com.kanoon.topapps.configs.Prefs;
import com.kanoon.topapps.data.model.TimeSheet;
import com.kanoon.topapps.data.remote.APIService;
import com.kanoon.topapps.data.remote.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TimeSheetActivity extends AppCompatActivity {

    private APIService apiService;
    private SharedPreferences prefs;
    private TimeSheet timeSheet;
    private TimeSheetAdapter adapter;
    private RecyclerView timeSheetRecylerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_sheet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        timeSheetRecylerview = (RecyclerView) findViewById(R.id.time_sheet_recyclerview);

        apiService = ApiUtils.getAPIService();
        prefs = Prefs.getAppPrefs(getApplicationContext());
        apiService.getTimeSheet("http://insp.kanoon.ir/top/api/GetTimeSheet?token=" + prefs.getString(Prefs.PREF_TOKEN, "")).enqueue(new Callback<TimeSheet>() {
            @Override
            public void onResponse(Call<TimeSheet> call, Response<TimeSheet> response) {
                timeSheet = response.body();
                Log.e("token", "onResponse: " + timeSheet.getMessage() + " token = \n" + Prefs.getAppPrefs(getApplicationContext()).getString(Prefs.PREF_TOKEN, ""));
                adapter = new TimeSheetAdapter(timeSheet);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                timeSheetRecylerview.setLayoutManager(layoutManager);
                timeSheetRecylerview.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<TimeSheet> call, Throwable t) {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.connectionError), Toast.LENGTH_SHORT).show();
            }
        });

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
