package com.royan.fruitlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit>
{
    public FruitAdapter(Context context, List<Fruit> fruit)
    {
        super(context, 0, fruit);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        try
        {
            // Get the data item for this position
            Fruit fruit = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null)
            {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_listview, parent, false);
            }
            // Lookup view for data population
            TextView txtName = convertView.findViewById(R.id.listview_name);
            TextView txtCalories = convertView.findViewById(R.id.listview_calories);
            ImageView imageView = convertView.findViewById(R.id.listview_image);

            // Populate the data into the template view using the data object
            imageView.setImageResource(fruit.getImageId());
            txtName.setText(fruit.getName());
            txtCalories.setText(fruit.getCalories() + " calories");
            // Return the completed view to render on screen

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return convertView;
    }
}

