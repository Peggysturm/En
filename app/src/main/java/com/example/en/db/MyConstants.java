package com.example.en.db;

public class MyConstants {
    public static final String EDIT_STATE = "edit_state";
    public static final String LIST_ITEM_INTENT = "list_item_intent";
    public static final String TABLE_NAME = "my_table";
    public static final String _ID = "_id";
    public static final String ACCOUNT_NUMBER = "account_number";
    public static final String SURNAME = "surname";
    public static final String NAME = "name";
    public static final String PATRONYMIC = "patronymic";
    public static final String ADDRESS = "address";
    public static final String IMD = "imd";
    public static final String URI = "uri";
    public static final String DB_NAME = "my_db.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_STRUCTURE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + " (" + _ID + " INTEGER PRIMARY KEY," + ACCOUNT_NUMBER + " TEXT," +
            SURNAME + " TEXT," + NAME + " TEXT," + PATRONYMIC + " TEXT," + ADDRESS + " TEXT," +
            IMD + " TEXT," + URI + " TEXT)";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
}
