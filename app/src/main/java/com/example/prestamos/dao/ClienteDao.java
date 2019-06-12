package com.example.prestamos.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.prestamos.obj.Cliente;
import com.example.prestamos.pojo.ClienteConPrestamo;

import java.util.List;

@Dao
public interface ClienteDao {
    @Insert
    Long Insertar(Cliente cliente);
    @Delete
    void Borrar(Cliente cliente);
    @Update
    void Actualizar(Cliente cliente);

    @Query("SELECT * FROM cliente")
    List<ClienteConPrestamo>ObtenerTodo();

    @Query("SELECT * FROM cliente WHERE cedula=:id")
    ClienteConPrestamo ObtenerPorId(String id);

}
