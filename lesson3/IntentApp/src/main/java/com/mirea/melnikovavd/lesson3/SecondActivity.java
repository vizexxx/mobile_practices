package com.mirea.melnikovavd.lesson3;

import static android.content.Intent.getIntent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvResult = findViewById(R.id.tvResult);
        String time = getIntent().getStringExtra("TIME_KEY");

        int studentNumber = 16;
        int square = studentNumber * studentNumber;

        String resultText = String.format(
                "КВАДРАТ ЗНАЧЕНИЯ МОЕГО НОМЕРА ПО СПИСКУ В ГРУППЕ СОСТАВЛЯЕТ %d, а текущее время %s",
                square, time);

        tvResult.setText(resultText);
    }
}
