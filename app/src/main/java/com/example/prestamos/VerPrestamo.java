package com.example.prestamos;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class VerPrestamo extends AppCompatActivity {

    private int contador=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_prestamo);
        ActionBar bar=getSupportActionBar();
        bar.setSubtitle("Ver Prestamo");
        TextView cliente= findViewById(R.id.tvCliente);
        TextView monto= findViewById(R.id.tvMontoCredito);
        TextView interes=findViewById(R.id.tvInteres);
        TextView plazo=findViewById(R.id.tvPlazo);
        TextView fechaInicio=findViewById(R.id.tvFechaInicio);
        TextView fechaFinal= findViewById(R.id.tvFechaFinal);
        TextView montoPagar=findViewById(R.id.tvMontoPagar);
        TextView montoCuota=findViewById(R.id.tvMontoCuota);
        if (!Datos.prestamos.isEmpty()){
            cliente.setText(Datos.prestamos.get(0).getCliente());
            monto.setText(Datos.prestamos.get(0).getMontoCredito().toString());
            interes.setText(Datos.prestamos.get(0).getInteres().toString());
            plazo.setText(Datos.prestamos.get(0).getPlazo());
            fechaInicio.setText(Datos.prestamos.get(0).getFechaInicio());
            fechaFinal.setText(Datos.prestamos.get(0).getFechaFinal());
            montoPagar.setText(Datos.prestamos.get(0).getMontoPagar().toString());
            montoCuota.setText(Datos.prestamos.get(0).getMontoCuota().toString());
        }
        else {
            cliente.setText("");
            monto.setText("");
            interes.setText("");
            plazo.setText("");
            fechaInicio.setText("");
            fechaFinal.setText("");
            montoPagar.setText("");
            montoCuota.setText("");

        }
    }
    /*public void onClick(View view){
        TextView cliente= findViewById(R.id.tvCliente);
        TextView monto= findViewById(R.id.tvMontoCredito);
        TextView interes=findViewById(R.id.tvInteres);
        TextView plazo=findViewById(R.id.tvPlazo);
        TextView fechaInicio=findViewById(R.id.tvFechaInicio);
        TextView fechaFinal= findViewById(R.id.tvFechaFinal);
        TextView montoPagar=findViewById(R.id.tvMontoPagar);
        TextView montoCuota=findViewById(R.id.tvMontoCuota);
        if(view.getId()==R.id.btSiguiente){
            if (contador <(Datos.clientes.size()-1)){
                contador++;
                cliente.setText(Datos.prestamos.get(contador).getCliente());
                monto.setText(Datos.prestamos.get(contador).getMontoCredito().toString());
                interes.setText(Datos.prestamos.get(contador).getInteres().toString());
                plazo.setText(Datos.prestamos.get(contador).getPlazo());
                fechaInicio.setText(Datos.prestamos.get(contador).getFechaInicio());
                fechaFinal.setText(Datos.prestamos.get(contador).getFechaFinal());
                montoPagar.setText(Datos.prestamos.get(contador).getMontoPagar().toString());
                montoCuota.setText(Datos.prestamos.get(contador).getMontoCuota().toString());

            }
            else
                Toast.makeText(this, "Llego al ultimo", Toast.LENGTH_SHORT).show();
        }
        else{
            if (contador > 0){
                contador--;
                cliente.setText(Datos.prestamos.get(contador).getCliente());
                monto.setText(Datos.prestamos.get(contador).getMontoCredito().toString());
                interes.setText(Datos.prestamos.get(contador).getInteres().toString());
                plazo.setText(Datos.prestamos.get(contador).getPlazo());
                fechaInicio.setText(Datos.prestamos.get(contador).getFechaInicio());
                fechaFinal.setText(Datos.prestamos.get(contador).getFechaFinal());
                montoPagar.setText(Datos.prestamos.get(contador).getMontoPagar().toString());
                montoCuota.setText(Datos.prestamos.get(contador).getMontoCuota().toString());


            }
            else
                Toast.makeText(this, "Llego al primero", Toast.LENGTH_SHORT).show();

        }

    }*/

}
