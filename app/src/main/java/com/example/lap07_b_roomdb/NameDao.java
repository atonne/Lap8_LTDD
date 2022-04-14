package com.example.lap07_b_roomdb;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NameDao {
    @Query("select * from name_table")
    List<Name> getAll();

    @Query("SELECT * FROM name_table WHERE id IN (:nameIds)")
    LiveData<List<Name>> loadAllByIds(int[] nameIds);

//    @Query("SELECT * FROM Name WHERE first_name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    User findByName(String first, String last);

//    @Insert
//    void insertAll(Name... names);
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Name name);

//    @Delete
//    void delete(Name name);
    @Query("DELETE FROM name_table")
    void deleteAll();
}
