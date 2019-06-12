package com.example.prestamos.pojo;

import android.arch.persistence.room.Embedded;

import com.example.prestamos.obj.Cliente;
import com.example.prestamos.obj.Prestamo;

public class PrestamoConCliente {
    @Embedded
    Cliente cliente;

    @Embedded
    Prestamo prestamo;

    public PrestamoConCliente() {
        cliente= new Cliente();
        prestamo= new Prestamo();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }
}
