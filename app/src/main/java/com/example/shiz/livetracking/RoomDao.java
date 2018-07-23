package com.example.shiz.livetracking;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface RoomDao {

    @Query("Select * from  EntityRoom")
    public List<EntityRoom> getAllLocations();

    @Delete
    public void deleteMessage(EntityRoom loc);

    @Update
    public void update(EntityRoom loc);

    @Insert
    public void insert(EntityRoom loc);


}
