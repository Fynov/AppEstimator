package com.fynov.equaleyes.appestimator.ui.views;

import android.content.Context;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fynov.equaleyes.appestimator.R;

public class ButtonView extends ConstraintLayout {
    View rootView;
    TextView tvCalculate;
    ProgressBar pbLoading;


    public ButtonView(Context context) {
        super(context);
        init(context);
    }

    public ButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    private void init(Context context) {
        rootView = inflate(context, R.layout.button_view, this);
        tvCalculate = rootView.findViewById(R.id.tvcalculate);
        pbLoading = rootView.findViewById(R.id.pbButton);

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //we'll define this method later
                if (pbLoading.getVisibility() == VISIBLE){
                    pbLoading.setVisibility(GONE);
                    tvCalculate.setVisibility(VISIBLE);
                }else {
                    pbLoading.setVisibility(VISIBLE);
                    tvCalculate.setVisibility(GONE);
                }
            }
        });
    }
}
