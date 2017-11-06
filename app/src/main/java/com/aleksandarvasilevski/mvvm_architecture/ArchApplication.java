package com.aleksandarvasilevski.mvvm_architecture;


import android.app.Application;

import com.aleksandarvasilevski.mvvm_architecture.dependencyinjection.ApplicationComponent;
import com.aleksandarvasilevski.mvvm_architecture.dependencyinjection.ApplicationModule;
import com.aleksandarvasilevski.mvvm_architecture.dependencyinjection.DaggerApplicationComponent;
import com.aleksandarvasilevski.mvvm_architecture.dependencyinjection.RoomModule;

public class ArchApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .roomModule(new RoomModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
