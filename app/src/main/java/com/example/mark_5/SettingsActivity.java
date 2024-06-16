package com.example.mark_5;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;

public class SettingsActivity extends AppCompatActivity {

    SharedPreferences settings;
    int Year;
    int Month;
    int Day;
    ConstraintLayout Week_Row;
    TextView Week_TextView;

    Calendar date = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        BottomNavigationView Bot_Menu = findViewById(R.id.bottom_navigation_menu);
        Bot_Menu.setOnNavigationItemSelectedListener(bot_navigation_menu);

        BottomNavigationView Top_menu = findViewById(R.id.top_navigation_menu);
        Top_menu.setOnNavigationItemSelectedListener(top_navigation_menu);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener top_navigation_menu = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.return_back:
                    Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
            }
            return true;
        }
    };

    private BottomNavigationView.OnNavigationItemSelectedListener bot_navigation_menu = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.ok_button_menu:

                    SharedPreferences.Editor prefEditor = settings.edit();
                    prefEditor.putInt("Year", Year);
                    prefEditor.putInt("Month", Month);
                    prefEditor.putInt("Day", Day);
                    prefEditor.apply();

                    break;
            }

            Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);

            return true;
        }
    };

    public void setDate(View v) {
        DatePickerDialog dialog = new DatePickerDialog(SettingsActivity.this, R.style.DatePickerTheme_Dark, d,
                date.get(Calendar.YEAR),
                date.get(Calendar.MONTH),
                date.get(Calendar.DAY_OF_MONTH));

        dialog.show();
        dialog.getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.Mark_Checked));
        dialog.getButton(DatePickerDialog.BUTTON_POSITIVE).setText("Вибрати");
        dialog.getButton(DatePickerDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.Dark_Theme_Font_Light));
    }

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @SuppressLint("SetTextI18n")
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            date.set(Calendar.YEAR, year);
            date.set(Calendar.MONTH, monthOfYear);
            date.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            Year = year;
            Month = monthOfYear;
            Day = dayOfMonth;

            String temp_year = String.valueOf(Year);
            String temp_month = String.valueOf(Month + 1);
            String temp_day = String.valueOf(Day);

            Week_TextView.setText(String.format("%s.%s.%s", temp_day, temp_month, temp_year));
        }
    };
}
