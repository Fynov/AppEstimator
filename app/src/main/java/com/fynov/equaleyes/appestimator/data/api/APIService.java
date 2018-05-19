package com.fynov.equaleyes.appestimator.data.api;

import com.fynov.equaleyes.appestimator.data.models.Category;
import com.fynov.equaleyes.appestimator.data.models.Template;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIService {
    @GET("features/{templateName}")
    Call<List<Category>> getFeatures(@Path("templateName") String templateName);
    @GET("features")
    Call<List<Category>> getFeatures();

    @GET("templates")
    Call<List<Template>> getAllTemplates();
}
