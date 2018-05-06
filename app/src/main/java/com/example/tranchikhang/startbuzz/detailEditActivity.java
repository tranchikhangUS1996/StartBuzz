package com.example.tranchikhang.startbuzz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class detailEditActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_edit);
        int id = getIntent().getIntExtra(categoryDrinkActivity.EXTRADRINKID,0);
        Drink drink = Drink.Drinks[id];
        TextView name = (TextView)findViewById(R.id.drinkname);
        name.setText(drink.getName());
        TextView description = (TextView) findViewById(R.id.drinkdesciption);
        description.setText(drink.getDecription());
        ImageView img = (ImageView) findViewById(R.id.drinkimage);
        img.setImageResource(drink.getImageResourceID());
        img.setContentDescription(drink.getName());
    }
}
