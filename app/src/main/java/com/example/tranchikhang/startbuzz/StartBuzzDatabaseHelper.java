package com.example.tranchikhang.startbuzz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class StartBuzzDatabaseHelper extends SQLiteOpenHelper {

    private static final String DBName = "Startbuzz";
    private static final int DBVersion = 2;

    public StartBuzzDatabaseHelper(Context context) {
        super(context, DBName,null,DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        updateMyDatabase(sqLiteDatabase,0,DBVersion);
    }

    public void updateMyDatabase(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if(oldVersion<1) {
            String query = "CREATE TABLE DRINK(_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DESCRIPTION TEXT, IMAGE_RESOURCE_ID INTEGER );";
            sqLiteDatabase.execSQL(query);
            insertDrink(sqLiteDatabase, "Latte", "Espresso and steamed milk", R.drawable.latte);
            insertDrink(sqLiteDatabase, "Cappuccino", "Espresso, hot milk and steamed-milk foam", R.drawable.capuchino);
            insertDrink(sqLiteDatabase, "Filter", "Our best drip coffee", R.drawable.filter);
        }

        if(oldVersion<2) {
            sqLiteDatabase.execSQL("ALTER TABLE DRINK ADD COLUMN FAVORITE NUMERIC;");
        }
    }

    public void insertDrink(SQLiteDatabase sqLiteDatabase, String Name, String DeScription, int ResourceId) {
        ContentValues drinkContent = new ContentValues();
        drinkContent.put("NAME",Name);
        drinkContent.put("DESCRIPTION",DeScription);
        drinkContent.put("IMAGE_RESOURCE_ID",ResourceId);
        sqLiteDatabase.insert("DRINK",null,drinkContent);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        updateMyDatabase(sqLiteDatabase,oldVersion,newVersion);
    }
}
