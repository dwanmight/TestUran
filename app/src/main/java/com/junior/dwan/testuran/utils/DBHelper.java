package com.junior.dwan.testuran.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Might on 28.12.2016.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        // конструктор суперкласса
        super(context, "myDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("Log", "--- onCreate database ---");
        // создаем таблицу с полями
        db.execSQL("create table info ("
                + "id integer primary key autoincrement,"
                + "filename text,"
                + "date text,"
                + "isFolder boolean,"
                +"isBlue boolean,"
                +"isOrange boolean,"
                +"filetype text"+");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}