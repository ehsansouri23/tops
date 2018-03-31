package com.kanoon.topapps.modal;


import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.kanoon.topapps.R;
import com.kanoon.topapps.activities.AddTaskActivity;
import com.kanoon.topapps.adapter.ModalMenuListAdapter;
import com.kanoon.topapps.consts.State;
import com.kanoon.topapps.consts.Types;

import java.util.List;

/**
 * Created by ehsan on 2/19/2018.
 */

public class ModalDialog extends Dialog {

    private RecyclerView recyclerView;
    private TextView titleTextview;
    private TextSwitcher textSwitcher;
    private EditText searchBar, enterValue;
    private Button submit;
    private String title;
    private List<ModalMenuItem> modalMenuItemList;
    private ModalMenuListAdapter adapter;
    private AddTaskActivity activity;
    private int type;
    private int editTextMode;

    public ModalDialog(String title, List<ModalMenuItem> modalMenuItemList, AddTaskActivity activity) {
        super(activity);
        this.modalMenuItemList = modalMenuItemList;
        this.title = title;
        this.activity = activity;
        adapter = new ModalMenuListAdapter(modalMenuItemList, activity);
        type = Types.TYPE_OPTION;
    }

    public ModalDialog(String title, int editTextMode , AddTaskActivity activity) {
        super(activity);
        this.title = title;
        this.activity = activity;
        type = Types.TYPE_INPUT;
        this.editTextMode = editTextMode;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (type == Types.TYPE_OPTION)
            setContentView(R.layout.modal_layout);
        else
            setContentView(R.layout.edittext_modal_layout);

        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Display d = getWindow().getWindowManager().getDefaultDisplay();
        lp.copyFrom(getWindow().getAttributes());
        lp.width = (int) (d.getWidth() * 0.70);
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(lp);
        setCanceledOnTouchOutside(false);

        if (type == Types.TYPE_OPTION) {
            recyclerView = (RecyclerView) findViewById(R.id.menu_list);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity.getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);

            textSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);
            Animation textAnimationIn = AnimationUtils.
                    loadAnimation(activity.getApplicationContext(), android.R.anim.fade_in);
            textAnimationIn.setDuration(300);

            Animation textAnimationOut = AnimationUtils.
                    loadAnimation(activity.getApplicationContext(), android.R.anim.fade_out);
            textAnimationOut.setDuration(300);
            textSwitcher.setInAnimation(textAnimationIn);
            textSwitcher.setOutAnimation(textAnimationOut);

            textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
                @Override
                public View makeView() {
                    TextView t = new TextView(activity.getApplicationContext());
                    t.setTypeface(Typeface.createFromAsset(activity.getAssets(), "fonts/sl.ttf"));
                    t.setText("salam");
                    return t;
                }
            });
            textSwitcher.setCurrentText(title);

            searchBar = (EditText) findViewById(R.id.search_bar);
            searchBar.setTypeface(Typeface.createFromAsset(activity.getAssets(), "fonts/sl.ttf"));
            searchBar.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    adapter.getFilter().filter(searchBar.getText());
                }

                @Override
                public void afterTextChanged(Editable editable) {
                }
            });

        } else {
            titleTextview = (TextView) findViewById(R.id.title);
            enterValue = (EditText) findViewById(R.id.edit);
            submit = (Button) findViewById(R.id.submit);
            titleTextview.setText(title);
            if (editTextMode == State.STATE_COUNT || editTextMode == State.STATE_PAGE_COUNT || editTextMode == State.STATE_QUESTION_COUNT
                    || editTextMode == State.STATE_SUCCESSFUL_CALL_COUNT || editTextMode == State.STATE_UNSUCCESSFUL_CALL_COUNT
                    || editTextMode == State.STATE_TOTAL_CALL_COUNT || editTextMode == State.STATE_TIME)
                enterValue.setInputType(InputType.TYPE_CLASS_NUMBER);
            titleTextview.setTypeface(Typeface.createFromAsset(activity.getAssets(), "fonts/sl.ttf"));
            enterValue.setTypeface(Typeface.createFromAsset(activity.getAssets(), "fonts/sl.ttf"));
            submit.setTypeface(Typeface.createFromAsset(activity.getAssets(), "fonts/sl.ttf"));
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (enterValue.getText().toString().equals("")) {
                        enterValue.setHint(R.string.shouldNotEmpty);
                        enterValue.setHintTextColor(activity.getResources().getColor(R.color.colorAccent));
                    } else {
                        activity.onEdittextDialogClicked(enterValue.getText().toString());
                    }
                }
            });
        }
    }


    public void reload(String title, List<ModalMenuItem> modalMenuItemList) {
        textSwitcher.setText(title);
        searchBar.setText("");
        this.modalMenuItemList = modalMenuItemList;
        adapter.setModalMenuItemList(this.modalMenuItemList);
        adapter.notifyDataSetChanged();
        if (!isShowing())
            show();
    }

    public void reload(String title) {

    }


}
