package com.example.prestamos;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prestamos.db.DbPrestamos;
import com.example.prestamos.obj.Cliente;
import com.example.prestamos.obj.Datos;
import com.example.prestamos.obj.Pago;
import com.example.prestamos.pojo.PrestamoConPagoCliente;

import java.util.ArrayList;
import java.util.List;

public class VerPrestamo extends AppCompatActivity {
    private int id=0;
    private DbPrestamos db;
    private List<Pago>pagoList=new ArrayList<>();
    private ListView lvPagos;
    private  ArrayAdapter arrayAdapter;
    List<Double> pagado= new ArrayList<>();
    private double ptxt=0;
    private TextView montoCuota;

    PrestamoConPagoCliente prestamoConPagoCliente=new PrestamoConPagoCliente();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_prestamo);
        ActionBar bar=getSupportActionBar();
        bar.setSubtitle("Ver Prestamo");
        lvPagos= findViewById(R.id.lvPagos);
        TextView monto= findViewById(R.id.tvMontoCredito);
        TextView interes=findViewById(R.id.tvInteres);
        TextView plazo=findViewById(R.id.tvPlazo);
        TextView fechaInicio=findViewById(R.id.tvFechaInicio);
        TextView fechaFinal= findViewById(R.id.tvFechaFinal);
        TextView montoPagar=findViewById(R.id.tvMontoPagar);
        montoCuota=findViewById(R.id.tvMontoCuota);
        db=DbPrestamos.getAppDataBase(this);

        Bundle extras=getIntent().getExtras();

        if(extras!=null){
            id=extras.getInt("position");
        prestamoConPagoCliente=db.pagoDao().ObtenerPorPrestamo(id);


        monto.setText(prestamoConPagoCliente.getPrestamoConCliente().getPrestamo().getMontoPagar().toString());
        interes.setText(prestamoConPagoCliente.getPrestamoConCliente().getPrestamo().getInteres());
        plazo.setText(prestamoConPagoCliente.getPrestamoConCliente().getPrestamo().getPlazo());
        fechaInicio.setText(prestamoConPagoCliente.getPrestamoConCliente().getPrestamo().getFechaInicio());
        fechaFinal.setText(prestamoConPagoCliente.getPrestamoConCliente().getPrestamo().getFechaFinal());
        montoPagar.setText(prestamoConPagoCliente.getPrestamoConCliente().getPrestamo().getMontoPagar().toString());
        for (Pago p : prestamoConPagoCliente.getPagoList()){
            pagado.add(p.getPagado());

            ptxt=p.getPagado()+ ptxt;
            if(ptxt==0)
                montoCuota.setText("0.0");
            montoCuota.setText(""+ptxt);

        }
        arrayAdapter =  new ArrayAdapter(this,android.R.layout.simple_list_item_1,pagado);
        lvPagos.setAdapter(arrayAdapter);
        }

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
            AlertDialog.Builder builder = new AlertDialog.Builder(VerPrestamo.this);
            builder.setTitle("Ingresando Pago");
            final View view = LayoutInflater.from(VerPrestamo.this).inflate(R.layout.dialog_pago,null,false);
            builder.setView(view);
            builder.setNegativeButton("cancelar",null);
            builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    EditText etPago= view.findViewById(R.id.etPago);
                    double debe= prestamoConPagoCliente.getPrestamoConCliente().getPrestamo().getMontoPagar()-ptxt;
                    if (debe!=0) {
                        Pago pago = new Pago();
                        if (Double.parseDouble(etPago.getText().toString()) <= debe)
                            pago.setPagado(Double.parseDouble(etPago.getText().toString()));
                        else
                            pago.setPagado(debe);

                        pago.setIdPrestamo(prestamoConPagoCliente.getPrestamoConCliente().getPrestamo().getId());

                        try {
                                db.pagoDao().Insertar(pago);
                                pagado.add(pago.getPagado());
                                arrayAdapter.notifyDataSetChanged();
                            montoCuota.setText(""+(ptxt+pago.getPagado()));

                        } catch (SQLiteConstraintException e) {
                            Toast.makeText(VerPrestamo.this, "Error \n" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                        Toast.makeText(VerPrestamo.this, "Ya ha pagado", Toast.LENGTH_SHORT).show();
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        }
        return super.onOptionsItemSelected(item);
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
