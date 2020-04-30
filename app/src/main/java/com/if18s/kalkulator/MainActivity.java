package com.if18s.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtBil1;
    EditText txtBil2;
    TextView lblHasil;
    String operasi = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtBil1 = (EditText) findViewById(R.id.txtBil1);
        txtBil2 = (EditText) findViewById(R.id.txtBil2);
        lblHasil = (TextView) findViewById(R.id.lblHasil);
        Button btnPlus = (Button) findViewById(R.id.btnPlus);
        Button btnMin = (Button) findViewById(R.id.btnMin);
        Button btnKali = (Button) findViewById(R.id.btnKali);
        Button btnBagi = (Button) findViewById(R.id.btnBagi);
        Button btnHitung = (Button) findViewById(R.id.btnHitung);
        Button btnBersih = (Button) findViewById(R.id.btnBersih);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operasi = "+";
            }
        });

        btnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operasi = "-";
            }
        });

        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operasi = "/";
            }
        });

        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operasi = "X";
            }
        });

        btnBersih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bersihkan();
            }
        });

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input1 = txtBil1.getText().toString();
                String input2 = txtBil2.getText().toString();

                if (input1.equals("") || input2.equals("") || (input1.equals("") && input2.equals(""))) {
                    Toast.makeText(getApplicationContext(), "Input bilangan harus isi..", Toast.LENGTH_LONG).show();
                } else if(operasi.equals("")) {
                    Toast.makeText(getApplicationContext(), "Operasi Aritmatika belum dipilih..", Toast.LENGTH_LONG).show();
                } else {
                    double bil1 = Double.parseDouble(input1);
                    double bil2 = Double.parseDouble(input2);

                    lblHasil.setText(Hitung(bil1, bil2));
                }
            }
        });

    }

    public void Bersihkan() {
        txtBil1.setText(null);
        txtBil2.setText(null);
        lblHasil.setText("Hasil");
        operasi = "";
    }

    public String Hitung(double bil1, double bil2) {
        double hasil = 0;

        switch (operasi) {
            case "+":
                    hasil = bil1 + bil2;
                break;
            case "-":
                hasil = bil1 - bil2;
                break;
            case "x":
                hasil = bil1 * bil2;
                break;
            case "/":
                hasil = bil1 / bil2;
                break;
        }
        String rs = bil1 + " " + operasi + " " + bil2 + " = " + hasil;
        return rs;
    }
}
