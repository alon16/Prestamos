package com.example.prestamos.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.prestamos.obj.Prestamo;
import com.example.prestamos.obj.Pago;
import com.example.prestamos.pojo.PrestamoConCliente;

import java.util.List;

@Dao
public interface PrestamoDao {
    @Insert
    Long Insertar(Prestamo prestamo);

    @Delete
    void Borrar(Prestamo prestamo);

    @Update
    void Actualizar(Prestamo prestamo);

    @Query("SELECT * FROM prestamo")
    List<Prestamo>ObtenerTodo();

    @Query("SELECT * FROM prestamo WHERE id=:id")
    Prestamo ObtenerPorId(int id);

    @Query("SELECT * FROM prestamo INNER JOIN cliente ON cedula=idCliente")
    List<PrestamoConCliente>ObtenerTodoConCliente();

    @Query("SELECT * FROM prestamo INNER JOIN cliente on cedula=idCliente WHERE idCliente=:id")
    List<PrestamoConCliente>ObtenerPrestamo(String id );
}
