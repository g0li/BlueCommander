package com.copiacs.bluecommander.dailyvisitors;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
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

public class NewDVisitorEntry extends AppCompatActivity implements VerticalStepperForm {
    VerticalStepperFormLayout verticalStepperForm;
    ViewGroup vg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_visitor_entry);


        String[] mySteps = {"Personal Details", "Vehicle and Identification"};
        String[] myStepsSub = {"Enter Visitor's Info", "Enter Visitor's Info"};

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
