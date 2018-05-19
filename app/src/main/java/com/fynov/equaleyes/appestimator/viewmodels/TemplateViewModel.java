package com.fynov.equaleyes.appestimator.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.fynov.equaleyes.appestimator.data.api.APIService;
import com.fynov.equaleyes.appestimator.data.api.RetrofitClient;
import com.fynov.equaleyes.appestimator.data.models.Category;
import com.fynov.equaleyes.appestimator.data.models.Feature;
import com.fynov.equaleyes.appestimator.data.models.Template;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TemplateViewModel extends ViewModel {
    private APIService service;
    private MutableLiveData<ArrayList<Template>> mTemplateList = new MutableLiveData<>();

    public TemplateViewModel(){
        final ArrayList<Template> templateList = new ArrayList<>();

        service = RetrofitClient.getClient("http://estimateapi.pythonanywhere.com/").create(APIService.class);

        service.getAllTemplates()
                .enqueue(new Callback<List<Template>>() {
                    @Override
                    public void onResponse(Call<List<Template>> call, Response<List<Template>> response) {
                        templateList.addAll(response.body());
                        templateList.add(new Template("", "https://i.imgur.com/udWLorv.png"));
                        mTemplateList.setValue(templateList);
                    }

                    @Override
                    public void onFailure(Call<List<Template>> call, Throwable t) {
                        //TODO: Error message, don't know what view to input for snackbar. Snackbar.make(, "API is unavailible.", Snackbar.LENGTH_SHORT);
                    }
                });

/*
        templateList.add(new Template("coinbase", "https://i.imgur.com/8hy9TrW.png"));
        templateList.add(new Template("revolut", "https://i.imgur.com/y4nuRmd.png"));
        templateList.add(new Template("snapchat", "https://i.imgur.com/poOrRBG.png"));
        templateList.add(new Template("", "https://i.imgur.com/udWLorv.png"));
        mTemplateList.setValue(templateList);
*/

    }

    public LiveData<ArrayList<Template>> getTemplateList() { return mTemplateList; }
}
