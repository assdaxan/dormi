package com.example.dormi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class NoticePage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<NoticeObject> list = new ArrayList<NoticeObject>();
    private Elements element;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_page);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));

        new NoticePage.Description().execute();
    }


    private class Description extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document doc = Jsoup.connect("http://dormi.mokpo.ac.kr/www/bbs/board.php?bo_table=notice").get();

                element = doc.select("#content > div > section > div.board_list > form > table > tbody > tr");

                for(Element elem : element){
                    String string_num = elem.select("td:nth-child(1)").text();
                    String string_title = elem.select("td:nth-child(2)").text();
                    String string_link = elem.select("td:nth-child(2) > nobr > a").attr("href");
                    String string_date = elem.select("td:nth-child(3)").text();
                    String string_views = elem.select("td:nth-child(4)").text();

                    System.out.println(string_title);

                    list.add(new NoticeObject(string_num, string_title, string_link, string_date, string_views));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            NoticeAdapter myAdapter = new NoticeAdapter(list);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(myAdapter);
        }
    }
}
