package com.example.a99ecoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CategoriesActivity extends AppCompatActivity {

    private ImageButton buttonMenu,buttonCategories,buttonStatistics,buttonTips;
    private CardView cardViewCarton,cardViewScrap,cardViewCooper,cardViewPlastic,cardViewPaper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_categories);


        cardViewCarton = findViewById(R.id.cardViewCarton);
        cardViewScrap = findViewById(R.id.cardViewScrap);
        cardViewCooper = findViewById(R.id.cardViewCooper);
        cardViewPlastic = findViewById(R.id.cardViewPlastic);
        cardViewPaper = findViewById(R.id.cardViewPaper);

        buttonMenu = findViewById(R.id.buttonMenu);
        buttonCategories = findViewById(R.id.buttonCategories);
        buttonStatistics = findViewById(R.id.buttonStatistics);
        buttonTips = findViewById(R.id.buttonTips);

        cardViewCarton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CategoriesActivity.this,MaterialsRegistryActivity.class);
                intent.putExtra("material", "Cartón");
                startActivity(intent);
            }
        });
        cardViewScrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesActivity.this,MaterialsRegistryActivity.class);
                intent.putExtra("material", "Chatarra");
                startActivity(intent);

            }
        });
        cardViewCooper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesActivity.this,MaterialsRegistryActivity.class);
                intent.putExtra("material", "Cobre");
                startActivity(intent);
            }
        });
        cardViewPlastic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesActivity.this,MaterialsRegistryActivity.class);
                intent.putExtra("material", "Plastico");
                startActivity(intent);
            }
        });
        cardViewPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesActivity.this,MaterialsRegistryActivity.class);
                intent.putExtra("material", "Papel");
                startActivity(intent);
            }
        });
        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        buttonCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesActivity.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });

        buttonStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesActivity.this, StatisticsActivity.class);
                startActivity(intent);
            }
        });

        buttonTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesActivity.this, TipsActivity.class);
                startActivity(intent);
            }
        });
    }
}