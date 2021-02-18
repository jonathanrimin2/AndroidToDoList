package com.example.todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    //Initialize variable
    DrawerLayout drawerLayout;
    CalendarView calendarView;
    TextView dateText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calendarView = findViewById(R.id.calendarView);
        dateText =findViewById(R.id.dateText);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int i, int i1, int i2) {
                String date = (i1 + 1) + "/" + i2 + "/" + i;
                dateText.setText(date);
            }
        });


        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);

    }

    public void ClickMenu(View view){
        MainActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){
        MainActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        //Redirect activity to home
        MainActivity.redirectActivity(this,MainActivity.class);
    }

    public void ClickDashboard(View view){
        //Recreate activity
        recreate();;
    }

    public void ClickAboutUs(View view){
        //Redirect activity to about us
        MainActivity.redirectActivity(this, AboutUs.class);
    }

    public void ClickLogout(View view){
        //Close app
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(drawerLayout);


    }
}