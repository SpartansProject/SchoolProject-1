package com.example.schoolproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    Button nextBtn;
    TextView mTitleText;
    ImageView backBtn;
    RadioButton Male, Female;
    DatePicker date;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sign_up );

        //hooks
       nextBtn = findViewById(R.id.next_register);
       mTitleText = findViewById(R.id.title_text);
       backBtn = findViewById(R.id.back_arrow);
    }


    public void callNextRegister(View view) {

        Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);

        //adding transitions
        Pair[] pairs = new Pair[3];

        pairs[0] = new Pair<View,String>(backBtn, "transition_back_arrow_btn");
        pairs[1] = new Pair<View,String>(mTitleText, "transition_title_text");
        pairs[2] = new Pair<View,String>(nextBtn, "transition_next_btn");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUpActivity.this, pairs);
            startActivity(intent, options.toBundle());
        }
        else{

            startActivity( intent );
        }
    }
}