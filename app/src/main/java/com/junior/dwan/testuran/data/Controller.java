package com.junior.dwan.testuran.data;

import android.content.Context;

import com.junior.dwan.testuran.utils.GenerateData;

import java.util.ArrayList;

/**
 * Created by Might on 28.12.2016.
 */

public class Controller {
    private static Controller sController;
    private Context mAppContext;
    private ArrayList<Model> mListModels;

    private Controller(Context appContext){
        mAppContext=appContext;
        mListModels=new ArrayList<>();

    }

    public static Controller getInstance(Context c) {
        if (sController == null)
            sController = new Controller(c.getApplicationContext());
        return sController;
    }

    public ArrayList<Model> getListModels(Context context){
        return GenerateData.generateList(context);
    }

}
