package com.example.SqlLite.OperacionesCrud.Esquemas;

import android.provider.BaseColumns;

public class AsignaturaEsquema implements BaseColumns {
    public static abstract class Esquema implements BaseColumns {
        public static final String TABLE_NAME = "asignatura";

        public static final String ID = "ID_ASIGNATURA";
        public static final String NOMBRE = "NOMBRE";
        public static final String RATING = "RATING_ASIGNATURA";

        public static String[] ALLCOLUMNAS = {NOMBRE, RATING, ID};

        public static final String CREAR_TABLA_ASIGNATURA =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        NOMBRE + " TEXT," +
                        RATING + " INTEGER)";

        public static final String BORRA_TABLA_ASIGNATURA =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}

