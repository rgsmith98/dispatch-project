package com.example.dispatchproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Context context = this;
    TextView signuptextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signuptextview = findViewById(R.id.signuptextview);

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
    }
}
