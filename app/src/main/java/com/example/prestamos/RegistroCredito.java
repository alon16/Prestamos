package com.example.prestamos;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.prestamos.db.DbPrestamos;
import com.example.prestamos.obj.Cliente;
import com.example.prestamos.obj.Datos;
import com.example.prestamos.obj.Prestamo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RegistroCredito extends AppCompatActivity {
    private Double montito=0.0;
    private int tiempo=1;
    private Double inte=0.15;
    private String idCliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_credito);
        ActionBar bar=getSupportActionBar();
        bar.setSubtitle("Ingresar Credito");
        EditText monto= findViewById(R.id.etMonto);
        EditText plazos= findViewById(R.id.etPlazo);
        Spinner interes= findViewById(R.id.cbInteres);
        EditText fechaInicio= findViewById(R.id.etFecha);
        EditText fechaFinal= findViewById(R.id.etFechaEnd);
        Spinner nombres= findViewById(R.id.cbNombre);
        //Creando Adaptador Para Spinner
        List<String>spnombre= new ArrayList<String>();
        Bundle extras=getIntent().getExtras();
        String valor = null;

        if(extras!=null)
        {
            idCliente=extras.getString("idCliente");
            valor= extras.getString("nombre");
            spnombre.add(valor);
        }
        else {
            for (Cliente c: Datos.clientes) {
                spnombre.add(c.getNombre()+" "+c.getApellido());
            }
        }

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,spnombre);
        //Asignando Adaptador
        nombres.setAdapter(adapter);
        //Iniciando fechas.
        SimpleDateFormat fechis= new SimpleDateFormat("dd/MM/yyyy");
        Calendar c= Calendar.getInstance();
        c.setTime(new Date());
        fechaInicio.setText(fechis.format(c.getTime()));
        c.add(Calendar.MONTH,1);//Agregar el siguiente mes
        fechaFinal.setText(fechis.format(c.getTime()));
        //Estableciendo el envento OnChange
        monto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().length()>0){
                    montito= Double.parseDouble(s.toString());
                    calculando(montito,inte,tiempo);
                }
                else {

                    TextView mostrarMonto= findViewById(R.id.tvTotalPagar);
                    TextView mostrarCuota=findViewById(R.id.tvCuota);
                    mostrarCuota.setText("0.0");
                    mostrarMonto.setText("0.0");


                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //Estableciendo el evento ItemSelected
        interes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                    inte=0.15;
                else if(position==1)
                    inte=0.20;
                else
                    inte=0.25;

                calculando(montito,inte,tiempo);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Estableciendo evento OnChange a Plazo
        plazos.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().length()>0){
                    tiempo=Integer.parseInt(s.toString());
                    calculando(montito,inte,tiempo);
                }
                else{
                    EditText fechaFinal= findViewById(R.id.etFechaEnd);
                    SimpleDateFormat fechis= new SimpleDateFormat("dd/MM/yyyy");
                    Calendar c= Calendar.getInstance();
                    c.setTime(new Date());
                    c.add(Calendar.MONTH,1);//Agregar el siguiente mes
                    fechaFinal.setText(fechis.format(c.getTime()));
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuagregarprestamo,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent();
        if(item.getItemId()==R.id.mnGuardar){
            Prestamo NuevoPrestamo= new Prestamo();
            Spinner nombres= findViewById(R.id.cbNombre);
            EditText monto= findViewById(R.id.etMonto);
            Spinner interes= findViewById(R.id.cbInteres);
            TextView plazo=findViewById(R.id.etPlazo);
            EditText fechaInicio=findViewById(R.id.etFecha);
            EditText fechaFinal= findViewById(R.id.etFechaEnd);
            TextView montoPagar=findViewById(R.id.tvTotalPagar);
            TextView montoCuota=findViewById(R.id.tvCuota);
            NuevoPrestamo.setIdCliente(idCliente);
            NuevoPrestamo.setMontoCredito(Double.parseDouble(monto.getText().toString()));
            NuevoPrestamo.setInteres(interes.getSelectedItem().toString());
            NuevoPrestamo.setPlazo(plazo.getText().toString());
            NuevoPrestamo.setFechaInicio(fechaInicio.getText().toString());
            NuevoPrestamo.setFechaFinal(fechaFinal.getText().toString());
            NuevoPrestamo.setMontoPagar(Double.valueOf(montoPagar.getText().toString()));
            NuevoPrestamo.setMontoCuota(0.0);
            DbPrestamos.getAppDataBase(this).prestamoDao().Insertar(NuevoPrestamo);
            setResult(RESULT_OK,intent);
        }
        else
            setResult(RESULT_CANCELED,intent);
        finish();
        return super.onOptionsItemSelected(item);
    }

    public void calculando(Double monto,Double interes, int plazo){
        TextView mostrarMonto= findViewById(R.id.tvTotalPagar);
        TextView mostrarCuota=findViewById(R.id.tvCuota);

        Double total =montito+(montito*(inte*plazo));
        mostrarMonto.setText(String.valueOf(total));
        mostrarCuota.setText(String.valueOf((total/plazo)));

        EditText fechaFinal= findViewById(R.id.etFechaEnd);

        SimpleDateFormat fechis= new SimpleDateFormat("dd/MM/yyyy");
        Calendar c= Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH,plazo);//Agregar el siguiente mes
        fechaFinal.setText(fechis.format(c.getTime()));

    }

}
