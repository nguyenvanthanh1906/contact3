package com.example.contact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.contact.contactjava;

import java.util.ArrayList;
import java.util.List;

public class manager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="contact_manager";
    private static final String TABLE_NAME="contact";

    private static final String NAME="name";
    private static final String PHONE="phone";
    private static int  VERSION=1;

private String SQLQuery="CREATE TABLE " + TABLE_NAME + "("
        + NAME + " TEXT PRIMARY KEY,"
        +PHONE + " TEXT" + ")";
    public manager(@Nullable Context context) {
        super(context, DATABASE_NAME, null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
sqLiteDatabase.execSQL(SQLQuery);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void addcontact(  contactjava contactjava ) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues values=new ContentValues();
    values.put(NAME,contactjava.getmName());
    values.put(PHONE,contactjava.getmPhone());
    db.insert(TABLE_NAME,null,values);
    db.close();
}
   public List<contactjava> getAllContact(){
        List<contactjava> listcontact=new ArrayList<>();
        String selectQuery="SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor= db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()){
            do {
                contactjava contactjava= new contactjava();

                contactjava.setmName(cursor.getString(0));
                contactjava.setmPhone(cursor.getString(1));
                listcontact.add(contactjava);
            }while (cursor.moveToNext());
        }
        db.close();
        return listcontact;
   }
}
