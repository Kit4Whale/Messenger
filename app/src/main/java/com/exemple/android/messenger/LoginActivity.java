package com.exemple.android.messenger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private Button nextButton, verificationButton;
    private EditText phoneInput, verificationCodeInput;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nextButton = (Button) findViewById(R.id.login_next_button);
        verificationButton = (Button) findViewById(R.id.login_verification_button);
        verificationCodeInput = (EditText) findViewById(R.id.login_verification_input);
        phoneInput = (EditText) findViewById(R.id.login_phone_input);
        tv2 = (TextView) findViewById(R.id.tv2);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextButton.setVisibility(View.INVISIBLE);
                phoneInput.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                verificationButton.setVisibility(View.VISIBLE);
                verificationCodeInput.setVisibility(View.VISIBLE);
            }
        });
    }
}