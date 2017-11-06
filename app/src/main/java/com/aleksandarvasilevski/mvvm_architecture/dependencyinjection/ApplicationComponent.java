package com.aleksandarvasilevski.mvvm_architecture.dependencyinjection;

import android.app.Application;

import com.aleksandarvasilevski.mvvm_architecture.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, RoomModule.class})
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);

    Application application();
}
