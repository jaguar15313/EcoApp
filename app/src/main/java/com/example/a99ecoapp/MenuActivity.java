

package com.example.a99ecoapp;

import static com.example.a99ecoapp.R.id.imageButtonTips;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuActivity extends AppCompatActivity {

    private ImageButton buttonMenu,buttonCategories,buttonStatistics,buttonTips,
    imageButtonCategories,imageButtonStatistics,imageButtonTips ;

    private String[] dailyTips = {
            "Ahorra energía apagando las luces que no necesitas.",
            "Desconecta los electrodomésticos que no estás usando.",
            "Utiliza bombillas LED para reducir el consumo de energía.",
            "Apaga tu computadora cuando no la estés usando.",
            "Aprovecha la luz natural durante el día.",
            "Mantén el refrigerador bien cerrado para ahorrar energía.",
            "Usa el aire acondicionado con moderación.",
            "Lava tu ropa con agua fría para ahorrar energía.",
            "Revisa tus aparatos eléctricos para evitar fugas de energía.",
            "Plancha tu ropa en una sola sesión para ahorrar energía."
    };


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        buttonMenu = findViewById(R.id.buttonMenu);
        buttonCategories = findViewById(R.id.buttonCategories);
        buttonStatistics = findViewById(R.id.buttonStatistics);
        buttonTips = findViewById(R.id.buttonTips);

        // Inicializar los SharedPreferences
        SharedPreferences preferences = getSharedPreferences("DailyTips", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        // Verificar si los consejos ya están guardados
        boolean isInitialized = preferences.getBoolean("isInitialized", false);

        if (!isInitialized) {
            // Guardar los consejos en SharedPreferences
            for (int i = 0; i < dailyTips.length; i++) {
                editor.putString("tip_" + i, dailyTips[i]);
            }
            editor.putBoolean("isInitialized", true);
            editor.apply();
        }



        imageButtonCategories = findViewById(R.id. imageButtonCategories);
        imageButtonStatistics = findViewById(R.id.imageButtonStatistics);
        imageButtonTips = findViewById(R.id.imageButtonTips);


        imageButtonCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });

        imageButtonStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, StatisticsActivity.class);
                startActivity(intent);
            }
        });

        imageButtonTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, TipsActivity.class);
                startActivity(intent);
            }
        });



        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        buttonCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });

        buttonStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, StatisticsActivity.class);
                startActivity(intent);
            }
        });

        buttonTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, TipsActivity.class);
                startActivity(intent);
            }
        });
    }
}