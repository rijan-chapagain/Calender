package com.example.calender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MySqliteOpenHelper mySqliteOpenHelper;
    private SQLiteDatabase mDatabase;
    private Button createDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createDatabase = (Button) findViewById(R.id.createDatabase);

        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    mySqliteOpenHelper = new MySqliteOpenHelper(getApplicationContext());
                    Toast.makeText(getApplicationContext(),"DB successfully created. ", Toast.LENGTH_LONG).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Error creating database  ", Toast.LENGTH_LONG).show();
                }
                mDatabase = mySqliteOpenHelper.getReadableDatabase();

                Cursor cursor = mDatabase.rawQuery("select * from caledar ;", null);

                System.out.println("MainActivity.onClick:"+ cursor.getColumnCount());



        }
    });
    }
}