package com.shabayekdes.shabayekdes;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by SevenTG on 17/03/2017.
 */

public class Dbconnection extends SQLiteOpenHelper{

    public static final String DB_NAME = "membership.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "user";
    public static final String COL_FNAME = "fname";
    public static final String COL_LNAME = "lname";
    public static final String COL_AGE = "age";
    public static final String COL_PHONE = "phone";

    public Dbconnection(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_FNAME + " TEXT," + COL_LNAME + " TEXT," +
                COL_AGE + " INTEGER," + COL_PHONE + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public long insertName(String fname,String lname,int age,String phone){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_FNAME, fname);
        values.put(COL_LNAME, lname);
        values.put(COL_AGE, age);
        values.put(COL_PHONE, phone);

        long id = db.insert(TABLE_NAME, null, values);
        return id;
    }
    public ArrayList getAllName(){
        SQLiteDatabase db = this.getReadableDatabase();

        ArrayList arrayList = new ArrayList();

        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME ,null);
        res.moveToFirst();
        while (res.isAfterLast() == false){
            arrayList.add(res.getString(res.getColumnIndex("id")) + ")" +
                        res.getString(res.getColumnIndex(COL_FNAME)) + " : " +
                        res.getString(res.getColumnIndex(COL_LNAME)) + " : " +
                        res.getString(res.getColumnIndex(COL_AGE)) + " : " +
                        res.getString(res.getColumnIndex(COL_PHONE)));
            res.moveToNext();
        }
        return arrayList;
    }


}