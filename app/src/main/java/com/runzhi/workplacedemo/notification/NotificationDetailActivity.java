package com.runzhi.workplacedemo.notification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.runzhi.workplacedemo.R;

public class NotificationDetailActivity extends AppCompatActivity {

    private CompanyNotificationDataModel mNotificationModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_detail);

        ActionBar titleBar = getSupportActionBar();
        if (titleBar != null) {
            titleBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            titleBar.setCustomView(R.layout.notificaton_title_bar);
        }

        TextView titleTextView = findViewById(R.id.notification_detail_title);
        TextView messageTextView = findViewById(R.id.notification_detail_message);

        ImageButton backButton = findViewById(R.id.notification_activity_back_button);
        if (backButton != null) {
            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }

        Intent launchIntent = getIntent();
        if (launchIntent != null) {
            mNotificationModel = launchIntent.getParcelableExtra(
                    CompanyNotificationFragment.NOTIFICATION_DATA_MODEL);
            String title = getReadablePriorityText(
                    mNotificationModel.getmPriority()) + " " + mNotificationModel.getmTitle();
            titleTextView.setText(title);
            messageTextView.setText(mNotificationModel.getmMessage());
        }
    }

    private String getReadablePriorityText(NotificationPriority priority) {
        switch (priority) {
            case LOW:
                return getString(R.string.priority_readable_text_low);
            case MID:
                return getString(R.string.priority_readable_text_mid);
            case HIGH:
                return getString(R.string.priority_readable_text_high);
            case URGENT:
                return getString(R.string.priority_readable_text_urgent);
            default:
                return getString(R.string.priority_readable_text_low);
        }
    }
}

