package com.example.a99ecoapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StatisticsActivity extends AppCompatActivity {
    private ImageButton buttonMenu,buttonCategories,buttonStatistics,buttonTips;
    private TableLayout tableLayout;
    private Button buttonClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_statistics);


        tableLayout = findViewById(R.id.myTableLayout);
        buttonClear = findViewById(R.id.buttonClear);


        loadData();


        buttonMenu = findViewById(R.id.buttonMenu);
        buttonCategories = findViewById(R.id.buttonCategories);
        buttonStatistics = findViewById(R.id.buttonStatistics);
        buttonTips = findViewById(R.id.buttonTips);


        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearData();
            }
        });



        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StatisticsActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        buttonCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StatisticsActivity.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });

        buttonStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StatisticsActivity.this, StatisticsActivity.class);
                startActivity(intent);
            }
        });

        buttonTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StatisticsActivity.this, TipsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        SharedPreferences waterPrefs = getSharedPreferences("Data", MODE_PRIVATE);
        SharedPreferences electricityPrefs = getSharedPreferences("ElectricityData", MODE_PRIVATE);

        int waterIndex = waterPrefs.getInt("index", 0);
        int electricityIndex = electricityPrefs.getInt("index", 0);

        for (int i = 0; i < waterIndex; i++) {
            String month = waterPrefs.getString("month_" + i, "");
            String material = waterPrefs.getString("material_" + i, "");
            String weight = waterPrefs.getString("weight_" + i, "");
            String price = waterPrefs.getString("price_" + i, "");

            TableRow tableRow = new TableRow(this);

            TextView textViewMonth = new TextView(this);
            textViewMonth.setText(month);
            textViewMonth.setBackgroundResource(R.color.white);
            tableRow.addView(textViewMonth);

            TextView textViewMaterial = new TextView(this);
            textViewMaterial.setText(material);
            textViewMaterial.setBackgroundResource(R.color.white);
            tableRow.addView(textViewMaterial);

            TextView textViewWeight = new TextView(this);
            textViewWeight.setText(weight);
            textViewWeight.setBackgroundResource(R.color.white);
            tableRow.addView(textViewWeight);

            TextView textViewPrice = new TextView(this);
            textViewPrice.setText(price);
            textViewPrice.setBackgroundResource(R.color.white);
            tableRow.addView(textViewPrice);

            tableLayout.addView(tableRow);
        }
    }
    private void clearData() {
        SharedPreferences waterPrefs = getSharedPreferences("Data", MODE_PRIVATE);


        SharedPreferences.Editor waterEditor = waterPrefs.edit();
        waterEditor.clear();
        waterEditor.apply();
        tableLayout.removeAllViews();

        Toast.makeText(this, "Datos borrados", Toast.LENGTH_SHORT).show();
    }
}