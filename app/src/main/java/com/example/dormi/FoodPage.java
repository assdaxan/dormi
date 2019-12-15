package com.example.dormi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class FoodPage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<FoodObject> list = new ArrayList<FoodObject>();
    private Elements element;
    private TabLayout tablayout;
    private Intent intent;
    private String board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_page);

        intent = getIntent();

        board = intent.getStringExtra("board");

        new FoodPage.Description().execute();
    }

    private class Description extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document doc = Jsoup.connect("http://dormi.mokpo.ac.kr/www/bbs/board.php?bo_table="+board).get();

                element = doc.select("#content > div > section > div:nth-child(5) > table > tbody > tr");

                for (Element elem : element) {
                    String title = elem.select("td:nth-child(1)").text();
                    String breakfast = elem.select("td:nth-child(2)").text().replace(" ", "\n");
                    String lunch = elem.select("td:nth-child(3)").text().replace(" ", "\n");
                    String dinner = elem.select("td:nth-child(4)").text().replace(" ", "\n");

                    System.out.println(breakfast);

                    list.add(new FoodObject(title, breakfast, lunch, dinner));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            TabLayout tablayout = (TabLayout)findViewById(R.id.tablayout);
            for(FoodObject food : list){
                tablayout.addTab(tablayout.newTab().setText(food.getTitle()));
            }

            Calendar cal = Calendar.getInstance();
            String strWeek = null;

            int nWeek = cal.get(Calendar.DAY_OF_WEEK)-1;
            tablayout.getTabAt(nWeek).select();
            changeView(nWeek);

            tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    int pos = tab.getPosition();
                    changeView(pos);
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                    // do nothing
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {
                    // do nothing
                }
            }) ;
        }

        private void changeView(int index) {
            TextView textView1 = (TextView) findViewById(R.id.textView5);
            TextView textView2 = (TextView) findViewById(R.id.textView6);
            TextView textView3 = (TextView) findViewById(R.id.textView7);

            textView1.setText(list.get(index).getBreakfast());
            textView2.setText(list.get(index).getLunch());
            textView3.setText(list.get(index).getDinner());
        }
    }
}
