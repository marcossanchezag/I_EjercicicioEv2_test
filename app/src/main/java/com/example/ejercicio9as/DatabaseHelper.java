package com.example.ejercicio9as;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;



public class DatabaseHelper extends SQLiteOpenHelper {

    private Context contexto;
    private final String SQLCREATE = "CREATE TABLE Jugadores (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, puntuacion INTEGER)";
    private final String SQLDROP = "DROP TABLE IF EXISTS Jugadores";  //

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Jugadores.db";

    //Constructor de la bbdd
    public DatabaseHelper(Context contexto) {
        super(contexto, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Metodo obligatorio onCreate (al crear la bbdd, creamos la tabla)
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLCREATE);

    }

    //Metodo obligatorio onUpgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQLDROP);
        onCreate(db);
    }


    ////////////////////// Metodos opcionales, segun necesidad ////////////////////////

    //Metodo para insertar un profesor de ejemplo
    public void insertarJugadorEjemplo(String nombre, int puntuacion) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nombre", nombre);
        valores.put("puntuacion", puntuacion);
        db.insert("Jugadores", null, valores);

        db.close();
    }


    //Método para comprobar si un profesor esta en la tabla
    public int ObtenerMejorPuntuacion(String nombre) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT puntuacion FROM Jugadores WHERE nombre = ?";
        Cursor cursor = db.rawQuery(query, new String[]{nombre});

        int mejorpuntuacion = 0; // Valor por defecto
        if (cursor.moveToFirst()) {
            mejorpuntuacion = cursor.getInt(0);
        }

        cursor.close();
        db.close();
        return mejorpuntuacion;
    }




}
