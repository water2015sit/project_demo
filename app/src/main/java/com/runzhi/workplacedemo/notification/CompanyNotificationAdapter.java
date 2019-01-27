package com.runzhi.workplacedemo.notification;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.runzhi.workplacedemo.R;
import com.runzhi.workplacedemo.notification.dots.NotificationPriorityHighDotView;
import com.runzhi.workplacedemo.notification.dots.NotificationPriorityLowDotView;
import com.runzhi.workplacedemo.notification.dots.NotificationPriorityMidDotView;
import com.runzhi.workplacedemo.notification.dots.NotificationPriorityUrgentDotView;

import java.util.List;

public class CompanyNotificationAdapter extends
        RecyclerView.Adapter<CompanyNotificationAdapter.CompanyNotificationItemViewHolder>{
    private Context mContext;
    private List<CompanyNotificationDataModel> mNotificationDataModels;

    public static class CompanyNotificationItemViewHolder extends RecyclerView.ViewHolder {

        LinearLayout itemViewWrapper;
        LinearLayout parentLayout;
        TextView titleView;
        TextView messageView;

        public CompanyNotificationItemViewHolder(View itemView) {
            super(itemView);
            itemViewWrapper = itemView.findViewById(R.id.item_view_wrapper);
            parentLayout = itemView.findViewById(R.id.dot_view);
            titleView = itemView.findViewById(R.id.notification_title);
            messageView = itemView.findViewById(R.id.notification_message);
        }
    }

    public CompanyNotificationAdapter(Context context, List<CompanyNotificationDataModel> mNotificationDataModels) {
        this.mContext = context;
        this.mNotificationDataModels = mNotificationDataModels;
    }

    @Override
    public CompanyNotificationItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
                parent.getContext())
                .inflate(R.layout.company_notification_item, parent, false);
        return new CompanyNotificationItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CompanyNotificationItemViewHolder holder, final int position) {
        CompanyNotificationDataModel notificationDataModel = mNotificationDataModels.get(position);
        View dotView;
        switch (notificationDataModel.getmPriority()) {
            case URGENT:
                dotView = new NotificationPriorityUrgentDotView(mContext);
                break;
            case HIGH:
                dotView = new NotificationPriorityHighDotView(mContext);
                break;
            case MID:
                dotView = new NotificationPriorityMidDotView(mContext);
                break;
            case LOW:
                dotView = new NotificationPriorityLowDotView(mContext);
                break;
            default:
                dotView = new NotificationPriorityLowDotView(mContext);
        }
        holder.parentLayout.addView(dotView);
        holder.titleView.setText(notificationDataModel.getmTitle());
        holder.messageView.setText(notificationDataModel.getmMessage());

        holder.itemViewWrapper.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(mContext, NotificationDetailActivity.class);
                        intent.putExtra(
                                CompanyNotificationFragment.NOTIFICATION_DATA_MODEL,
                                mNotificationDataModels.get(position));
                        mContext.startActivity(intent);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return mNotificationDataModels.size();
    }
}
