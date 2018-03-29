package com.kanoon.topapps.modal;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextSwitcher;
import android.widget.TextView;

import com.kanoon.topapps.R;
import com.kanoon.topapps.activities.AddTaskActivity;
import com.kanoon.topapps.adapter.ModalMenuListAdapter;

import java.util.List;

/**
 * Created by ehsan on 2/19/2018.
 */

public class ModalDialog extends Dialog {

    private RecyclerView recyclerView;
    private TextView titleTextview;
    private TextSwitcher textSwitcher;
    private EditText searchBar;
    private String title;
    private List<ModalMenuItem> modalMenuItemList;
    private ModalMenuListAdapter adapter;
    private AddTaskActivity activity;

    public ModalDialog(String title, List<ModalMenuItem> modalMenuItemList, AddTaskActivity activity) {
        super(activity);
        this.modalMenuItemList = modalMenuItemList;
        this.title = title;
        this.activity = activity;
        adapter = new ModalMenuListAdapter(modalMenuItemList);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.modal_layout);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Display d = getWindow().getWindowManager().getDefaultDisplay();
        lp.copyFrom(getWindow().getAttributes());
        lp.width = (int) (d.getWidth() * 0.70);
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(lp);
        setCanceledOnTouchOutside(false);

        recyclerView = (RecyclerView) findViewById(R.id.menu_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity.getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }



    //    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.modal_layout, container);
//        recyclerView = (RecyclerView) v.findViewById(R.id.modal_items_list);
//        titleTextview = (TextView) v.findViewById(R.id.title);
//        textSwitcher = (TextSwitcher) v.findViewById(R.id.textSwitcher);
//        searchBar = (EditText) v.findViewById(R.id.search_bar);
//
//        Animation textAnimationIn =  AnimationUtils.
//                loadAnimation(activity.getApplicationContext(),   android.R.anim.fade_in);
//        textAnimationIn.setDuration(300);
//
//        Animation textAnimationOut =  AnimationUtils.
//                loadAnimation(activity.getApplicationContext(),   android.R.anim.fade_out);
//        textAnimationOut.setDuration(300);
//        textSwitcher.setInAnimation(textAnimationIn);
//        textSwitcher.setOutAnimation(textAnimationOut);
//
//
//        searchBar.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                adapter.getFilter().filter(searchBar.getText());
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//
//        return v;
//    }

//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        textSwitcher.setText(title);
//
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(layoutManager);
//        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
//        itemAnimator.setAddDuration(1000);
//        itemAnimator.setRemoveDuration(1000);
//        itemAnimator.setChangeDuration(1000);
//        recyclerView.setItemAnimator(itemAnimator);
//        recyclerView.setAdapter(adapter);
//    }

//    public void onResume() {
//        super.onResume();
//
//        Window window = getDialog().getWindow();
//        Point size = new Point();
//
//        Display display = window.getWindowManager().getDefaultDisplay();
//        display.getSize(size);
//
//        int width = size.x;
//
//        window.setLayout((int) (width * 0.8), WindowManager.LayoutParams.WRAP_CONTENT);
//        window.setGravity(Gravity.CENTER);
//
//        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//    }

//    public void reload(String title, List<ModalMenuItem> modalMenuItemList) {
//        textSwitcher.setText(title);
//        searchBar.setText("");
//        this.modalMenuItemList = modalMenuItemList;
//        adapter.setItems(this.modalMenuItemList);
//        adapter.notifyDataSetChanged();
//    }


}
