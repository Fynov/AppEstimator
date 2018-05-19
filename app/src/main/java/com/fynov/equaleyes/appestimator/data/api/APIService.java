package com.fynov.equaleyes.appestimator.data.api;

import com.fynov.equaleyes.appestimator.data.models.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("features")
    Call<List<Category>> getAllFeatures();

}
