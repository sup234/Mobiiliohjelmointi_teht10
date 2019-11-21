package com.example.teht10;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.Calendar;

public class Palvelu extends IntentService {

    public Palvelu(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        final Handler mHandler = intent.getParcelableExtra("mHandler");
        String currentTime = Calendar.getInstance().getTime().toString();
        String message = intent.getStringExtra("message");

        RoomDatabase.Builder<Tietokanta> builder = Room.databaseBuilder(this, Tietokanta.class, Tietokanta.NIMI);
        final Tietokanta t = builder.build();
        DBTimestampDao dbTimestampDao = t.dbTimestampDao();
        DBTimestamp taulu = new DBTimestamp();
        taulu.screenstate = message;
        taulu.timestamp = currentTime;

        dbTimestampDao.InsertTimestamp(taulu);

        // Miten tieto siirretään MainActivityyn...?

        /*Message msg = obtainMessage();
        msg.sendToTarget();*/
    }

}
