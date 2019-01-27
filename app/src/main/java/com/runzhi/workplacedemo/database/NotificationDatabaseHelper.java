package com.runzhi.workplacedemo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class NotificationDatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + CompanyNotificationContract.NotificationEntry.TABLE_NAME + " (" +
                    CompanyNotificationContract.NotificationEntry._ID + " INTEGER PRIMARY KEY," +
                    CompanyNotificationContract.NotificationEntry.COLUMN_NAME_TITLE + " TEXT," +
                    CompanyNotificationContract.NotificationEntry.COLUMN_NAME_MESSAGE + " TEXT," +
                    CompanyNotificationContract.NotificationEntry.COLUMN_NAME_PRIORITY + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + CompanyNotificationContract.NotificationEntry.TABLE_NAME;

    public NotificationDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }
}
