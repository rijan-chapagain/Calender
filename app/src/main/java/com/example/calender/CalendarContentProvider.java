package com.example.calender;

import android.app.AppComponentFactory;
import android.content.ContentResolver;
import android.net.Uri;
import android.provider.CalendarContract;

import androidx.appcompat.app.AppCompatActivity;

import java.net.URI;

public class CalendarContentProvider extends AppCompatActivity {


    ContentResolver cr = getContentResolver();
    Uri uri = CalendarContract.Calendars.CONTENT_URI;

    public CalendarContentProvider() {
        mProjection = new String[]{
                CalendarContract.Calendars._ID,
                CalendarContract.Calendars.ACCOUNT_NAME,
                CalendarContract.Calendars.CALENDAR_DISPLAY_NAME,
                CalendarContract.Calendars.OWNER_ACCOUNT
        };
    }

    public void selectionContent (){
        String selection = "((" + CalendarContract.Calendars.ACCOUNT_NAME + " = ?) AND ("
                                + CalendarContract.Calendars.ACCOUNT_TYPE + " = ?) AND ("
                                + CalendarContract.Calendars.OWNER_ACCOUNT + " = ?))";

        String[] selectionArgs = new String[] {"sampleuser@gmail.com", "com.google", "sampleuser@gmail.com"};

    }

    public String [] mProjection;

}
