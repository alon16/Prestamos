package com.example.prestamos;

import android.arch.persistence.room.Room;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.prestamos.adapter.RVAdapter;
import com.example.prestamos.db.DbPrestamos;
import com.example.prestamos.obj.Cliente;
import com.example.prestamos.pojo.ClienteConPrestamo;


import java.util.ArrayList;
import java.util.List;

public class RVActivity extends AppCompatActivity {
    private List<ClienteConPrestamo>clienteList= new ArrayList<>();
    private RVAdapter rvAdapter;
    private DbPrestamos db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);
        db= DbPrestamos.getAppDataBase(this);
        clienteList= db.clienteDao().ObtenerTodo();


        final RecyclerView rvCliente= findViewById(R.id.rvClientes);

        RVAdapter.OnItemClickListener onItemClickListener = new RVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String cual, final int position) {
                if (cual.equals("editar")){
                    Intent intent = new Intent(RVActivity.this, MainActivity.class);
                    intent.putExtra("position",clienteList.get(position).getCliente().getCedula());
                    intent.putExtra("positionList",position);
                    startActivityForResult(intent,1111);
                }
                else if (cual.equals("borrar")){

                AlertDialog.Builder builder= new AlertDialog.Builder(RVActivity.this);
                builder.setTitle("Borrar");
                builder.setMessage("Desea borrar?");
                builder.setNegativeButton("No", null);
                builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        db.clienteDao().Borrar(clienteList.get(position).getCliente());
                        clienteList.remove(position);
                        //Datos.clientes.remove(position);
                        rvAdapter.notifyDataSetChanged();
                    }
                });
                    AlertDialog dialog = builder.create();
               dialog.show();

                }
                else if (cual.equals("VerPrestamo")){
                    Intent intent = new Intent(RVActivity.this, listaPrestamos.class);
                    intent.putExtra("position",clienteList.get(position).getCliente().getCedula());
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(RVActivity.this, VistaCliente.class);
                    intent.putExtra("position",clienteList.get(position).getCliente().getCedula());
                    startActivity(intent);
                }

            }
        };

        rvAdapter= new RVAdapter(clienteList,onItemClickListener);
        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        rvCliente.setHasFixedSize(true);
        rvCliente.setLayoutManager(layoutManager);
        rvCliente.setAdapter(rvAdapter);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1111) {
            if (resultCode == RESULT_OK) {
                Bundle extra = data.getExtras();
                if(extra!=null) {
                    int posicion = extra.getInt("posicion");
                    String id= extra.getString("id");
                    clienteList.set(posicion,DbPrestamos.getAppDataBase(this).clienteDao().ObtenerPorId(id));
                rvAdapter.notifyDataSetChanged();
                }
            }
        }
    }
}
