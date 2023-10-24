package com.example.en.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.en.adapter.ListItem;

import java.util.ArrayList;
import java.util.List;

public class MyDbManager {
    private Context context;
    private MyDbHelper myDbHelper;
    private SQLiteDatabase db;

    public MyDbManager(Context context) {
        this.context = context;
        myDbHelper = new MyDbHelper(context);
    }

    public void openDb() {
        db = myDbHelper.getReadableDatabase();
    }

    public void insertToDb(int accountNumber, String surname, String name,
                           String patronymic, String address, int imd, String uri) {
        ContentValues cv = new ContentValues();
        cv.put(MyConstants.ACCOUNT_NUMBER, accountNumber);
        cv.put(MyConstants.SURNAME, surname);
        cv.put(MyConstants.NAME, name);
        cv.put(MyConstants.PATRONYMIC, patronymic);
        cv.put(MyConstants.ADDRESS, address);
        cv.put(MyConstants.IMD, imd);
        cv.put(MyConstants.URI, uri);
        db.insert(MyConstants.TABLE_NAME, null, cv);
    }

    public List<ListItem> getFromDb(String searchText) {
        List<ListItem> tempList = new ArrayList<>();
        String selection = MyConstants.ACCOUNT_NUMBER + " like ?";
        Cursor cursor = db.query(MyConstants.TABLE_NAME, null, selection,
                new String[]{"%" + searchText + "%"}, null, null, null);

        while (cursor.moveToNext()) {
            ListItem item = new ListItem();
            @SuppressLint("Range") int accountNumber = cursor.getInt(cursor.getColumnIndex(MyConstants.ACCOUNT_NUMBER));
            @SuppressLint("Range") String surname = cursor.getString(cursor.getColumnIndex(MyConstants.SURNAME));
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(MyConstants.NAME));
            @SuppressLint("Range") String patronymic = cursor.getString(cursor.getColumnIndex(MyConstants.PATRONYMIC));
            @SuppressLint("Range") String address = cursor.getString(cursor.getColumnIndex(MyConstants.ADDRESS));
            @SuppressLint("Range") int imd = cursor.getInt(cursor.getColumnIndex(MyConstants.IMD));
            @SuppressLint("Range") String uri = cursor.getString(cursor.getColumnIndex(MyConstants.URI));
            item.setAccountNumber(accountNumber);
            item.setSurname(surname);
            item.setName(name);
            item.setPatronymic(patronymic);
            item.setAddress(address);
            item.setImd(imd);
            item.setUri(uri);
            tempList.add(item);
        }
        cursor.close();
        return tempList;
    }

    public void closeDb() {
        myDbHelper.close();
    }
}
