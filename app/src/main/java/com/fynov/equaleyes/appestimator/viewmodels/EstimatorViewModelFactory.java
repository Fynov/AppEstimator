package com.fynov.equaleyes.appestimator.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class EstimatorViewModelFactory implements ViewModelProvider.Factory {
    private final String templateName;

    public EstimatorViewModelFactory(String templateName) {
        this.templateName = templateName;
    }

    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(EstimatorViewModel.class)) {
            return (T) new EstimatorViewModel(templateName);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
