package com.google.colorgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.Calendar;

/*
 *
 * SettingActivity who contains my tow application settings, the first one is the dark mode option
 * and the second one is the font size option.
 *
 */
public class SettingActivity extends AppCompatActivity
{
    SwitchMaterial switchMaterial;
    private boolean SwitchOnOff;

    TextView textFont;
    Button small;
    Button large;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        preferences = getSharedPreferences("Preferences", MODE_PRIVATE);
        Utilities.darkMode(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        switchMaterial = findViewById(R.id.themeSwitch);
        switchMaterial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked)
            {
                if (isChecked)
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                else
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                saveTheme();
            }
        });

        textFont = (TextView) findViewById(R.id.textFont);
        small = (Button) findViewById(R.id.small);
        small.setOnClickListener(v -> changeToSmall());
        large = (Button) findViewById(R.id.large);
        large.setOnClickListener(v -> changeToLarge());

        Utilities.setFontSize(findViewById(R.id.setting), preferences.getFloat("TextSize", 1f));


        //Notification part to get notification every 15 min.
        createNotificationChannel();
        Intent intent= new Intent(SettingActivity.this, ReceiveNotification.class);
        @SuppressLint("UnspecifiedImmutableFlag")
        PendingIntent pendingIntent = PendingIntent.getBroadcast(SettingActivity.this, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Calendar calendar = Calendar.getInstance();
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_FIFTEEN_MINUTES, pendingIntent);
    }

    // To save the current application theme when the application closes.
    @Override
    public void onStop()
    {
        super.onStop();
        saveTheme();
    }

    // To load the saved application theme when the application opens and update the view of the switchMaterial.
    @Override
    public void onStart()
    {
        super.onStart();
        loadTheme();
        updateViews();
    }

    // Save the current theme to the preferences file.
    public void saveTheme()
    {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("SwitchState", switchMaterial.isChecked());
        editor.apply();
    }

    // Load the theme who was saved before on the preferences file.
    public void loadTheme()
    {
        SwitchOnOff = preferences.getBoolean("SwitchState", true);
    }

    // Update the view of the switchMaterial, it will still on the on mode if we go back and go inside settings again.
    public void updateViews()
    {
        switchMaterial.setChecked(SwitchOnOff);
    }

    // Function to create notifications channel to be used when user receive a notify.
    private void createNotificationChannel()
    {
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel("notify", "Chanel", importance);
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }

    // Function to change the font size to large
    private void changeToLarge()
    {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putFloat("TextSize", 1.3f);
        editor.apply();
        Utilities.setFontSize(findViewById(R.id.setting), preferences.getFloat("TextSize", 1f));
    }

    // Function to change the font size to small
    private void changeToSmall()
    {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putFloat("TextSize", 1f);
        editor.apply();
        Utilities.setFontSize(findViewById(R.id.setting), preferences.getFloat("TextSize", 1f));
    }

}