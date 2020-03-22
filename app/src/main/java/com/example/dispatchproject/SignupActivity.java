package com.example.dispatchproject;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    //Account Type Spinner
    Spinner accountType;
    EditText emailAddress;
    Context context = this;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        /**
         => Initialize Account Type Spinner and Set Data into it
         --------------------------------------------------------
        **/

                accountType = findViewById(R.id.registerType);

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



        /**
            => Initialize Email Address Field
         ------------------------------------------------
        **/
                emailAddress = findViewById(R.id.emailInput);
        /**
         ------------------------------------------------
        **/
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
