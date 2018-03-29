package com.kanoon.topapps.menu_item;

import com.kanoon.topapps.consts.State;
import com.kanoon.topapps.consts.Types;

import java.util.IllegalFormatCodePointException;

/**
 * Created by ehsan on 2/16/2018.
 */

public class MainMenuItem {
    private int type;
    private int state;
    private String title;
    private String chosen;
    private boolean done;

    public MainMenuItem(int state) {
        this.state = state;
        if (state >= State.STATE_TASKS_MAIN && state <= State.STATE_CATEGORY)
            type = Types.TYPE_OPTION;

        else
            type = Types.TYPE_INPUT;
        chosen = "انتخاب کنید...";
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChosen() {
        return chosen;
    }

    public void setChosen(String chosen) {
        this.chosen = chosen;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
