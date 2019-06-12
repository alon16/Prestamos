package com.example.prestamos.pojo;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import com.example.prestamos.obj.Cliente;
import com.example.prestamos.obj.Prestamo;

import java.util.ArrayList;
import java.util.List;

public class ClienteConPrestamo {
    @Embedded
    Cliente cliente;

    @Relation(parentColumn = "cedula",entityColumn = "idCliente", entity= Prestamo.class)
    List<Prestamo>prestamoList;

    public ClienteConPrestamo() {
        cliente=new Cliente();
        prestamoList=new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Prestamo> getPrestamoList() {
        return prestamoList;
    }

    public void setPrestamoList(List<Prestamo> prestamoList) {
        this.prestamoList = prestamoList;
    }
}
