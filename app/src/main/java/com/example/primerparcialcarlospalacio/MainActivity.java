package com.example.primerparcialcarlospalacio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Declaración de variables de la UI [cite: 11, 12, 13, 14, 15]
    EditText n1, n2;
    Button btnPotencia, btnModulo, btnMaximo, btnLimpiar, btnVerDetalle;
    TextView tvResultado;
    ImageView ivOperacion;

    // Variables para almacenar datos y enviarlos después [cite: 25, 26, 27]
    String operacionSeleccionada = "";
    double valorA = 0, valorB = 0, resultadoCalculado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Ajuste de insets (copiado de tu referencia)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. Enlazar componentes [cite: 12, 13, 14, 15]
        n1 = findViewById(R.id.txt1);
        n2 = findViewById(R.id.txt2);
        btnPotencia = findViewById(R.id.btnpotencia);
        btnModulo = findViewById(R.id.btnmodulo);
        btnMaximo = findViewById(R.id.btnmaximo);
        btnLimpiar = findViewById(R.id.btnlimpiar);
        btnVerDetalle = findViewById(R.id.btnverdetalle);
        tvResultado = findViewById(R.id.tvresultado);
        ivOperacion = findViewById(R.id.ivoperacion);

        // 2. Lógica de los botones

        // POTENCIA [cite: 16, 20]
        btnPotencia.setOnClickListener(v -> calcular("POTENCIA"));

        // MÓDULO [cite: 17, 21]
        btnModulo.setOnClickListener(v -> calcular("MODULO"));

        // MÁXIMO [cite: 18, 22]
        btnMaximo.setOnClickListener(v -> calcular("MAXIMO"));

        // LIMPIAR [cite: 23]
        btnLimpiar.setOnClickListener(v -> {
            n1.setText("");
            n2.setText("");
            tvResultado.setText("Resultado");
            ivOperacion.setImageDrawable(null);
            operacionSeleccionada = "";
        });

        // VER DETALLE (Intent Explícito) [cite: 24, 25, 26, 27]
        btnVerDetalle.setOnClickListener(v -> {
            if (!operacionSeleccionada.isEmpty()) {
                Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
                intent.putExtra("OPERACION", operacionSeleccionada);
                intent.putExtra("A", valorA);
                intent.putExtra("B", valorB);
                intent.putExtra("RESULTADO", resultadoCalculado);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Realiza una operación primero", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Método auxiliar para centralizar los cálculos y validaciones [cite: 6]
    private void calcular(String tipo) {
        try {
            valorA = Double.parseDouble(n1.getText().toString());
            valorB = Double.parseDouble(n2.getText().toString());
            operacionSeleccionada = tipo;

            switch (tipo) {
                case "POTENCIA":
                    resultadoCalculado = Math.pow(valorA, valorB); // [cite: 20]
                    ivOperacion.setImageResource(R.drawable.rayo); // [cite: 16]
                    break;
                case "MODULO":
                    if (valorB != 0) { // Validación B != 0
                        resultadoCalculado = valorA % valorB;
                        ivOperacion.setImageResource(R.drawable.porcentaje); // [cite: 17]
                    } else {
                        Toast.makeText(this, "B no puede ser cero", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    break;
                case "MAXIMO":
                    resultadoCalculado = Math.max(valorA, valorB); // [cite: 22]
                    ivOperacion.setImageResource(R.drawable.max); // [cite: 18]
                    break;
            }
            tvResultado.setText("Resultado: " + resultadoCalculado); // [cite: 14]

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Ingresa números válidos", Toast.LENGTH_SHORT).show();
        }
    }
}