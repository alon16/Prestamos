package com.example.prestamos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickContinuar(View view){
        EditText nombre= findViewById(R.id.etNombre);
        EditText telefono= findViewById(R.id.etTelefono);
        EditText cedula= findViewById(R.id.etCedula);
        EditText direccion= findViewById(R.id.etDireccion);


        if(nombre.getText().toString().isEmpty())
            nombre.setError("Campo Obligatorio");
        if(telefono.getText().toString().isEmpty())
            telefono.setError("Campo Obligatorio");
        if (direccion.getText().toString().isEmpty())
            direccion.setError("Campo Obligatorio");
        if(cedula.getText().toString().isEmpty())
            cedula.setError("Campo Obligatorio");
      if(!(nombre.getText().toString().isEmpty()|| telefono.getText().toString().isEmpty()|| direccion.getText().toString().isEmpty()|| cedula.getText().toString().isEmpty() )) {
          Intent intent= new Intent(this, RegistroCredito.class);
           startActivity(intent);
        }
        else
            Toast.makeText(this, "Revise los campos", Toast.LENGTH_SHORT).show();


    }

}
