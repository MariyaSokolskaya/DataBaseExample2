package com.example.admin215.databaseexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Admin215 on 01.03.2018.
 */

public class DBHelper extends SQLiteOpenHelper {
    //имя файла с базой
    public static final String DATABASE_NAME = "budget.db";
    //версия базы
    public static final int DATABASE_VERSION = 1;
    //имя таблица
    public static final String TABLE_NAME = "budget";
    //имена полей (столбцов) таблицы
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PURCHASE = "purchase";
    public static final String COLUMN_MONEY = "money";
    public static final String COLUMN_CATEGORY = "category";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryCreate = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " integer primary key autoincrement, "
                + COLUMN_PURCHASE + " text, "
                + COLUMN_MONEY + " real, "
                + COLUMN_CATEGORY + " text NOT NULL DEFAULT \"Продукты\");";
        sqLiteDatabase.execSQL(queryCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String queryDrop = "DROP TABLE IF EXIST " + TABLE_NAME;
        sqLiteDatabase.execSQL(queryDrop);
        onCreate(sqLiteDatabase);
    }
}
