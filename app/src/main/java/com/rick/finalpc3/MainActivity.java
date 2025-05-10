package com.rick.finalpc3;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText edtNombreCliente;
    private Button btnConfirmarPedido;
    private ArrayList<String> pedidoDetalles;
    private double totalPedido = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNombreCliente = findViewById(R.id.edtNombreCliente);
        btnConfirmarPedido = findViewById(R.id.btnConfirmarPedido);

        // Simulación de productos agregados (esto se puede hacer dinámico luego)
        pedidoDetalles = new ArrayList<>();
        pedidoDetalles.add("1x Arroz Chaufa - S/ 20.00");
        pedidoDetalles.add("2x Inca Kola - S/ 25.00");
        totalPedido = 45.00;

        btnConfirmarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = edtNombreCliente.getText().toString().trim();

                if (nombre.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Ingrese su nombre", Toast.LENGTH_SHORT).show();
                    return;
                }

                String fechaHora = new SimpleDateFormat("dd/MM/yyyy - hh:mm a", Locale.getDefault()).format(new Date());

                Intent intent = new Intent(MainActivity.this, PedidosActivity.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("fecha", fechaHora);
                intent.putExtra("total", totalPedido);
                intent.putStringArrayListExtra("detalles", pedidoDetalles);
                startActivity(intent);
            }
        });
    }
}
