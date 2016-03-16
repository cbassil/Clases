package com.example.camilo.estudiantes;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Pablo on 15/03/2016.
 */
public class Vista extends SQLiteOpenHelper {

    private static final String DB_NAME="estudiantes";
    private static final int SCHEME_VERSION = 1;
    private SQLiteDatabase db;

    public Vista(Context context) {
        super(context, DB_NAME, null, SCHEME_VERSION);
        db = this.getWritableDatabase();
    }

    private ContentValues generarValores(estudiantes estud){
        ContentValues valores = new ContentValues();
        valores.put(estudiantes.FIELD_ID, estud.getId());
        valores.put(estudiantes.FIELD_NAME, estud.getNombre());
        valores.put(estudiantes.FIELD_DESCRIPTION, estud.getDescripcion());
        return valores;
    }

    public void insertarEstud(estudiantes estud){
        db.insert(estudiantes.TABLE_NAME,null,generarValores(estud));
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(estudiantes.CREATE_DB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
