package com.example.dwaekrany;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final ActivityResultLauncher<Intent> summaryLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if (result.getResultCode() == RESULT_OK
                                && result.getData() != null) {

                            String number = result.getData()
                                    .getStringExtra(SummaryActivity.EXTRA_NUMBER);

                            Toast.makeText(
                                    this,
                                    getString(R.string.registered, number),
                                    Toast.LENGTH_LONG
                            ).show();
                        }
                        // RESULT_CANCELED: użytkownik zrezygnował lub nacisnął Wstecz.
                    }
            );
    private EditText etName;
    private EditText etEmail;
    private Spinner spCourse;
    private SeekBar sbLevel;
    private TextView tvLevelValue;
    private CheckBox cbNewsletter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        spCourse = findViewById(R.id.spCourse);
        sbLevel = findViewById(R.id.sbLevel);
        tvLevelValue = findViewById(R.id.tvLevelValue);
        cbNewsletter = findViewById(R.id.cbNewsletter);

        Button btnNext = findViewById(R.id.btnNext);

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.courses,
                        android.R.layout.simple_spinner_item
                );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spCourse.setAdapter(adapter);

        sbLevel.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(
                            SeekBar seekBar, int progress, boolean fromUser) {
                        tvLevelValue.setText(String.valueOf(progress));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                }
        );

        btnNext.setOnClickListener(v -> openSummary());
    }

    private void openSummary() {
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String course = spCourse.getSelectedItem().toString();
        int level = sbLevel.getProgress();
        boolean newsletter = cbNewsletter.isChecked();

        Intent intent = new Intent(this, SummaryActivity.class);

        intent.putExtra(SummaryActivity.EXTRA_NAME, name);
        intent.putExtra(SummaryActivity.EXTRA_EMAIL, email);
        intent.putExtra(SummaryActivity.EXTRA_COURSE, course);
        intent.putExtra(SummaryActivity.EXTRA_LEVEL, level);
        intent.putExtra(SummaryActivity.EXTRA_NEWSLETTER, newsletter);

        summaryLauncher.launch(intent);    }
}