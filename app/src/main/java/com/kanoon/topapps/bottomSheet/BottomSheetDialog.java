package com.kanoon.topapps.bottomSheet;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kanoon.topapps.R;
import com.kanoon.topapps.activities.AddTaskActivity;
import com.kanoon.topapps.adapter.BottomSheetMenuAdapter;
import com.kanoon.topapps.consts.Labels;
import com.kanoon.topapps.consts.State;
import com.kanoon.topapps.data.model.Book;
import com.kanoon.topapps.data.model.Category;
import com.kanoon.topapps.data.model.Channel;
import com.kanoon.topapps.data.model.Course;
import com.kanoon.topapps.data.model.GroupCode;
import com.kanoon.topapps.data.model.GroupMain;
import com.kanoon.topapps.data.model.Location;
import com.kanoon.topapps.data.model.TaskMain;
import com.kanoon.topapps.data.model.TaskSubLevel;
import com.kanoon.topapps.data.model.TaskType;
import com.kanoon.topapps.data.model.TaskTypes;
import com.kanoon.topapps.data.model.TestDate;
import com.kanoon.topapps.data.model.TestType;
import com.kanoon.topapps.data.remote.APIService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressLint("ValidFragment")
public class BottomSheetDialog extends BottomSheetDialogFragment {

    private AddTaskActivity activity;
    private List<BottomSheetMenuItem> bottomSheetMenuItemList;
    private APIService apiService;

    private View contentView;

    @SuppressLint("ValidFragment")
    public BottomSheetDialog(List<BottomSheetMenuItem> bottomSheetMenuItemList, AddTaskActivity activity, APIService apiService) {
        this.bottomSheetMenuItemList = bottomSheetMenuItemList;
        this.activity = activity;
        this.apiService = apiService;
    }


    private BottomSheetBehavior.BottomSheetCallback mBottomSheetBehaviorCallback = new BottomSheetBehavior.BottomSheetCallback() {

        @Override
        public void onStateChanged(@NonNull View bottomSheet, int newState) {
            if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                dismiss();
            }
        }

        @Override
        public void onSlide(@NonNull View bottomSheet, float slideOffset) {
        }
    };

    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        contentView = View.inflate(getContext(), R.layout.botom_sheet_layout, null);
        dialog.setContentView(contentView);
        TextView title = (TextView) contentView.findViewById(R.id.title);
        Log.e("in setup", "title is " + title);

        RecyclerView list = (RecyclerView) contentView.findViewById(R.id.bottom_sheet_items_list);
        BottomSheetMenuAdapter adapter = new BottomSheetMenuAdapter(bottomSheetMenuItemList, activity);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity.getApplicationContext());
        list.setLayoutManager(layoutManager);
        list.setAdapter(adapter);


        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ((View) contentView.getParent()).getLayoutParams();
        CoordinatorLayout.Behavior behavior = params.getBehavior();

        if (behavior != null && behavior instanceof BottomSheetBehavior) {
            ((BottomSheetBehavior) behavior).setBottomSheetCallback(mBottomSheetBehaviorCallback);
        }

    }

    public void create(int state, int id) {
        String title = Labels.getLabel(activity.getApplicationContext(), state);
//        LayoutInflater inflater = LayoutInflater.from(activity.getApplicationContext());
//        inflater.inflate(R.layout.botom_sheet_layout, null);
//        contentView = activity.getApplicationContext().inflate(R.layout.botom_sheet_layout, null);
//        TextView titleTextView = (TextView) inflater.findViewById(R.id.title);
//        titleTextView.setText(title);
//        Log.e("in create", "title is " + titleTextView);

        switch (state) {
            case State.STATE_TASKS_MAIN:
                apiService.getTasksMain().enqueue(new Callback<List<TaskMain>>() {
                    @Override
                    public void onResponse(Call<List<TaskMain>> call, Response<List<TaskMain>> response) {
                        bottomSheetMenuItemList.removeAll(bottomSheetMenuItemList);
                        for (int i = 0; i < response.body().size(); i++) {
                            bottomSheetMenuItemList.add(new BottomSheetMenuItem(response.body().get(i).getMainName(), response.body().get(i).getMainId()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<TaskMain>> call, Throwable t) {
                    }
                });
                break;

            case State.STATE_TASK_SUBLEVEL:
                apiService.getTaskSubLevel(id).enqueue(new Callback<List<TaskSubLevel>>() {
                    @Override
                    public void onResponse(Call<List<TaskSubLevel>> call, Response<List<TaskSubLevel>> response) {
                        bottomSheetMenuItemList.removeAll(bottomSheetMenuItemList);
                        for (int i = 0; i < response.body().size(); i++) {
                            bottomSheetMenuItemList.add(new BottomSheetMenuItem(response.body().get(i).getSubLevelName(), response.body().get(i).getSubLevelId()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<TaskSubLevel>> call, Throwable t) {

                    }
                });
                break;

            case State.STATE_TASK_TYPE:
                apiService.getTaskTypeList(id).enqueue(new Callback<List<TaskTypes>>() {
                    @Override
                    public void onResponse(Call<List<TaskTypes>> call, Response<List<TaskTypes>> response) {
                        bottomSheetMenuItemList.removeAll(bottomSheetMenuItemList);
                        for (int i = 0; i < response.body().size(); i++) {
                            bottomSheetMenuItemList.add(new BottomSheetMenuItem(response.body().get(i).getTypeName(), response.body().get(i).getTypeId()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<TaskTypes>> call, Throwable t) {

                    }
                });
                break;

            case State.STATE_GROUP_MAIN_CODE:
                apiService.getGroupMain().enqueue(new Callback<List<GroupMain>>() {
                    @Override
                    public void onResponse(Call<List<GroupMain>> call, Response<List<GroupMain>> response) {
                        bottomSheetMenuItemList.removeAll(bottomSheetMenuItemList);
                        for (int i = 0; i < response.body().size(); i++) {
                            bottomSheetMenuItemList.add(new BottomSheetMenuItem(response.body().get(i).getMainName(), response.body().get(i).getMainCode()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<GroupMain>> call, Throwable t) {

                    }
                });
                break;

            case State.STATE_GROUP_CODE:
                apiService.getGroupCode(id).enqueue(new Callback<List<GroupCode>>() {
                    @Override
                    public void onResponse(Call<List<GroupCode>> call, Response<List<GroupCode>> response) {
                        bottomSheetMenuItemList.removeAll(bottomSheetMenuItemList);
                        for (int i = 0; i < response.body().size(); i++) {
                            bottomSheetMenuItemList.add(new BottomSheetMenuItem(response.body().get(i).getGroupName(), response.body().get(i).getGroupCode1()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<GroupCode>> call, Throwable t) {

                    }
                });
                break;

            case State.STATE_COURSE_ID:
                apiService.getCourses(id).enqueue(new Callback<List<Course>>() {
                    @Override
                    public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
                        bottomSheetMenuItemList.removeAll(bottomSheetMenuItemList);
                        for (int i = 0; i < response.body().size(); i++) {
                            bottomSheetMenuItemList.add(new BottomSheetMenuItem(response.body().get(i).getCourseName(), response.body().get(i).getCourseId()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Course>> call, Throwable t) {

                    }
                });
                break;

            case State.STATE_TEST_DATE:
                apiService.getTestDate(id).enqueue(new Callback<List<TestDate>>() {
                    @Override
                    public void onResponse(Call<List<TestDate>> call, Response<List<TestDate>> response) {
                        bottomSheetMenuItemList.removeAll(bottomSheetMenuItemList);
                        for (int i = 0; i < response.body().size(); i++) {
                            bottomSheetMenuItemList.add(new BottomSheetMenuItem(response.body().get(i).getHejri(), response.body().get(i).getDateValue()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<TestDate>> call, Throwable t) {

                    }
                });
                break;

            case State.STATE_BOOKS:
                apiService.getBooks().enqueue(new Callback<List<Book>>() {
                    @Override
                    public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                        bottomSheetMenuItemList.removeAll(bottomSheetMenuItemList);
                        for (int i = 0; i < response.body().size(); i++) {
                            bottomSheetMenuItemList.add(new BottomSheetMenuItem(response.body().get(i).getBookName(), response.body().get(i).getId()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Book>> call, Throwable t) {

                    }
                });
                break;

            case State.STATE_LOCATION:
                apiService.getLocations().enqueue(new Callback<List<Location>>() {
                    @Override
                    public void onResponse(Call<List<Location>> call, Response<List<Location>> response) {
                        bottomSheetMenuItemList.removeAll(bottomSheetMenuItemList);
                        for (int i = 0; i < response.body().size(); i++) {
                            bottomSheetMenuItemList.add(new BottomSheetMenuItem(response.body().get(i).getLocationName(), response.body().get(i).getLocationId()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Location>> call, Throwable t) {

                    }
                });
                break;

            case State.STATE_CHANNEL_ID:
                apiService.getChannels().enqueue(new Callback<List<Channel>>() {
                    @Override
                    public void onResponse(Call<List<Channel>> call, Response<List<Channel>> response) {
                        bottomSheetMenuItemList.removeAll(bottomSheetMenuItemList);
                        for (int i = 0; i < response.body().size(); i++) {
                            bottomSheetMenuItemList.add(new BottomSheetMenuItem(response.body().get(i).getChanneName(), response.body().get(i).getChanneId()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Channel>> call, Throwable t) {

                    }
                });
                break;

            case State.STATE_TEST_TYPE:
                apiService.getTestTypes(id).enqueue(new Callback<List<TestType>>() {
                    @Override
                    public void onResponse(Call<List<TestType>> call, Response<List<TestType>> response) {
                        bottomSheetMenuItemList.removeAll(bottomSheetMenuItemList);
                        for (int i = 0; i < response.body().size(); i++) {
                            bottomSheetMenuItemList.add(new BottomSheetMenuItem(response.body().get(i).getTestTypeName(), response.body().get(i).getTestTypeId()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<TestType>> call, Throwable t) {

                    }
                });
                break;

            case State.STATE_CATEGORY:
                apiService.getCategories().enqueue(new Callback<List<Category>>() {
                    @Override
                    public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                        bottomSheetMenuItemList.removeAll(bottomSheetMenuItemList);
                        for (int i = 0; i < response.body().size(); i++) {
                            bottomSheetMenuItemList.add(new BottomSheetMenuItem(response.body().get(i).getCatagoryName(), response.body().get(i).getCatagoryId()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Category>> call, Throwable t) {

                    }
                });
                break;
            default:
                break;

        }
    }
}
