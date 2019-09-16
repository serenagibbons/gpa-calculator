package com.example.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText g1, g2, g3, g4, g5;
    TextView display;
    ConstraintLayout app;
    Button b;

    double x1, x2, x3, x4, x5;  // course grades

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
        if (b.getText().equals(getResources().getString(R.string.btn_label))) {
            if (g1.getText().toString().isEmpty() || g2.getText().toString().isEmpty()
               || g3.getText().toString().isEmpty() || g4.getText().toString().isEmpty()
               || g5.getText().toString().isEmpty()) {
                // if any fields are empty display toast and return
                Toast.makeText(this, getResources().getString(R.string.toast), Toast.LENGTH_LONG).show();
                return;
            }
            // EditViews input types are all numberDecimal, so should not throw exception when parsing
            x1 = Double.parseDouble(g1.getText().toString());
            x2 = Double.parseDouble(g2.getText().toString());
            x3 = Double.parseDouble(g3.getText().toString());
            x4 = Double.parseDouble(g4.getText().toString());
            x5 = Double.parseDouble(g5.getText().toString());

            inputTest();

            // calculate GPA
            double gpa = (x1 + x2 + x3 + x4 + x5) / 5;
            // convert gpa to string
            String strGpa = String.format(getResources().getString(R.string.gpa_display), gpa);
            // display gpa
            display.setText(strGpa);

            // change app background color based on calculated gpa
            if (gpa < 60) {
                app.setBackgroundColor(getResources().getColor(R.color.red));
            } else if (gpa < 80) {
                app.setBackgroundColor(getResources().getColor(R.color.yellow));
            } else {
                app.setBackgroundColor(getResources().getColor(R.color.green));
            }

            // set button label to "clear forms"
            b.setText(getResources().getString(R.string.btn_label2));
        }
        else {
            // clear all fields
            g1.getText().clear();
            g2.getText().clear();
            g3.getText().clear();
            g4.getText().clear();
            g5.getText().clear();

            // reset background colors
            g1.setBackgroundColor(Color.TRANSPARENT);
            g2.setBackgroundColor(Color.TRANSPARENT);
            g3.setBackgroundColor(Color.TRANSPARENT);
            g4.setBackgroundColor(Color.TRANSPARENT);
            g5.setBackgroundColor(Color.TRANSPARENT);

            app.setBackgroundColor(getResources().getColor(R.color.white));

            // clear calculated gpa
            display.setText("");

            // set button label back to "Compute GPA"
            b.setText(getResources().getString(R.string.btn_label));
        }
    }

    public void inputTest() {
        // validate that grade inputs are between 0 and 100
        boolean valid = true;
        if (x1 > 100 || x1 < 0) {
            g1.setBackgroundColor(getResources().getColor(R.color.red2));
            valid = false;
        }
        if (x2 > 100 || x2 < 0) {
            g2.setBackgroundColor(getResources().getColor(R.color.red2));
            valid = false;
        }
        if (x3 > 100 || x3 < 0) {
            g3.setBackgroundColor(getResources().getColor(R.color.red2));
            valid = false;
        }
        if (x4 > 100 || x4 < 0) {
            g4.setBackgroundColor(getResources().getColor(R.color.red2));
            valid = false;
        }
        if (x5 > 100 || x5 < 0) {
            g5.setBackgroundColor(getResources().getColor(R.color.red2));
            valid = false;
        }

        // if any fields have incorrect input, display toast
        if (!valid) {
            Toast.makeText(this, getResources().getString(R.string.toast2), Toast.LENGTH_LONG).show();
        }
    }
}
