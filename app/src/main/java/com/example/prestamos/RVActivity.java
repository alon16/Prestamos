package com.example.prestamos;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RVActivity extends AppCompatActivity {
    private List<Cliente>clienteList= new ArrayList<>();
    private RVAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);


        final RecyclerView rvCliente= findViewById(R.id.rvClientes);
        RVAdapter.OnItemClickListener onItemClickListener = new RVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String cual, final int position) {
                if (cual.equals("editar")){
                    Intent intent = new Intent(RVActivity.this, MainActivity.class);
                    intent.putExtra("position",position);
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
                        Datos.clientes.remove(position);
                        rvAdapter.notifyDataSetChanged();
                    }
                });
                    AlertDialog dialog = builder.create();
               dialog.show();

                }
                else{
                    Intent intent = new Intent(RVActivity.this, VistaCliente.class);
                    intent.putExtra("position",position);
                    startActivity(intent);
                }

            }
        };

        rvAdapter= new RVAdapter(Datos.clientes,onItemClickListener);
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
                rvAdapter.notifyDataSetChanged();
            }
        }
    }
}
