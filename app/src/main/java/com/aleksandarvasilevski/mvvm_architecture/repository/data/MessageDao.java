package com.aleksandarvasilevski.mvvm_architecture.repository.data;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.aleksandarvasilevski.mvvm_architecture.repository.data.entity.Message;

import java.util.List;

@Dao
public interface MessageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMessage(Message message);

    @Query("SELECT * FROM Message")
    LiveData<List<Message>> getAllMessages();

    @Query("SELECT * FROM Message ORDER BY id DESC LIMIT 1")
    LiveData<Message> getLastMessage();

    @Update()
    int updateMessage(Message message);

    @Delete()
    int deleteMessage(Message message);
}
