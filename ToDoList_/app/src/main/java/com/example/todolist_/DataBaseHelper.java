package com.example.todolist_;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {


    public static final int version =1;
    public static final String TABLE_NAME = "tableName";
    public static final String YAPILACAK = "YAPILACAK";
    public static final String Kolon_id = "ID";
    public static final String[] satir = {YAPILACAK,Kolon_id};

    public DataBaseHelper(@Nullable Context context) {
        super(context, TABLE_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" + Kolon_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + YAPILACAK + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean yapilacakEkle(yapilacak yapilacak){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(YAPILACAK, yapilacak.getYapilacak());
        long insert = db.insert(TABLE_NAME, null, cv);
        if(insert ==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public List<yapilacak> yapilacakgetir(){
        List<yapilacak> returnList = new ArrayList<>();
        String sorgu = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sorgu,null);
        if(cursor.moveToFirst()){
            do {
                int yapilacakid = cursor.getInt(0);
                String yapilacakadi = cursor.getString(1);
                yapilacak yap = new yapilacak(yapilacakid,yapilacakadi);
                returnList.add(yap);
            }while (cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return returnList;
    }

    public yapilacak yapilacakal(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,satir," id = ? ", new String[]{String.valueOf(id)}, null,null,null);
        if(cursor !=null) {
            cursor.moveToFirst();
        }
            yapilacak yap = new yapilacak();
            yap.setId(Integer.parseInt(cursor.getString(0)));
            yap.setYapilacak(cursor.getString(1));
            return yap;
        }


    public void kitapSil(yapilacak yap){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,Kolon_id + " = ? ",new String[] {String.valueOf(yap.getId())});
        db.close();
    }

}

