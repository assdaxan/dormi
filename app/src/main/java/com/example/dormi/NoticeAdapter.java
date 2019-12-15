package com.example.dormi;

import android.content.Intent;
import android.net.Uri;
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
            this.title = (TextView) view.findViewById(R.id.title);
            this.date = (TextView) view.findViewById(R.id.date);
            this.views = (TextView) view.findViewById(R.id.views);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition() ;
                    if (pos != RecyclerView.NO_POSITION) {
                        NoticeObject item = mList.get(pos) ;

                        System.out.println(item.getLink());

                        Uri u = Uri.parse("http://dormi.mokpo.ac.kr/www/bbs/"+item.getLink());

                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        System.out.println(u);
                        intent.setData(u);
                        v.getContext().startActivity(intent);
                    }
                }
            });
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