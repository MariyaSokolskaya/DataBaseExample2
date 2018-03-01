package com.example.admin215.databaseexample;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    DBHelper dbHelper;
    EditText purchase, money, category;
    Button toBaseButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        purchase = (EditText) findViewById(R.id.purchase_text);
        money = (EditText) findViewById(R.id.money_text);
        category = (EditText) findViewById(R.id.category_text);
        toBaseButton = (Button) findViewById(R.id.tobase_button);



        toBaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper = new DBHelper(getBaseContext());
                SQLiteDatabase sdb = dbHelper.getWritableDatabase();

                //получаем данные из текстовых полей
                String purchaseStr = purchase.getText().toString();
                String categoryStr = category.getText().toString();
                double moneyStr = Double.parseDouble(money.getText().toString());

                //формирование запроса на добавление записи в базу
                ContentValues values = new ContentValues();
                values.put(DBHelper.COLUMN_PURCHASE, purchaseStr);
                values.put(DBHelper.COLUMN_MONEY, moneyStr);
                values.put(DBHelper.COLUMN_CATEGORY, categoryStr);

                sdb.insert(DBHelper.TABLE_NAME, null, values);

                sdb.close();
                dbHelper.close();
            }
        });
    }
}
