package com.example.login_fb;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    TextView tvProfileName103, tvEmailRow103, tvPhoneRow103, tvSkypeRow103, tvWebRow103;
    ImageButton btnSetting103;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvProfileName103 = findViewById(R.id.tvProfileName103);
        tvEmailRow103    = findViewById(R.id.tvEmailRow103);
        tvPhoneRow103    = findViewById(R.id.tvPhoneRow103);
        tvSkypeRow103    = findViewById(R.id.tvSkypeRow103);
        tvWebRow103      = findViewById(R.id.tvWebRow103);
        btnSetting103    = findViewById(R.id.btnSetting103);

        String user = getIntent().getStringExtra("EXTRA_EMAIL_103");
        if (user == null || user.isEmpty()) user = "binh";

        tvProfileName103.setText(capitalize(user));
        tvEmailRow103.setText("email : " + user + "@gmail.com");
        tvPhoneRow103.setText("Phone : 0123 456 789");
        tvSkypeRow103.setText("Skype : " + user + "007");
        tvWebRow103.setText("Web : mysite.com/");

        btnSetting103.setOnClickListener(v -> {
            Intent back = new Intent(ProfileActivity.this, MainActivity.class);
            startActivity(back);
            finish();
        });
    }

    private String capitalize(String s) {
        return (s == null || s.isEmpty()) ? s : s.substring(0,1).toUpperCase() + s.substring(1);
    }
}
