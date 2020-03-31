package com.example.dispatchproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {
    Context context = this;
    TextView signuptextview;
    Button btnLogin;

    EditText etusername;
    EditText etpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signuptextview = findViewById(R.id.signuptextview);
        btnLogin = findViewById(R.id.btnLogin);

        signuptextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Redirect to Signup Activity
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent signUpIntent = new Intent(LoginActivity.this, SignupActivity.class);
                        startActivity(signUpIntent);
                        overridePendingTransition(R.anim.slide_out_bottom, R.anim.slide_in_bottom);
                    }
                }, 100);
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etusername = findViewById(R.id.username);
                etpassword = findViewById(R.id.password);

                String usernameval = etusername.getText().toString().trim();
                String passwordval = etpassword.getText().toString().trim();

                if(usernameval.equals("") || passwordval.equals("")){
                    if(usernameval.equals("")) {
                        etusername.setError("Username is Required");
                        etusername.setFocusable(true);
                    }

                    if(passwordval.equals("")){
                        etpassword.setError("Password is Required");
                    }
                }else{
                    Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Login Button Click", Snackbar.LENGTH_LONG).setActionTextColor(Color.RED);
                    snackbar.show();
                }
            }
        });
    }
}
