package com.aleksandarvasilevski.mvvm_architecture.dependencyinjection;


import android.app.Application;

import com.aleksandarvasilevski.mvvm_architecture.ArchApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final ArchApplication application;

    public ApplicationModule(ArchApplication application){
        this.application = application;
    }

    @Provides
    ArchApplication provideRoomApplication(){
        return application;
    }

    @Provides
    Application provideApplication(){
        return application;
    }
}
