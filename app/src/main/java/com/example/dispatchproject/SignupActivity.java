package com.example.dispatchproject;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class SignupActivity extends AppCompatActivity {

    //Account Type Spinner
    //Spinner accountType;
    MaterialBetterSpinner accountType;

    //All Input Fields
    EditText etusername;
    EditText etemail;
    EditText etpassword;

    Context context = this;

    Button btnRegister;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnRegister = findViewById(R.id.btnRegister);

        //Initialize all Input Fields
        etusername = findViewById(R.id.usernameInput);
        etemail = findViewById(R.id.emailInput);
        etpassword = findViewById(R.id.passwordInput);

        /**
         => Initialize Account Type Spinner and Set Data into it
         --------------------------------------------------------
        **/

               //accountType = findViewById(R.id.registerType);
                accountType = (MaterialBetterSpinner) findViewById(R.id.registerType);

                accountType.setFocusable(true);
                accountType.setFocusableInTouchMode(true);

                //Set Data in Array For Account Type
                String[] accontTypeValues = { "Select Account Type", "Production", "Supply", "Quality", "Dispatch" };

                //Set Data in Adapter
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.layout.spinner_layout, accontTypeValues);

                //By Default Select First Value
                accountType.setSelection(0);

                //Set Adapter in Spinner
                accountType.setAdapter(adapter);
        /**
         ------------------------------------------------
        **/







        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SetValidation
                String spaccountTypeVal = accountType.getText().toString().trim();
                String etusernameval = etusername.getText().toString().trim();
                String etemailval = etemail.getText().toString().trim();
                String etpasswordval = etpassword.getText().toString().trim();

                if(spaccountTypeVal.equals("Select Account Type") || etusernameval.equals("") || etemailval.equals("") || etpasswordval.equals(""))
                {
                    if(spaccountTypeVal.equals("Select Account Type"))
                    {
                        accountType.setFocusable(true);
                        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Account Type is Required", Snackbar.LENGTH_LONG).setActionTextColor(Color.RED);
                        snackbar.show();
                    }
                    if(etusernameval.equals(""))
                    {
                        etusername.setError("Username is Required");
                        etusername.setFocusable(true);
                    }
                    if(etemailval.equals(""))
                    {
                        etemail.setError("Email is Required");
                        etemail.setFocusable(true);
                    }
                    if(etpasswordval.equals(""))
                    {
                        etpassword.setError("Password is Required");
                        etpassword.setFocusable(true);
                    }
                }
                else
                {
                    Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Register Successfully", Snackbar.LENGTH_LONG).setActionTextColor(Color.GREEN);
                    snackbar.show();
                }
            }
        });
    }



    //Hide Keyboard on outside touch
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }
}
