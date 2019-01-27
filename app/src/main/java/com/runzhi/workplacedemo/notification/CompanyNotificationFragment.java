package com.runzhi.workplacedemo.notification;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.runzhi.workplacedemo.R;
import com.runzhi.workplacedemo.dataaccess.NotificationDataAccessHelper;

public class CompanyNotificationFragment extends Fragment {

    public static final String NOTIFICATION_DATA_MODEL = "notification_data_model";

    private CompanyNotificationAdapter mCompanyNotificationAdapter;

    public CompanyNotificationFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_company_notification, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.notification_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mCompanyNotificationAdapter =
                new CompanyNotificationAdapter(
                        getContext(),
                        NotificationDataAccessHelper.getNotificationsFromDataBase(getContext()));
        recyclerView.setAdapter(mCompanyNotificationAdapter);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
