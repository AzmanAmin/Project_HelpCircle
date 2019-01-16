package com.example.asus.demoapplication;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class LogIn extends AppCompatActivity {

    private Button btnSignIn,btnSignUp;

    private TextInputLayout textInputEmail, textInputPassword;

    private TextView here;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        btnSignIn = (Button) findViewById(R.id.btn_sign_in);
        here = (TextView) findViewById(R.id.here);
        btnSignIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
        here.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openSignUp();
            }
        });

        textInputEmail = findViewById(R.id.text_email);
        textInputPassword = findViewById(R.id.text_password);

    }

        public void openSignUp(){
            Intent intent = new Intent(this, SignUp.class);
            startActivity(intent);
    }
    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
