
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
import android.text.Layout;
import android.view.Gravity;

import com.fynov.equaleyes.appestimator.R;
import com.fynov.equaleyes.appestimator.data.ApplicationMy;
import com.fynov.equaleyes.appestimator.data.models.Category;
import com.fynov.equaleyes.appestimator.data.models.Template;
import com.fynov.equaleyes.appestimator.databinding.ActivityEstimatorBinding;
import com.fynov.equaleyes.appestimator.databinding.ActivityMainBinding;
import com.fynov.equaleyes.appestimator.databinding.ActivityMainBindingImpl;
import com.fynov.equaleyes.appestimator.ui.adapters.CategoryAdapter;
import com.fynov.equaleyes.appestimator.ui.adapters.TemplateAdapter;
import com.fynov.equaleyes.appestimator.viewmodels.TemplateViewModel;

import java.util.ArrayList;

public class ActivityMain extends AppCompatActivity{

    private ActivityMainBinding binding;
    private TemplateViewModel mTemplateViewModel;
    private RecyclerView.LayoutManager mLayoutManagaer;
    TemplateAdapter mAdapter;
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTemplateViewModel = ViewModelProviders.of(this).get(TemplateViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mLayoutManagaer = new LinearLayoutManager(this);
        mAdapter = new TemplateAdapter(new ArrayList<Template>(), this);

        binding.rvTemplates.setLayoutManager(mLayoutManagaer);
        binding.rvTemplates.setAdapter(mAdapter);

        subscribe();
    }

    private void subscribe(){
        final Observer<ArrayList<Template>> templateObserver = new Observer<ArrayList<Template>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Template> templates) {
                mAdapter.setItems(templates);
            }
        };
        mTemplateViewModel.getTemplateList().observe(this, templateObserver);
    }
}