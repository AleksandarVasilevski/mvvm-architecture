package com.aleksandarvasilevski.mvvm_architecture.repository.data;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.aleksandarvasilevski.mvvm_architecture.repository.data.entity.Message;

@Database(entities = {Message.class}, version = 1)
public abstract class MessageDatabase extends RoomDatabase {
    public static final String DB_NAME = "db";
    public abstract MessageDao messageDao();
}
