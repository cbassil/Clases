package com.example.camilo.estudiantes;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class splash_screen extends AppCompatActivity {

    private boolean estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        cargarPreferencias();
        if(estado){
            Intent intent = new Intent(splash_screen.this,MainActivity.class);
            startActivity(intent);
            finish();
        }else{
            procesoCarga proceso = new procesoCarga();
        }
    }

    private void cargarPreferencias(){
        SharedPreferences mispreferencias = getPreferences("preferencias", Context.MODE_PRIVATE);
        mispreferencias.getBoolean("isLoad", false);
    }

    private SharedPreferences getPreferences(String preferencias, int modePrivate) {
        return null;
    }

    private void guardarPreferencias(boolean valor){
        SharedPreferences mispreferencias = getPreferences("preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mispreferencias.edit();
        editor.putBoolean("isLoad",valor);
        editor.commit();
    }

    private class procesoCarga extends AsyncTask<Void,Void,Void>{

        ProgressDialog dialog;
        ArrayList<estudiantes> estudiantes = new ArrayList<estudiantes>(Arrays.asList(
                new estudiantes("Camilo","ingenieria de sistemas"),
                new estudiantes("Sergio","ingenieria de sistemas"),
                new estudiantes("Humberto","ingenieria de sistemas")
        ));
        @Override
        protected void onPostExecute(Void aVoid) {
            guardarPreferencias(true);
            if(dialog.isShowing()){
                dialog.dismiss();
                Intent intent = new Intent(splash_screen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }

        @Override
        protected void onPreExecute(){
            dialog = new ProgressDialog(splash_screen.this);
            dialog.setTitle("Esto es el Titulo");
            dialog.setMessage("Insertando en BD");
            dialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            Vista helper = new Vista(splash_screen.this);
            for(int i = 0 ; i<estudiantes.size();i++){
                estudiantes estud = new estudiantes();
                helper.insertarEstud(estud);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
