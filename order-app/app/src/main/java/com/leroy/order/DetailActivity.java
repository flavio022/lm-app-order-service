package com.leroy.order;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView orderNumberName = findViewById(R.id.orderNumber_name);
        TextView orderNumber = findViewById(R.id.orderNumber);

        TextView status_name = findViewById(R.id.status_order_name);
        TextView status = findViewById(R.id.status_order);

        TextView nomeClienteName = findViewById(R.id.nome_cliente_name);
        TextView nomeCliente = findViewById(R.id.nome_cliente);

        TextView enderecoClienteNome = findViewById(R.id.enderecoCliente_name);
        TextView enderecoCliente = findViewById(R.id.enderecoCliente);

        TextView nomePrestadorNome = findViewById(R.id.nome_prestador_nome);
        TextView nomePrestador = findViewById(R.id.nome_prestador);

        TextView nomeEmpresaNome = findViewById(R.id.nomeEmpresa_nome);
        TextView nomeEmpresa = findViewById(R.id.nomeEmpresa);


        Bundle bundle = getIntent().getExtras();


        String mOrderNumber = bundle.getString("orderNumber");
        String mStatus = bundle.getString("status");
        String mNomeCliente = bundle.getString("nomeCliente");
        String mEnderecoCliente = bundle.getString("enderecoCliente");
        String mNomePrestador = bundle.getString("nomePrestador");
        String mNomeEmpresa = bundle.getString("nomeEmpresa");

        orderNumberName.setText("Número da OS:");
        orderNumber.setText(mOrderNumber);

        status_name.setText("Status:");
        status.setText(mStatus);

        nomeClienteName.setText("Nome Cliente:");
        nomeCliente.setText(mNomeCliente);

        enderecoClienteNome.setText("Endereço do cliente:");
        enderecoCliente.setText(mEnderecoCliente);

        nomePrestadorNome.setText("Prestador:");
        nomePrestador.setText(mNomePrestador);

        nomeEmpresaNome.setText("Empresa:");
        nomeEmpresa.setText(mNomeEmpresa);

    }
}