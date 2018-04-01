package com.kanoon.topapps.consts;

import android.content.Context;

import com.kanoon.topapps.R;

import java.net.ContentHandler;

/**
 * Created by ehsan on 2/16/2018.
 */

public class Labels {
    public static String getLabel(Context context, int state) {
        String label;

        switch (state) {
            case State.STATE_TASKS_MAIN:
                label = context.getResources().getString(R.string.tasks_main);
                break;
            case State.STATE_TASK_SUBLEVEL:
                label = context.getResources().getString(R.string.task_sublevel);
                break;
            case State.STATE_TASK_TYPE:
                label = context.getResources().getString(R.string.task_type);
                break;
            case State.STATE_GROUP_MAIN_CODE:
                label = context.getResources().getString(R.string.group_main_code);
                break;
            case State.STATE_GROUP_CODE:
                label = context.getResources().getString(R.string.group_code);
                break;
            case State.STATE_COURSE_ID:
                label = context.getResources().getString(R.string.course_id);
                break;
            case State.STATE_TEST_DATE:
                label = context.getResources().getString(R.string.test_date);
                break;
            case State.STATE_BOOKS:
                label = context.getResources().getString(R.string.books);
                break;
            case State.STATE_VERSION:
                label = context.getResources().getString(R.string.version);
                break;
            case State.STATE_LOCATION:
                label = context.getResources().getString(R.string.location);
                break;
            case State.STATE_CHANNEL_ID:
                label = context.getResources().getString(R.string.channel_id);
                break;
            case State.STATE_TEST_TYPE:
                label = context.getResources().getString(R.string.test_type);
                break;
            case State.STATE_CATEGORY:
                label = context.getResources().getString(R.string.category);
                break;
            case State.STATE_CRS_SUBJECT:
                label = context.getResources().getString(R.string.crs_subject);
                break;
            case State.STATE_SUBJECT:
                label = context.getResources().getString(R.string.subject);
                break;
            case State.STATE_SESSION_DATE:
                label = context.getResources().getString(R.string.session_date);
                break;
            case State.STATE_SESSION_LOCATION:
                label = context.getResources().getString(R.string.session_location);
                break;
            case State.STATE_SESSION_MANAGER:
                label = context.getResources().getString(R.string.session_manager);
                break;
            case State.STATE_TOTAL_CALL_COUNT:
                label = context.getResources().getString(R.string.total_call_count);
                break;
            case State.STATE_SUCCESSFUL_CALL_COUNT:
                label = context.getResources().getString(R.string.successful_call_count);
                break;
            case State.STATE_UNSUCCESSFUL_CALL_COUNT:
                label = context.getResources().getString(R.string.unsuccessful_call_count);
                break;
            case State.STATE_OWNER:
                label = context.getResources().getString(R.string.owner);
                break;
            case State.STATE_INTERVIEWEE:
                label = context.getResources().getString(R.string.interviewee);
                break;
            case State.STATE_LEARN_SOURCE:
                label = context.getResources().getString(R.string.learn_course);
                break;
            case State.STATE_DESCRIPTION:
                label = context.getResources().getString(R.string.description);
                break;
            case State.STATE_COUNT:
                label = context.getResources().getString(R.string.count);
                break;
            case State.STATE_PAGE_COUNT:
                label = context.getResources().getString(R.string.page_count);
                break;
            case State.STATE_QUESTION_COUNT:
                label = context.getResources().getString(R.string.question_count);
                break;
            case State.STATE_TIME:
                label = context.getResources().getString(R.string.time);
                break;
            case State.STATE_GENERATE_DATE:
                label = context.getResources().getString(R.string.generate_date);
                break;
            case State.STATE_SEND_DATE:
                label = context.getResources().getString(R.string.send_date);
                break;
            case State.STATE_MANAGER_USER_ID:
                label = context.getResources().getString(R.string.manager);
                break;
            default:
                label = "...";
        }
        return label;
    }

    public static String getMonth(Context context, int month) {
        String label;

        switch (month) {
            case 1:
                label = context.getResources().getString(R.string.farvardin);
                break;
            case 2:
                label = context.getResources().getString(R.string.ordibehesht);
                break;
            case 3:
                label = context.getResources().getString(R.string.khordad);
                break;
            case 4:
                label = context.getResources().getString(R.string.tir);
                break;
            case 5:
                label = context.getResources().getString(R.string.mordad);
                break;
            case 6:
                label = context.getResources().getString(R.string.shahrivar);
                break;
            case 7:
                label = context.getResources().getString(R.string.mehr);
                break;
            case 8:
                label = context.getResources().getString(R.string.aban);
                break;
            case 9:
                label = context.getResources().getString(R.string.azar);
                break;
            case 10:
                label = context.getResources().getString(R.string.day);
                break;
            case 11:
                label = context.getResources().getString(R.string.bahman);
                break;
            case 12:
                label = context.getResources().getString(R.string.esfand);
                break;
            default:
                label = "...";
        }
        return label;
    }
}