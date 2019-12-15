package com.example.dormi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button call_btn  = (Button)findViewById(R.id.button);
        Button call_btn2 = (Button)findViewById(R.id.button2);
        Button call_btn3 = (Button)findViewById(R.id.button3);
        Button call_btn4 = (Button)findViewById(R.id.button4);

        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button:
                        startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:0614502909")));
                        break;
                    case R.id.button2:
                        startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:0614506207")));
                        break;
                    case R.id.button3:
                        startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:0614502911")));
                        break;
                    case R.id.button4:
                        startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:0614508600")));
                        break;
                }
            }
        };

        call_btn.setOnClickListener(onClickListener);
        call_btn2.setOnClickListener(onClickListener);
        call_btn3.setOnClickListener(onClickListener);
        call_btn4.setOnClickListener(onClickListener);
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

