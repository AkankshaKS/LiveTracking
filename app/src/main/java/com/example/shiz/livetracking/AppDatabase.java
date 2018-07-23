package com.example.shiz.livetracking;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


@Database(entities = { EntityRoom.class }, version = 2,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract RoomDao getRoomDao();
    private static AppDatabase roomDB;

    static AppDatabase getInstance(Context context) {

        if (null == roomDB) {
            roomDB = buildDatabaseInstance(context);
        }
        return roomDB;
    }

    private static AppDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class,
                "Location-database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries().build();
    }

    public void cleanUp(){
        roomDB = null;
    }
    public static void destroyInstance() {
        roomDB = null;
    }

}

