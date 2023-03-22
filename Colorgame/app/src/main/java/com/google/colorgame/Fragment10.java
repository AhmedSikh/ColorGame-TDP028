package com.google.colorgame;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class Fragment10 extends Fragment
{
    View view;
    ImageButton whiteButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_10, container, false);

        whiteButton = view.findViewById(R.id.WhiteButton);
        whiteButton.setOnClickListener((View.OnClickListener)getContext());

        Utilities.setFontSize((ViewGroup) view, requireContext().getSharedPreferences("Preferences", Context.MODE_PRIVATE).getFloat("TextSize", 1f));

        return view;
    }
}