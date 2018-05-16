package com.fynov.equaleyes.appestimator.data;

import android.app.Application;
import android.content.Context;


import com.fynov.equaleyes.lib_data.DataAll;


/**
 * Created by Bor on 05/03/2018.
 */

public class ApplicationMy extends Application {
    public DataAll all;
    public Context ac;

    @Override
    public void onCreate() {
        super.onCreate();
        ac=this;
    }
}


