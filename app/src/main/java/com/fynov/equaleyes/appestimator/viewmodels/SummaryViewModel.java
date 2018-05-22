package com.fynov.equaleyes.appestimator.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.fynov.equaleyes.appestimator.data.api.APIService;
import com.fynov.equaleyes.appestimator.data.api.RetrofitClient;
import com.fynov.equaleyes.appestimator.data.models.CalculatorReturn;
import com.fynov.equaleyes.appestimator.data.models.Category;
import com.fynov.equaleyes.appestimator.data.models.Feature;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SummaryViewModel extends ViewModel {
    private APIService service;
    private MutableLiveData<CalculatorReturn> mCalcReturn = new MutableLiveData<>();

    public SummaryViewModel(final String idList) {
        final ArrayList<Category> catList = new ArrayList<>();


        service = RetrofitClient.getClient("http://estimateapi.pythonanywhere.com/").create(APIService.class);

        service.calculate(idList)
                .enqueue(new Callback<CalculatorReturn>() {
                    @Override
                    public void onResponse(Call<CalculatorReturn> call, Response<CalculatorReturn> response) {
                        mCalcReturn.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<CalculatorReturn> call, Throwable t) {
                        //TODO: Error message, don't know what view to input for snackbar. Snackbar.make(, "API is unavailible.", Snackbar.LENGTH_SHORT);
                    }
                });
    }

    public LiveData<CalculatorReturn> getCalculatorReturn() {
        return mCalcReturn;
    }
}
