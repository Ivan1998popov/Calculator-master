package ru.myproject.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FormulaBrock extends AppCompatActivity {

    RadioGroup rgGender;
    RadioButton rbGender;
    EditText etHeight_value;
    TextView tvWeight_value;
    TextView tvWeight_temp;
    String result;
    Double result_double;
    Button btnCalculate;
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formula_brock);

        rgGender = findViewById(R.id.gender);

        etHeight_value = findViewById(R.id.input_height);
        tvWeight_value = findViewById(R.id.weight_value);
        btnCalculate = findViewById(R.id.calculate);
        tvWeight_temp = findViewById(R.id.weight_temp);
        //etHeight_value.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);
        tvTitle = findViewById(R.id.textTitle);

        btnCalculate.setOnClickListener(v -> {
            int radioId = rgGender.getCheckedRadioButtonId();
            rbGender = findViewById(radioId);
            try {
                if (rbGender.getText().equals("Женщина")) {
                    if (etHeight_value.getText().length() == 0) {
                        Toast.makeText(this, "Введите Ваш рост!", Toast.LENGTH_LONG).show();
                    } else {
                        result = etHeight_value.getText().toString();                   //получили то, что ввел пользователь
                        if (Double.parseDouble(result) < 150) {
                            Toast.makeText(this, "Слишком маленький рост!", Toast.LENGTH_LONG).show();
                        } else if (Double.parseDouble(result) > 230) {
                            Toast.makeText(this, "Слишком большой рост!", Toast.LENGTH_LONG).show();
                        } else {
                            result_double = (Double.parseDouble(result) - 110) * (1.15);    //перевели в цифру и посчитали
                            result_double = aroundUp(result_double, 2);          //округлили
                            result = (Double.toString(result_double));                      //вернули в строку
                            result += getResources().getString(R.string.add_kg);                                                //дописали кг
                            tvWeight_temp.setText(" ");
                            tvWeight_value.setText(result);                                 //вывели
                        }

                    }
                } else if (rbGender.getText().equals("Мужчина")) {
                    if (etHeight_value.getText().length() == 0) {
                        Toast.makeText(this, "Введите Ваш рост!", Toast.LENGTH_LONG).show();
                    } else {
                        result = etHeight_value.getText().toString();                   //получили то, что ввел пользователь
                        if (Double.parseDouble(result) < 150) {
                            Toast.makeText(this, "Слишком маленький рост!", Toast.LENGTH_LONG).show();
                        } else {
                            result_double = (Double.parseDouble(result) - 100) * (1.15);    //перевели в цифру и посчитали
                            result_double = aroundUp(result_double, 2);          //округлили

                            result = (Double.toString(result_double));                      //вернули в строку
                            result += getResources().getString(R.string.add_kg);            //дописали кг
                            tvWeight_temp.setText(" ");
                            tvWeight_value.setText(result);                                 //вывели

                        }
                    }
                }
            } catch (NullPointerException npe) {
                Toast.makeText(this, "Выберете Ваш пол!", Toast.LENGTH_LONG).show();
            }
        });
    }

    public static double aroundUp(double number, int canDecimal) {
        int cifras = (int) Math.pow(10, canDecimal);
        return Math.ceil(number * cifras) / cifras;
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
        //  result = savedInstanceState.getString("weight");
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
        //outState.putString("weight", result);
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


