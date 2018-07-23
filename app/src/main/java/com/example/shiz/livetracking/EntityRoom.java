package com.example.shiz.livetracking;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class EntityRoom {

    @PrimaryKey
    @NonNull
    private String location;

    private int location_id;


    public EntityRoom(int location_id, String location) {
        this.location_id = location_id;
        this.location = location;
    }

    public int getLocation_id()
    {

        return location_id;
    }

    public void setLocation_id(int location_id) {

        this.location_id = location_id;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location) {

        this.location = location;
    }

    @Override
    public String toString() {
        return "EntityRoom{" +
                "location_id=" + location_id +
                ", location='" + location + '\'' +
                '}';
    }
}

