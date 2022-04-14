package com.example.lap07_b_roomdb;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NameRepository {
    private NameDao nameDao;
    private LiveData<List<Name>> listLiveData;

    NameRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        nameDao = db.nameDao();
        listLiveData = (LiveData<List<Name>>) nameDao.getAll();
    }

    LiveData<List<Name>> getAllNames(){
        return listLiveData;
    }

    void insertName(Name name){
        AppDatabase.dbWriteExecutor.execute(() -> {
            nameDao.insert(name);
        });
    }
}
