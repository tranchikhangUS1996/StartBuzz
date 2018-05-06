package com.example.tranchikhang.startbuzz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class categoryDrinkActivity extends Activity {

    public static final String EXTRADRINKID = new String("EXTRADRINKID");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_drink);
        ArrayAdapter<Drink> arrayAdapter = new ArrayAdapter<Drink>(this,android.R.layout.simple_list_item_1,Drink.Drinks);
        ListView list_drinks = (ListView) findViewById(R.id.list_drinks);
        list_drinks.setAdapter(arrayAdapter);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(categoryDrinkActivity.this,detailEditActivity.class);
                intent.putExtra(categoryDrinkActivity.EXTRADRINKID,(int) id);
                startActivity(intent);
            }
        };
        list_drinks.setOnItemClickListener(itemClickListener);
    }
}
