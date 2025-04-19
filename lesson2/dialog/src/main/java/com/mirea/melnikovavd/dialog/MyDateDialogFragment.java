package com.mirea.melnikovavd.dialog;

import static android.app.PendingIntent.getActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class MyDateDialogFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    @Override
    public DatePickerDialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(
                getActivity(),
                this,
                year,
                month,
                day
        );
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        String date = day + "." + (month + 1) + "." + year;
        if (getView() != null) {
            Snackbar.make(getView(), "Выбрана дата: " + date, Snackbar.LENGTH_LONG).show();
        }
    }
}
