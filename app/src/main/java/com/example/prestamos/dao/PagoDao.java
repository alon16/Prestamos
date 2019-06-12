package com.example.prestamos.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.prestamos.obj.Pago;
import com.example.prestamos.obj.Prestamo;
import com.example.prestamos.pojo.PrestamoConCliente;
import com.example.prestamos.pojo.PrestamoConPagoCliente;

import java.util.List;
@Dao
public interface PagoDao {
    @Insert
    Long Insertar(Pago pago);

    @Query("SELECT * FROM prestamo INNER JOIN cliente on cedula=idCliente")
    List<PrestamoConPagoCliente> ObtenerTodo();

    @Query("SELECT * FROM prestamo INNER JOIN cliente on cedula=idCliente  WHERE  id=:id ")
    PrestamoConPagoCliente ObtenerPorPrestamo(int id);
}
