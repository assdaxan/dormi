package com.example.dormi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void NoticePage(View view){
        Intent intent = new Intent(MainActivity.this, NoticePage.class);
        startActivity(intent);
    }

    public void FoodPage(View view){
        Intent intent = new Intent(MainActivity.this, FoodPage.class);
        intent.putExtra("board", "food");
        startActivity(intent);
    }

    public void FoodPageBTL(View view){
        Intent intent = new Intent(MainActivity.this, FoodPage.class);
        intent.putExtra("board", "food_btl");
        startActivity(intent);
    }
}

