package com.example.teht10;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class DBTimestamp {

    @PrimaryKey (autoGenerate = true)
    public int timestamp_id;

    public String timestamp;
    public String screenstate;
}
