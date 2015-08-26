package ru.darvell.meetingclient;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends AppCompatActivity {

    private EditText emailText;
    private EditText passwText;
    private Button signinBtn;
    private Button signupBtn;

    private ProgressDialog pDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        pDialog = new ProgressDialog(this);
//        pDialog.show();

        emailText = (EditText) findViewById(R.id.emailTextIn);
        passwText = (EditText) findViewById(R.id.passwTextIn);
        signinBtn = (Button) findViewById(R.id.btn_signin);
        signupBtn = (Button) findViewById(R.id.btn_signup);

        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });

    }

    private void openMain(){
        startActivity(new Intent(this, MainActivity.class));
    }



}
