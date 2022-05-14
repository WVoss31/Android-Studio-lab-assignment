package com.example.problem_solver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class _8puzzle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_8puzzle);
    }

    public void _interactive(View view) {
        Intent intent = new Intent(this, _8puzzle_interactive.class);
        startActivity(intent);
    }

}