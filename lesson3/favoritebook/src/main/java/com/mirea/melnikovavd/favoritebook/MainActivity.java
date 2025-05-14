    package com.mirea.melnikovavd.favoritebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
        private ActivityResultLauncher<Intent> activityResultLauncher;
        static final String KEY = "book_name";
        static final String USER_MESSAGE = "MESSAGE";
        private TextView textViewUserBook;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            textViewUserBook = findViewById(R.id.textViewBook);

            ActivityResultCallback<ActivityResult> callback = new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            String userBook = data.getStringExtra(USER_MESSAGE);
                            textViewUserBook.setText(userBook);
                        }
                    }
                }
            };

            activityResultLauncher = registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    callback);
        }

        public void getInfoAboutBook(View view) {
            Intent intent = new Intent(this, ShareActivity.class);
            intent.putExtra(KEY, "Кладбище домашних животных"); // Любимая книга разработчика
            activityResultLauncher.launch(intent);
        }
    }