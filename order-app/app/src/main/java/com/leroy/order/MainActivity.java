package com.leroy.order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private List<Order> orderList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();

        orderList = new ArrayList<>();
        fetchMovies();


    }

    private void fetchMovies() {

        String url = "http://192.168.0.10:8081/ordemDeServico";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0 ; i < response.length() ; i ++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        String orderNumber = jsonObject.getString("id").toString();
                        String status = jsonObject.getString("status");
                        String nomeCliente = jsonObject.getString("nomeCliente");
                        String nomePrestador = jsonObject.getString("nomePrestador");
                        String nomeEmpresa = jsonObject.getString("nomeEmpresa");
                        String enderecoCliente = jsonObject.getString("endereco");

                        Order order = new Order(
                                orderNumber,
                                status ,
                                nomeCliente ,
                                enderecoCliente,
                                nomePrestador ,
                                nomeEmpresa);

                        orderList.add(order);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    OrderAdapter adapter = new OrderAdapter(MainActivity.this , orderList);

                    recyclerView.setAdapter(adapter);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonArrayRequest);
    }
}