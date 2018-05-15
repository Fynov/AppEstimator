package com.fynov.equaleyes.appestimator.ui.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fynov.equaleyes.appestimator.R;
import com.fynov.equaleyes.appestimator.databinding.ActivityEstimatorBinding;
import com.fynov.equaleyes.lib_data.DataAll;

public class ActivityEstimator extends AppCompatActivity {
    ActivityEstimatorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimator);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_estimator);
        // Create or access the data to bind
        DataAll all = new DataAll();
        all.Scenario();
        // Attach the user to the binding
        binding.setData(all);

    }
}
