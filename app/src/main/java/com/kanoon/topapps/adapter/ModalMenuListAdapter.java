package com.kanoon.topapps.adapter;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Filter;
import android.widget.TextView;

import com.kanoon.topapps.R;
import com.kanoon.topapps.activities.AddTaskActivity;
import com.kanoon.topapps.modal.ModalMenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ehsan on 3/29/2018.
 */

public class ModalMenuListAdapter extends RecyclerView.Adapter<ModalMenuListAdapter.ViewHolder> {

    private List<ModalMenuItem> modalMenuItemList;
    private List<ModalMenuItem> filteredModalMenuItemList;
    private AddTaskActivity activity;

    public ModalMenuListAdapter(List<ModalMenuItem> modalMenuItemList, AddTaskActivity activity) {
        this.modalMenuItemList = modalMenuItemList;
        this.filteredModalMenuItemList = modalMenuItemList;
        this.activity = activity;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView item;

        public ViewHolder(View itemView) {
            super(itemView);
            item = (TextView) itemView.findViewById(R.id.text);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.modal_menu_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.item.setTypeface(Typeface.createFromAsset(activity.getAssets(), "fonts/sl.ttf"));
        holder.item.setText(filteredModalMenuItemList.get(position).getName());
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onModalMenuItemClicked(filteredModalMenuItemList.get(position).getId(), filteredModalMenuItemList.get(position).getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return filteredModalMenuItemList.size();
    }

    public List<ModalMenuItem> getModalMenuItemList() {
        return modalMenuItemList;
    }

    public void setModalMenuItemList(List<ModalMenuItem> modalMenuItemList) {
        this.modalMenuItemList = modalMenuItemList;
    }

    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String s = charSequence.toString();
                if (s.isEmpty()) {
                    filteredModalMenuItemList = modalMenuItemList;
                } else {
                    List<ModalMenuItem> list = new ArrayList<>();
                    for (ModalMenuItem item :
                            modalMenuItemList) {
                        if (item.getName().contains(s))
                            list.add(item);
                    }
                    filteredModalMenuItemList = list;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredModalMenuItemList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredModalMenuItemList = (List<ModalMenuItem>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
