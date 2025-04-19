package com.mirea.melnikovavd.dialog;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.snackbar.Snackbar;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnTimePicker = findViewById(R.id.buttonTimeDialog);
        Button btnDatePicker = findViewById(R.id.buttonDateDialog);
        Button btnProgressDialog = findViewById(R.id.buttonProgressDialog);

        btnTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timeDialog = new MyTimeDialogFragment();
                timeDialog.show(getSupportFragmentManager(), "timePicker");
            }
        });

        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dateDialog = new MyDateDialogFragment();
                dateDialog.show(getSupportFragmentManager(), "datePicker");
            }
        });

        btnProgressDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment progressDialog = new MyProgressDialogFragment();
                progressDialog.show(getSupportFragmentManager(), "progressDialog");

                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        DialogFragment dialog = (DialogFragment) getSupportFragmentManager()
                                .findFragmentByTag("progressDialog");
                        if (dialog != null) {
                            dialog.dismiss();
                            Snackbar.make(findViewById(android.R.id.content),
                                    "Загрузка завершена", Snackbar.LENGTH_SHORT).show();
                        }
                    }
                }, 3000);
            }
        });
    }

    public void onClickShowDialog(View view) {
        AlertDialogFragment dialogFragment = new AlertDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "mirea");
    }

    public void onOkClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Иду дальше\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onCancelClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Нет\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onNeutralClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"На паузе\"!",
                Toast.LENGTH_LONG).show();
    }
}