package com.example.schoolproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    Button mButtonLogin;
    EditText mTextEmail;
    EditText mTextPassword;
    ProgressBar progressBar;
    FirebaseAuth fAuth;
    ImageView img;
    TextView ForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login2 );
        mButtonLogin = (Button) findViewById(R.id.login);
        mTextEmail = (EditText) findViewById(R.id.txt_email);
        mTextPassword = (EditText) findViewById(R.id.txt_password);
        ForgotPassword = findViewById(R.id.forgotPassword);
        img = (ImageView) findViewById(R.id.GoBack);

        ForgotPassword.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent next = new Intent(LoginActivity.this, ForgetPassword.class);
                startActivity(next);
            }
        } );

        mButtonLogin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mTextEmail.getText().toString().trim();
                String password = mTextPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){

                    mTextEmail.setError("Email required");
                    return;
                }
                if(TextUtils.isEmpty(password)){

                   mTextPassword.setError("password is required");
                   return;
                }

                if(password.length() < 4){

                    mTextPassword.setError("minimum should be 8 characters");
                    return;
                }
                progressBar.setVisibility(view.VISIBLE);

                //authenticate the user

            }

        } );

        }

    public void goBack(View view) {

        Intent i = new Intent(LoginActivity.this, LoginRegistration.class);
        startActivity(i);
    }

}