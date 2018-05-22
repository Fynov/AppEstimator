package com.fynov.equaleyes.appestimator.data.api;

import com.fynov.equaleyes.appestimator.data.models.CalculatorReturn;
import com.fynov.equaleyes.appestimator.data.models.Category;
import com.fynov.equaleyes.appestimator.data.models.Template;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {
    @GET("features/{templateName}")
    Call<List<Category>> getFeatures(@Path("templateName") String templateName);
    @POST("calculate")
    Call<CalculatorReturn> calculate(@Query("id") String idList);

    @GET("templates")
    Call<List<Template>> getAllTemplates();
}
