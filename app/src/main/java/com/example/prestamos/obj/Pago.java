package com.example.prestamos.obj;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;
import static android.arch.persistence.room.ForeignKey.RESTRICT;
@Entity
public class Pago {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ForeignKey(entity = Prestamo.class,childColumns = "id",
            parentColumns = "id",
            onDelete = CASCADE,
            onUpdate = RESTRICT)
    private int idPrestamo;
    private double pagado;

    public Pago() {
    }

    public Pago( int idPrestamo, double pagado) {

        this.idPrestamo = idPrestamo;
        this.pagado = pagado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public double getPagado() {
        return pagado;
    }

    public void setPagado(double pagado) {
        this.pagado = pagado;
    }
}
