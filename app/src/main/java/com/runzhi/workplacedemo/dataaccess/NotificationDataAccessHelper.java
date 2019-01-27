package com.runzhi.workplacedemo.dataaccess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.runzhi.workplacedemo.database.CompanyNotificationContract;
import com.runzhi.workplacedemo.database.NotificationDatabaseHelper;
import com.runzhi.workplacedemo.notification.CompanyNotificationDataModel;
import com.runzhi.workplacedemo.notification.NotificationPriority;

import java.util.ArrayList;
import java.util.List;

public class NotificationDataAccessHelper {

    private NotificationDataAccessHelper() {}

    public static long writeToDataBase(Context context, String title, String message, int priority) {
        NotificationDatabaseHelper databaseHelper = new NotificationDatabaseHelper(context);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CompanyNotificationContract.NotificationEntry.COLUMN_NAME_TITLE, title);
        values.put(CompanyNotificationContract.NotificationEntry.COLUMN_NAME_MESSAGE, message);
        values.put(CompanyNotificationContract.NotificationEntry.COLUMN_NAME_PRIORITY, priority);

        long newRowId = sqLiteDatabase.insert(CompanyNotificationContract.NotificationEntry.TABLE_NAME, null, values);
        return newRowId;
    }

    public static List<CompanyNotificationDataModel> getNotificationsFromDataBase(Context context) {
        List<CompanyNotificationDataModel> modelList = new ArrayList<>();
        NotificationDatabaseHelper databaseHelper = new NotificationDatabaseHelper(context);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();

        String[] projection = {
                CompanyNotificationContract.NotificationEntry.COLUMN_NAME_TITLE,
                CompanyNotificationContract.NotificationEntry.COLUMN_NAME_MESSAGE,
                CompanyNotificationContract.NotificationEntry.COLUMN_NAME_PRIORITY,
        };

        String sortOrder =
                CompanyNotificationContract.NotificationEntry.COLUMN_NAME_PRIORITY + " DESC";

        Cursor cursor = sqLiteDatabase.query(
                CompanyNotificationContract.NotificationEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        while(cursor.moveToNext()) {
            String title = cursor.getString(
                    cursor.getColumnIndexOrThrow(
                            CompanyNotificationContract.NotificationEntry.COLUMN_NAME_TITLE));
            String message = cursor.getString(
                    cursor.getColumnIndexOrThrow(
                            CompanyNotificationContract.NotificationEntry.COLUMN_NAME_MESSAGE));
            int priority = cursor.getInt(
                    cursor.getColumnIndexOrThrow(
                            CompanyNotificationContract.NotificationEntry.COLUMN_NAME_PRIORITY));
            NotificationPriority priorityEnum = getPriorityEnum(priority);
            modelList.add(new CompanyNotificationDataModel(title, message, priorityEnum));
        }

        return modelList;
    }

    private static NotificationPriority getPriorityEnum(int priority) {
        switch (priority) {
            case 1:
                return NotificationPriority.LOW;
            case 2:
                return NotificationPriority.MID;
            case 3:
                return NotificationPriority.HIGH;
            case 4:
                return NotificationPriority.URGENT;
            default:
                return NotificationPriority.LOW;
        }
    }
}
