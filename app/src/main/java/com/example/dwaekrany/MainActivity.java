
package com.example.dwaekrany;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(v -> openSummary());
    }

    private void openSummary() {
        Intent intent = new Intent(this, SummaryActivity.class);
        startActivity(intent);
    }
}
