package com.example.mrinalmriyo.registrationapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nameEditText,emailEditText,phoneEditText;
    String username,useremail,userphone;
    SQLiteDatabase myDatabase;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout=(ConstraintLayout)findViewById(R.id.layout);
        constraintLayout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        
    }

    public void viewList(View view)
    {
        Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(intent);
    }

    public void registerUser(View view){

        nameEditText=(EditText)findViewById(R.id.editText);
        emailEditText=(EditText)findViewById(R.id.editText1);
        phoneEditText=(EditText)findViewById(R.id.editText2);

        username=nameEditText.getText().toString();
        useremail=emailEditText.getText().toString();
        userphone=phoneEditText.getText().toString();

        try{

            myDatabase=this.openOrCreateDatabase("registered users", MODE_PRIVATE, null);

            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS registeredUsers(name VARCHAR, email VARCHAR, phone VARCHAR)");

            String sqlcommand=
                    "INSERT INTO registeredUsers(name, email, phone) VALUES ('"
                            +username+"','"+useremail+"','"+userphone+"'"+")";
            myDatabase.execSQL(sqlcommand);




        }
        catch (Exception e){

        }

        Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(intent);

    }

}
