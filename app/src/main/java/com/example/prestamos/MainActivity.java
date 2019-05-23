package com.example.prestamos;


import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {
    private int posicion;
    private Boolean edit=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar bar=getSupportActionBar();
        bar.setSubtitle("Ingresar Cliente");

        EditText nombre= findViewById(R.id.etNombre);
        EditText telefono= findViewById(R.id.etTelefono);
        EditText cedula= findViewById(R.id.etCedula);
        EditText direccion= findViewById(R.id.etDireccion);
        EditText apellido= findViewById(R.id.etApellido);
        EditText ocupacion= findViewById(R.id.etOcupacion);
        Spinner sexo= findViewById(R.id.cbSexo);

        Bundle extras=getIntent().getExtras();


        if(extras!=null){
            edit=true;
          posicion=extras.getInt("position");
          nombre.setText(Datos.clientes.get(posicion).getNombre());
          apellido.setText(Datos.clientes.get(posicion).getApellido());
          telefono.setText(Datos.clientes.get(posicion).getTelefono());
          cedula.setText(Datos.clientes.get(posicion).getCedula());
          direccion.setText(Datos.clientes.get(posicion).getDireccion());
          ocupacion.setText(Datos.clientes.get(posicion).getOcupacion());

          if(Datos.clientes.get(posicion).getSexo().equals("Femenino"))
              sexo.setSelection(1);
          else
              sexo.setSelection(0);


        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuagregarprestamo,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent();
        if(item.getItemId()==R.id.mnGuardar){
            Bundle extras=getIntent().getExtras();
            EditText nombre = findViewById(R.id.etNombre);
            EditText telefono = findViewById(R.id.etTelefono);
            EditText cedula = findViewById(R.id.etCedula);
            EditText direccion = findViewById(R.id.etDireccion);
            EditText apellido = findViewById(R.id.etApellido);
            EditText ocupacion = findViewById(R.id.etOcupacion);
            Spinner sexo = findViewById(R.id.cbSexo);

            if(!edit) {
                Cliente nuevoCliente = new Cliente();

                if (nombre.getText().toString().isEmpty())
                    nombre.setError("Campo Obligatorio");
                if (telefono.getText().toString().isEmpty())
                    telefono.setError("Campo Obligatorio");
                if (direccion.getText().toString().isEmpty())
                    direccion.setError("Campo Obligatorio");
                if (cedula.getText().toString().isEmpty())
                    cedula.setError("Campo Obligatorio");
                if (!(nombre.getText().toString().isEmpty() || telefono.getText().toString().isEmpty() || direccion.getText().toString().isEmpty() || cedula.getText().toString().isEmpty())) {
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
                    Toast.makeText(this, "Cliente ha sido GUARDADO", Toast.LENGTH_SHORT).show();
                    intent.putExtra("nombre", nuevoCliente.getNombre());


                } else
                    Toast.makeText(this, "Revise los campos", Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK, intent);
            }
            else{
                Datos.clientes.get(posicion).setNombre(nombre.getText().toString());
                Datos.clientes.get(posicion).setApellido(apellido.getText().toString());
                Datos.clientes.get(posicion).setTelefono(telefono.getText().toString());
                Datos.clientes.get(posicion).setCedula(cedula.getText().toString());
                Datos.clientes.get(posicion).setSexo(sexo.getSelectedItem().toString());
                Datos.clientes.get(posicion).setDireccion(direccion.getText().toString());
                Datos.clientes.get(posicion).setOcupacion(ocupacion.getText().toString());
            }
            setResult(RESULT_OK, intent);
            finish();
        }
        else{
            setResult(RESULT_CANCELED,intent);
            finish();}
        return super.onOptionsItemSelected(item);
    }


}
