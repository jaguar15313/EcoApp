package com.example.a99ecoapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import java.util.Timer;
import java.util.TimerTask;

public class TipsActivity extends AppCompatActivity {
    private TextView textViewTip;
    private ViewPager viewPager;
    private int[] imageIds = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5};
    private int currentPage = 0;
    private Timer timer;
    private final long DELAY_MS = 500;
    private final long PERIOD_MS = 3000;

    private ImageButton buttonMenu,buttonCategories,buttonStatistics,buttonTips;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tips);

        textViewTip = findViewById(R.id.textViewTip);
        viewPager = findViewById(R.id.viewPager);

        loadDailyTip();
        setupViewPager();

        buttonMenu = findViewById(R.id.buttonMenu);
        buttonCategories = findViewById(R.id.buttonCategories);
        buttonStatistics = findViewById(R.id.buttonStatistics);
        buttonTips = findViewById(R.id.buttonTips);


        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TipsActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        buttonCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TipsActivity.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });

        buttonStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TipsActivity.this, StatisticsActivity.class);
                startActivity(intent);
            }
        });

        buttonTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TipsActivity.this, TipsActivity.class);
                startActivity(intent);
            }
        });
    }
    private void loadDailyTip() {
        SharedPreferences preferences = getSharedPreferences("DailyTips", MODE_PRIVATE);
        String dailyTip = preferences.getString("currentTip", "¡Consejo no disponible!");

        textViewTip.setText(dailyTip);
    }

    private void setupViewPager() {
        ImagePagerAdapter adapter = new ImagePagerAdapter(this, imageIds);
        viewPager.setAdapter(adapter);

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == imageIds.length) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);
    }
}