package com.kanoon.topapps.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.kanoon.topapps.R;
import com.kanoon.topapps.adapter.MenuListAdapter;
import com.kanoon.topapps.consts.State;
import com.kanoon.topapps.consts.Types;
import com.kanoon.topapps.data.model.Task;
import com.kanoon.topapps.data.model.TaskType;
import com.kanoon.topapps.data.remote.APIService;
import com.kanoon.topapps.data.remote.ApiUtils;
import com.kanoon.topapps.menu_item.MainMenuItem;
import com.kanoon.topapps.modal.ModalDialog;
import com.kanoon.topapps.modal.ModalMenuItem;

import java.util.ArrayList;
import java.util.List;


public class AddTaskActivity extends AppCompatActivity {
    private static final String TAG = "AddTaskActivity";

    private APIService apiService;

    private RecyclerView menuRecyclerView;
    private MenuListAdapter menuListAdapter;
    private List<MainMenuItem> menuItemList;

    private TextView chooseTextView;

//    private List<ModalMenuItem> modalMenuItemList;
//    private ModalDialog modalDialog;

//    private EditTextDialog editTextDialog;
//    private Button submitButton;

    private TaskType taskType;

//    private HashMap<Integer, IdAndValue> stateAndId;

    private Task task;


    private int curState;
//    private int id;
//    private int position;
//    private List<Integer> stateList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupMenuRecyclerViewAndTitle();


        task = new Task();
//        stateList = new ArrayList<>();
//        stateList.add(State.STATE_TASKS_MAIN);

//        SharedPreferences appPrefs = Prefs.getAppPrefs(getApplicationContext());
//        String token = appPrefs.getString()

        apiService = ApiUtils.getAPIService();
//        stateAndId = new HashMap<>();

//        submitButton = (Button) findViewById(R.id.submit_button);
//        submitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                writeToClass();
//                apiService.insertTask(task /*"SM65wZG15HJUJTGN3TTcYayfFwRmHUnFuVDDbPTHiwYqoDvkqXhMcY46guMrsx%2bN%2bBFeVMZihLCdiWgVxTggo1x4DMubX5OGLq6%2bnk3%2bu0sQ0Rfa%2fqth%2fDvpx8mHFJ8O"*/).enqueue(new Callback<Mete>() {
//                    @Override
//                    public void onResponse(Call<Mete> call, Response<Mete> response) {
//                        Log.e("--", response.body().getStatus() + "\n" + response.body().getMessage());
//                    }
//
//                    @Override
//                    public void onFailure(Call<Mete> call, Throwable t) {
//
//                    }
//                });
//            }
//        });

        taskType = new TaskType();

        //at first
//        id = -1;
        curState = State.STATE_TASKS_MAIN;
//        stateAndId.put(curState, new IdAndValue(0,""));


//        editTextDialog = new EditTextDialog(AddTaskActivity.this);

        //setting up menu list

//        modalMenuItemList = new ArrayList<>();
//        modalDialog = new ModalDialog(Labels.getLabel(getApplicationContext(), State.STATE_TASKS_MAIN), modalMenuItemList, AddTaskActivity.this);
//        modalDialog.show(getSupportFragmentManager(), "TAG");
//        getModalMenuItemList(curState);

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
        curState = menuItemState;
//        this.position = position;

        if (menuItemType == Types.TYPE_OPTION) {
//            bottomSheetDialog.create(menuItemState, id);
        }

        if (menuItemType == Types.TYPE_INPUT) {
//            this.position = position;
//            String title = Labels.getLabel(getApplicationContext(), menuItemState);
//            editTextDialog.showDialog(title, curState);
        }
//        if (isFinished())
//            submitButton.setVisibility(View.VISIBLE);

    }

//    public void onModalMenuItemClicked(final int id, String name) {
//        stateList.add(curState);
//        stateAndId.put(curState, new IdAndValue(id, name));
//        menuItemList.get(position).setChosen(name);
//        position++;
//        final int[] newState = new int[1];
////        if (name.equals("کانال تلگرام")) {
////            newState[0] = State.STATE_CHANNEL_ID;
////            curState = newState[0];
////            if (curState <= State.STATE_CATEGORY) {
////                getModalMenuItemList(curState);
////                modalDialog.reload(Labels.getLabel(getApplicationContext(), curState), modalMenuItemList);
////            } else {
////                modalDialog.dismiss();
////                editTextDialog.showDialog(Labels.getLabel(getApplicationContext(), curState), curState);
////            }
////        }
////        else {
//        if (curState == State.STATE_TASK_TYPE) {
//            apiService.getTaskType(id).enqueue(new Callback<TaskType>() {
//                @Override
//                public void onResponse(Call<TaskType> call, Response<TaskType> response) {
//                    taskType = response.body();
//                    newState[0] = taskType.getNextState(curState);
//                    menuItemList.add(new MainMenuItem(newState[0]));
//                    menuListAdapter.notifyDataSetChanged();
//
//                    curState = newState[0];
//                    if (curState <= State.STATE_CATEGORY) {
////                        getModalMenuItemList(curState);
////                        modalDialog.reload(Labels.getLabel(getApplicationContext(), curState), modalMenuItemList);
//                    } else {
////                        modalDialog.dismiss();
//                        editTextDialog.showDialog(Labels.getLabel(getApplicationContext(), curState), curState);
//                    }
//
//                }
//
//                @Override
//                public void onFailure(Call<TaskType> call, Throwable t) {
//                    Toast.makeText(getApplicationContext(), "اتصال برقرار نیست", Toast.LENGTH_SHORT).show();
//                }
//            });
//        } else {
//            newState[0] = taskType.getNextState(curState);
//
//            menuItemList.add(new MainMenuItem(newState[0]));
//            menuListAdapter.notifyDataSetChanged();
//
//            curState = newState[0];
//            if (curState <= State.STATE_CATEGORY) {
////                getModalMenuItemList(curState);
////                modalDialog.reload(Labels.getLabel(getApplicationContext(), curState), modalMenuItemList);
//            } else {
////                modalDialog.dismiss();
//                editTextDialog.showDialog(Labels.getLabel(getApplicationContext(), curState), curState);
//            }
//        }
////        }
//        if (isFinished())
//            submitButton.setVisibility(View.VISIBLE);
//    }

//    public void onEditTextDialogClosed(String chosen) {
//        stateList.add(curState);
//        stateAndId.put(curState, new IdAndValue(-1, chosen));
//        menuItemList.get(position).setChosen(chosen);
//        menuListAdapter.notifyDataSetChanged();
//        position++;
//        int newState = taskType.getNextState(curState);
//        curState = newState;
//        if (isFinished()) {
//            submitButton.setVisibility(View.VISIBLE);
//        } else {
//            menuItemList.add(new MainMenuItem(newState));
//            menuListAdapter.notifyDataSetChanged();
//            editTextDialog.showDialog(Labels.getLabel(getApplicationContext(), curState), curState);
//        }
//
//    }

//    private void getModalMenuItemList(int state) {
//
//        switch (state) {
//            case State.STATE_TASKS_MAIN:
//                apiService.getTasksMain().enqueue(new Callback<List<TaskMain>>() {
//                    @Override
//                    public void onResponse(Call<List<TaskMain>> call, Response<List<TaskMain>> response) {
//                        modalMenuItemList.removeAll(modalMenuItemList);
//                        for (int i = 0; i < response.body().size(); i++) {
//                            modalMenuItemList.add(new ModalMenuItem(response.body().get(i).getMainName(), response.body().get(i).getMainId()));
//                        }
////                        modalDialog.reload(Labels.getLabel(getApplicationContext(), curState), modalMenuItemList);
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<TaskMain>> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), "اتصال برقرار نیست", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                break;
//
//            case State.STATE_TASK_SUBLEVEL:
//                apiService.getTaskSubLevel(stateAndId.get(State.STATE_TASKS_MAIN).getId()).enqueue(new Callback<List<TaskSubLevel>>() {
//                    @Override
//                    public void onResponse(Call<List<TaskSubLevel>> call, Response<List<TaskSubLevel>> response) {
//                        modalMenuItemList.removeAll(modalMenuItemList);
//                        for (int i = 0; i < response.body().size(); i++) {
//                            modalMenuItemList.add(new ModalMenuItem(response.body().get(i).getSubLevelName(), response.body().get(i).getSubLevelId()));
//                        }
//                        modalDialog.reload(Labels.getLabel(getApplicationContext(), curState), modalMenuItemList);
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<TaskSubLevel>> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), "اتصال برقرار نیست", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                break;
//
//            case State.STATE_TASK_TYPE:
//                apiService.getTaskTypeList(stateAndId.get(State.STATE_TASK_SUBLEVEL).getId()).enqueue(new Callback<List<TaskTypes>>() {
//                    @Override
//                    public void onResponse(Call<List<TaskTypes>> call, Response<List<TaskTypes>> response) {
//                        modalMenuItemList.removeAll(modalMenuItemList);
//                        for (int i = 0; i < response.body().size(); i++) {
//                            modalMenuItemList.add(new ModalMenuItem(response.body().get(i).getTypeName(), response.body().get(i).getTypeId()));
//                        }
//                        modalDialog.reload(Labels.getLabel(getApplicationContext(), curState), modalMenuItemList);
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<TaskTypes>> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), "اتصال برقرار نیست", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                break;
//
//            case State.STATE_GROUP_MAIN_CODE:
//                apiService.getGroupMain().enqueue(new Callback<List<GroupMain>>() {
//                    @Override
//                    public void onResponse(Call<List<GroupMain>> call, Response<List<GroupMain>> response) {
//                        modalMenuItemList.removeAll(modalMenuItemList);
//                        for (int i = 0; i < response.body().size(); i++) {
//                            modalMenuItemList.add(new ModalMenuItem(response.body().get(i).getMainName(), response.body().get(i).getMainCode()));
//                        }
//                        modalDialog.reload(Labels.getLabel(getApplicationContext(), curState), modalMenuItemList);
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<GroupMain>> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), "اتصال برقرار نیست", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                break;
//
//            case State.STATE_GROUP_CODE:
//                apiService.getGroupCode(stateAndId.get(State.STATE_GROUP_MAIN_CODE).getId()).enqueue(new Callback<List<GroupCode>>() {
//                    @Override
//                    public void onResponse(Call<List<GroupCode>> call, Response<List<GroupCode>> response) {
//                        modalMenuItemList.removeAll(modalMenuItemList);
//                        for (int i = 0; i < response.body().size(); i++) {
//                            modalMenuItemList.add(new ModalMenuItem(response.body().get(i).getGroupName(), response.body().get(i).getGroupCode1()));
//                        }
//                        modalDialog.reload(Labels.getLabel(getApplicationContext(), curState), modalMenuItemList);
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<GroupCode>> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), "اتصال برقرار نیست", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                break;
//
//            case State.STATE_COURSE_ID:
//                apiService.getCourses(stateAndId.get(State.STATE_GROUP_CODE).getId()).enqueue(new Callback<List<Course>>() {
//                    @Override
//                    public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
//                        modalMenuItemList.removeAll(modalMenuItemList);
//                        for (int i = 0; i < response.body().size(); i++) {
//                            modalMenuItemList.add(new ModalMenuItem(response.body().get(i).getCourseName(), response.body().get(i).getCourseId()));
//                        }
//                        modalDialog.reload(Labels.getLabel(getApplicationContext(), curState), modalMenuItemList);
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<Course>> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), "اتصال برقرار نیست", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                break;
//
//            case State.STATE_TEST_DATE:
//                apiService.getTestDate(stateAndId.get(State.STATE_GROUP_CODE).getId()).enqueue(new Callback<List<TestDate>>() {
//                    @Override
//                    public void onResponse(Call<List<TestDate>> call, Response<List<TestDate>> response) {
//                        modalMenuItemList.removeAll(modalMenuItemList);
//                        for (int i = 0; i < response.body().size(); i++) {
//                            modalMenuItemList.add(new ModalMenuItem(response.body().get(i).getHejri(), response.body().get(i).getDateValue()));
//                        }
//                        modalDialog.reload(Labels.getLabel(getApplicationContext(), curState), modalMenuItemList);
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<TestDate>> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), "اتصال برقرار نیست", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                break;
//
//            case State.STATE_BOOKS:
//                apiService.getBooks().enqueue(new Callback<List<Book>>() {
//                    @Override
//                    public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
//                        modalMenuItemList.removeAll(modalMenuItemList);
//                        for (int i = 0; i < response.body().size(); i++) {
//                            modalMenuItemList.add(new ModalMenuItem(response.body().get(i).getBookName(), response.body().get(i).getId()));
//                        }
//                        modalDialog.reload(Labels.getLabel(getApplicationContext(), curState), modalMenuItemList);
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<Book>> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), "اتصال برقرار نیست", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                break;
//
//            case State.STATE_LOCATION:
//                apiService.getLocations().enqueue(new Callback<List<Location>>() {
//                    @Override
//                    public void onResponse(Call<List<Location>> call, Response<List<Location>> response) {
//                        modalMenuItemList.removeAll(modalMenuItemList);
//                        for (int i = 0; i < response.body().size(); i++) {
//                            modalMenuItemList.add(new ModalMenuItem(response.body().get(i).getLocationName(), response.body().get(i).getLocationId()));
//                        }
//                        modalDialog.reload(Labels.getLabel(getApplicationContext(), curState), modalMenuItemList);
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<Location>> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), "اتصال برقرار نیست", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                break;
//
//            case State.STATE_CHANNEL_ID:
//                apiService.getChannels().enqueue(new Callback<List<Channel>>() {
//                    @Override
//                    public void onResponse(Call<List<Channel>> call, Response<List<Channel>> response) {
//                        modalMenuItemList.removeAll(modalMenuItemList);
//                        for (int i = 0; i < response.body().size(); i++) {
//                            modalMenuItemList.add(new ModalMenuItem(response.body().get(i).getChanneName(), response.body().get(i).getChanneId()));
//                        }
//                        modalDialog.reload(Labels.getLabel(getApplicationContext(), curState), modalMenuItemList);
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<Channel>> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), "اتصال برقرار نیست", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                break;
//
//            case State.STATE_TEST_TYPE:
//                apiService.getTestTypes(stateAndId.get(State.STATE_GROUP_MAIN_CODE).getId()).enqueue(new Callback<List<TestType>>() {
//                    @Override
//                    public void onResponse(Call<List<TestType>> call, Response<List<TestType>> response) {
//                        modalMenuItemList.removeAll(modalMenuItemList);
//                        for (int i = 0; i < response.body().size(); i++) {
//                            modalMenuItemList.add(new ModalMenuItem(response.body().get(i).getTestTypeName(), response.body().get(i).getTestTypeId()));
//                        }
//                        modalDialog.reload(Labels.getLabel(getApplicationContext(), curState), modalMenuItemList);
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<TestType>> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), "اتصال برقرار نیست", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                break;
//
//            case State.STATE_CATEGORY:
//                apiService.getCategories().enqueue(new Callback<List<Category>>() {
//                    @Override
//                    public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
//                        modalMenuItemList.removeAll(modalMenuItemList);
//                        for (int i = 0; i < response.body().size(); i++) {
//                            modalMenuItemList.add(new ModalMenuItem(response.body().get(i).getCatagoryName(), response.body().get(i).getCatagoryId()));
//                        }
//                        modalDialog.reload(Labels.getLabel(getApplicationContext(), curState), modalMenuItemList);
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<Category>> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), "اتصال برقرار نیست", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                break;
//            case State.STATE_MANAGER_USER_ID:
//                apiService.getManagers().enqueue(new Callback<List<Managers>>() {
//                    @Override
//                    public void onResponse(Call<List<Managers>> call, Response<List<Managers>> response) {
//                        modalMenuItemList.removeAll(modalMenuItemList);
//                        for (int i = 0; i < response.body().size(); i++) {
//                            modalMenuItemList.add(new ModalMenuItem(response.body().get(i).getFullname(), response.body().get(i).getUserId()));
//                        }
//                        modalDialog.reload(Labels.getLabel(getApplicationContext(), curState), modalMenuItemList);
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<Managers>> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), "اتصال برقرار نیست", Toast.LENGTH_SHORT).show();
//                    }
//                });
//            default:
//                break;
//        }
//    }

//    private boolean isFinished() {
//        if (curState == State.STATE_FINISH)
//            return true;
//        else return false;
//    }

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


        List<ModalMenuItem> modalMenuItemList = new ArrayList<>();
        modalMenuItemList.add(new ModalMenuItem("آیتم اول", 2));
        modalMenuItemList.add(new ModalMenuItem("آیتم اول", 2));
        modalMenuItemList.add(new ModalMenuItem("آیتم اول", 2));
        modalMenuItemList.add(new ModalMenuItem("آیتم اول", 2));
        modalMenuItemList.add(new ModalMenuItem("آیتم اول", 2));
        modalMenuItemList.add(new ModalMenuItem("آیتم اول", 2));
        modalMenuItemList.add(new ModalMenuItem("آیتم اول", 2));
        modalMenuItemList.add(new ModalMenuItem("آیتم اول", 2));
        modalMenuItemList.add(new ModalMenuItem("آیتم اول", 2));
        modalMenuItemList.add(new ModalMenuItem("آیتم اول", 2));
        modalMenuItemList.add(new ModalMenuItem("آیتم اول", 2));
        modalMenuItemList.add(new ModalMenuItem("آیتم اول", 2));
        modalMenuItemList.add(new ModalMenuItem("آیتم اول", 2));
        modalMenuItemList.add(new ModalMenuItem("آیتم اول", 2));
        modalMenuItemList.add(new ModalMenuItem("آیتم اول", 2));
        modalMenuItemList.add(new ModalMenuItem("آیتم اول", 2));
        modalMenuItemList.add(new ModalMenuItem("آیتم اول", 2));
        modalMenuItemList.add(new ModalMenuItem("آیتم اول", 2));
        modalMenuItemList.add(new ModalMenuItem("آیتم اول", 2));
        modalMenuItemList.add(new ModalMenuItem("آیتم اول", 2));
        modalMenuItemList.add(new ModalMenuItem("آیتم اول", 2));
        modalMenuItemList.add(new ModalMenuItem("آیتم اول", 2));
        modalMenuItemList.add(new ModalMenuItem("آیتم اول", 2));
        modalMenuItemList.add(new ModalMenuItem("آیتم اول", 2));
        modalMenuItemList.add(new ModalMenuItem("آیتم اول", 2));
        modalMenuItemList.add(new ModalMenuItem("آیتم اول", 2));

        ModalDialog dialog = new ModalDialog("تایتل",modalMenuItemList, AddTaskActivity.this);
        dialog.show();
    }

//    private void writeToClass() {
//        for (int i = 0; i < stateList.size(); i++) {
//            int state = stateList.get(i);
//            switch (state) {
//                case State.STATE_TASKS_MAIN:
//                    task.setTaskMainId(stateAndId.get(state).getId());
//                    break;
//                case State.STATE_TASK_SUBLEVEL:
//                    task.setTaskSubLevelId(stateAndId.get(state).getId());
//                    break;
//                case State.STATE_TASK_TYPE:
//                    task.setTaskType(stateAndId.get(state).getId());
//                    break;
//                case State.STATE_MANAGER_USER_ID:
//                    task.setManagerUserId(stateAndId.get(state).getId());
//                    break;
//                case State.STATE_GROUP_MAIN_CODE:
//                    task.setGroupMainCode(stateAndId.get(state).getId());
//                    break;
//                case State.STATE_GROUP_CODE:
//                    task.setGroupCode(stateAndId.get(state).getId());
//                    break;
//                case State.STATE_TEST_DATE:
//                    task.setTestDate(stateAndId.get(state).getId());
//                    break;
//                case State.STATE_BOOKS:
//                    task.setBookId(stateAndId.get(state).getId());
//                    break;
//                case State.STATE_VERSION:
//                    task.setVersion(stateAndId.get(state).getId());
//                    break;
//                case State.STATE_LOCATION:
//                    task.setLocation(stateAndId.get(state).getId());
//                    break;
//                case State.STATE_CHANNEL_ID:
//                    task.setChannelId(stateAndId.get(state).getId());
//                    break;
//                case State.STATE_TEST_TYPE:
//                    task.setTestType(stateAndId.get(state).getId());
//                    break;
//                case State.STATE_CATEGORY:
//                    task.setCategory(stateAndId.get(state).getId());
//                    break;
//                case State.STATE_CRS_SUBJECT:
//                    task.setCrsSubject(stateAndId.get(state).getValue());
//                    break;
//                case State.STATE_SUBJECT:
//                    task.setSubject(stateAndId.get(state).getValue());
//                    break;
//                case State.STATE_SESSION_DATE:
//                    task.setSendDate(stateAndId.get(state).getValue());
//                    break;
//                case State.STATE_SESSION_LOCATION:
//                    task.setSesssionLocation(stateAndId.get(state).getValue());
//                    break;
//                case State.STATE_SESSION_MANAGER:
//                    task.setSesssionManager(stateAndId.get(state).getValue());
//                    break;
//                case State.STATE_TOTAL_CALL_COUNT:
//                    task.setTotalCallCount(Integer.parseInt(stateAndId.get(state).getValue()));
//                    break;
//                case State.STATE_UNSUCCESSFUL_CALL_COUNT:
//                    task.setUnsuccessfulCallCount(Integer.parseInt(stateAndId.get(state).getValue()));
//                    break;
//                case State.STATE_SUCCESSFUL_CALL_COUNT:
//                    task.setSuccessCallCount(Integer.parseInt(stateAndId.get(state).getValue()));
//                    break;
//                case State.STATE_OWNER:
//                    task.setOwner(stateAndId.get(state).getValue());
//                    break;
//                case State.STATE_INTERVIEWEE:
//                    task.setInterviewee(stateAndId.get(state).getValue());
//                    break;
//                case State.STATE_LEARN_SOURCE:
//                    task.setLearnSource(stateAndId.get(state).getValue());
//                    break;
//                case State.STATE_DESCRIPTION:
//                    task.setDescription(stateAndId.get(state).getValue());
//                    break;
//                case State.STATE_COUNT:
//                    task.setCount(Integer.parseInt(stateAndId.get(state).getValue()));
//                    break;
//                case State.STATE_PAGE_COUNT:
//                    task.setPageCount(Integer.parseInt(stateAndId.get(state).getValue()));
//                    break;
//                case State.STATE_QUESTION_COUNT:
//                    task.setQuestionCount(Integer.parseInt(stateAndId.get(state).getValue()));
//                    break;
//                case State.STATE_TIME:
//                    task.setTime(Integer.parseInt(stateAndId.get(state).getValue()));
//                    break;
//                case State.STATE_GENERATE_DATE:
//                    task.setGenerateDate(stateAndId.get(state).getValue());
//                    break;
//                case State.STATE_SEND_DATE:
//                    task.setSendDate(stateAndId.get(state).getValue());
//                    break;
//            }
//        }
//    }
}