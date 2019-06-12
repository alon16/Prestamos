package com.example.prestamos.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.prestamos.R;
import com.example.prestamos.obj.Cliente;
import com.example.prestamos.pojo.ClienteConPrestamo;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ClienteHolder> {
    private List<ClienteConPrestamo>clienteList;
    private OnItemClickListener onItemClickListener;

    public  interface OnItemClickListener
    {
        void onItemClick(String cual,int position);
    }


    public RVAdapter(List<ClienteConPrestamo>clienteList,OnItemClickListener onItemClickListener){
        this.clienteList=clienteList;
        this.onItemClickListener=onItemClickListener;
    }
    @NonNull
    @Override
    public ClienteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater= LayoutInflater.from(viewGroup.getContext());
        View view= inflater.inflate(R.layout.item_cliente,viewGroup,false);

        ClienteHolder clienteHolder = new ClienteHolder(view);
        return clienteHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ClienteHolder clienteHolder, int i) {
        clienteHolder.tvNombre.setText(clienteList.get(i).getCliente().getNombre());
        clienteHolder.tvApellido.setText(clienteList.get(i).getCliente().getApellido());
    }

    @Override
    public int getItemCount() {
        return clienteList.size();
    }

    public class ClienteHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvNombre;
        public TextView tvApellido;
        public ImageButton ibEditar;
        public ImageButton ibBorrar;
        public ImageButton ibVerPrestamo;
        public ClienteHolder(@NonNull View itemView) {
            super(itemView);
            this.tvNombre= itemView.findViewById(R.id.tvNombre);
            this.tvApellido= itemView.findViewById(R.id.tvApellido);
            this.ibEditar=itemView.findViewById(R.id.ibEditar);
            this.ibBorrar=itemView.findViewById(R.id.ibBorrar);
            this.ibVerPrestamo=itemView.findViewById(R.id.ibVerPrestamo);
            this.ibEditar.setOnClickListener(this);
            this.ibBorrar.setOnClickListener(this);
            this.ibVerPrestamo.setOnClickListener(this);
            this.tvNombre.setOnClickListener(this);
            this.tvApellido.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String enviar="";
            if(v.getId()==R.id.ibEditar)
                enviar="editar";
            else if (v.getId()==R.id.ibBorrar)
                    enviar ="borrar";
            else if (v.getId()==R.id.ibVerPrestamo)
                enviar="VerPrestamo";
            else
                enviar="nombre";
            onItemClickListener.onItemClick(enviar, getAdapterPosition());
        }
    }

}
