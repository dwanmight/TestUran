package com.junior.dwan.testuran.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.junior.dwan.testuran.data.Model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Might on 28.12.2016.
 */

public class GenerateData {

    public GenerateData() {
    }

    public static ArrayList<Model> generateList(Context context) {

        ArrayList<Model> list = new ArrayList<>();

        Model folderFamilySHared = new Model("FamilyShared", true, new Date(System.currentTimeMillis()), false, false, "none");
        list.add(folderFamilySHared);

        Model forWork = new Model("For Work", true, new Date(System.currentTimeMillis() - 10000), true, false, "none");
        list.add(forWork);

        Model workPowerpoint = new Model("WorkPowerPoint.pptx", false, new Date(System.currentTimeMillis() - 15000), false, false, "doc");
        list.add(workPowerpoint);

        Model speech = new Model("Speech.docx", false, new Date(System.currentTimeMillis() - 15000), false, true, "doc");
        list.add(speech);

        Model TomsFolder = new Model("Toms Folder", true, new Date(System.currentTimeMillis() - 18000), false, false, "none");
        list.add(TomsFolder);

        Model pict = new Model("DSC119.jpg", false, new Date(System.currentTimeMillis() - 18000), true, true, "image");
        list.add(pict);

//        DBUtils db=new DBUtils(context);
//        db.insertToDB(list);
        return list;
    }

}
