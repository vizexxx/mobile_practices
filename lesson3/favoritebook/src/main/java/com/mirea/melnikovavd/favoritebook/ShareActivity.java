package com.mirea.melnikovavd.favoritebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShareActivity extends AppCompatActivity {

    private EditText editTextUserBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TextView devBookView = findViewById(R.id.textViewDevBook);
            String devBook = extras.getString(MainActivity.KEY);
            devBookView.setText(String.format("Любимая книга разработчика - %s", devBook));
        }

        editTextUserBook = findViewById(R.id.editTextUserBook);
    }

    public void sendBookName(View view) {
        String userBook = editTextUserBook.getText().toString();
        if (!userBook.isEmpty()) {
            Intent data = new Intent();
            data.putExtra(MainActivity.USER_MESSAGE,
                    "Название Вашей любимой книги: " + userBook);
            setResult(Activity.RESULT_OK, data);
            finish();
        } else {
            editTextUserBook.setError("Введите название книги");
        }
    }
}