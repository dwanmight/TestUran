package com.junior.dwan.testuran.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.junior.dwan.testuran.data.Model;

import java.util.ArrayList;

/**
 * Created by Might on 28.12.2016.
 */

public class DBUtils {
    private static DBHelper sDBHelper;
    Context mContext;
    SQLiteDatabase mSQLiteDatabase;

    public DBUtils(Context context) {
        mContext = context;
        sDBHelper = new DBHelper(context);
        mSQLiteDatabase = sDBHelper.getWritableDatabase();
    }

    public void insertToDB(ArrayList<Model> list) {
        ArrayList<Model> models=list;
        ContentValues cv = new ContentValues();


        for (int i = 0; i < list.size(); i++) {
            cv.put("filename", list.get(i).getFilename());
            cv.put("date", list.get(i).getModDate().toString());
            cv.put("isFolder", list.get(i).isFolder());
            cv.put("isBlue", list.get(i).isBlue());
            cv.put("isOrange", list.get(i).isOrange());
            cv.put("filetype", list.get(i).checkFileType());
            long rowID = mSQLiteDatabase.insert("mytable", null, cv);
            Log.i("TAG", "ID=" + rowID);
        }


    }


    public void readFromDB() {
        Log.d("TAG", "--- Rows in mytable: ---");
        // делаем запрос всех данных из таблицы mytable, получаем Cursor
        Cursor c = mSQLiteDatabase.query("mytable", null, null, null, null, null, null);

        // ставим позицию курсора на первую строку выборки
        // если в выборке нет строк, вернется false
        if (c.moveToFirst()) {

            // определяем номера столбцов по имени в выборке
            int idColIndex = c.getColumnIndex("id");
            int nameColIndex = c.getColumnIndex("filename");
            int dateIndex = c.getColumnIndex("date");
            int isFolderIndex = c.getColumnIndex("isFolder");
            int isBlueIndex = c.getColumnIndex("isBlue");
            int isOrangeIndex = c.getColumnIndex("isOrange");
            int filetypeIndex = c.getColumnIndex("filetype");

            do {
                // получаем значения по номерам столбцов и пишем все в лог
                Log.i("TAG",
                        "ID = " + c.getInt(idColIndex) +
                                ", filename = " + c.getString(nameColIndex) +
                                ", date = " + c.getString(dateIndex)+
                        ", isFolder = " + c.getString(isFolderIndex)+
                        ", isBlue = " + c.getString(isBlueIndex)+
                        ", isOrange = " + c.getString(isOrangeIndex)+
                        ", filetype = " + c.getString(filetypeIndex));
                // переход на следующую строку
                // а если следующей нет (текущая - последняя), то false - выходим из цикла
            } while (c.moveToNext());
        } else
            Log.d("TAG", "0 rows");
        c.close();
    }

}
