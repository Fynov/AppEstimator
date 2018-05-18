package com.fynov.equaleyes.appestimator.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.design.widget.Snackbar;

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
        final ArrayList<Category> catList = new ArrayList<>();
        ArrayList<Feature> featureList = new ArrayList<>();
        service = RetrofitClient.getClient("http://estimateapi.pythonanywhere.com/").create(APIService.class);

        service.getAllFeatures()
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


        /*

        featureList.add(new Feature("1", "Light", "IDK", 10, 1));
        featureList.add(new Feature("2", "Heavy", "IDK", 20, 3, true));
        Category cat = new Category("1", "UI", 3, featureList);
        catList.add(cat);

        featureList = new ArrayList<>();
        featureList.add(new Feature("1", "Quick", "IDK", 10, 2));
        featureList.add(new Feature("2", "Secure", "IDK", 20, 4, true));
        cat = new Category("2", "Login", 2, featureList);
        catList.add(cat);

        featureList = new ArrayList<>();
        featureList.add(new Feature("1", "Persistent", "IDK", 10, 4));
        featureList.add(new Feature("2", "Confirmed", "IDK", 20, 3));
        cat = new Category("3", "Logout", 4, featureList);
        catList.add(cat);

        featureList = new ArrayList<>();
        featureList.add(new Feature("1", "Email", "IDK", 10, 1, true));
        featureList.add(new Feature("2", "OTP", "IDK", 20, 2));
        cat = new Category("4", "Auth", 1, featureList);
        catList.add(cat);
        mCategoryList.setValue(catList);

        //Runable represents API delayed response
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 2000);*/
    }

    public LiveData<ArrayList<Category>> getCategoryList() {
        return mCategoryList;
    }

    public void getCategories(){

    }
}
