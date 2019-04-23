package com.example.prestamos;

public class Prestamo {
    private  String cliente;
    private String montoCredito;
    private String interes;
    private String plazo;
    private String fechaInicio;
    private String fechaFinal;
    private String MontoPagar;
    private String MontoCuota;

    public Prestamo(String Cliente,String montoCredito, String interes, String plazo, String fechaInicio, String fechaFinal, String montoPagar, String montoCuota) {
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

    public void setMontoCredito(String montoCredito) {
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

    public void setMontoPagar(String montoPagar) {
        MontoPagar = montoPagar;
    }

    public void setMontoCuota(String montoCuota) {
        MontoCuota = montoCuota;
    }

    public String getMontoCredito() {
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

    public String getMontoPagar() {
        return MontoPagar;
    }

    public String getMontoCuota() {
        return MontoCuota;
    }
}
