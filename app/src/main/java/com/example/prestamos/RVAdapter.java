package com.example.prestamos;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ClienteHolder> {
    private List<Cliente>clienteList;
    private OnItemClickListener onItemClickListener;

    public  interface OnItemClickListener
    {
        void onItemClick(String cual,int position);
    }


    public RVAdapter(List<Cliente>clienteList,OnItemClickListener onItemClickListener){
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
        clienteHolder.tvNombre.setText(clienteList.get(i).getNombre());
        clienteHolder.tvApellido.setText(clienteList.get(i).getApellido());
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
        public ClienteHolder(@NonNull View itemView) {
            super(itemView);
            this.tvNombre= itemView.findViewById(R.id.tvNombre);
            this.tvApellido= itemView.findViewById(R.id.tvApellido);
            this.ibEditar=itemView.findViewById(R.id.ibEditar);
            this.ibBorrar=itemView.findViewById(R.id.ibBorrar);
            this.ibEditar.setOnClickListener(this);
            this.ibBorrar.setOnClickListener(this);
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
            else
                enviar="nombre";
            onItemClickListener.onItemClick(enviar, getAdapterPosition());
        }
    }

}
