package com.example.mrinalmriyo.registrationapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    SQLiteDatabase myDatabase;
    ListView listView;
    ArrayList<String> data;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView=(ListView)findViewById(R.id.listView);
        data=new ArrayList<String>();

        Intent intent=getIntent();

        try{

            myDatabase=this.openOrCreateDatabase("registered users", MODE_PRIVATE, null);

            Cursor cursor=myDatabase.rawQuery("SELECT * FROM registeredUsers",null);

            int nameIndex=cursor.getColumnIndex("name");
            int emailIndex=cursor.getColumnIndex("email");
            int phoneIndex=cursor.getColumnIndex("phone");
            cursor.moveToFirst();

            while(cursor!=null){

                String myData=cursor.getString(nameIndex) + "\n" +
                        cursor.getString(emailIndex) + "\n" +
                        cursor.getString(phoneIndex);
                data.add(myData);

                arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);

                listView.setAdapter(arrayAdapter);

                cursor.moveToNext();
            }

        }
        catch(Exception e){

        }

    }
}
