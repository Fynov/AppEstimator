package com.fynov.equaleyes.appestimator.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;


import java.util.ArrayList;

public class SummaryViewModelFactory implements ViewModelProvider.Factory {
    private final String calc;

    public SummaryViewModelFactory(String  calc) {
        this.calc = calc;
    }

    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(SummaryViewModel.class)) {
            return (T) new SummaryViewModel(calc);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
