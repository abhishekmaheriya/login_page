package com.example.login_ssit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class registerActivity extends AppCompatActivity {
    TextView ahaccount;
    EditText usernameR, emailR, passwordR, cpasswordR;
    Button btnregister;
    boolean isEmailValid, isPasswordValid,isPhoneValid,isNameValid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ahaccount = findViewById(R.id.already_have_account);
        usernameR = findViewById(R.id.inputusername);
        emailR = findViewById(R.id.inputEmail);
        passwordR = findViewById(R.id.inputPassword);
        cpasswordR = findViewById(R.id.inputConfirmpass);
        btnregister = findViewById(R.id.btnRegister);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetValidation();
            }
        });

        ahaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(getApplicationContext(),loginActivity.class);
                startActivity(i2);
            }
        });
    }

    public void SetValidation() {
        // Check for a valid name.
        if (usernameR.getText().toString().isEmpty()) {
            usernameR.setError(getResources().getString(R.string.name_error));
            isNameValid = false;
        } else  {
            isNameValid = true;
        }

        // Check for a valid email address.
        if (emailR.getText().toString().isEmpty()) {
            emailR.setError(getResources().getString(R.string.email_error));
            isEmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailR.getText().toString()).matches()) {
            emailR.setError(getResources().getString(R.string.error_invalid_email));
            isEmailValid = false;
        } else  {
            isEmailValid = true;
        }


        // Check for a valid password.
        if (passwordR.getText().toString().isEmpty()) {
            passwordR.setError(getResources().getString(R.string.password_error));
            isPasswordValid = false;
        } else if (passwordR.getText().length() < 6) {
            passwordR.setError(getResources().getString(R.string.error_invalid_password));
            isPasswordValid = false;
        } else  {
            isPasswordValid = true;
        }

        if (isNameValid && isEmailValid && isPasswordValid) {
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
            finish();
        }

    }
}