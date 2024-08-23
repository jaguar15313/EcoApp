package com.example.a99ecoapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MaterialsRegistryActivity extends AppCompatActivity {
    private ImageButton buttonMenu,buttonCategories,buttonStatistics,buttonTips;
    private Button buttonCancel;
    private EditText editTextMaterial,editTextWeight, editTextMonth, editTextPrice;
    private Button buttonSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_materials_registry);

        editTextMaterial = findViewById(R.id.editTextMaterial);
        editTextWeight = findViewById(R.id.editTextWeight);
        editTextMonth = findViewById(R.id.editTextMonth);
        editTextPrice = findViewById(R.id.editTextPrice);
        buttonSave = findViewById(R.id.buttonSave);



        String material = getIntent().getStringExtra("material");
        if (material != null) {
            editTextMaterial.setText(material);
        }

        buttonCancel = findViewById(R.id.buttonCancel);

        buttonMenu = findViewById(R.id.buttonMenu);
        buttonCategories = findViewById(R.id.buttonCategories);
        buttonStatistics = findViewById(R.id.buttonStatistics);
        buttonTips = findViewById(R.id.buttonTips);

        buttonSave.setOnClickListener(v -> saveData());

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MaterialsRegistryActivity.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });

        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MaterialsRegistryActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        buttonCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MaterialsRegistryActivity.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });

        buttonStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MaterialsRegistryActivity.this, StatisticsActivity.class);
                startActivity(intent);
            }
        });

        buttonTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MaterialsRegistryActivity.this, TipsActivity.class);
                startActivity(intent);
            }
        });

    }

    private void saveData() {
        String material = editTextMaterial.getText().toString();
        String weight = editTextWeight.getText().toString();
        String month = editTextMonth.getText().toString();
        String price = editTextPrice.getText().toString();

        if (material.isEmpty() ||  weight.isEmpty() || month.isEmpty() || price.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }
        // Guardar los datos en SharedPreferences
        SharedPreferences preferences = getSharedPreferences("Data", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        int index = preferences.getInt("index", 0);
        editor.putString("material_" + index, material);
        editor.putString("weight_" + index, weight);
        editor.putString("month_" + index, month);
        editor.putString("price_" + index, price);
        editor.putInt("index", index + 1);
        editor.apply();

        Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show();
        finish();
    }


}