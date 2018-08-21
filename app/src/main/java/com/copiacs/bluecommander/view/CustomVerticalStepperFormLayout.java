package com.copiacs.bluecommander.view;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.copiacs.bluecommander.R;

import ernestoyaquello.com.verticalstepperform.VerticalStepperFormLayout;

public class CustomVerticalStepperFormLayout extends VerticalStepperFormLayout {
    public static final String TAG = "CustomStepperFormLayout";
    public CustomVerticalStepperFormLayout(Context context) {
        super(context);
    }

    public CustomVerticalStepperFormLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomVerticalStepperFormLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void setUpStep(int stepNumber) {
        Log.d(TAG, "setUpStep: CUSTOM STEPPER METHOD BEING CALLED");
        LinearLayout stepLayout = createStepLayout(stepNumber);
        if (stepNumber < numberOfSteps) {
            // The content of the step is the corresponding custom view previously created
            RelativeLayout stepContent = stepLayout.findViewById(R.id.step_content);
            // start new
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            stepContent.addView(stepContentViews.get(stepNumber), params);
            // end new
        } else {
            setUpStepLayoutAsConfirmationStepLayout(stepLayout);
        }
        addStepToContent(stepLayout);
    }
}
