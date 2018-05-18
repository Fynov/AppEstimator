package com.fynov.equaleyes.appestimator.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.fynov.equaleyes.appestimator.data.models.Category;
import com.fynov.equaleyes.appestimator.data.models.Template;

import java.util.ArrayList;

public class TemplateViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Template>> mTemplateList = new MutableLiveData<>();

    public TemplateViewModel(){
        ArrayList<Template> templateList = new ArrayList<>();

        templateList.add(new Template("coinbase"));
        templateList.add(new Template("revolut"));
        templateList.add(new Template("snapchat"));
        templateList.add(new Template("scratch"));

        mTemplateList.setValue(templateList);

    }

    public LiveData<ArrayList<Template>> getTemplateList() { return mTemplateList; }
}
