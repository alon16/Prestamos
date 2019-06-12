package com.example.prestamos.obj;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity
public class Cliente {
    @PrimaryKey() @NonNull
    private String cedula;
    private String nombre;
    private String apellido;
    private String sexo;
    private String telefono;

    private String ocupacion;
    private String direccion;

    public Cliente(String nombre, String apellido, String sexo, String telefono, String cedula, String ocupacion, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.telefono = telefono;
        this.cedula = cedula;
        this.ocupacion = ocupacion;
        this.direccion = direccion;
    }
    public Cliente(){

    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public String getDireccion() {
        return direccion;
    }
}

