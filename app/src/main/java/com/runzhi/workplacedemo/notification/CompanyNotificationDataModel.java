package com.runzhi.workplacedemo.notification;

import android.os.Parcel;
import android.os.Parcelable;

public class CompanyNotificationDataModel implements Parcelable {

    private String mTitle;
    private String mMessage;
    private NotificationPriority mPriority;

    public CompanyNotificationDataModel(String mTitle, String mMessage) {
        this.mTitle = mTitle;
        this.mMessage = mMessage;
        this.mPriority = NotificationPriority.LOW;
    }

    public CompanyNotificationDataModel(String mTitle, String mMessage, NotificationPriority mPriority) {
        this.mTitle = mTitle;
        this.mMessage = mMessage;
        this.mPriority = mPriority;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmMessage() {
        return mMessage;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    public NotificationPriority getmPriority() {
        return mPriority;
    }

    public void setmPriority(NotificationPriority mPriority) {
        this.mPriority = mPriority;
    }

    // In order to pass our data model in the intent, we have to serialize our model, below are
    // boiler plate code.
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mTitle);
        parcel.writeString(mMessage);
        parcel.writeInt(getPriorityInteger(mPriority));
    }

    public static final Parcelable.Creator<CompanyNotificationDataModel> CREATOR =
            new Parcelable.Creator<CompanyNotificationDataModel>() {

                @Override
                public CompanyNotificationDataModel createFromParcel(Parcel parcel) {
                    return new CompanyNotificationDataModel(parcel);
                }

                @Override
                public CompanyNotificationDataModel[] newArray(int i) {
                    return new CompanyNotificationDataModel[i];
                }
            };

    private CompanyNotificationDataModel(Parcel parcel) {
        mTitle = parcel.readString();
        mMessage = parcel.readString();
        mPriority = getPriorityEnum(parcel.readInt());
    }

    private int getPriorityInteger(NotificationPriority priority) {
        switch (priority) {
            case LOW:
                return 1;
            case MID:
                return 2;
            case HIGH:
                return 3;
            case URGENT:
                return 4;
            default:
                return 1;
        }
    }

    private NotificationPriority getPriorityEnum(int priority) {
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

