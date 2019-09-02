package com.royan.fruitlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowFruit extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_fruit);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        int imageID = Integer.parseInt(intent.getStringExtra("imageName"));
        int calories = Integer.parseInt(intent.getStringExtra("calories"));

        ImageView image = findViewById(R.id.listview_image);
        TextView txtName = findViewById(R.id.listview_name);
        TextView txtCalories = findViewById(R.id.listview_calories);

        txtName.setText(name);
        txtCalories.setText(calories + " calories");
        image.setImageResource(imageID);

    }
}
