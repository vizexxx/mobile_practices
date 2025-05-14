package com.mirea.melnikovavd.sharer;

import static android.content.Intent.getIntent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShareActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        TextView tvReceivedData = findViewById(R.id.tvReceivedData);
        Intent receivedIntent = getIntent();

        // Обработка полученных данных
        if (Intent.ACTION_SEND.equals(receivedIntent.getAction())) {
            String sharedText = receivedIntent.getStringExtra(Intent.EXTRA_TEXT);
            if (sharedText != null) {
                tvReceivedData.setText("Полученные данные: " + sharedText);
            }
        }
    }
}
