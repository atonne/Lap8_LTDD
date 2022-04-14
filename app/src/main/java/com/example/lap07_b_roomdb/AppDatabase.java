package com.example.lap07_b_roomdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Name.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NameDao nameDao();

    private static volatile AppDatabase instance;
    private static final int number_of_threads = 4;
    static final ExecutorService dbWriteExecutor = Executors.newFixedThreadPool(number_of_threads);

    static AppDatabase getDatabase(final Context context){
        if(instance==null){
            synchronized (AppDatabase.class){
                if(instance==null){
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "lap7_name_roomdb").build();
                }
            }
        }
        return instance;
    }
}
