package com.copiacs.bluecommander.visitorslist;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.copiacs.bluecommander.R;
import com.copiacs.bluecommander.view.CustomVerticalStepperFormLayout;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.ArrayList;
import java.util.List;

import ernestoyaquello.com.verticalstepperform.VerticalStepperFormLayout;
import ernestoyaquello.com.verticalstepperform.interfaces.VerticalStepperForm;

public class NewVisitorEntry extends AppCompatActivity implements VerticalStepperForm {
    VerticalStepperFormLayout verticalStepperForm;
    MaterialSpinner vehicleType;
    ViewGroup vg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_visitor_entry);


        String[] mySteps = {"Personal Details", "Vehicle and Identification", "Host Details"};
        String[] myStepsSub = {"Enter Visitor's Info", "Enter Visitor's Info", "Enter Host Info"};

        int colorPrimary = ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary);
        int colorPrimaryDark = ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark);
        verticalStepperForm =  findViewById(R.id.vertical_stepper_form);
        CustomVerticalStepperFormLayout.Builder.newInstance(verticalStepperForm, mySteps, this, this)
                .primaryColor(colorPrimary)
                .primaryDarkColor(colorPrimaryDark)
                .displayBottomNavigation(true)
                .materialDesignInDisabledSteps(true)
                .stepsSubtitles(myStepsSub)
                .init();
        vg=(ViewGroup)verticalStepperForm;
        }
    @Override
    public View createStepContentView(int stepNumber) {
        View view= LayoutInflater.from(this).inflate(R.layout.vs_personaldetails,vg);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        switch (stepNumber)
        {
            case 0:
                view= LayoutInflater.from(this).inflate(R.layout.vs_personaldetails,vg);
                    return view;
            case 1:
                view= LayoutInflater.from(this).inflate(R.layout.vs_vehicledetails,vg);

                List<String>data=new ArrayList<>();
                for(int i=0;i<5;i++)
                {
                    data.add("Type "+i);
                }
                MaterialSpinner vType=view.findViewById(R.id.vehicleType);
                vType.setItems(data);
                MaterialSpinner idType=view.findViewById(R.id.idSpinner);
                idType.setItems(data);
                return view;

            case 2:
                view= LayoutInflater.from(this).inflate(R.layout.vs_hostdetails,vg);

                List<String>data2=new ArrayList<>();
                for(int i=0;i<5;i++)
                {
                    data2.add("Type "+i);
                }
                MaterialSpinner building=view.findViewById(R.id.hostBuilding);
                building.setItems(data2);
                List<String>data3=new ArrayList<>();
                for(int i=0;i<5;i++)
                {
                    data3.add("Type "+i);
                }
                MaterialSpinner gate=view.findViewById(R.id.hostGate);
                gate.setItems(data3);
                return view;
        }
        return null;
    }

    @Override
    public void onStepOpening(int stepNumber) {
        verticalStepperForm.setActiveStepAsCompleted();
    }

    @Override
    public void sendData() {
    finish();
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

}
