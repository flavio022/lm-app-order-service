package com.leroy.order;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

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

        Button botao_enviar = findViewById(R.id.button_atendimento);

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

        botao_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendWorkPostRequest();
            }
        });

    }


    private void sendWorkPostRequest() {

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://192.168.0.10:8081/ordemDeServico";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Toast.makeText(DetailActivity.this, "Response is: " + response.substring(0,500), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DetailActivity.this, "That didn't work!", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("endereco", "Rua dene");

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type","application/json");
                return params;
            }
        };
        queue.add(stringRequest);


// Add the request to the RequestQueue.
        queue.add(stringRequest);
}


}