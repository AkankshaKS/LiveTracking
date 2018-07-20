package com.example.shiz.livetracking;
/*
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


@Database(entities = { EntityRoom.class }, version = 1)
public abstract class Roomdbse extends RoomDatabase {

    public abstract Roomdao getRoomdao();
    private static Roomdbse roomDB;

    static Roomdbse getInstance(Context context) {

        if (null == roomDB) {
            roomDB = buildDatabaseInstance(context);
        }
        return roomDB;
    }

    private static Roomdbse buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                Roomdbse.class,
                "Location-database")
                .allowMainThreadQueries().build();
    }

    public void cleanUp(){
        roomDB = null;
    }
    public static void destroyInstance() {
        roomDB = null;
    }

}
*/