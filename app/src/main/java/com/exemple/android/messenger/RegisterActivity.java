package com.exemple.android.messenger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private Button loginBtn, registerBtn;
    private EditText emailET, passwordED;
    private TextView changeTV;
    ProgressDialog loadingBar;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loginBtn = (Button) findViewById(R. id.login_button);
        registerBtn = (Button) findViewById(R. id.register_button);
        emailET = (EditText) findViewById(R. id.email_input);
        passwordED = (EditText) findViewById(R. id.password_input);
        changeTV = (TextView) findViewById(R. id.changeTV);

        loadingBar = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();

        changeTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTV.setVisibility(View.INVISIBLE);
                registerBtn.setVisibility(View.INVISIBLE);
                loginBtn.setVisibility(View.VISIBLE);
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAccount();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInAccount();
            }
        });
    }

    private void signInAccount() {
        String email = emailET.getText().toString();
        String password = passwordED.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Заполните поле email", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Заполните поле пароль", Toast.LENGTH_SHORT).show();
        }
        else {
            loadingBar.setTitle("Вход в аккаунт");
            loadingBar.setMessage("Пожалуйста, подождите");
            loadingBar.setCanceledOnTouchOutside(true);
            loadingBar.show();

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        loadingBar.dismiss();
                        Toast.makeText(RegisterActivity.this, "Успешный вход", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        String massage = task.getException().toString();
                        Toast.makeText(RegisterActivity.this, "Ошибка" + massage, Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

    }

    private void createAccount() {
        String email = emailET.getText().toString();
        String password = passwordED.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Заполните поле email", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Заполните поле пароль", Toast.LENGTH_SHORT).show();
        }
        else {
            loadingBar.setTitle("Создание аккаунта");
            loadingBar.setMessage("Пожалуйста, подождите");
            loadingBar.setCanceledOnTouchOutside(true);
            loadingBar.show();

            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        loadingBar.dismiss();
                        Toast.makeText(RegisterActivity.this, "Успешная регистрация", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        String massage = task.getException().toString();
                        Toast.makeText(RegisterActivity.this, "Ошибка" + massage, Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
    }
}