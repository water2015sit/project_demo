package com.runzhi.workplacedemo.personaltask;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class PersonalTaskAdapter extends
        RecyclerView.Adapter<PersonalTaskAdapter.PersonalTaskItemViewHolder>{

    public static class PersonalTaskItemViewHolder extends RecyclerView.ViewHolder {
        public PersonalTaskItemViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public PersonalTaskItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(PersonalTaskItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

