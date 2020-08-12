package com.exemple.android.messenger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private Button loginBtn, registerBtn;
    private EditText emailET, passwordED;
    private TextView changeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loginBtn = (Button) findViewById(R. id.login_button);
        registerBtn = (Button) findViewById(R. id.register_button);
        emailET = (EditText) findViewById(R. id.email_input);
        passwordED = (EditText) findViewById(R. id.password_input);
        changeTV = (TextView) findViewById(R. id.changeTV);

        changeTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTV.setVisibility(View.INVISIBLE);
                registerBtn.setVisibility(View.INVISIBLE);
                loginBtn.setVisibility(View.VISIBLE);
            }
        });
    }
}