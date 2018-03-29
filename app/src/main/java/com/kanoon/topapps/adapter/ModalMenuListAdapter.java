package com.kanoon.topapps.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kanoon.topapps.R;
import com.kanoon.topapps.modal.ModalMenuItem;

import java.util.List;

/**
 * Created by ehsan on 3/29/2018.
 */

public class ModalMenuListAdapter extends RecyclerView.Adapter<ModalMenuListAdapter.ViewHolder> {

    private List<ModalMenuItem> modalMenuItemList;

    public ModalMenuListAdapter(List<ModalMenuItem> modalMenuItemList) {
        this.modalMenuItemList = modalMenuItemList;
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
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.item.setText(modalMenuItemList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return modalMenuItemList.size();
    }
}
