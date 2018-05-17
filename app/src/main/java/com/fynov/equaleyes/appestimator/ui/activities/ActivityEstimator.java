package com.fynov.equaleyes.appestimator.ui.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Gravity;

import com.fynov.equaleyes.appestimator.R;
import com.fynov.equaleyes.appestimator.data.ApplicationMy;
import com.fynov.equaleyes.appestimator.data.models.Category;
import com.fynov.equaleyes.appestimator.databinding.ActivityEstimatorBinding;
import com.fynov.equaleyes.appestimator.ui.adapters.CategoryAdapter;
import com.fynov.equaleyes.appestimator.viewmodels.EstimatorViewModel;

import java.util.ArrayList;

public class ActivityEstimator extends AppCompatActivity {
    private ActivityEstimatorBinding binding;
    private EstimatorViewModel mEstimatorViewModel;
    private RecyclerView.LayoutManager mLayoutManagaer;
    CategoryAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mEstimatorViewModel = ViewModelProviders.of(this).get(EstimatorViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_estimator);

        mLayoutManagaer = new LinearLayoutManager(this);
        mAdapter = new CategoryAdapter(new ArrayList<Category>());

        binding.rvCategories.setLayoutManager(mLayoutManagaer);
        binding.rvCategories.setAdapter(mAdapter);
        binding.toolbar.setTitle(R.string.app_name);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            binding.textView.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
            binding.textView.setGravity(Gravity.LEFT);
        }

        subscribe();
    }

    private void subscribe(){
        final Observer<ArrayList<Category>> categoryObserver = new Observer<ArrayList<Category>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Category> categories) {
                mAdapter.setItems(categories);
            }
        };
        mEstimatorViewModel.getCategoryList().observe(this, categoryObserver);
    }
}
