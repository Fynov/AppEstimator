package com.fynov.equaleyes.appestimator.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.fynov.equaleyes.appestimator.data.api.APIService;
import com.fynov.equaleyes.appestimator.data.api.RetrofitClient;
import com.fynov.equaleyes.appestimator.data.models.Category;
import com.fynov.equaleyes.appestimator.data.models.Feature;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EstimatorViewModel extends ViewModel {
    private APIService service;
    private MutableLiveData<ArrayList<Category>> mCategoryList = new MutableLiveData<>();

    public EstimatorViewModel() {

    }

    public LiveData<ArrayList<Category>> getCategoryList() {
        return mCategoryList;
    }

    public void makeAPIcall(String templateName){
        final ArrayList<Category> catList = new ArrayList<>();
        service = RetrofitClient.getClient("http://estimateapi.pythonanywhere.com/").create(APIService.class);


        if (templateName.isEmpty())
            service.getFeatures()
                    .enqueue(new Callback<List<Category>>() {
                        @Override
                        public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                            catList.addAll(response.body());
                            for (Category cat: catList) {
                                cat.setTime(0);
                                for (Feature feat: cat.getFeatures()) {
                                    feat.setSelected(false);
                                }
                            }
                            mCategoryList.setValue(catList);
                        }

                        @Override
                        public void onFailure(Call<List<Category>> call, Throwable t) {
                            //TODO: Error message, don't know what view to input for snackbar. Snackbar.make(, "API is unavailible.", Snackbar.LENGTH_SHORT);
                        }
                    });
        else
            service.getFeatures(templateName)
                    .enqueue(new Callback<List<Category>>() {
                        @Override
                        public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                            catList.addAll(response.body());
                            for (Category cat: catList) {
                                cat.setTime(0);
                                for (Feature feat: cat.getFeatures()) {
                                    feat.setSelected(feat.getTemplate().get(0).isSelected());
                                }
                            }
                            mCategoryList.setValue(catList);
                        }

                        @Override
                        public void onFailure(Call<List<Category>> call, Throwable t) {
                            //TODO: Error message, don't know what view to input for snackbar. Snackbar.make(, "API is unavailible.", Snackbar.LENGTH_SHORT);
                        }
                    });
    }
}
