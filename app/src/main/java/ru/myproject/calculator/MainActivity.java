package ru.myproject.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnFormulaBrock, btnFormulaLorenz, btnTableEgorovLevitsky, btnIndexKetle,
            btnIndexBodyMass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFormulaBrock = findViewById(R.id.formula_brock);
        btnFormulaLorenz = findViewById(R.id.formula_lorenz);
        btnTableEgorovLevitsky= findViewById(R.id.table_egorov_levitsky);
        btnIndexKetle= findViewById(R.id.index_ketle);

        btnFormulaBrock.setOnClickListener(v -> {
            Intent intent = new Intent(this, FormulaBrock.class);
            startActivity(intent);
        });

        btnFormulaLorenz.setOnClickListener(v -> {
            Intent intent = new Intent(this, FormulaLorenz.class);
            startActivity(intent);
        });

        btnTableEgorovLevitsky.setOnClickListener(v -> {
            Intent intent = new Intent(this, TableEgorovLevitsky.class);
            startActivity(intent);
        });

        btnIndexKetle.setOnClickListener(v -> {
            Intent intent = new Intent(this, IndexKetle.class);
            startActivity(intent);
        });


    }
}
