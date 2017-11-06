package com.aleksandarvasilevski.mvvm_architecture.viewmodel;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.aleksandarvasilevski.mvvm_architecture.repository.MainRepository;
import com.aleksandarvasilevski.mvvm_architecture.repository.data.MessageDao;
import com.aleksandarvasilevski.mvvm_architecture.repository.data.entity.Message;

import java.util.List;

import javax.inject.Inject;

public class MainViewModel extends ViewModel {

    private static MutableLiveData<Message> liveData = new MutableLiveData<Message>();
    private MainRepository mainRepository;

    public MainViewModel(MainRepository repository){
        this.mainRepository = repository;
    }

    public LiveData<List<Message>> getAllMessages(){
        return mainRepository.getAllMessages();
    }

    public LiveData<Message> getLastMessage(){
        return mainRepository.getLastMessage();
    }

    public void insertMessage(Message message){
        mainRepository.insertMessage(message);
    }
}
