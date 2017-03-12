package com.example.loginnew.newlogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by codept on 12/3/17.
 */

public class SQLiteDB {
    public static final String key_name="name";
    public static final String key_username="username";
    public static final String key_password="password";
    private static final String key_table="registration";
    private static final String key_db_name="form";
    private static final int db_version=1;

    public static final String create ="create table registration(name text not null,username text primary key,password text not null);";
    private final Context context;
    private SQLiteDatabase db;
    private DBHelper help;

    public SQLiteDB(Context context) {
        this.context = context;
        help=new DBHelper(context);
    }
    private static class DBHelper extends SQLiteOpenHelper{

        public DBHelper(Context context) {
            super(context, key_db_name,null, db_version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                db.execSQL(create);
            }catch (Exception e){

            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

    public SQLiteDB open() throws SQLException{
        db=help.getWritableDatabase();
        return this;
    }

    public void close(){
        help.close();
    }

    public long insert(String name,String username,String password){
        ContentValues cv=new ContentValues();
        cv.put(key_name,name);
        cv.put(key_username,username);
        cv.put(key_password,password);
        return db.insert(key_table,null,cv);
    }

    public String getEntry(String username){
        Cursor cursor=db.query(key_table,new String[]{key_name,key_username,key_password},key_username+"=?",new String[]{String.valueOf(username)},null,null,null,null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        String password=cursor.getString(cursor.getColumnIndex(key_password));
        cursor.close();
        return password;
    }

}
