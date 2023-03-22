package com.google.colorgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

/*
*
* PlayNowActivity who contains the container who has all the fragments.
*
 */
public class PlayNowActivity extends AppCompatActivity implements View.OnClickListener
{
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_now);

        preferences = getSharedPreferences("Preferences", MODE_PRIVATE);
        Utilities.setFontSize(findViewById(R.id.container), preferences.getFloat("TextSize", 1f));
    }

    // Function to add the next fragment when the user pressing on the correct imageButton.
    @Override
    public void onClick(View view)
    {
        Fragment fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragment = fragmentManager.findFragmentById(R.id.container);
        //If not last fragment so play the same voice when pressing on correct picture
        if (!(fragment instanceof Fragment12))
        {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.winn);
            mediaPlayer.start();
        }

        addFragment();
    }

    // Function to add the fragments and show them.
    private void addFragment()
    {
        Fragment fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment = fragmentManager.findFragmentById(R.id.container);
        if(fragment instanceof Fragment1) {
            fragment = new Fragment2();
        } else if(fragment instanceof Fragment2) {
            fragment = new Fragment3();
        } else if(fragment instanceof Fragment3) {
            fragment = new Fragment4();
        } else if(fragment instanceof Fragment4) {
            fragment = new Fragment5();
        } else if(fragment instanceof Fragment5) {
            fragment = new Fragment6();
        } else if(fragment instanceof Fragment6) {
            fragment = new Fragment7();
        } else if(fragment instanceof Fragment7) {
            fragment = new Fragment8();
        } else if(fragment instanceof Fragment8) {
            fragment = new Fragment9();
        } else if(fragment instanceof Fragment9) {
            fragment = new Fragment10();
        } else if(fragment instanceof Fragment10) {
            fragment = new Fragment11();
        } else if(fragment instanceof Fragment11) {
            fragment = new Fragment12();
        } else if(fragment instanceof Fragment12) {
            fragment = new FragmentWin();
            //This is the last fragment so play the other voice
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.winn_game);
            mediaPlayer.start();
        }

        assert fragment != null;
        fragmentTransaction.replace(R.id.container,fragment);
        //to back ex: from fragment2 to fragment1, without this the back button will back to MainActivity
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}