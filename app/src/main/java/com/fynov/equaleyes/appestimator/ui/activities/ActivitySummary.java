package com.fynov.equaleyes.appestimator.ui.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fynov.equaleyes.appestimator.R;
import com.fynov.equaleyes.appestimator.data.models.CalculatorReturn;
import com.fynov.equaleyes.appestimator.data.models.Category;
import com.fynov.equaleyes.appestimator.databinding.ActivitySummaryBinding;
import com.fynov.equaleyes.appestimator.viewmodels.SummaryViewModel;
import com.fynov.equaleyes.appestimator.viewmodels.SummaryViewModelFactory;

import java.util.ArrayList;

public class ActivitySummary extends AppCompatActivity {
    ActivitySummaryBinding binding;
    SummaryViewModel mSummaryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_summary);


        final SummaryViewModelFactory factory =
                new SummaryViewModelFactory(getIntent().getStringExtra("idList"));

         mSummaryViewModel = ViewModelProviders.of(this, factory).get(SummaryViewModel.class);
         subscribe();
    }

    private void subscribe(){
        final Observer<CalculatorReturn> categoryObserver = new Observer<CalculatorReturn>() {
            @Override
            public void onChanged(@Nullable CalculatorReturn calc) {
                binding.setCalculate(calc);
                binding.executePendingBindings();
            }
        };
        mSummaryViewModel.getCalculatorReturn().observe(this, categoryObserver);
    }
}
