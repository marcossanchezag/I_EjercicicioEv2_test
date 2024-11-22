package com.example.ejercicio9as;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String SQLCREATE = "CREATE TABLE Jugadores (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, puntuacion INTEGER)";
    private static final String SQLDROP = "DROP TABLE IF EXISTS Jugadores";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Jugadores.db";

    public DatabaseHelper(Context contexto) {
        super(contexto, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLCREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQLDROP);
        onCreate(db);
    }

    public void insertarJugadorEjemplo(String nombre, Integer puntuacion) {
        try (SQLiteDatabase db = this.getWritableDatabase()) {

            //consulta si el jugador existe
            Cursor cursor = db.rawQuery("SELECT * FROM Jugadores WHERE nombre= ?",new String[]{nombre});

            if(cursor.getCount()>0){
                //actualizar puntuación si el jugador está en la BBDD:
                db.execSQL("UPDATE Jugadores SET puntuacion = ? WHERE nombre = ?", new Object[]{puntuacion, nombre});

            }else{
                //insertar el jugador
                ContentValues valores = new ContentValues();
                valores.put("nombre", nombre);
                valores.put("puntuacion", obtener.NotaFinal());
                db.insert("Jugadores", null, valores);
            }

            db.close();
        }
    }

    public int obtenerMejorPuntuacion(String nombre) {
        SQLiteDatabase db = this.getReadableDatabase();
        String Query = "SELECT puntuacion FROM Jugadores where nombre=?";
        Cursor cursor = db.rawQuery(Query,new String[]{nombre});

        if(cursor.moveToFirst()){
            int mejorPuntuacion = cursor.getInt(0);
            cursor.close();
            db.close();
            Log.d("bd",mejorPuntuacion + " "+nombre);
            return mejorPuntuacion;

        }else {
            cursor.close();
            db.close();
            Log.d("bd2" ,nombre);

            return 0;
      }
    }
}
