package com.aleksandarvasilevski.mvvm_architecture.viewmodel;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.aleksandarvasilevski.mvvm_architecture.repository.MainRepository;

public class MainViewModelFactory implements ViewModelProvider.Factory {

    private final MainRepository mainRepository;

    public MainViewModelFactory(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)){
            return (T) new MainViewModel(mainRepository);
        }
        else {
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }
}
