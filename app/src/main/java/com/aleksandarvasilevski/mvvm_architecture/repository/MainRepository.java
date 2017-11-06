package com.aleksandarvasilevski.mvvm_architecture.repository;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.aleksandarvasilevski.mvvm_architecture.repository.data.MessageDao;
import com.aleksandarvasilevski.mvvm_architecture.repository.data.entity.Message;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MainRepository {

    private final MessageDao messageDao;

    @Inject
    public MainRepository (MessageDao messageDao){
        this.messageDao = messageDao;
    }

    public LiveData<List<Message>> getAllMessages(){
        return messageDao.getAllMessages();
    }

    public LiveData<Message> getLastMessage(){
        return messageDao.getLastMessage();
    }

    public void insertMessage(Message message) {
        messageDao.insertMessage(message); }

    //ToDo update and delete
}
