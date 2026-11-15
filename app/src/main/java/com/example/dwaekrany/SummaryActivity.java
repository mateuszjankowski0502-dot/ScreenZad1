package com.example.dwaekrany;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_EMAIL = "extra_email";
    public static final String EXTRA_COURSE = "extra_course";
    public static final String EXTRA_LEVEL = "extra_level";
    public static final String EXTRA_NEWSLETTER = "extra_newsletter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        String email = getIntent().getStringExtra(EXTRA_EMAIL);
        String course = getIntent().getStringExtra(EXTRA_COURSE);
        int level = getIntent().getIntExtra(EXTRA_LEVEL, 0);
        boolean newsletter =
                getIntent().getBooleanExtra(EXTRA_NEWSLETTER, false);

        String newsletterText = newsletter
                ? getString(R.string.yes_short)
                : getString(R.string.no_short);

        String summary = getString(
                R.string.summary_format,
                name,
                email,
                course,
                level,
                newsletterText
        );

        TextView tvSummary = findViewById(R.id.tvSummary);
        tvSummary.setText(summary);
    }
}