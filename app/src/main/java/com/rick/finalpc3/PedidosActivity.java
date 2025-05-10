package com.rick.finalpc3;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class PedidosActivity extends AppCompatActivity {

    private LinearLayout layoutPedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        layoutPedidos = findViewById(R.id.layoutPedidos);

        String nombre = getIntent().getStringExtra("nombre");
        String fecha = getIntent().getStringExtra("fecha");
        double total = getIntent().getDoubleExtra("total", 0.0);
        ArrayList<String> detalles = getIntent().getStringArrayListExtra("detalles");

        agregarPedido(nombre, fecha, total, detalles);
    }

    private void agregarPedido(String nombre, String fecha, double total, ArrayList<String> detalles) {
        CardView cardView = new CardView(this);
        cardView.setCardElevation(8);
        cardView.setRadius(16);
        LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        cardParams.setMargins(0, 16, 0, 0);
        cardView.setLayoutParams(cardParams);

        LinearLayout contenido = new LinearLayout(this);
        contenido.setOrientation(LinearLayout.VERTICAL);
        contenido.setPadding(24, 24, 24, 24);

        contenido.addView(crearTextView("Nombre: " + nombre));
        contenido.addView(crearTextView("Fecha: " + fecha));
        contenido.addView(crearTextView("Total: S/ " + total));
        contenido.addView(crearTextView("Detalles:"));

        for (String item : detalles) {
            contenido.addView(crearTextView("- " + item));
        }

        cardView.addView(contenido);
        layoutPedidos.addView(cardView);
    }

    private TextView crearTextView(String texto) {
        TextView tv = new TextView(this);
        tv.setText(texto);
        tv.setTextSize(16);
        return tv;
    }
}
