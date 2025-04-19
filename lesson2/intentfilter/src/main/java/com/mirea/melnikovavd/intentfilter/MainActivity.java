package com.mirea.melnikovavd.intentfilter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonOpenBrowser = findViewById(R.id.buttonOpenBrowser);
        buttonOpenBrowser.setOnClickListener (v -> {
            Uri address = Uri.parse("https://www.mirea.ru/");
            Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, address);
            startActivity(openLinkIntent);
        });

        Button buttonDataTransfer = findViewById(R.id.buttonDataTransfer);
        buttonDataTransfer.setOnClickListener (v -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "MIREA");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Melnikova Valeria Dmitrievna");
            startActivity(Intent.createChooser(shareIntent, "Мy personal information"));
        });
    }
}