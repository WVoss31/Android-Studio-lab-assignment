package com.example.problem_solver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class fwgc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fwgc);
    }

    public void farmer_interactive(View view) {
        Intent intent = new Intent(this, farmer_interactive.class);
        startActivity(intent);
    }
}