package com.example.prestamos;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prestamos.obj.Datos;

public class Inicial extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);
        TextView tvDatos=findViewById(R.id.tvDatos);
        registerForContextMenu(tvDatos);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnCliente:
                Intent intent = new Intent(this, MainActivity.class);
                startActivityForResult(intent,1111);
                break;
            case R.id.mnPrestamo:
                Intent intent1 = new Intent(this, listaPrestamos.class);
                startActivity(intent1);
                break;
            case R.id.mnVerCliente:
                Intent intent2 = new Intent(this, RVActivity.class);
                startActivity(intent2);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        TextView tvDatos=findViewById(R.id.tvDatos);
        if(requestCode==1111){
            if (resultCode==RESULT_OK){
                Bundle extra = data.getExtras();
                if(extra!=null) {
                    String nombre = extra.getString("nombre");
                    tvDatos.append("\n Ingreso de Nuevo Cliente "+nombre);
                }
            }
            else{
                tvDatos.append("\n Cancelo Ingreso de Nuevo Cliente ");
            }
        }
        else if (requestCode==2222){
            if (resultCode==RESULT_OK)
                tvDatos.append("\n Ingreso de Nuevo Prestamo ");
            else
                tvDatos.append("\n Cancelo Ingreso de Nuevo Prestamo");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.contextual,menu);
        super.onCreateContextMenu(menu, v, menuInfo);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        TextView tvDatos=findViewById(R.id.tvDatos);
        switch (item.getItemId()){
            case R.id.mnCopiar:

                ClipboardManager clipboardManager = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);

                ClipData clipData = ClipData.newPlainText("Historial", tvDatos.getText());

                clipboardManager.setPrimaryClip(clipData);
                break;
            case R.id.mnBorrar:
                tvDatos.setText("");
        }
        return super.onContextItemSelected(item);
    }
}
