package com.kanoon.topapps.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.kanoon.topapps.R;
import com.kanoon.topapps.adapter.MenuListAdapter;
import com.kanoon.topapps.bottomSheet.BottomSheetDialog;
import com.kanoon.topapps.bottomSheet.BottomSheetMenuItem;
import com.kanoon.topapps.consts.Labels;
import com.kanoon.topapps.consts.State;
import com.kanoon.topapps.consts.Types;
import com.kanoon.topapps.data.remote.APIService;
import com.kanoon.topapps.data.remote.ApiUtils;
import com.kanoon.topapps.menu_item.MainMenuItem;

import java.util.ArrayList;
import java.util.List;

//import jp.wasabeef.recyclerview.animators.FadeInLeftAnimator;

public class AddTaskActivity extends AppCompatActivity {

    private APIService apiService;

    private RecyclerView menuList;
    private MenuListAdapter menuListAdapter;
    private List<MainMenuItem> menuItemList;

    private List<BottomSheetMenuItem> bottomSheetMenuItemList;
    BottomSheetDialog bottomSheetDialog;


    private int curState;
    private int id;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        apiService = ApiUtils.getAPIService();

        bottomSheetMenuItemList = new ArrayList<>();
        bottomSheetDialog = new BottomSheetDialog(bottomSheetMenuItemList, AddTaskActivity.this, apiService);

        //setting up menu list
        menuItemList = new ArrayList<>();
        menuItemList.add(new MainMenuItem(Types.TYPE_OPTION, State.STATE_TASKS_MAIN));
        curState = State.STATE_TASKS_MAIN;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        menuList = (RecyclerView) findViewById(R.id.menu_list);
        menuList.setLayoutManager(layoutManager);
        menuListAdapter = new MenuListAdapter(menuItemList, AddTaskActivity.this);
        menuList.setAdapter(menuListAdapter);
        menuList.setItemAnimator(new DefaultItemAnimator());

        //at first
        id = -1;

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


    public void onMenuItemClicked(int menuItemState, int menuItemType, int position) {
        bottomSheetDialog.create(menuItemState, id);
        bottomSheetDialog.show(getSupportFragmentManager(), "TAG");
        curState = menuItemState;

        this.position = position;
    }

    public void onBottomSheetMenuItemClicked(int id, String name) {
        menuItemList.get(position).setChosen(name);
        menuItemList.add(new MainMenuItem(Types.TYPE_OPTION, ++curState));
        this.id = id;
        bottomSheetDialog.dismiss();
        menuListAdapter.notifyDataSetChanged();
    }

}


