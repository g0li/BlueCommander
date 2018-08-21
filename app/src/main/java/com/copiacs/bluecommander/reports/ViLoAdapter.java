package com.copiacs.bluecommander.reports;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.copiacs.bluecommander.R;

public class ViLoAdapter extends RecyclerView.Adapter<ViLoAdapter.VIBuHolder> {
    @NonNull
    @Override
    public VIBuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_visitor_log,parent,false);
        return new VIBuHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VIBuHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class VIBuHolder extends RecyclerView.ViewHolder{
        public VIBuHolder(View itemView) {
            super(itemView);
        }
    }
}
