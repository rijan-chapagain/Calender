package com.example.calender;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqliteOpenHelper extends SQLiteOpenHelper {

    private static final String database_name = "calendar.db";
    private String table_name = "calendar";
    private static final int database_version = 1;
    private String column_id="id", column_name="name";
    private String database_create_statement =
            "CREATE TABLE "+ table_name+" ( "+column_id + " INTEGER primary key autoincrement, "+ column_name+ " TEXT not null );";

    public MySqliteOpenHelper(Context context)
    {
        super(context, database_name, null, database_version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL(database_create_statement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        // update table here
    }
}
