package com.example.prestamos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RegistroCredito extends AppCompatActivity {
    private Double montito=0.0;
    private int tiempo=1;
    private Double inte=0.15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_credito);
        EditText monto= findViewById(R.id.etMonto);
        EditText plazos= findViewById(R.id.etPlazo);
        Spinner interes= findViewById(R.id.cbInteres);
        EditText fechaInicio= findViewById(R.id.etFecha);
        EditText fechaFinal= findViewById(R.id.etFechaEnd);
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
    public void onClickFinalizar(View view){
        Toast.makeText(this, "Gracias!", Toast.LENGTH_SHORT).show();
    }

}