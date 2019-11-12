package ru.myproject.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class IndexKetle extends AppCompatActivity {

    RadioGroup rgGender, rgAge, rgBody;
    RadioButton rbGender, rbAge, rbBody;
    EditText etHeight_value, etWeight_value;
    TextView tvIndexKetle_value, tvIndexKetle_temp, twAnswer;
    Button btnCalculate;
    TextView tvTitle;
    String result_height, result_weight;
    Double result_double;
    Integer flag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_ketle);

        tvTitle = findViewById(R.id.textTitle);
        rgGender = findViewById(R.id.gender);
        rgAge = findViewById(R.id.age);
        rgBody = findViewById(R.id.body);

        etHeight_value = findViewById(R.id.input_height);
        etWeight_value = findViewById(R.id.input_weight);
        btnCalculate = findViewById(R.id.calculate);
        tvIndexKetle_value = findViewById(R.id.index_ketle_value);
        tvIndexKetle_temp = findViewById(R.id.index_ketle_temp);
        twAnswer = findViewById(R.id.answer);



        btnCalculate.setOnClickListener(v -> {
            int radioId = rgGender.getCheckedRadioButtonId();
            rbGender = findViewById(radioId);

            radioId = rgAge.getCheckedRadioButtonId();
            rbAge = findViewById(radioId);

            radioId = rgBody.getCheckedRadioButtonId();
            rbBody = findViewById(radioId);

            if (etHeight_value.getText().length() == 0) {
                Toast.makeText(this, "Введите Ваш рост!", Toast.LENGTH_LONG).show();
            }
            else if (etWeight_value.getText().length() == 0) {
                Toast.makeText(this, "Введите Ваш вес!", Toast.LENGTH_LONG).show();
            } else {

                result_height = etHeight_value.getText().toString();                   //получили рост, что ввел пользователь
                result_weight = etWeight_value.getText().toString();                   //получили вес, что ввел пользователь
                if (Double.parseDouble(result_height) < 150) {
                    Toast.makeText(this, "Слишком маленький рост!", Toast.LENGTH_LONG).show();
                } else if (Double.parseDouble(result_height) > 230) {
                    Toast.makeText(this, "Слишком большой рост!", Toast.LENGTH_LONG).show();
                } else  if (Double.parseDouble(result_weight) < 10) {
                    Toast.makeText(this, "Слишком вес рост!", Toast.LENGTH_LONG).show();
                } else if (Double.parseDouble(result_weight) > 330) {
                    Toast.makeText(this, "Слишком вес рост!", Toast.LENGTH_LONG).show();
                }
                else {
                    //перевели в цифру и посчитали
                    result_double = (Double.parseDouble(result_weight)*1000/Double.parseDouble(result_height));
                    result_double = aroundUp(result_double, 2);          //округлили
                    tvIndexKetle_temp.setText(" ");
                    //вернули в строку и вывели
                    tvIndexKetle_value.setText((Double.toString(result_double)));

                    if (rbGender.getText().equals("Женщина")) {
                        if (rbAge.getText().equals("26-39 лет")) {
                            if (rbBody.getText().equals("Крупное")) {

                                if (result_double > 380 && result_double < 420) {
                                   flag =1;
                                } else if (result_double > 420) {
                                    flag =2;
                                } else if (result_double < 380) {
                                    flag =0;
                                }
                                indexKetle(flag, twAnswer);
                            } else if (rbBody.getText().equals("Норма")) {
                                if (result_double > 340 && result_double < 380) {
                                    flag =1;
                                } else if (result_double > 380) {
                                    flag =2;
                                } else if (result_double < 340) {
                                    flag =0;
                                }
                                indexKetle(flag, twAnswer);
                            }
                            else if (rbBody.getText().equals("Худое")) {
                                if (result_double > 330 && result_double < 340) {
                                    flag =1;
                                } else if (result_double > 340) {
                                    flag =2;
                                } else if (result_double < 330) {
                                    flag =0;
                                }
                                indexKetle(flag, twAnswer);
                            }
                        }
                        if (rbAge.getText().equals("от 40 лет")) {
                            if (rbBody.getText().equals("Крупное")) {
                                if (result_double > 421 && result_double < 440) {
                                    flag =1;
                                } else if (result_double > 440) {
                                    flag =2;
                                } else if (result_double < 421) {
                                    flag =0;
                                }
                                indexKetle(flag, twAnswer);
                            } else if (rbBody.getText().equals("Норма")) {
                                if (result_double > 381 && result_double < 400) {
                                    flag =1;
                                } else if (result_double > 400) {
                                    flag =2;
                                } else if (result_double < 381) {
                                    flag =0;;
                                }
                                indexKetle(flag, twAnswer);
                            }
                            else if (rbBody.getText().equals("Худое")) {
                                if (result_double > 341 && result_double < 360) {
                                    flag =1;
                                } else if (result_double > 360) {
                                    flag =2;
                                } else if (result_double < 341) {
                                    flag =0;
                                }
                                indexKetle(flag, twAnswer);
                            }
                        }
                    } else if (rbGender.getText().equals("Мужчина")) {
                        if (rbAge.getText().equals("26-39 лет")) {
                            if (rbBody.getText().equals("Крупное")) {
                                if (result_double > 390 && result_double < 430) {
                                    flag =1;
                                } else if (result_double > 430) {
                                    flag =2;
                                } else if (result_double < 390) {
                                    flag =0;
                                }
                                indexKetle(flag, twAnswer);
                            } else if (rbBody.getText().equals("Норма")) {
                                if (result_double > 350 && result_double < 390) {
                                    flag =1;
                                } else if (result_double > 390) {
                                    flag =2;
                                } else if (result_double < 350) {
                                    flag =0;
                                }
                                indexKetle(flag, twAnswer);
                            }
                            else if (rbBody.getText().equals("Худое")) {
                                if (result_double > 340 && result_double < 350) {
                                    flag =1;
                                } else if (result_double > 350) {
                                    flag =2;
                                } else if (result_double < 340) {
                                    flag =0;
                                }
                                indexKetle(flag, twAnswer);
                            }
                        }
                        if (rbAge.getText().equals("от 40 лет")) {
                            if (rbBody.getText().equals("Крупное")) {
                                if (result_double > 431 && result_double < 450) {
                                    flag =1;
                                } else if (result_double > 450) {
                                    flag =2;
                                } else if (result_double < 431) {
                                    flag =0;
                                }
                                indexKetle(flag, twAnswer);
                            } else if (rbBody.getText().equals("Норма")) {
                                if (result_double > 391 && result_double < 410) {
                                    flag =1;
                                } else if (result_double > 410) {
                                    flag =2;
                                } else if (result_double < 391) {
                                    flag =0;
                                }
                                indexKetle(flag, twAnswer);
                            }
                            else if (rbBody.getText().equals("Худое")) {
                                if (result_double > 351 && result_double < 370) {
                                    flag =1;
                                } else if (result_double > 370) {
                                    flag =2;
                                } else if (result_double < 351) {
                                    flag =0;
                                }
                                indexKetle(flag, twAnswer);
                            }
                        }
                    }
                }
            }
        });
    }

    public static double aroundUp(double number, int canDecimal) {
        int cifras = (int) Math.pow(10, canDecimal);
        return Math.ceil(number * cifras) / cifras;
    }

    public static void indexKetle(int flag, TextView twAnswer) {
        if (flag==1) {
            twAnswer.setText("Вес в норме!");
        } else if (flag == 2) {
            twAnswer.setText("Вес выше нормы!");
        } else if (flag == 0) {
            twAnswer.setText("Вес ниже нормы!");
        }
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
        String textViewText = savedInstanceState.getString("index");
        TextView nameView = findViewById(R.id.index_ketle_value);
        nameView.setText(textViewText);

        String textViewText2 = savedInstanceState.getString("index_temp");
        TextView nameView2 = findViewById(R.id.index_ketle_temp);
        nameView2.setText(textViewText2);

        String textViewText3 = savedInstanceState.getString("index_answer");
        TextView nameView3 = findViewById(R.id.answer);
        nameView3.setText(textViewText3);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView nameView = findViewById(R.id.index_ketle_value);
        outState.putString("index", nameView.getText().toString());

        TextView nameView2 = findViewById(R.id.index_ketle_temp);
        outState.putString("index_temp", nameView2.getText().toString());

        TextView nameView3 = findViewById(R.id.answer);
        outState.putString("index_answer", nameView3.getText().toString());
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onStop() {
        super.onStop();
    }
}
