package com.example.prestamos.pojo;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import com.example.prestamos.obj.Pago;
import com.example.prestamos.obj.Prestamo;

import java.util.ArrayList;
import java.util.List;

public class PrestamoConPagoCliente {
    @Embedded
    PrestamoConCliente prestamoConCliente;

    @Relation(parentColumn = "id",entityColumn = "idPrestamo", entity= Pago.class)
    List<Pago>pagoList;

    public PrestamoConPagoCliente() {
        this.prestamoConCliente = new PrestamoConCliente();
        this.pagoList = new ArrayList<>();
    }

    public PrestamoConCliente getPrestamoConCliente() {
        return prestamoConCliente;
    }

    public void setPrestamoConCliente(PrestamoConCliente prestamoConCliente) {
        this.prestamoConCliente = prestamoConCliente;
    }

    public List<Pago> getPagoList() {
        return pagoList;
    }

    public void setPagoList(List<Pago> pagoList) {
        this.pagoList = pagoList;
    }
}
