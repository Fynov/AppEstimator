package com.fynov.equaleyes.appestimator;

import android.app.Application;
import android.content.Context;


import com.fynov.equaleyes.lib_data.DataAll;


/**
 * Created by Bor on 05/03/2018.
 */

public class ApplicationMy extends Application {
    DataAll all;
    Context ac;

    @Override
    public void onCreate() {
        super.onCreate();
        ac=this;
    }
}


