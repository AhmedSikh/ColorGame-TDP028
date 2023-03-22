package com.google.colorgame;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDelegate;

/*
*
* Utilities class contains tow important functions, setFontSize and darkMode.
*
 */

public class Utilities
{
    // setFontSize is a function to change the font size to everything on my application.
    public static void setFontSize(ViewGroup root, float sizeMultiplier)
    {
        final int childCount = root.getChildCount();
        for (int i = 0; i < childCount; i++)
        {
            final View view = root.getChildAt(i);
            if (view instanceof ViewGroup)
            {
                setFontSize((ViewGroup) view, sizeMultiplier);
            }

            if (view instanceof TextView)
            {
                final TextView textView = (TextView) view;
                textView.setTextSize(15*sizeMultiplier);
            }
        }
    }

    // darkMode is a function to change between the dark theme and the original them (light).
    public static void darkMode(Context context)
    {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
        {
            context.setTheme(R.style.Theme_Dark);
        }
        else
        {
            context.setTheme(R.style.Theme_ColorGame);
        }
    }
}
