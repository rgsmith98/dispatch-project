package com.example.dispatchproject;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    //Account Type Spinner
    Spinner accountType;
    Context context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        accountType = findViewById(R.id.registerType);

        //Set Data in Array For Account Type
        String[] accontTypeValues = { "Production", "Supply", "Quality", "Dispatch" };

        //Set Data in Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.layout.spinner_layout, accontTypeValues);

        accountType.setAdapter(adapter);
    }
}
