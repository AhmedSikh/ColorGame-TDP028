package com.google.colorgame;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class Fragment3 extends Fragment
{
    View view;
    ImageButton blackButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_3, container, false);

        blackButton = view.findViewById(R.id.BlackButton);
        blackButton.setOnClickListener((View.OnClickListener)getContext());

        Utilities.setFontSize((ViewGroup) view, requireContext().getSharedPreferences("Preferences", Context.MODE_PRIVATE).getFloat("TextSize", 1f));

        return view;
    }
}