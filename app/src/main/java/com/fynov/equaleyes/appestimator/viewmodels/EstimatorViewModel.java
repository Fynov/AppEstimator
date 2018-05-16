package com.fynov.equaleyes.appestimator.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;
import android.os.SystemClock;

import com.android.volley.CacheDispatcher;
import com.fynov.equaleyes.appestimator.data.models.Category;
import com.fynov.equaleyes.appestimator.data.models.Feature;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class EstimatorViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Category>> mCategoryList = new MutableLiveData<>();

    public EstimatorViewModel() {

        //Runable represents API delayed response
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ArrayList<Category> catList = new ArrayList<>();
                ArrayList<Feature> featureList = new ArrayList<>();

                featureList.add(new Feature("1", "Light", "IDK", 10, 2));
                featureList.add(new Feature("2", "Heavy", "IDK", 20, 4));
                Category cat = new Category("1", "UI", 3, featureList);
                catList.add(cat);

                featureList = new ArrayList<>();
                featureList.add(new Feature("1", "Quick", "IDK", 10, 2));
                featureList.add(new Feature("2", "Secure", "IDK", 20, 4));
                cat = new Category("2", "Login", 2, featureList);
                catList.add(cat);

                featureList = new ArrayList<>();
                featureList.add(new Feature("1", "Persistent", "IDK", 10, 2));
                featureList.add(new Feature("2", "Confirmed", "IDK", 20, 4));
                cat = new Category("3", "Logout", 4, featureList);
                catList.add(cat);

                featureList = new ArrayList<>();
                featureList.add(new Feature("1", "Email", "IDK", 10, 2));
                featureList.add(new Feature("2", "OTP", "IDK", 20, 4));
                cat = new Category("4", "Auth", 1, featureList);
                catList.add(cat);
                mCategoryList.setValue(catList);
            }
        }, 2000);
    }

    public LiveData<ArrayList<Category>> getCategoryList() {
        return mCategoryList;
    }
}
