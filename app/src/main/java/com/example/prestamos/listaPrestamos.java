package com.example.prestamos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.prestamos.adapter.MiAdapterCiente;
import com.example.prestamos.db.DbPrestamos;
import com.example.prestamos.obj.Prestamo;
import com.example.prestamos.pojo.PrestamoConCliente;
import com.example.prestamos.pojo.PrestamoConPagoCliente;

import java.util.ArrayList;
import java.util.List;

public class listaPrestamos extends AppCompatActivity implements ListView.OnItemClickListener {
    MiAdapterCiente adapter;
    List<PrestamoConCliente> prestamoConClienteList= new ArrayList<>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_prestamos);
        ListView lvPrestamos= findViewById(R.id.lvPrestamos);
        String id;

        Bundle extras=getIntent().getExtras();

        if(extras!=null){
            id=extras.getString("position");
            prestamoConClienteList.addAll(DbPrestamos.getAppDataBase(this).prestamoDao().ObtenerPrestamo(id));
            adapter= new MiAdapterCiente(this,R.layout.item_cliente_prestamo,prestamoConClienteList);
        }
        else{
            prestamoConClienteList.addAll(DbPrestamos.getAppDataBase(this).prestamoDao().ObtenerTodoConCliente());
            adapter= new MiAdapterCiente(this, R.layout.item_cliente_prestamo, prestamoConClienteList);
        }
        lvPrestamos.setAdapter(adapter);
        lvPrestamos.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, VerPrestamo.class);
        intent.putExtra("position", prestamoConClienteList.get(position).getPrestamo().getId());
        startActivity(intent);
    }
}
