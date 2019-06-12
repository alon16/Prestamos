package com.example.prestamos;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prestamos.db.DbPrestamos;
import com.example.prestamos.obj.Cliente;
import com.example.prestamos.obj.Datos;
import com.example.prestamos.pojo.ClienteConPrestamo;

public class VistaCliente extends AppCompatActivity {
    private ClienteConPrestamo cliente= new ClienteConPrestamo();
    private DbPrestamos db;
    private String id;
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

        db= DbPrestamos.getAppDataBase(this);
        Bundle extras=getIntent().getExtras();


        if(extras!=null)
        {
            id=extras.getString("position");

            cliente=db.clienteDao().ObtenerPorId(id);

            nombre.setText(cliente.getCliente().getNombre());
            telefono.setText(cliente.getCliente().getTelefono());
            cedula.setText(cliente.getCliente().getCedula());
            direccion.setText(cliente.getCliente().getDireccion());
            apellido.setText(cliente.getCliente().getApellido());
            ocupacion.setText(cliente.getCliente().getOcupacion());
            sexo.setText(cliente.getCliente().getSexo());
            /*
            nombre.setText(Datos.clientes.get(posicion).getNombre());
            telefono.setText(Datos.clientes.get(posicion).getTelefono());
            cedula.setText(Datos.clientes.get(posicion).getCedula());
            direccion.setText(Datos.clientes.get(posicion).getDireccion());
            apellido.setText(Datos.clientes.get(posicion).getApellido());
            ocupacion.setText(Datos.clientes.get(posicion).getOcupacion());
            sexo.setText(Datos.clientes.get(posicion).getSexo());*/
        }

        //Inicializando los TextView
        /*if (!Datos.clientes.isEmpty()){
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
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuagregar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView nombre= findViewById(R.id.tvNombre);
        TextView apellido= findViewById(R.id.tvApellido);

            if(item.getItemId()==R.id.mnNuevoPrestamo){
                Intent intent= new Intent(this, RegistroCredito.class);
                intent.putExtra("nombre",nombre.getText()+" "+apellido.getText());
                intent.putExtra("idCliente",id);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    /*private int contador=0;

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

    }*/
}
