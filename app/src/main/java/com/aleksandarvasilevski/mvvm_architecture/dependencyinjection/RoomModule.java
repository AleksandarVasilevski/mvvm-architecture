package com.aleksandarvasilevski.mvvm_architecture.dependencyinjection;


import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.persistence.room.Room;

import com.aleksandarvasilevski.mvvm_architecture.repository.MainRepository;
import com.aleksandarvasilevski.mvvm_architecture.repository.data.MessageDao;
import com.aleksandarvasilevski.mvvm_architecture.repository.data.MessageDatabase;
import com.aleksandarvasilevski.mvvm_architecture.viewmodel.MainViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    private final MessageDatabase messageDatabase;

    public RoomModule(Application application){
        this.messageDatabase = Room.databaseBuilder(application, MessageDatabase.class, "Message.db").build();
    }

    @Provides
    @Singleton
    MainRepository provideMainRepository(MessageDao messageDao){
        return new MainRepository(messageDao);
    }

    @Provides
    @Singleton
    MessageDao provideMessageDao(MessageDatabase messageDatabase){
        return messageDatabase.messageDao();
    }

    @Provides
    @Singleton
    MessageDatabase providesMessageDatabase(Application application){
        return messageDatabase;
    }

    @Provides
    @Singleton
    ViewModelProvider.Factory provideViewModelFactory(MainRepository mainRepository){
        return new MainViewModelFactory(mainRepository);
    }
}
