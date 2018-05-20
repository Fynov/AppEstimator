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
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.fynov.equaleyes.appestimator.R;
import com.fynov.equaleyes.appestimator.data.ApplicationMy;
import com.fynov.equaleyes.appestimator.data.models.Category;
import com.fynov.equaleyes.appestimator.data.models.Feature;
import com.fynov.equaleyes.appestimator.databinding.ActivityEstimatorBinding;
import com.fynov.equaleyes.appestimator.ui.adapters.CategoryAdapter;
import com.fynov.equaleyes.appestimator.utils.Callback;
import com.fynov.equaleyes.appestimator.viewmodels.EstimatorViewModel;
import com.fynov.equaleyes.appestimator.viewmodels.EstimatorViewModelFactory;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class    ActivityEstimator extends AppCompatActivity {
    private ActivityEstimatorBinding binding;
    private EstimatorViewModel mEstimatorViewModel;
    private RecyclerView.LayoutManager mLayoutManagaer;
    CategoryAdapter mAdapter;
    ArrayList<Category> categoryArrayList;

    TextView tvTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        EstimatorViewModelFactory factory =
                new EstimatorViewModelFactory(getIntent().getStringExtra("template_name"));

        mEstimatorViewModel = ViewModelProviders.of(this, factory).get(EstimatorViewModel.class);
        //mEstimatorViewModel = ViewModelProviders.of(this).get(EstimatorViewModel.class);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_estimator);
        mLayoutManagaer = new LinearLayoutManager(this);

        Callback categoryCallback = new Callback() {
            @Override
            public void onFeatureSelectionChanged() {
                updateView(categoryArrayList);
            }
        };
        mAdapter = new CategoryAdapter(new ArrayList<Category>(), categoryCallback);

        binding.rvCategories.setLayoutManager(mLayoutManagaer);
        binding.rvCategories.setAdapter(mAdapter);
        binding.toolbar.setTitle(R.string.app_name);
        tvTotal = binding.getRoot().findViewById(R.id.tvTotal);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            binding.textView.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
            binding.textView.setGravity(Gravity.START);
        }
        subscribe();
    }

    private void subscribe(){
        final Observer<ArrayList<Category>> categoryObserver = new Observer<ArrayList<Category>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Category> categories) {
                categoryArrayList = categories;
                mAdapter.setItems(categoryArrayList);
                updateView(categoryArrayList);
            }
        };
        mEstimatorViewModel.getCategoryList().observe(this, categoryObserver);
    }

    public void updateView(ArrayList<Category> categoryList){
        Double sum = 0.0;
        for (Category cat: categoryList) {
            for (Feature feat: cat.getFeatures()) {
                if (feat.isSelected()){
                    sum += feat.getTime();
                }
            }
        }

        DecimalFormat format = new DecimalFormat();
        format.setDecimalSeparatorAlwaysShown(false);
        tvTotal.setText(format.format(sum) + " " +getResources().getString(R.string.TimeUnit));
    }
}
