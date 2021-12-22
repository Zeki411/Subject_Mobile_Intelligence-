package com.example.miproject.runapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.List;

@Dao
public interface RunningDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Runningdata runningdata);

    @Update
    public void update(Runningdata runningdata);

    @Delete
    public void delete(Runningdata runningdata);

    @Query("SELECT * FROM running_table")
    public List<Runningdata> getAllRuningdata();

    // @Query can also do delete and updata database
    // UPDATE or DELETE queries can return void or int. If it is an int, the value is the number of rows affected by this query.
    @Query("DELETE FROM running_table WHERE id = :runningId")
    abstract void deleteById(int runningId);// delete row by Id, and since id is the autogenerated pramiray key it has to be Id

    @Query("DELETE FROM running_table")
    abstract void deleteall();


    /* @Query("SELECT * FROM running_table WHERE test = :running_test")
    public List<Runningdata> getRunningInfoBytest(int running_test);*/

}