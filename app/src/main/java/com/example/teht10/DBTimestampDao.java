package com.example.teht10;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DBTimestampDao {

    @Query("SELECT * FROM DBTimestamp")
    List<DBTimestamp> getAll();

    @Insert
    void InsertTimestamp(DBTimestamp dbTimestamp);

    @Delete
    void DeleteTimestamp(DBTimestamp dbTimestamp);
}
