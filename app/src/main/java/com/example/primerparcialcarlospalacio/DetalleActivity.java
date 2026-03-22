package com.example.primerparcialcarlospalacio; //  Verifica que este sea tu paquete real

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetalleActivity extends AppCompatActivity { // [cite: 28]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle); // [cite: 29]

        // 1. Recibir datos del Intent [cite: 3, 24]
        String op = getIntent().getStringExtra("OPERACION"); // [cite: 25]
        double a = getIntent().getDoubleExtra("A", 0.0); // [cite: 26]
        double b = getIntent().getDoubleExtra("B", 0.0); // [cite: 26]
        double res = getIntent().getDoubleExtra("RESULTADO", 0.0); // [cite: 27]

        // 2. Enlazar componentes [cite: 30, 31, 32]
        TextView tvOp = findViewById(R.id.tvDetalleOperacion);
        TextView tvA = findViewById(R.id.tvValorA);
        TextView tvB = findViewById(R.id.tvValorB);
        TextView tvRes = findViewById(R.id.tvValorResultado);
        ImageView ivIcono = findViewById(R.id.ivDetalleIcono);
        Button btnRegresar = findViewById(R.id.btnRegresar);

        // 3. Mostrar datos con formato [cite: 34]
        tvOp.setText("Operación: " + op);
        tvA.setText("Número A: " + a);
        tvB.setText("Número B: " + b);
        tvRes.setText("Resultado Final: " + res);

        // 4. Configurar ícono según la operación [cite: 7, 31, 35]
        if ("POTENCIA".equals(op)) {
            ivIcono.setImageResource(R.drawable.rayo); // [cite: 16]
        } else if ("MODULO".equals(op)) {
            ivIcono.setImageResource(R.drawable.porcentaje); // [cite: 17]
        } else if ("MAXIMO".equals(op)) {
            ivIcono.setImageResource(R.drawable.max); // [cite: 18]
        }

        // 5. Botón Regresar [cite: 32, 36]
        btnRegresar.setOnClickListener(v -> finish());
    }
}