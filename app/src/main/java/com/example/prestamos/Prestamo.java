package com.example.prestamos;

public class Prestamo {
    private  String cliente;
    private Double montoCredito;
    private String interes;
    private String plazo;
    private String fechaInicio;
    private String fechaFinal;
    private Double MontoPagar;
    private Double MontoCuota;

    public Prestamo(){

    };

    public Prestamo(String Cliente,Double montoCredito, String interes, String plazo, String fechaInicio, String fechaFinal, Double montoPagar, Double montoCuota) {
        this.cliente= Cliente;
        this.montoCredito = montoCredito;
        this.interes = interes;
        this.plazo = plazo;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        MontoPagar = montoPagar;
        MontoCuota = montoCuota;
    }

    public void setCliente(String cedula) {
        this.cliente = cedula;
    }

    public String getCliente() {
        return cliente;
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
