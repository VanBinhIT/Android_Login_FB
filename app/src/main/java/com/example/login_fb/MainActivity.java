package com.example.login_fb;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout tilEmail103, tilPass103;
    private TextInputEditText etEmailPhone103, etPassword103;
    private MaterialButton btnLogin103, btnCreateAcc103;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tilEmail103     = findViewById(R.id.tilEmail103);
        tilPass103      = findViewById(R.id.tilPass103);
        etEmailPhone103 = findViewById(R.id.etEmailPhone103);
        etPassword103   = findViewById(R.id.etPassword103);
        btnLogin103     = findViewById(R.id.btnLogin103);
        btnCreateAcc103 = findViewById(R.id.btnCreateAcc103);


        TextWatcher clearError = new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                tilEmail103.setError(null);
                tilPass103.setError(null);
            }
            @Override public void afterTextChanged(Editable s) {}
        };
        etEmailPhone103.addTextChangedListener(clearError);
        etPassword103.addTextChangedListener(clearError);

        btnLogin103.setOnClickListener(v -> {
            if (!validateInputs()) return;

            String user = etEmailPhone103.getText().toString().trim();
            String pass = etPassword103.getText().toString();

            if (user.equals("binh@gmail.com") && pass.equals("123456")) {
                Intent i = new Intent(this, ProfileActivity.class);
                i.putExtra("EXTRA_EMAIL_103", user);
                startActivity(i);
                finish();
            } else {
                tilEmail103.setError("Sai tài khoản hoặc mật khẩu");
                tilPass103.setError("Sai tài khoản hoặc mật khẩu");
            }
        });


        btnCreateAcc103.setOnClickListener(v ->
                Toast.makeText(this, "Demo: tạo tài khoản (mock)", Toast.LENGTH_SHORT).show()
        );
    }

    private boolean validateInputs() {
        String emailOrPhone = etEmailPhone103.getText() == null ? "" : etEmailPhone103.getText().toString().trim();
        String pass = etPassword103.getText() == null ? "" : etPassword103.getText().toString();

        if (emailOrPhone.isEmpty()) {
            tilEmail103.setError("Vui lòng nhập email hoặc số điện thoại");
            tilEmail103.requestFocus();
            return false;
        }
        if (pass.isEmpty()) {
            tilPass103.setError("Vui lòng nhập mật khẩu");
            tilPass103.requestFocus();
            return false;
        }
        if (emailOrPhone.contains("@") && !Patterns.EMAIL_ADDRESS.matcher(emailOrPhone).matches()) {
            tilEmail103.setError("Email không hợp lệ");
            tilEmail103.requestFocus();
            return false;
        }
        if (pass.length() < 6) {
            tilPass103.setError("Mật khẩu tối thiểu 6 ký tự");
            tilPass103.requestFocus();
            return false;
        }
        return true;
    }
}
