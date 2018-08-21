package com.copiacs.bluecommander.accountsetup;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.copiacs.bluecommander.R;

public class DVisAdapter extends RecyclerView.Adapter<DVisAdapter.BuildingHolder>{
    @NonNull
    @Override
    public BuildingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dvistr,parent,false);
        return new BuildingHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BuildingHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class BuildingHolder extends RecyclerView.ViewHolder{
        public BuildingHolder(View itemView) {
            super(itemView);
        }
    }
}
