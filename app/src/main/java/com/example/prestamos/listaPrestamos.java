package com.example.prestamos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class listaPrestamos extends AppCompatActivity {
    MiAdapterCiente adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_prestamos);

        ListView lvPrestamos= findViewById(R.id.lvPrestamos);

        adapter= new MiAdapterCiente(this, R.layout.item_cliente_prestamo,Datos.prestamos);
        lvPrestamos.setAdapter(adapter);
    }


}
