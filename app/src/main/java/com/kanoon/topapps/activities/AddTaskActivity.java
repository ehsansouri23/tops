package com.kanoon.topapps.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kanoon.topapps.IdAndValue;
import com.kanoon.topapps.R;
import com.kanoon.topapps.SendActivityMessageModel;
import com.kanoon.topapps.adapter.MenuListAdapter;
import com.kanoon.topapps.configs.Prefs;
import com.kanoon.topapps.consts.Labels;
import com.kanoon.topapps.consts.State;
import com.kanoon.topapps.consts.Types;
import com.kanoon.topapps.data.model.Book;
import com.kanoon.topapps.data.model.Category;
import com.kanoon.topapps.data.model.Channel;
import com.kanoon.topapps.data.model.Course;
import com.kanoon.topapps.data.model.GroupCode;
import com.kanoon.topapps.data.model.GroupMain;
import com.kanoon.topapps.data.model.Location;
import com.kanoon.topapps.data.model.Managers;
import com.kanoon.topapps.data.model.Task;
import com.kanoon.topapps.data.model.TaskMain;
import com.kanoon.topapps.data.model.TaskSubLevel;
import com.kanoon.topapps.data.model.TaskType;
import com.kanoon.topapps.data.model.TaskTypes;
import com.kanoon.topapps.data.model.TestDate;
import com.kanoon.topapps.data.model.TestType;
import com.kanoon.topapps.data.model.TimeSheet;
import com.kanoon.topapps.data.remote.APIService;
import com.kanoon.topapps.data.remote.ApiUtils;
import com.kanoon.topapps.menu_item.MainMenuItem;
import com.kanoon.topapps.modal.ModalDialog;
import com.kanoon.topapps.modal.ModalMenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AddTaskActivity extends AppCompatActivity {
    private static final String TAG = "AddTaskActivity";

    private APIService apiService;

    private RecyclerView menuRecyclerView;
    private MenuListAdapter menuListAdapter;
    private List<MainMenuItem> menuItemList;
    private List<ModalMenuItem> modalMenuItemList;
    private ModalDialog modalDialog;
    private HashMap<Integer, IdAndValue> stateAndId;

    private TextView chooseTextView;
    private Button submitButton;

    private String token;

    //    private EditTextDialog editTextDialog;
    private int position;
    private int currentState;

//    private Button submitButton;

    private TaskType taskType;

    private Task task;


    //    private int id;
//    private List<Integer> stateList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        apiService = ApiUtils.getAPIService();
        stateAndId = new HashMap<>();
        modalMenuItemList = new ArrayList<>();
        taskType = new TaskType();
        task = new Task();

        token = Prefs.getAppPrefs(getApplicationContext()).getString(Prefs.PREF_TOKEN, "");
        setupMenuRecyclerViewAndTitle();

        currentState = State.STATE_TASKS_MAIN;
        position = 0;

        modalDialog = new ModalDialog("", modalMenuItemList, AddTaskActivity.this);
        modalDialog.show();
        getModalMenuItemList(currentState);

        submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/sl.ttf"));
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeToClass();
                Log.e(TAG, "onClick: type = \n" + task.toString());
                apiService.insertTask("http://insp.kanoon.ir/Top/api/Insert?token=" + Prefs.getAppPrefs(getApplicationContext()).getString(Prefs.PREF_TOKEN, ""), task).enqueue(new Callback<SendActivityMessageModel>() {
                    @Override
                    public void onResponse(Call<SendActivityMessageModel> call, Response<SendActivityMessageModel> response) {
                        Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<SendActivityMessageModel> call, Throwable t) {
                        connectionError();
                    }
                });
            }
        });

        currentState = State.STATE_TASKS_MAIN;
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

    public void onMenuItemClicked(int position) {
        currentState = menuItemList.get(position).getState();
        this.position = position;

        if (menuItemList.get(position).getType() == Types.TYPE_OPTION) {
            modalDialog = new ModalDialog(Labels.getLabel(getApplicationContext(), currentState), modalMenuItemList, AddTaskActivity.this);
            modalDialog.show();
            getModalMenuItemList(currentState);
        }

        if (menuItemList.get(position).getType() == Types.TYPE_INPUT) {
            modalDialog = new ModalDialog(Labels.getLabel(getApplicationContext(), currentState), currentState, AddTaskActivity.this);
            modalDialog.show();

        }
    }

    public void onModalMenuItemClicked(final int id, String name) {
        stateAndId.put(currentState, new IdAndValue(id, name));
        menuItemList.get(position).setDone(true);
        menuItemList.get(position).setChosen(name);
        menuListAdapter.notifyItemChanged(position);
        if (position != menuItemList.size() - 1) {
            submitButton.setVisibility(View.GONE);
            for (int i = position + 1; i < menuItemList.size(); i++) {
                menuItemList.remove(i);
                i--;
            }
            menuListAdapter.notifyDataSetChanged();
        }
        position++;
        if (currentState == State.STATE_LOCATION) {
            if (name.equals("کانال تلگرام")) {
                Log.e(TAG, "onModalMenuItemClicked: telegram selected");
                currentState = State.STATE_CHANNEL_ID;
                menuItemList.add(new MainMenuItem(currentState));
                getModalMenuItemList(currentState);
                menuListAdapter.notifyItemInserted(position);
                menuRecyclerView.smoothScrollToPosition(position);
            } else {
                currentState = State.STATE_TEST_TYPE;
                currentState = taskType.getNextState(currentState);
                menuItemList.add(new MainMenuItem(currentState));
                if (menuItemList.get(position).getType() == Types.TYPE_OPTION) {
                    getModalMenuItemList(currentState);
                } else {
                    modalDialog.dismiss();
                    modalDialog = new ModalDialog(Labels.getLabel(getApplicationContext(), currentState), currentState, AddTaskActivity.this);
                    modalDialog.show();
                }
                menuListAdapter.notifyItemInserted(position);
                menuRecyclerView.smoothScrollToPosition(position);
            }
        } else if (currentState == State.STATE_TASK_TYPE) {
            apiService.getTaskType(id, token).enqueue(new Callback<TaskType>() {
                @Override
                public void onResponse(Call<TaskType> call, Response<TaskType> response) {
                    taskType = response.body();
                    currentState = taskType.getNextState(currentState);

                    menuItemList.add(new MainMenuItem(currentState));
                    if (menuItemList.get(position).getType() == Types.TYPE_OPTION) {
                        getModalMenuItemList(currentState);
                    } else {
                        modalDialog.dismiss();
                        modalDialog = new ModalDialog(Labels.getLabel(getApplicationContext(), currentState), currentState, AddTaskActivity.this);
                        modalDialog.show();
                    }
                    menuListAdapter.notifyItemInserted(position);
                    menuRecyclerView.smoothScrollToPosition(position);
                }

                @Override
                public void onFailure(Call<TaskType> call, Throwable t) {
                    connectionError();
                }
            });
        } else {
            currentState = taskType.getNextState(currentState);
            menuItemList.add(new MainMenuItem(currentState));
            if (menuItemList.get(position).getType() == Types.TYPE_OPTION) {
                getModalMenuItemList(currentState);
            } else {
                modalDialog.dismiss();
                modalDialog = new ModalDialog(Labels.getLabel(getApplicationContext(), currentState), currentState, AddTaskActivity.this);
                modalDialog.show();
            }
            menuListAdapter.notifyItemInserted(position);
            menuRecyclerView.smoothScrollToPosition(position);
        }
        Log.e(TAG, "onModalMenuItemClicked: state = " + currentState);
    }

    public void onEdittextDialogClicked(String name) {
        stateAndId.put(currentState, new IdAndValue(-1, name));
        menuItemList.get(position).setDone(true);
        menuItemList.get(position).setChosen(name);
        menuListAdapter.notifyItemChanged(position);
        if (position != menuItemList.size() - 1) {
            submitButton.setVisibility(View.GONE);
            for (int i = position + 1; i < menuItemList.size(); i++) {
                menuItemList.remove(i);
                i--;
            }
        }
        menuListAdapter.notifyDataSetChanged();
        position++;
        currentState = taskType.getNextState(currentState);
        if (currentState == State.STATE_FINISH) {
            modalDialog.dismiss();
            isFinished();
            return;
        }
        menuItemList.add(new MainMenuItem(currentState));
        if (menuItemList.get(position).getType() == Types.TYPE_OPTION) {
            getModalMenuItemList(currentState);
        } else {
            modalDialog.dismiss();
            modalDialog = new ModalDialog(Labels.getLabel(getApplicationContext(), currentState), currentState, AddTaskActivity.this);
            modalDialog.show();
        }
        menuListAdapter.notifyItemInserted(position);
        menuRecyclerView.smoothScrollToPosition(position);
    }

    private void getModalMenuItemList(int state) {
        switch (state) {
            case State.STATE_TASKS_MAIN:
                apiService.getTasksMain(token).enqueue(new Callback<List<TaskMain>>() {
                    @Override
                    public void onResponse(Call<List<TaskMain>> call, Response<List<TaskMain>> response) {
                        modalMenuItemList.removeAll(modalMenuItemList);
                        for (int i = 0; i < response.body().size(); i++) {
                            modalMenuItemList.add(new ModalMenuItem(response.body().get(i).getMainName(), response.body().get(i).getMainId()));
                        }
                        modalDialog.reload(Labels.getLabel(getApplicationContext(), currentState), modalMenuItemList);
                    }

                    @Override
                    public void onFailure(Call<List<TaskMain>> call, Throwable t) {
                        connectionError();
                    }
                });
                break;

            case State.STATE_TASK_SUBLEVEL:
                apiService.getTaskSubLevel(stateAndId.get(State.STATE_TASKS_MAIN).getId(), token).enqueue(new Callback<List<TaskSubLevel>>() {
                    @Override
                    public void onResponse(Call<List<TaskSubLevel>> call, Response<List<TaskSubLevel>> response) {
                        modalMenuItemList.removeAll(modalMenuItemList);
                        for (int i = 0; i < response.body().size(); i++) {
                            modalMenuItemList.add(new ModalMenuItem(response.body().get(i).getSubLevelName(), response.body().get(i).getSubLevelId()));
                        }
                        modalDialog.reload(Labels.getLabel(getApplicationContext(), currentState), modalMenuItemList);
                    }

                    @Override
                    public void onFailure(Call<List<TaskSubLevel>> call, Throwable t) {
                        connectionError();
                    }
                });
                break;

            case State.STATE_TASK_TYPE:
                apiService.getTaskTypeList(stateAndId.get(State.STATE_TASK_SUBLEVEL).getId(), token).enqueue(new Callback<List<TaskTypes>>() {
                    @Override
                    public void onResponse(Call<List<TaskTypes>> call, Response<List<TaskTypes>> response) {
                        modalMenuItemList.removeAll(modalMenuItemList);
                        for (int i = 0; i < response.body().size(); i++) {
                            modalMenuItemList.add(new ModalMenuItem(response.body().get(i).getTypeName(), response.body().get(i).getTypeId()));
                        }
                        modalDialog.reload(Labels.getLabel(getApplicationContext(), currentState), modalMenuItemList);
                    }

                    @Override
                    public void onFailure(Call<List<TaskTypes>> call, Throwable t) {
                        connectionError();
                    }
                });
                break;

            case State.STATE_GROUP_MAIN_CODE:
                apiService.getGroupMain(token).enqueue(new Callback<List<GroupMain>>() {
                    @Override
                    public void onResponse(Call<List<GroupMain>> call, Response<List<GroupMain>> response) {
                        modalMenuItemList.removeAll(modalMenuItemList);
                        for (int i = 0; i < response.body().size(); i++) {
                            modalMenuItemList.add(new ModalMenuItem(response.body().get(i).getMainName(), response.body().get(i).getMainCode()));
                        }
                        modalDialog.reload(Labels.getLabel(getApplicationContext(), currentState), modalMenuItemList);
                    }

                    @Override
                    public void onFailure(Call<List<GroupMain>> call, Throwable t) {
                        connectionError();
                    }
                });
                break;

            case State.STATE_GROUP_CODE:
                apiService.getGroupCode(stateAndId.get(State.STATE_GROUP_MAIN_CODE).getId(), token).enqueue(new Callback<List<GroupCode>>() {
                    @Override
                    public void onResponse(Call<List<GroupCode>> call, Response<List<GroupCode>> response) {
                        modalMenuItemList.removeAll(modalMenuItemList);
                        for (int i = 0; i < response.body().size(); i++) {
                            modalMenuItemList.add(new ModalMenuItem(response.body().get(i).getGroupName(), response.body().get(i).getGroupCode1()));
                        }
                        modalDialog.reload(Labels.getLabel(getApplicationContext(), currentState), modalMenuItemList);
                    }

                    @Override
                    public void onFailure(Call<List<GroupCode>> call, Throwable t) {
                        connectionError();
                    }
                });
                break;

            case State.STATE_COURSE_ID:
                apiService.getCourses(stateAndId.get(State.STATE_GROUP_CODE).getId(), token).enqueue(new Callback<List<Course>>() {
                    @Override
                    public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
                        modalMenuItemList.removeAll(modalMenuItemList);
                        for (int i = 0; i < response.body().size(); i++) {
                            modalMenuItemList.add(new ModalMenuItem(response.body().get(i).getCourseName(), response.body().get(i).getCourseId()));
                        }
                        modalDialog.reload(Labels.getLabel(getApplicationContext(), currentState), modalMenuItemList);
                    }

                    @Override
                    public void onFailure(Call<List<Course>> call, Throwable t) {
                        connectionError();
                    }
                });
                break;

            case State.STATE_TEST_DATE:
                apiService.getTestDate(stateAndId.get(State.STATE_GROUP_CODE).getId(), token).enqueue(new Callback<List<TestDate>>() {
                    @Override
                    public void onResponse(Call<List<TestDate>> call, Response<List<TestDate>> response) {
                        modalMenuItemList.removeAll(modalMenuItemList);
                        for (int i = 0; i < response.body().size(); i++) {
                            modalMenuItemList.add(new ModalMenuItem(response.body().get(i).getHejri(), response.body().get(i).getDateValue()));
                        }
                        modalDialog.reload(Labels.getLabel(getApplicationContext(), currentState), modalMenuItemList);
                    }

                    @Override
                    public void onFailure(Call<List<TestDate>> call, Throwable t) {
                        connectionError();
                    }
                });
                break;

            case State.STATE_BOOKS:
                apiService.getBooks(token).enqueue(new Callback<List<Book>>() {
                    @Override
                    public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                        modalMenuItemList.removeAll(modalMenuItemList);
                        for (int i = 0; i < response.body().size(); i++) {
                            modalMenuItemList.add(new ModalMenuItem(response.body().get(i).getBookName(), response.body().get(i).getId()));
                        }
                        modalDialog.reload(Labels.getLabel(getApplicationContext(), currentState), modalMenuItemList);
                    }

                    @Override
                    public void onFailure(Call<List<Book>> call, Throwable t) {
                        connectionError();
                    }
                });
                break;

            case State.STATE_LOCATION:
                apiService.getLocations(token).enqueue(new Callback<List<Location>>() {
                    @Override
                    public void onResponse(Call<List<Location>> call, Response<List<Location>> response) {
                        modalMenuItemList.removeAll(modalMenuItemList);
                        for (int i = 0; i < response.body().size(); i++) {
                            modalMenuItemList.add(new ModalMenuItem(response.body().get(i).getLocationName(), response.body().get(i).getLocationId()));
                        }
                        modalDialog.reload(Labels.getLabel(getApplicationContext(), currentState), modalMenuItemList);
                    }

                    @Override
                    public void onFailure(Call<List<Location>> call, Throwable t) {
                        connectionError();
                    }
                });
                break;

            case State.STATE_CHANNEL_ID:
                apiService.getChannels(token).enqueue(new Callback<List<Channel>>() {
                    @Override
                    public void onResponse(Call<List<Channel>> call, Response<List<Channel>> response) {
                        modalMenuItemList.removeAll(modalMenuItemList);
                        for (int i = 0; i < response.body().size(); i++) {
                            modalMenuItemList.add(new ModalMenuItem(response.body().get(i).getChanneName(), response.body().get(i).getChanneId()));
                        }
                        modalDialog.reload(Labels.getLabel(getApplicationContext(), currentState), modalMenuItemList);
                    }

                    @Override
                    public void onFailure(Call<List<Channel>> call, Throwable t) {
                        connectionError();
                    }
                });
                break;

            case State.STATE_TEST_TYPE:
                apiService.getTestTypes(stateAndId.get(State.STATE_GROUP_MAIN_CODE).getId(), token).enqueue(new Callback<List<TestType>>() {
                    @Override
                    public void onResponse(Call<List<TestType>> call, Response<List<TestType>> response) {
                        modalMenuItemList.removeAll(modalMenuItemList);
                        for (int i = 0; i < response.body().size(); i++) {
                            modalMenuItemList.add(new ModalMenuItem(response.body().get(i).getTestTypeName(), response.body().get(i).getTestTypeId()));
                        }
                        modalDialog.reload(Labels.getLabel(getApplicationContext(), currentState), modalMenuItemList);
                    }

                    @Override
                    public void onFailure(Call<List<TestType>> call, Throwable t) {
                        connectionError();
                    }
                });
                break;

            case State.STATE_CATEGORY:
                apiService.getCategories(token).enqueue(new Callback<List<Category>>() {
                    @Override
                    public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                        modalMenuItemList.removeAll(modalMenuItemList);
                        for (int i = 0; i < response.body().size(); i++) {
                            modalMenuItemList.add(new ModalMenuItem(response.body().get(i).getCatagoryName(), response.body().get(i).getCatagoryId()));
                        }
                        modalDialog.reload(Labels.getLabel(getApplicationContext(), currentState), modalMenuItemList);
                    }

                    @Override
                    public void onFailure(Call<List<Category>> call, Throwable t) {
                        connectionError();
                    }
                });
                break;
            case State.STATE_MANAGER_USER_ID:
                apiService.getManagers(token).enqueue(new Callback<List<Managers>>() {
                    @Override
                    public void onResponse(Call<List<Managers>> call, Response<List<Managers>> response) {
                        modalMenuItemList.removeAll(modalMenuItemList);
                        for (int i = 0; i < response.body().size(); i++) {
                            modalMenuItemList.add(new ModalMenuItem(response.body().get(i).getFullname(), response.body().get(i).getUserId()));
                        }
                        modalDialog.reload(Labels.getLabel(getApplicationContext(), currentState), modalMenuItemList);
                    }

                    @Override
                    public void onFailure(Call<List<Managers>> call, Throwable t) {
                        connectionError();
                    }
                });
            default:
                break;
        }
    }

    private void isFinished() {
        if (currentState == State.STATE_FINISH)
            submitButton.setVisibility(View.VISIBLE);
        else
            submitButton.setVisibility(View.INVISIBLE);
    }

    private void setupMenuRecyclerViewAndTitle() {
        chooseTextView = (TextView) findViewById(R.id.choose_title);
        chooseTextView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/sl.ttf"));
        menuItemList = new ArrayList<>();
        menuItemList.add(new MainMenuItem(State.STATE_TASKS_MAIN));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        menuRecyclerView = (RecyclerView) findViewById(R.id.menu_list);
        menuRecyclerView.setLayoutManager(layoutManager);
        menuListAdapter = new MenuListAdapter(menuItemList, AddTaskActivity.this);
        menuRecyclerView.setAdapter(menuListAdapter);
        menuRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void connectionError() {
        Toast.makeText(getApplicationContext(), getResources().getString(R.string.connectionError), Toast.LENGTH_SHORT).show();
    }

    private void writeToClass() {
        for (int i = 1; i < State.STATE_FINISH; i++) {
            int state = -1;
            if (stateAndId.get(i) != null) {
                state = stateAndId.get(i).getId();
                Log.e(TAG, "writeToClass: " + Labels.getLabel(getApplicationContext(), i) + " : " + stateAndId.get(i).getValue());
                switch (i) {
                    case State.STATE_TASKS_MAIN:
                        task.setTaskMainId(stateAndId.get(i).getId());
                        break;
                    case State.STATE_TASK_SUBLEVEL:
                        task.setTaskSubLevelId(stateAndId.get(i).getId());
                        break;
                    case State.STATE_TASK_TYPE:
                        task.setTaskType(stateAndId.get(i).getId());
                        break;
                    case State.STATE_MANAGER_USER_ID:
                        task.setManagerUserId(stateAndId.get(i).getId());
                        break;
                    case State.STATE_GROUP_MAIN_CODE:
                        task.setGroupMainCode(stateAndId.get(i).getId());
                        break;
                    case State.STATE_GROUP_CODE:
                        task.setGroupCode(stateAndId.get(i).getId());
                        break;
                    case State.STATE_TEST_DATE:
                        task.setTestDate(stateAndId.get(i).getId());
                        break;
                    case State.STATE_BOOKS:
                        task.setBookId(stateAndId.get(i).getId());
                        break;
                    case State.STATE_VERSION:
                        task.setVersion(stateAndId.get(i).getId());
                        break;
                    case State.STATE_LOCATION:
                        task.setLocation(stateAndId.get(i).getId());
                        break;
                    case State.STATE_CHANNEL_ID:
                        task.setChannelId(stateAndId.get(i).getId());
                        break;
                    case State.STATE_TEST_TYPE:
                        task.setTestType(stateAndId.get(i).getId());
                        break;
                    case State.STATE_CATEGORY:
                        task.setCategory(stateAndId.get(i).getId());
                        break;
                    case State.STATE_CRS_SUBJECT:
                        task.setCrsSubject(stateAndId.get(i).getValue());
                        break;
                    case State.STATE_SUBJECT:
                        task.setSubject(stateAndId.get(i).getValue());
                        break;
                    case State.STATE_SESSION_DATE:
                        task.setSendDate(stateAndId.get(i).getValue());
                        break;
                    case State.STATE_SESSION_LOCATION:
                        task.setSesssionLocation(stateAndId.get(i).getValue());
                        break;
                    case State.STATE_SESSION_MANAGER:
                        task.setSesssionManager(stateAndId.get(i).getValue());
                        break;
                    case State.STATE_TOTAL_CALL_COUNT:
                        task.setTotalCallCount(Integer.parseInt(stateAndId.get(i).getValue()));
                        break;
                    case State.STATE_UNSUCCESSFUL_CALL_COUNT:
                        task.setUnsuccessfulCallCount(Integer.parseInt(stateAndId.get(i).getValue()));
                        break;
                    case State.STATE_SUCCESSFUL_CALL_COUNT:
                        task.setSuccessCallCount(Integer.parseInt(stateAndId.get(i).getValue()));
                        break;
                    case State.STATE_OWNER:
                        task.setOwner(stateAndId.get(i).getValue());
                        break;
                    case State.STATE_INTERVIEWEE:
                        task.setInterviewee(stateAndId.get(i).getValue());
                        break;
                    case State.STATE_LEARN_SOURCE:
                        task.setLearnSource(stateAndId.get(i).getValue());
                        break;
                    case State.STATE_DESCRIPTION:
                        task.setDescription(stateAndId.get(i).getValue());
                        break;
                    case State.STATE_COUNT:
                        task.setCount(Integer.parseInt(stateAndId.get(i).getValue()));
                        break;
                    case State.STATE_PAGE_COUNT:
                        task.setPageCount(Integer.parseInt(stateAndId.get(i).getValue()));
                        break;
                    case State.STATE_QUESTION_COUNT:
                        task.setQuestionCount(Integer.parseInt(stateAndId.get(i).getValue()));
                        break;
                    case State.STATE_TIME:
                        task.setTime(Integer.parseInt(stateAndId.get(i).getValue()));
                        break;
                    case State.STATE_GENERATE_DATE:
                        task.setGenerateDate(stateAndId.get(i).getValue());
                        break;
                    case State.STATE_SEND_DATE:
                        task.setSendDate(stateAndId.get(i).getValue());
                        break;
                }
            }
        }
    }
}