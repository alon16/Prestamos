package com.example.prestamos;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  void onClickCancelar(View view){
        Intent intent = new Intent();
        setResult(RESULT_CANCELED,intent);
        finish();

    }
    public void onClickContinuar(View view){
        Cliente nuevoCliente=new Cliente();

        EditText nombre= findViewById(R.id.etNombre);
        EditText telefono= findViewById(R.id.etTelefono);
        EditText cedula= findViewById(R.id.etCedula);
        EditText direccion= findViewById(R.id.etDireccion);
        EditText apellido= findViewById(R.id.etApellido);
        EditText ocupacion= findViewById(R.id.etOcupacion);
        Spinner sexo=findViewById(R.id.cbSexo);



        if(nombre.getText().toString().isEmpty())
            nombre.setError("Campo Obligatorio");
        if(telefono.getText().toString().isEmpty())
            telefono.setError("Campo Obligatorio");
        if (direccion.getText().toString().isEmpty())
            direccion.setError("Campo Obligatorio");
        if(cedula.getText().toString().isEmpty())
            cedula.setError("Campo Obligatorio");
      if(!(nombre.getText().toString().isEmpty()|| telefono.getText().toString().isEmpty()|| direccion.getText().toString().isEmpty()|| cedula.getText().toString().isEmpty() )) {
          /*Intent intent= new Intent(this, RegistroCredito.class);
           startActivity(intent);*/
          //Tomando los datos que el usuario ingreso
          nuevoCliente.setNombre(nombre.getText().toString());
          nuevoCliente.setApellido(apellido.getText().toString());
          nuevoCliente.setSexo(sexo.getSelectedItem().toString());
          nuevoCliente.setTelefono(telefono.getText().toString());
          nuevoCliente.setCedula(cedula.getText().toString());
          nuevoCliente.setOcupacion(ocupacion.getText().toString());
          nuevoCliente.setDireccion(direccion.getText().toString());
          Datos.clientes.add(nuevoCliente);
          Intent intent = new Intent();
          intent.putExtra("nombre",nuevoCliente.getNombre());

          setResult(RESULT_OK,intent);
          finish();
        }
        else
            Toast.makeText(this, "Revise los campos", Toast.LENGTH_SHORT).show();



    }

}
