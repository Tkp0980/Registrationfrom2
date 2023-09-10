package com.example.registrationfrom2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    private FloatingActionButton fab;
    private LinearLayout linearLayoutRoot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         //finding root layout
          linearLayoutRoot = findViewById(R.id.linearLayoutRoot);
        //floating button declaration
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);
        //spinner code form hereee
        Spinner spinnerDzongkhag = findViewById(R.id.spinnerDzongkhag);
        Spinner spinnerGewog = findViewById(R.id.spinnerGewog);
        Spinner spinnerCountry = findViewById(R.id.spinnerCountry);


        ArrayAdapter<CharSequence> dzongkhagAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.dzongkhag_array,
                android.R.layout.simple_spinner_item
        );
        ArrayAdapter<CharSequence> gewogAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.gewog_array,
                android.R.layout.simple_spinner_item
        );
        ArrayAdapter<CharSequence> countryAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.country_array,
                android.R.layout.simple_spinner_item
        );


        dzongkhagAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gewogAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinnerDzongkhag.setAdapter(dzongkhagAdapter);
        spinnerGewog.setAdapter(gewogAdapter);
        spinnerCountry.setAdapter(countryAdapter);
       //spinner code ends
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.fab) {
            showAlertDialog();
        }
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Submit")
                .setMessage("Are you sure you want to submit?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    showToast("Submitted!");
                })
                .setNegativeButton("No", null)
                .show();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
   //Making the screen responsive
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Check the new device orientation
        int orientation = newConfig.orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            linearLayoutRoot.setOrientation(LinearLayout.HORIZONTAL);
        } else if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            linearLayoutRoot.setOrientation(LinearLayout.VERTICAL);
        }
    }
}
