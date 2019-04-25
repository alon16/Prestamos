package com.example.prestamos;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class VistaCliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_cliente);
        ActionBar bar=getSupportActionBar();
        bar.setSubtitle("Ver Prestamo");
        TextView nombre= findViewById(R.id.tvNombre);
        TextView telefono= findViewById(R.id.tvTelefono);
        TextView cedula= findViewById(R.id.tvCedula);
        TextView direccion= findViewById(R.id.tvDireccion);
        TextView apellido= findViewById(R.id.tvApellido);
        TextView ocupacion= findViewById(R.id.tvOcupacion);
        TextView sexo= findViewById(R.id.tvSexo);

        //Inicializando los TextView
        if (!Datos.clientes.isEmpty()){
        nombre.setText(Datos.clientes.get(0).getNombre());
        telefono.setText(Datos.clientes.get(0).getTelefono());
        cedula.setText(Datos.clientes.get(0).getCedula());
        direccion.setText(Datos.clientes.get(0).getDireccion());
        apellido.setText(Datos.clientes.get(0).getApellido());
        ocupacion.setText(Datos.clientes.get(0).getOcupacion());
        sexo.setText(Datos.clientes.get(0).getSexo());

        }
        else{
            nombre.setText("");
            telefono.setText("");
            cedula.setText("");
            direccion.setText("");
            apellido.setText("");
            ocupacion.setText("");
            sexo.setText("");
        }
    }
    private int contador=0;
    public void Onclick(View view){

        TextView nombre= findViewById(R.id.tvNombre);
        TextView apellido= findViewById(R.id.tvApellido);
        TextView telefono= findViewById(R.id.tvTelefono);
        TextView cedula= findViewById(R.id.tvCedula);
        TextView direccion= findViewById(R.id.tvDireccion);
        TextView ocupacion= findViewById(R.id.tvOcupacion);
        TextView sexo= findViewById(R.id.tvSexo);

        if(view.getId()== R.id.btNuevo){
            Intent intent= new Intent(this, RegistroCredito.class);
            intent.putExtra("nombre",nombre.getText()+" "+apellido.getText());
            startActivity(intent);
        }
        else if(view.getId()==R.id.btSiguiente){
            if (contador <(Datos.clientes.size()-1)){
                contador++;
                nombre.setText(Datos.clientes.get(contador).getNombre());
                telefono.setText(Datos.clientes.get(contador).getTelefono());
                cedula.setText(Datos.clientes.get(contador).getCedula());
                direccion.setText(Datos.clientes.get(contador).getDireccion());
                apellido.setText(Datos.clientes.get(contador).getApellido());
                ocupacion.setText(Datos.clientes.get(contador).getOcupacion());
                sexo.setText(Datos.clientes.get(contador).getSexo());

            }
            else
                Toast.makeText(this, "Llego al ultimo", Toast.LENGTH_SHORT).show();
        }
        else{
            if (contador > 0){
                contador--;
                nombre.setText(Datos.clientes.get(contador).getNombre());
                telefono.setText(Datos.clientes.get(contador).getTelefono());
                cedula.setText(Datos.clientes.get(contador).getCedula());
                direccion.setText(Datos.clientes.get(contador).getDireccion());
                apellido.setText(Datos.clientes.get(contador).getApellido());
                ocupacion.setText(Datos.clientes.get(contador).getOcupacion());
                sexo.setText(Datos.clientes.get(contador).getSexo());


            }
            else
                Toast.makeText(this, "Llego al primero", Toast.LENGTH_SHORT).show();

        }

    }
}
