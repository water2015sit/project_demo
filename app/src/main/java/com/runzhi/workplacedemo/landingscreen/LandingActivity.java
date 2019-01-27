package com.runzhi.workplacedemo.landingscreen;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.runzhi.workplacedemo.R;
import com.runzhi.workplacedemo.dataaccess.NotificationDataAccessHelper;
import com.runzhi.workplacedemo.internalfiles.InternalFilesActivity;
import com.runzhi.workplacedemo.settings.SettingsActivity;
import com.runzhi.workplacedemo.webbrowser.WebBrowserActivity;

import java.util.ArrayList;
import java.util.List;

public class LandingActivity extends AppCompatActivity {

    LandingScreenPagerAdapter mLandingPagerAdater;
    ViewPager mainTabPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar titleBar = getSupportActionBar();
        if (titleBar != null) {
            titleBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            titleBar.setCustomView(R.layout.title_bar);
        }

        fetchData(this);
        initTabConfiguration();
        mainTabPager = findViewById(R.id.landing_pager);
        TabLayout tabLayout = findViewById(R.id.landing_tab_layout);
        mainTabPager.setAdapter(mLandingPagerAdater);
        tabLayout.setupWithViewPager(mainTabPager);
        tabLayout.setTabTextColors(Color.GRAY, Color.WHITE);

        final DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationDrawer = findViewById(R.id.navigation_drawer);
        navigationDrawer.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        item.setChecked(true);
                        Intent intent = null;
                        switch (item.getItemId()) {
                            case R.id.nav_internal_files:
                                intent = new Intent(LandingActivity.this, InternalFilesActivity.class);
                                break;
                            case R.id.nav_browser:
                                intent = new Intent(LandingActivity.this, WebBrowserActivity.class);
                                break;
                            case R.id.nav_setting:
                                intent = new Intent(LandingActivity.this, SettingsActivity.class);
                                break;
                            default:
                                break;
                        }
                        drawerLayout.closeDrawers();
                        if (intent != null) {
                            startActivity(intent);
                        }
                        return true;
                    }
                });

        ImageView actionBarMenu = findViewById(R.id.action_bar_drawer_menu);
        actionBarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void initTabConfiguration() {
        List<LandingScreenPagerAdapter.TabType> tabTypes = new ArrayList<>();
        tabTypes.add(LandingScreenPagerAdapter.TabType.NOTIFICATION);
        tabTypes.add(LandingScreenPagerAdapter.TabType.PERSONAL_TASK);
        mLandingPagerAdater =
                new LandingScreenPagerAdapter(
                        getApplicationContext(),
                        getSupportFragmentManager(),
                        tabTypes);
    }

    private void fetchData(Context context) {
        NotificationDataAccessHelper.writeToDataBase(
                context,
                "Update Your Mobile App",
                "Please help us dog food the latest mobile app.",
                1
        );
        NotificationDataAccessHelper.writeToDataBase(
                context,
                "Confirm Home Address",
                "We need to send you the updated tax documentation.",
                3
        );
        NotificationDataAccessHelper.writeToDataBase(
                context,
                "Join our company book club today",
                "Join our newly found book club, share your thoughts!",
                1
        );
        NotificationDataAccessHelper.writeToDataBase(
                context,
                "New monitors are in stock",
                "If you are interested in the new ultra wide monitor, please contact IT department",
                2
        );
        NotificationDataAccessHelper.writeToDataBase(
                context,
                "Submit your expense before this Friday",
                "Please submit your expense report by the end of this week",
                4
        );
        NotificationDataAccessHelper.writeToDataBase(
                context,
                "Route 1 Shuttle operates with delay",
                "Due to the signal failure, route 1 shuttle is 15 minutes late",
                3
        );
        NotificationDataAccessHelper.writeToDataBase(
                context,
                "Bring your kid to work day 2019",
                "This year's bring your kid to work day is set to April 1st",
                3
        );
        NotificationDataAccessHelper.writeToDataBase(
                context,
                "Let's build a strong tech community",
                "We need to a strong mobile tech community in this half",
                2
        );
        NotificationDataAccessHelper.writeToDataBase(
                context,
                "Office will be closed this Sunday",
                "Our office will be closed this Sunday due to the fire inspection",
                1
        );
        NotificationDataAccessHelper.writeToDataBase(
                context,
                "Bring your dog to work!",
                "All employee with dogs can bring your cute pet to the office",
                3
        );
    }
}

