package com.example.dwaekrany;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    public static final String EXTRA_NAME =
            "com.example.dwaekrany.NAME";

    public static final String EXTRA_EMAIL =
            "com.example.dwaekrany.EMAIL";

    public static final String EXTRA_COURSE =
            "com.example.dwaekrany.COURSE";

    public static final String EXTRA_LEVEL =
            "com.example.dwaekrany.LEVEL";

    public static final String EXTRA_NEWSLETTER =
            "com.example.dwaekrany.NEWSLETTER";

    public static final String EXTRA_NUMBER =
            "com.example.dwaekrany.NUMBER";

    private String summaryText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        TextView tvSummary = findViewById(R.id.tvSummary);
        Button btnEdit = findViewById(R.id.btnEdit);
        Button btnConfirm = findViewById(R.id.btnConfirm);
        Button btnShare = findViewById(R.id.btnShare);

        Intent receivedIntent = getIntent();

        String name = receivedIntent.getStringExtra(EXTRA_NAME);
        String email = receivedIntent.getStringExtra(EXTRA_EMAIL);
        String course = receivedIntent.getStringExtra(EXTRA_COURSE);
        int level = receivedIntent.getIntExtra(EXTRA_LEVEL, 0);
        boolean newsletter =
                receivedIntent.getBooleanExtra(EXTRA_NEWSLETTER, false);

        String newsletterText = getString(
                newsletter ? R.string.yes_short : R.string.no_short
        );

        summaryText = getString(
                R.string.summary_format,
                name,
                email,
                course,
                level,
                newsletterText
        );

        tvSummary.setText(summaryText);

        btnEdit.setOnClickListener(v -> finish());

        btnConfirm.setOnClickListener(v -> confirm());

        btnShare.setOnClickListener(v -> shareSummary());
    }

    private void confirm() {
        String number = "ZG/" +
                (1000 + new java.util.Random().nextInt(9000));

        Intent result = new Intent();
        result.putExtra(EXTRA_NUMBER, number);

        setResult(RESULT_OK, result);
        finish();
    }

    private void shareSummary() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);

        shareIntent.setType("text/plain");

        shareIntent.putExtra(
                Intent.EXTRA_TEXT,
                summaryText
        );

        Intent chooser = Intent.createChooser(
                shareIntent,
                "Udostępnij podsumowanie"
        );

        startActivity(chooser);
    }
}