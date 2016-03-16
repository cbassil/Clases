package com.example.camilo.estudiantes;

/**
 * Created by Pablo on 15/03/2016.
 */
public class estudiantes {

    public static final String TABLE_NAME = "estudiantes";
    public static final String FIELD_ID = "_id";
    public static final String FIELD_NAME = "_nombre";
    public static final String FIELD_DESCRIPTION = "_descripcion";
    public static final String CREATE_DB_TABLE = "create table" + TABLE_NAME + "{ "+
            FIELD_ID+ " integer primary key autoincrement,"+
            FIELD_NAME + " text,"+
            FIELD_DESCRIPTION + " text,"
            + " )";

    private int id;
    private String nombre;
    private String descripcion;

    public estudiantes(){

    }

    public estudiantes(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
