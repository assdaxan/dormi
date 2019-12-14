package com.example.dormi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder> {

    private ArrayList<NoticeObject> mList;

    public class NoticeViewHolder extends RecyclerView.ViewHolder {
        protected TextView title;
        protected TextView date;
        protected TextView views;


        public NoticeViewHolder(View view) {
            super(view);
            this.title = (TextView) view.findViewById(R.id.textView4);
            this.date = (TextView) view.findViewById(R.id.textView5);
            this.views = (TextView) view.findViewById(R.id.textView6);
        }
    }

    public NoticeAdapter(ArrayList<NoticeObject> list) {
        this.mList = list;
    }

    @Override
    public NoticeViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.notice_adapter, viewGroup, false);

        NoticeViewHolder viewHolder = new NoticeViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewHolder viewholder, int position) {
        viewholder.title.setText(mList.get(position).getTitle());
        viewholder.date.setText(mList.get(position).getReleaseDate());
        viewholder.views.setText(mList.get(position).getViews());
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }
}