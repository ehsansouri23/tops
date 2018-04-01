package com.kanoon.topapps.adapter;

import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kanoon.topapps.R;
import com.kanoon.topapps.activities.AddTaskActivity;
import com.kanoon.topapps.consts.Labels;
import com.kanoon.topapps.consts.State;
import com.kanoon.topapps.menu_item.MainMenuItem;

import java.util.List;

/**
 * Created by ehsan on 2/13/2018.
 */

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.ViewHolder> {

    private List<MainMenuItem> menuItemList;
    private AddTaskActivity activity;

    public MenuListAdapter(List<MainMenuItem> menuItemList, AddTaskActivity activity) {
        this.menuItemList = menuItemList;
        this.activity = activity;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView chosen;
        public CardView layout;

        public ViewHolder(View itemView) {
            super(itemView);
            layout = (CardView) itemView.findViewById(R.id.layout);
            title = (TextView) itemView.findViewById(R.id.title);
            chosen = (TextView) itemView.findViewById(R.id.chosen);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        int state = menuItemList.get(position).getState();
        String title = Labels.getLabel(activity.getApplicationContext(), state);
        holder.title.setTypeface(Typeface.createFromAsset(activity.getAssets(), "fonts/sl.ttf"));
        holder.title.setText(title);
        holder.chosen.setTypeface(Typeface.createFromAsset(activity.getAssets(), "fonts/sl.ttf"));
        holder.chosen.setText(menuItemList.get(position).getChosen());
        if (menuItemList.get(position).isDone()) {
            holder.layout.setBackgroundColor(activity.getApplicationContext().getResources().getColor(R.color.colorDone));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onMenuItemClicked(position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return menuItemList.size();
    }
}
