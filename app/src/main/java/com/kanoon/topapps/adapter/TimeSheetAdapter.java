package com.kanoon.topapps.adapter;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kanoon.topapps.R;
import com.kanoon.topapps.consts.Labels;
import com.kanoon.topapps.data.model.TimeSheet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ehsan on 3/31/2018.
 */

public class TimeSheetAdapter extends RecyclerView.Adapter<TimeSheetAdapter.ViewHolder> {

    private TimeSheet timeSheet;

    public TimeSheetAdapter(TimeSheet timeSheet) {
        this.timeSheet = timeSheet;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView date, startTime, endTime, duration, durationTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.date);
            startTime = (TextView) itemView.findViewById(R.id.start_time);
            endTime = (TextView) itemView.findViewById(R.id.end_time);
            duration = (TextView) itemView.findViewById(R.id.duration);
            durationTitle = (TextView) itemView.findViewById(R.id.duration_title);

            date.setTypeface(Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/sl.ttf"));
            duration.setTypeface(Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/sl.ttf"));
            endTime.setTypeface(Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/sl.ttf"));
            durationTitle.setTypeface(Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/sl.ttf"));
            startTime.setTypeface(Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/sl.ttf"));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.time_sheet_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String dateString = String.valueOf(timeSheet.getData().getTimeSheets().get(position).getHejriDate());
        String year = dateString.substring(0, 4);
        dateString = dateString.substring(4);
        String month = dateString.substring(0, 2);
        String day = dateString.substring(2);

        holder.date.setText(number2farsi(day) + " " + Labels.getMonth(holder.itemView.getContext(), Integer.parseInt(month)) + " " + number2farsi(year));
        holder.startTime.setText(number2farsi(String.valueOf(timeSheet.getData().getTimeSheets().get(position).getStartTime().getHour()))
         + ":" + number2farsi(String.valueOf(timeSheet.getData().getTimeSheets().get(position).getStartTime().getMinute()))
         + ":" + number2farsi(String.valueOf(timeSheet.getData().getTimeSheets().get(position).getStartTime().getSecond())));

        holder.endTime.setText(number2farsi(String.valueOf(timeSheet.getData().getTimeSheets().get(position).getEndTime().getHour()))
                + ":" + number2farsi(String.valueOf(timeSheet.getData().getTimeSheets().get(position).getEndTime().getMinute()))
                + ":" + number2farsi(String.valueOf(timeSheet.getData().getTimeSheets().get(position).getEndTime().getSecond())));

        holder.duration.setText(number2farsi(String.valueOf(timeSheet.getData().getTimeSheets().get(position).getDuration().getHour()))
                + ":" + number2farsi(String.valueOf(timeSheet.getData().getTimeSheets().get(position).getDuration().getMinute()))
                + ":" + number2farsi(String.valueOf(timeSheet.getData().getTimeSheets().get(position).getDuration().getSecond())));
    }

    @Override
    public int getItemCount() {
        return timeSheet.getData().getTimeSheets().size();
    }

    private static String number2farsi(String b) {

        Map<String, String> replaceMap = new HashMap<>();
        replaceMap.put("0", "۰");
        replaceMap.put("1", "۱");
        replaceMap.put("2", "۲");
        replaceMap.put("3", "۳");
        replaceMap.put("4", "۴");
        replaceMap.put("5", "۵");
        replaceMap.put("6", "۶");
        replaceMap.put("7", "۷");
        replaceMap.put("8", "۸");
        replaceMap.put("9", "۹");

        for (Map.Entry<String, String> entry : replaceMap.entrySet()) {
            b = b.replaceAll(entry.getKey(), entry.getValue());
        }

        return b;
    }
}
