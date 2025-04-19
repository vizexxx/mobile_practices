package com.mirea.melnikovavd.toastapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText editText = findViewById(R.id.editTextInput);
        Button button = findViewById(R.id.buttonCount);

        button.setOnClickListener(v -> {
            String text = editText.getText().toString();
            int count = text.length();
            String message = "СТУДЕНТ № 16 ГРУППА БСБО-05-23 Количество символов - " + count;
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        });
    }
}