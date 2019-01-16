package com.example.asus.demoapplication;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class SignUp extends AppCompatActivity {

    private Button btn_register;
    private TextInputLayout name, email, phone, pass, con_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openLogIn();
            }
        });

        name = findViewById(R.id.text_name);
        email = findViewById(R.id.text_email);
        phone = findViewById(R.id.text_phone);
        pass = findViewById(R.id.text_password);
        con_pass = findViewById(R.id.text_con_password);

    }
    public void openLogIn(){
        Intent intent = new Intent(this, LogIn.class);
        startActivity(intent);
    }
}
