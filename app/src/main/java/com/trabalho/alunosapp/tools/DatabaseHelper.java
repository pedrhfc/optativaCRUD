package com.trabalho.alunosapp.tools;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "register";
    private static final String TABLE_NAME_USR = "user_login";
    private static final String COL_ID_USR = "id";
    private static final String COL_NOME_USR = "nome";
    private static final String COL_EMAIL_USR = "email";

    private static final String CREATE_TABLE_USR = "CREATE TABLE " + TABLE_NAME_USR +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, email TEXT)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_USR);
        onCreate(db);
    }

    public boolean addUser(String nome, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NOME_USR, nome);
        contentValues.put(COL_EMAIL_USR, email);

        long result = db.insert(TABLE_NAME_USR, null, contentValues);

        return result != -1;
    }

    public boolean updateUser(String id, String nome, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ID_USR, id);
        contentValues.put(COL_NOME_USR, nome);
        contentValues.put(COL_EMAIL_USR, email);
        db.update(TABLE_NAME_USR, contentValues, COL_ID_USR + "= ?", new String[]{id});
        return true;
    }

    public Cursor selectUserById(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME_USR + " WHERE id= " + id, null);
    }
}

