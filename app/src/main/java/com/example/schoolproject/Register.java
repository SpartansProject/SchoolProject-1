package com.example.schoolproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    Button nextBtn;
    EditText mEmail;
    EditText mTextFirstName;
    TextView mTitleText;
    EditText mTextLastName;
    FirebaseAuth fAuth;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register );

        //hooks
        nextBtn =  findViewById(R.id.next_register);
        mEmail = findViewById(R.id.txt_email);
        mTitleText = findViewById(R.id.title_text);
        mTextFirstName =  findViewById(R.id.txt_firstName);
        mTextLastName = findViewById(R.id.txt_lastName);
        mTextPassword = findViewById(R.id.txt_password);
        mTextCnfPassword = findViewById(R.id.txt_cnf_password);
        backBtn = findViewById(R.id.back_arrow);

        fAuth = FirebaseAuth.getInstance();

        nextBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();
                String password = mTextPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){

                    mEmail.setError("Email required");
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

                //registering the user using firebase

            }
        } );

    }


    public void goBack(View view) {

        Intent ic = new Intent( Register.this, LoginRegistration.class);
        startActivity(ic);
    }

    public void callNextRegister(View view) {

        Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);

        //adding transitions
        Pair[] pairs = new Pair[3];

        pairs[0] = new Pair<View,String>(backBtn, "transition_back_arrow_btn");
        pairs[1] = new Pair<View,String>(mTitleText, "transition_title_text");
        pairs[2] = new Pair<View,String>(nextBtn, "transition_next_btn");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Register.this, pairs);
            startActivity(intent, options.toBundle());
        }
        else{

            startActivity( intent );
        }

    }
}