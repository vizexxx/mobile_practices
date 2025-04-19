package com.mirea.melnikovavd.dialog;

import static android.app.PendingIntent.getActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import androidx.fragment.app.DialogFragment;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class MyTimeDialogFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    @Override
    public TimePickerDialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        return new TimePickerDialog(
                getActivity(),
                this,
                hour,
                minute,
                DateFormat.is24HourFormat(getActivity())
        );
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String time = hourOfDay + ":" + minute;
        if (getView() != null) {
            Snackbar.make(getView(), "Выбрано время: " + time, Snackbar.LENGTH_LONG).show();
        }
    }
}
