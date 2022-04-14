package com.example.lap07_b_roomdb;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NameViewModel extends AndroidViewModel {
    private NameRepository nameRepository;
    private final LiveData<List<Name>> listLiveData;

    public NameViewModel(@NonNull Application application, NameRepository nameRepository, LiveData<List<Name>> listLiveData) {
        super(application);
        this.nameRepository = new NameRepository(application);
        this.listLiveData = nameRepository.getAllNames();
    }

    LiveData<List<Name>> getAllNames(){
        return listLiveData;
    }

    public void insert(Name name){
        nameRepository.insertName(name);
    }
}
