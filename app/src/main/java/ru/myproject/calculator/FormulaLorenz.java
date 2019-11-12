package ru.myproject.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FormulaLorenz extends AppCompatActivity {

    TextView tvTitle, tvLableLorenz, tvLableLorenz2;
    RadioGroup rgGender;
    RadioButton rbGender;
    EditText etHeight_value;
    TextView tvWeight_value;
    TextView tvWeight_temp;
    String result;
    Double result_double;
    Button btnCalculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formula_lorenz);

        tvTitle = findViewById(R.id.textTitle);             //заголовок
        tvLableLorenz = findViewById(R.id.lable_lorenz);
        rgGender = findViewById(R.id.gender);
        tvLableLorenz2 = findViewById(R.id.lable2_lorenz);
        etHeight_value = findViewById(R.id.input_height);   //ввод роста
        btnCalculate = findViewById(R.id.calculate);        //кнопка
        tvWeight_temp = findViewById(R.id.weight_temp);     //подсказка, для веса
        tvWeight_value = findViewById(R.id.weight_value);   //вывод веса

        btnCalculate.setOnClickListener(v -> {
            int radioId = rgGender.getCheckedRadioButtonId();
            rbGender = findViewById(radioId);
            try {
                if (rbGender.getText().equals("Женщина")) {
                    {
                        if (etHeight_value.getText().length() == 0) {
                            Toast.makeText(this, "Введите Ваш рост!", Toast.LENGTH_LONG).show();
                        } else {
                            result = etHeight_value.getText().toString();                       //получили то, что ввел пользователь
                            //перевели в цифру и посчитали
                            if (Double.parseDouble(result) > 175) {
                                Toast.makeText(this, "Рост больше 175см!", Toast.LENGTH_LONG).show();
                            } else if (Double.parseDouble(result) < 150) {
                                Toast.makeText(this, "Слишком маленький рост!", Toast.LENGTH_LONG).show();
                            } else {
                                result_double = (Double.parseDouble(result) - 100) - (Double.parseDouble(result) - 150) / 2;
                                result_double = FormulaBrock.aroundUp(result_double, 3); //округлили

                                    result = (Double.toString(result_double));                          //вернули в строку
                                    result += getResources().getString(R.string.add_kg);                //дописали кг
                                    tvWeight_temp.setText(" ");
                                    tvWeight_value.setText(result);                                     //вывели

                            }
                        }
                    }
                }
            }
            catch (NullPointerException npe) {
                Toast.makeText(this, "Выберете Ваш пол!", Toast.LENGTH_LONG).show();
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
    }
    protected void onPause() {
        super.onPause();
    }
    protected void onRestart() {
        super.onRestart();
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String textViewText = savedInstanceState.getString("weight2");
        TextView nameView = findViewById(R.id.weight_value);
        nameView.setText(textViewText);

        String textViewText2 = savedInstanceState.getString("weight_temp");
        TextView nameView2 = findViewById(R.id.weight_temp);
        nameView2.setText(textViewText2);
    }
    protected void onResume() {
        super.onResume();
    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView nameView = findViewById(R.id.weight_value);
        outState.putString("weight2", nameView.getText().toString());

        TextView nameView2 = findViewById(R.id.weight_temp);
        outState.putString("weight_temp", nameView2.getText().toString());
    }
    protected void onStart() {
        super.onStart();
    }
    protected void onStop() {
        super.onStop();
    }
}
