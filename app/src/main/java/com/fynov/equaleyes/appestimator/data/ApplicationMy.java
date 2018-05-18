package com.fynov.equaleyes.appestimator.data;

import android.app.Application;


import com.fynov.equaleyes.appestimator.data.models.Category;

import java.util.ArrayList;


/**
 * Created by Bor on 05/03/2018.
 */

public class ApplicationMy extends Application {
    public ArrayList<Category> allCategories;

    @Override
    public void onCreate() {
        super.onCreate();
        allCategories=new ArrayList<>();
    }
}


