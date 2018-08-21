package com.copiacs.bluecommander.reports;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.copiacs.bluecommander.R;
import com.copiacs.bluecommander.dailyvisitors.DailyVisitors;
import com.github.fabtransitionactivity.SheetLayout;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.VehicleHolder> {

    @NonNull
    @Override
    public VehicleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VehicleHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vehicle_log,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class VehicleHolder extends RecyclerView.ViewHolder {
        public VehicleHolder(final View itemView) {
            super(itemView);
            itemView.findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
                @Override
               public void onClick(View v) {
                    CardView coordinatorLayout=itemView.findViewById(R.id.cardib);
                    Snackbar.make(coordinatorLayout,"Four Wheeler - MH43AC4755",Snackbar.LENGTH_LONG).show();                }
            });

        }


    }
}
