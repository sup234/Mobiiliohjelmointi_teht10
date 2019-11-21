package com.example.teht10;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DBTimestamp.class}, version = 1)
public abstract class Tietokanta extends RoomDatabase {
    public static final String NIMI = "TIETOKANTA";
    public abstract DBTimestampDao dbTimestampDao();
}
