package com.example.lab18_dev_android;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int count = 0;  // ← Variable d'instance classique → PERDUE à la rotation !
    private TextView tvCount;
    private Button btnIncrement, btnDecrement, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCount = findViewById(R.id.tvCount);
        btnIncrement = findViewById(R.id.btnIncrement);
        btnDecrement = findViewById(R.id.btnDecrement);
        btnReset = findViewById(R.id.btnReset);

        // Problème : on ne restaure rien ici !
        updateUI();

        btnIncrement.setOnClickListener(v -> { count++; updateUI(); });
        btnDecrement.setOnClickListener(v -> { count--; updateUI(); });
        btnReset.setOnClickListener(v -> { count = 0; updateUI(); });
    }

    private void updateUI() {
        tvCount.setText(String.valueOf(count));
    }
}