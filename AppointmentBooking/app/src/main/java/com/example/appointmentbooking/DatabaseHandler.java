


package com.example.appointmentbooking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "bookings";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE PROFILE( ID INTEGER PRIMARY KEY , NAME TEXT, AGE TEXT ,EMAIL TEXT,ROLE TEXT)");
//        db.execSQL("CREATE TABLE PROFILE( ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, AGE TEXT,EMAIL TEXT,ROLE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PROFILE");
        onCreate(db);
    }

    public HashMap<String,String> getProfile(int id){
        HashMap<String, String> hmap = new HashMap<String, String>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "SELECT ID,NAME,AGE,EMAIL,ROLE FROM PROFILE WHERE ID = "+id, null );
        if(res.moveToFirst()) {
            do {
                hmap.put("id", res.getString(0));
                hmap.put("name", res.getString(1));
                hmap.put("age", res.getString(2));
                hmap.put("email", res.getString(3));
                hmap.put("role", res.getString(4));
            } while (res.moveToNext());
        }
        return  hmap;
    }
    public String checkLogin(){
        SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor =  db.rawQuery( "SELECT ROLE FROM PROFILE WHERE 1 ", null );
        try {
            if (cursor.moveToFirst()) return cursor.getString(0);
            else return "";
        }
        finally {
            cursor.close();
        }
    }

    public String getProfId(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.rawQuery( "SELECT id FROM PROFILE WHERE 1 ", null );
        try {
            if (cursor.moveToFirst()) return cursor.getString(0);
            else return "";
        }
        finally {
            cursor.close();
        }
    }

    public boolean  newProfile(int id , String name, String email,String age, String role){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("role", role);
        contentValues.put("age", age);
        db.insert("PROFILE", null, contentValues);
        return true;
    }

    public  void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
//        db.rawQuery("DELETE FROM PROFILE",null);
        db.delete("PROFILE",null,null);
    }
}
