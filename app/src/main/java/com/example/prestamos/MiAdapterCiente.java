package com.example.prestamos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MiAdapterCiente extends ArrayAdapter {
    private Context context;
    private int resource;
    private List<Prestamo> clienteList;


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

        tvCliente.setText(clienteList.get(position).getCliente());
        tvMonto.setText(clienteList.get(position).getMontoPagar().toString());
        tvCuota.setText(clienteList.get(position).getPlazo());
        return v;
    }
}
