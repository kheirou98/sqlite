package com.example.hp.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;


public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertData(String name, byte[] image,String nomLatin, String famille, String proprietes,
                           String posologie, String precautions, String partieUtilises){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO PLANTES VALUES (NULL,?,?,?,?,?,?,?,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,name);
        statement.bindBlob(2,image);
        statement.bindString(3,nomLatin);
        statement.bindString(4,famille);
        statement.bindString(5,proprietes);
        statement.bindString(6,posologie);
        statement.bindString(7,precautions);
        statement.bindString(8,partieUtilises);

        statement.executeInsert();
    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
