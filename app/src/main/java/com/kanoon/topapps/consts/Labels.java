package com.kanoon.topapps.consts;

import android.content.Context;

import com.kanoon.topapps.R;

import java.net.ContentHandler;

/**
 * Created by ehsan on 2/16/2018.
 */

public class Labels {
    public static String getLabel(Context contex, int state) {
        String label;

        switch (state) {
            case State.STATE_TASKS_MAIN:
                label = contex.getResources().getString(R.string.tasks_main);
                break;
            case State.STATE_TASK_SUBLEVEL:
                label = contex.getResources().getString(R.string.task_sublevel);
                break;
            case State.STATE_TASK_TYPE:
                label = contex.getResources().getString(R.string.task_type);
                break;
            case State.STATE_GROUP_MAIN_CODE:
                label = contex.getResources().getString(R.string.group_main_code);
                break;
            case State.STATE_GROUP_CODE:
                label = contex.getResources().getString(R.string.group_code);
                break;
            case State.STATE_COURSE_ID:
                label = contex.getResources().getString(R.string.course_id);
                break;
            case State.STATE_TEST_DATE:
                label = contex.getResources().getString(R.string.test_date);
                break;
            case State.STATE_BOOKS:
                label = contex.getResources().getString(R.string.books);
                break;
            case State.STATE_VERSION:
                label = contex.getResources().getString(R.string.version);
                break;
            case State.STATE_LOCATION:
                label = contex.getResources().getString(R.string.location);
                break;
            case State.STATE_CHANNEL_ID:
                label = contex.getResources().getString(R.string.channel_id);
                break;
            case State.STATE_TEST_TYPE:
                label = contex.getResources().getString(R.string.test_type);
                break;
            case State.STATE_CATEGORY:
                label = contex.getResources().getString(R.string.category);
                break;
            case State.STATE_CRS_SUBJECT:
                label = contex.getResources().getString(R.string.crs_subject);
                break;
            case State.STATE_SUBJECT:
                label = contex.getResources().getString(R.string.subject);
                break;
            case State.STATE_SESSION_DATE:
                label = contex.getResources().getString(R.string.session_date);
                break;
            case State.STATE_SESSION_LOCATION:
                label = contex.getResources().getString(R.string.session_location);
                break;
            case State.STATE_SESSION_MANAGER:
                label = contex.getResources().getString(R.string.session_manager);
                break;
            case State.STATE_TOTAL_CALL_COUNT:
                label = contex.getResources().getString(R.string.total_call_count);
                break;
            case State.STATE_SUCCESSFUL_CALL_COUNT:
                label = contex.getResources().getString(R.string.successful_call_count);
                break;
            case State.STATE_UNSUCCESSFUL_CALL_COUNT:
                label = contex.getResources().getString(R.string.unsuccessful_call_count);
                break;
            case State.STATE_OWNER:
                label = contex.getResources().getString(R.string.owner);
                break;
            case State.STATE_INTERVIEWEE:
                label = contex.getResources().getString(R.string.interviewee);
                break;
            case State.STATE_LEARN_SOURCE:
                label = contex.getResources().getString(R.string.learn_course);
                break;
            case State.STATE_DESCRIPTION:
                label = contex.getResources().getString(R.string.description);
                break;
            case State.STATE_COUNT:
                label = contex.getResources().getString(R.string.count);
                break;
            case State.STATE_PAGE_COUNT:
                label = contex.getResources().getString(R.string.page_count);
                break;
            case State.STATE_QUESTION_COUNT:
                label = contex.getResources().getString(R.string.question_count);
                break;
            case State.STATE_TIME:
                label = contex.getResources().getString(R.string.time);
                break;
            case State.STATE_GENERATE_DATE:
                label = contex.getResources().getString(R.string.generate_date);
                break;
            case State.STATE_SEND_DATE:
                label = contex.getResources().getString(R.string.send_date);
                break;
            default:
                label = "...";
        }
        return label;
    }
}
