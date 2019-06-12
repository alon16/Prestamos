package com.example.prestamos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.prestamos.R;
import com.example.prestamos.obj.Prestamo;
import com.example.prestamos.pojo.PrestamoConCliente;
import com.example.prestamos.pojo.PrestamoConPagoCliente;

import java.util.List;

public class MiAdapterCiente extends ArrayAdapter {
    private Context context;
    private int resource;
    private List<PrestamoConCliente> clienteList;


    public MiAdapterCiente(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.clienteList=objects;

    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View v=inflater.inflate(this.resource,parent,false);

        TextView tvCliente= v.findViewById(R.id.tvCliente);
        TextView tvMonto= v.findViewById(R.id.tvMonto);
        TextView tvCuota= v.findViewById(R.id.tvCuota);

        tvCliente.setText(clienteList.get(position).getCliente().getNombre());
        tvMonto.setText(clienteList.get(position).getPrestamo().getMontoPagar().toString());
        tvCuota.setText(clienteList.get(position).getPrestamo().getPlazo());
        return v;
    }
}
