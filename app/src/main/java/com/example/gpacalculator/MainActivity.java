package com.example.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText g1, g2, g3, g4, g5;
    TextView display;
    ConstraintLayout app;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        g1 = findViewById(R.id.grade1);
        g2 = findViewById(R.id.grade2);
        g3 = findViewById(R.id.grade3);
        g4 = findViewById(R.id.grade4);
        g5 = findViewById(R.id.grade5);
        display = findViewById(R.id.gpa);
        app = findViewById(R.id.constraintLayout);
        b = findViewById(R.id.button);
    }

    public void computeGPA(View view) {
        double x1 = Double.parseDouble(g1.getText().toString());
        double x2 = Double.parseDouble(g2.getText().toString());
        double x3 = Double.parseDouble(g3.getText().toString());
        double x4 = Double.parseDouble(g4.getText().toString());
        double x5 = Double.parseDouble(g5.getText().toString());

        double gpa = (x1 + x2 + x3 + x4 + x5) / 5;
        String strGpa = String.format(getResources().getString(R.string.gpa_display), gpa);
        display.setText(strGpa);

        if (gpa < 60) {
            app.setBackgroundColor(getResources().getColor(R.color.red));
        } else if (gpa < 80) {
            app.setBackgroundColor(getResources().getColor(R.color.yellow));
        } else {
            app.setBackgroundColor(getResources().getColor(R.color.green));
        }

        b.setText(getResources().getString(R.string.btn_label2));
    }
}
