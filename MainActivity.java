package com.royan.fruitlist;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import cn.pedant.SweetAlert.SweetAlertDialog;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity
{
    //SimpleAdapter simpleAdapter = null;
    FruitAdapter fruitAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        try
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            final String[] listViewName = {
                    "Orange",
                    "Cherry",
                    "Banana",
                    "Apple",
                    "Kiwi",
                    "Pear",
                    "Strawberry",
                    "Lemon",
                    "Peach",
                    "Apricot",
                    "Mango"
            };

            final int[] listOfCalories = {

                    47,
                    50,
                    89,
                    52,
                    61,
                    57,
                    33,
                    29,
                    39,
                    48,
                    60
            };

            final int[] listViewImage = {

                    R.drawable.orange,
                    R.drawable.cherry,
                    R.drawable.banana,
                    R.drawable.apple,
                    R.drawable.kiwi,
                    R.drawable.pear,
                    R.drawable.strawberry,
                    R.drawable.lemon,
                    R.drawable.peach,
                    R.drawable.apricot,
                    R.drawable.mango

            };

            final List<Fruit> lstFruit = new ArrayList<Fruit>();
            String keyForName = "KEY_FOR_NAME";
            String keyForCalories = "KEY_FOR_CALORIES";
            String keyForImage = "KEY_FOR_IMAGE";

            for (int i = 0; i < listViewName.length; i++)
            {
                Fruit fruit = new Fruit(i + 1, listViewName[i], listViewImage[i], listOfCalories[i]);
                lstFruit.add(fruit);
            }

            ListView lv = findViewById(R.id.myListView);
            fruitAdapter = new FruitAdapter(this, lstFruit);

            lv.setAdapter(fruitAdapter);
            lv.setClickable(true);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l)
                {
                    Fruit fruit = fruitAdapter.getItem(pos);
                    Intent myIntent = new Intent(MainActivity.this, ShowFruit.class);
                    myIntent.putExtra("name", fruit.getName());
                    myIntent.putExtra("imageName", String.valueOf(fruit.getImageId()));
                    myIntent.putExtra("calories", String.valueOf(fruit.getCalories()));
                    startActivity(myIntent);
                }
            });

            lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
            {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int pos, long l)
                {
                    new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE)
                            .setTitleText("Are you sure?")
                            .setContentText("You won't be able to recover this row!")
                            .setConfirmText("Delete!")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    sDialog.dismissWithAnimation();
                                    lstFruit.remove(pos);
                                    fruitAdapter.notifyDataSetChanged();
                                }
                            })
                            .setCancelButton("Cancel", new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    sDialog.dismissWithAnimation();
                                }
                            })
                            .show();

                    return true;
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
