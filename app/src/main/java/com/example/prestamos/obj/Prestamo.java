package com.example.prestamos.obj;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.RESTRICT;
import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity
public class Prestamo {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private Double montoCredito;
    private String interes;
    private String plazo;
    private String fechaInicio;
    private String fechaFinal;
    private Double MontoPagar;
    private Double MontoCuota;
    @ForeignKey(entity = Cliente.class,childColumns = "cedula",
            parentColumns = "id",
            onDelete = CASCADE,
            onUpdate = RESTRICT
    )
    private String idCliente;

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public Prestamo(){

    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Prestamo(Double montoCredito, String interes, String plazo, String fechaInicio, String fechaFinal, Double montoPagar, Double montoCuota) {

        this.montoCredito = montoCredito;
        this.interes = interes;
        this.plazo = plazo;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        MontoPagar = montoPagar;
        MontoCuota = montoCuota;
    }


    public void setMontoCredito(Double montoCredito) {
        this.montoCredito = montoCredito;
    }

    public void setInteres(String interes) {
        this.interes = interes;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public void setMontoPagar(Double montoPagar) {
        MontoPagar = montoPagar;
    }

    public void setMontoCuota(Double montoCuota) {
        MontoCuota = montoCuota;
    }

    public Double getMontoCredito() {
        return montoCredito;
    }

    public String getInteres() {
        return interes;
    }

    public String getPlazo() {
        return plazo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public Double getMontoPagar() {
        return MontoPagar;
    }

    public Double getMontoCuota() {
        return MontoCuota;
    }
}
