package com.runzhi.workplacedemo.landingscreen;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.runzhi.workplacedemo.R;
import com.runzhi.workplacedemo.notification.CompanyNotificationFragment;
import com.runzhi.workplacedemo.personaltask.PersonalTaskFragment;

import java.util.List;

public class LandingScreenPagerAdapter extends FragmentStatePagerAdapter {

    private Context mContext;
    private List<TabType> mTabs;

    enum TabType {
        NOTIFICATION,
        PERSONAL_TASK,
    }

    LandingScreenPagerAdapter(Context context, FragmentManager fm, List<TabType> tabs) {
        super(fm);
        mContext = context;
        mTabs = tabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (mTabs.get(position)) {
            case NOTIFICATION:
                return new CompanyNotificationFragment();
            case PERSONAL_TASK:
                return new PersonalTaskFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return TabType.values().length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mContext == null) {
            return null;
        }
        switch (mTabs.get(position)) {
            case NOTIFICATION:
                return mContext.getString(R.string.company_notification_tab_title);
            case PERSONAL_TASK:
                return mContext.getString(R.string.personal_task_tab_title);
            default:
                return null;
        }
    }
}
