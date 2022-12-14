package com.jenil.call_recorder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    SQLiteDatabase sqLiteDatabase;

    public DatabaseManager(Context activity) {
        sqLiteDatabase = DatabaseSingleton.getInstance(activity);
    }

    public void addCallDetails(CallDetails callDetails) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHandler.SERIAL_NUMBER, callDetails.getSerial());
        values.put(DatabaseHandler.PHONE_NUMBER, callDetails.getNum());
        values.put(DatabaseHandler.TIME, callDetails.getTime());
        values.put(DatabaseHandler.DATE, callDetails.getDate());
        sqLiteDatabase.insert(DatabaseHandler.TABLE_RECORD, null, values);
    }


    public List<CallDetails> getAllDetails() {
        List<CallDetails> recordList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + DatabaseHandler.TABLE_RECORD;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                CallDetails callDetails = new CallDetails();
                callDetails.setSerial(cursor.getInt(0));
                callDetails.setNum(cursor.getString(1));
                callDetails.setTime(cursor.getString(2));
                callDetails.setDate(cursor.getString(3));
                recordList.add(callDetails);
            } while (cursor.moveToNext());
        }
        return recordList;
    }
}