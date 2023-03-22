package com.google.colorgame;


import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>
{
    String[] colorsName;
    int[] images;
    Context context;

    // Initialize the dataset of the Adapter.
    public Adapter(Context con, String[] colorsN, int[] colorsImages)
    {
        context = con;
        colorsName = colorsN;
        images = colorsImages;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        // Create a new view, which defines the UI of the list item
        View view = inflater.inflate(R.layout.line, parent, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position)
    {
        // Get element from my dataset at this position and replace the
        // contents of the view with that element
        viewHolder.myColorsName.setText(colorsName[position]);
        viewHolder.myImages.setImageResource(images[position]);

        SharedPreferences preferences = context.getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        Utilities.setFontSize((ViewGroup) viewHolder.itemView, preferences.getFloat("TextSize", 1.1f));
    }

    // Return the size(length) of my dataset (invoked by the layout manager)
    @Override
    public int getItemCount()
    {
        return colorsName.length;
    }

    //Provide a reference to the type of views that i am using.
    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView myColorsName;
        ImageView myImages;

        public ViewHolder(View view)
        {
            super(view);
            myColorsName = itemView.findViewById(R.id.colorsName);
            myImages = itemView.findViewById(R.id.images);
        }
    }

}
