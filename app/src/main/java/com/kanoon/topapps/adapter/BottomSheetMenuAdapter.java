package com.kanoon.topapps.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kanoon.topapps.R;
import com.kanoon.topapps.activities.AddTaskActivity;
import com.kanoon.topapps.bottomSheet.BottomSheetMenuItem;

import java.util.List;

/**
 * Created by ehsan on 2/15/2018.
 */

public class BottomSheetMenuAdapter extends RecyclerView.Adapter<BottomSheetMenuAdapter.ViewHolder> {

    private List<BottomSheetMenuItem> items;
    private AddTaskActivity activity;

    public BottomSheetMenuAdapter(List<BottomSheetMenuItem> items, AddTaskActivity activity) {
        this.items = items;
        this.activity = activity;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView itemlist;

        public ViewHolder(View itemView) {
            super(itemView);
            itemlist = (TextView) itemView.findViewById(R.id.text);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item_list_dialog_item, parent, false);
        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.itemlist.setText(items.get(position).getName());
        holder.itemlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onBottomSheetMenuItemClicked(items.get(position).getId(), items.get(position).getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}