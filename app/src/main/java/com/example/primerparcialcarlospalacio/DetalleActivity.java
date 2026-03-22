package com.example.primerparcialcarlospalacio;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        String op = getIntent().getStringExtra("OPERACION");
        double a = getIntent().getDoubleExtra("A", 0.0);
        double b = getIntent().getDoubleExtra("B", 0.0);
        double res = getIntent().getDoubleExtra("RESULTADO", 0.0);

        TextView tvOp = findViewById(R.id.tvDetalleOperacion);
        TextView tvA = findViewById(R.id.tvValorA);
        TextView tvB = findViewById(R.id.tvValorB);
        TextView tvRes = findViewById(R.id.tvValorResultado);
        ImageView ivIcono = findViewById(R.id.ivDetalleIcono);
        Button btnRegresar = findViewById(R.id.btnRegresar);

        tvOp.setText("Operación: " + op);
        tvA.setText("Número A: " + a);
        tvB.setText("Número B: " + b);
        tvRes.setText("Resultado Final: " + res);

        if ("POTENCIA".equals(op)) {
            ivIcono.setImageResource(R.drawable.rayo);
        } else if ("MODULO".equals(op)) {
            ivIcono.setImageResource(R.drawable.porcentaje);
        } else if ("MAXIMO".equals(op)) {
            ivIcono.setImageResource(R.drawable.max);
        }

        btnRegresar.setOnClickListener(v -> finish());
    }
}