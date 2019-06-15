package com.example.cachua.thuchanhso2.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.cachua.thuchanhso2.Model.BookModel;
import com.example.cachua.thuchanhso2.Model.LoginModel;

import java.util.ArrayList;

public class MyDataBaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_time ";

    private static final String TABLE_LOGIN = "table_login";
    private static final String TABLE_BOOK = "table_book";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_NAME_BOOK = "name_book";
    private static final String COLUMN_KIND_BOOK = "kind_book";
    private static final String COLUMN_PASSWORD = "password";


    public MyDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String scriptCreateTableLogin = "CREATE TABLE " + TABLE_LOGIN + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_PASSWORD + " TEXT " + ")";

        db.execSQL(scriptCreateTableLogin);

        String scriptCreateTableBook = "CREATE TABLE " + TABLE_BOOK + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NAME_BOOK + " TEXT,"
                + COLUMN_KIND_BOOK + " TEXT " + ")";

        db.execSQL(scriptCreateTableBook);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOK);

    }

    public void addTableAlarm(LoginModel loginModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, loginModel.getName());
        values.put(COLUMN_PASSWORD, loginModel.getPassword());


        db.insert(TABLE_LOGIN, null, values);
        db.close();

    }


    public void addTableBook(BookModel bookModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_BOOK, bookModel.getNameBook());
        values.put(COLUMN_KIND_BOOK, bookModel.getKindBook());


        db.insert(TABLE_BOOK, null, values);
        db.close();

    }


    public void deleteTableLogin(LoginModel worldClockModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_LOGIN, COLUMN_ID + " = ?",
                new String[]{String.valueOf(worldClockModel.getId())});
        db.close();
    }

    public void deleteTableLogin(BookModel bookModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BOOK, COLUMN_ID + " = ?",
                new String[]{String.valueOf(bookModel.getId())});
        db.close();
    }


    public ArrayList<LoginModel> getAllLogin() {

        ArrayList<LoginModel> loginModelArrayList = new ArrayList<LoginModel>();
        String selectQuery = "SELECT  * FROM " + TABLE_LOGIN;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                LoginModel loginModel = new LoginModel();
                loginModel.setId(Integer.parseInt(cursor.getString(0)));
                loginModel.setName((cursor.getString(1)));
                loginModel.setPassword((cursor.getString(2)));


                // Thêm vào danh sách.
                loginModelArrayList.add(loginModel);
            } while (cursor.moveToNext());
        }
        return loginModelArrayList;

    }

    public ArrayList<BookModel> getAllBook() {

        ArrayList<BookModel> loginModelArrayList = new ArrayList<BookModel>();
        String selectQuery = "SELECT  * FROM " + TABLE_BOOK;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                BookModel loginModel = new BookModel();
                loginModel.setId(Integer.parseInt(cursor.getString(0)));
                loginModel.setNameBook((cursor.getString(1)));
                loginModel.setKindBook((cursor.getString(2)));


                // Thêm vào danh sách.
                loginModelArrayList.add(loginModel);
            } while (cursor.moveToNext());
        }
        return loginModelArrayList;

    }

}
