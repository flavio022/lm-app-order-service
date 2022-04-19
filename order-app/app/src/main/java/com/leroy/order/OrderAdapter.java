package com.leroy.order;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderHolder> {

    private Context context;
    private List<Order> orderList;

    public OrderAdapter(Context context , List<Order> orders){
        this.context = context;
        orderList = orders;
    }
    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item , parent , false);
        return new OrderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHolder holder, int position) {

        Order order = orderList.get(position);

        holder.orderNumber.setText(order.getOrderNumber());
        holder.status.setText(order.getStatus());
        holder.nomeCliente.setText(order.getNomeCliente());
        holder.enderecoCliente.setText(order.getEnderecoCliente());
        holder.nomePrestador.setText(order.getNomePrestador());
        holder.nomeEmpresa.setText(order.getNomeEmpresa());

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , DetailActivity.class);

                Bundle bundle = new Bundle();

                bundle.putString("orderNumber",order.getOrderNumber());
                bundle.putString("status" , order.getStatus());
                bundle.putString("nomeCliente",order.getNomeCliente());
                bundle.putString("enderecoCliente" , order.getEnderecoCliente());
                bundle.putString("nomePrestador" , order.getNomePrestador());
                bundle.putString("nomeEmpresa", order.getNomeEmpresa());



                intent.putExtras(bundle);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class OrderHolder extends RecyclerView.ViewHolder{

        TextView orderNumber, status , nomeCliente , enderecoCliente , nomePrestador, nomeEmpresa;

        ConstraintLayout constraintLayout;

        public OrderHolder(@NonNull View itemView) {
            super(itemView);
            orderNumber = itemView.findViewById(R.id.orderNumber);
            status = itemView.findViewById(R.id.status_order);
            nomeCliente = itemView.findViewById(R.id.nome_cliente);
            enderecoCliente = itemView.findViewById(R.id.enderecoCliente);
            nomePrestador = itemView.findViewById(R.id.nome_prestador);
            nomeEmpresa = itemView.findViewById(R.id.nomeEmpresa);

            constraintLayout = itemView.findViewById(R.id.main_layout);
        }
    }
}
