package com.mirea.melnikovavd.simplefragmentapp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragmentContainer) != null) {
            configurePortraitMode();
        }
        else{
            configureLandscapeMode();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        recreate();
    }

    private void configurePortraitMode() {
        Button btn1 = findViewById(R.id.btnFragment1);
        Button btn2 = findViewById(R.id.btnFragment2);

        btn1.setOnClickListener(v -> showFragment(new FirstFragment()));
        btn2.setOnClickListener(v -> showFragment(new SecondFragment()));

        if (getSupportFragmentManager().findFragmentById(R.id.fragmentContainer) == null) {
            showFragment(new FirstFragment());
        }
    }
    private void configureLandscapeMode() {
        Fragment fragment1 = getSupportFragmentManager().findFragmentById(R.id.list);
        Fragment fragment2 = getSupportFragmentManager().findFragmentById(R.id.viewer);

        if (fragment1 == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.list, new FirstFragment())
                    .commit();
        }

        if (fragment2 == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.viewer, new SecondFragment())
                    .commit();
        }
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
}