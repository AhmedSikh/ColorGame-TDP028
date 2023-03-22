package com.google.colorgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.Objects;

/*
*
* MainActivity who shows the recyclerView that's holds to Arrays, one for colors text and the other
* for all images who will shows on the view.
*
 */
public class MainActivity extends AppCompatActivity
{
    RecyclerView recyclerView;

    String[] colors;
    int[] images = {R.drawable.red, R.drawable.blue, R.drawable.black, R.drawable.grey,
            R.drawable.green, R.drawable.brown, R.drawable.orange, R.drawable.purple, R.drawable.rainbow,
            R.drawable.white, R.drawable.pink, R.drawable.yellow};

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("Preferences", MODE_PRIVATE);

        recyclerView = findViewById(R.id.recyclerView);

        colors = getResources().getStringArray(R.array.colorsName);

        Adapter Adapter = new Adapter(this, colors, images);

        recyclerView.setAdapter(Adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.play).setOnClickListener(view -> startPlayNowActivity());
    }

    // To make the changes of "TextSize" on the MainActivity directly.
    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onResume()
    {
        super.onResume();
        Objects.requireNonNull(recyclerView.getAdapter()).notifyDataSetChanged();
        Utilities.setFontSize(findViewById(R.id.pur), preferences.getFloat("TextSize", 1f));
    }

    // Check the preferences if the "SwitchState" is true, the Dark mode must be on,
    // else Dark mode is on off.
    @Override
    protected void onStart()
    {
        super.onStart();
        if (preferences.getBoolean("SwitchState", true))
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    // When "PLAY NOW" button is pressed, start PlayNowActivity.
    private void startPlayNowActivity()
    {
        Intent intent = new Intent(this, PlayNowActivity.class);
        startActivity(intent);
    }

    // To create options menu bar.
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == R.id.setting)
        {
            startSettingActivity();
        }
        return super.onOptionsItemSelected(item);
    }

    // When "Settings" button is pressed on the menu, start Setting activity.
    private void startSettingActivity()
    {
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }
}