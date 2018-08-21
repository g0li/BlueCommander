package com.copiacs.bluecommander.visitorexit;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.copiacs.bluecommander.R;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class VisitorExitAdapter extends RecyclerView.Adapter<VisitorExitAdapter.VisitorListHolder> {
    @NonNull
    @Override
    public VisitorListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_visitor_exit,parent,false);
        return new VisitorListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VisitorListHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class VisitorListHolder extends RecyclerView.ViewHolder{
        ImageButton details;
        RelativeLayout mRelativeLayout;
        private PopupWindow mPopupWindow;
        public VisitorListHolder(View itemView) {
            super(itemView);
            details=itemView.findViewById(R.id.details);
            mRelativeLayout=itemView.findViewById(R.id.mRelativeLayout);
            details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LayoutInflater inflater = (LayoutInflater) v.getContext().getSystemService(LAYOUT_INFLATER_SERVICE);

                    // Inflate the custom layout/view
                    View customView = inflater.inflate(R.layout.item_view_details_pop,null);
                    mPopupWindow = new PopupWindow(
                            customView,
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                    );
                    if(Build.VERSION.SDK_INT>=21){
                        mPopupWindow.setElevation(5.0f);
                    }
                    mPopupWindow.setAnimationStyle(R.style.Animation);
                    Button closeButton =  customView.findViewById(R.id.close);

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mPopupWindow.dismiss();
                        }
                    });
                    mPopupWindow.showAtLocation(mRelativeLayout, Gravity.CENTER,0,0);

                }
            });
        }
    }
}
