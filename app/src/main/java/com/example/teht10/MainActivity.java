package com.example.teht10;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;


public class MainActivity extends AppCompatActivity {

    Kuuntelija kuuntelija = new Kuuntelija();
    IntentFilter intentFilter = new IntentFilter();
    Intent intent;
    ListView listview = findViewById(R.id.listview1);
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listview, R.id.textview1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        getApplicationContext().registerReceiver(kuuntelija, intentFilter);
        listview.setAdapter(adapter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
    }

    @Override
    protected void onResume() {
        super.onResume();
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        registerReceiver(kuuntelija, intentFilter);
    }


    private class Kuuntelija extends BroadcastReceiver {

        Handler mHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message inputMessage) {
                adapter.add(inputMessage.toString());
            }
        };

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("ACTION_SCREEN_ON")) {
                String message = "Open";
                intent.putExtra("message", message);
                intent.putExtra("mHandler", new Messenger(mHandler));
                intent = new Intent (MainActivity.this, Palvelu.class);
                startService(intent);
            }
            else {
                String message = "Closed";
                intent.putExtra("message", message);
                intent.putExtra("mHandler", new Messenger(mHandler));
                intent = new Intent (MainActivity.this, Palvelu.class);
                startService(intent);
            }
        }
    }

}

