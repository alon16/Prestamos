package com.example.prestamos.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.prestamos.dao.ClienteDao;
import com.example.prestamos.dao.PagoDao;
import com.example.prestamos.dao.PrestamoDao;
import com.example.prestamos.obj.Cliente;
import com.example.prestamos.obj.Pago;
import com.example.prestamos.obj.Prestamo;

@Database(entities = {Cliente.class, Prestamo.class, Pago.class},version = 1)
public abstract class DbPrestamos extends RoomDatabase {
    private static DbPrestamos INSTANCE;
    public abstract ClienteDao clienteDao();
    public abstract PrestamoDao prestamoDao();
    public abstract PagoDao pagoDao();

    public static DbPrestamos getAppDataBase(Context context){
        if (INSTANCE == null){
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), DbPrestamos.class, "db")
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }
    public static void destroyInstance(){
        INSTANCE=null;
    }
}
