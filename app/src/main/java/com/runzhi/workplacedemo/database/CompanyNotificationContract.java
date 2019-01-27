package com.runzhi.workplacedemo.database;

import android.provider.BaseColumns;

public class CompanyNotificationContract {

    private CompanyNotificationContract() {}

    public static class NotificationEntry implements BaseColumns {
        public static final String TABLE_NAME = "notification_entry";
        public static final String COLUMN_NAME_TITLE = "notification_title";
        public static final String COLUMN_NAME_MESSAGE = "notification_message";
        public static final String COLUMN_NAME_PRIORITY = "notification_priority";
    }
}
