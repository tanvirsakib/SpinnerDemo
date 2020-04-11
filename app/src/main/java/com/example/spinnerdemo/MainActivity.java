package com.example.spinnerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] countryNames;
    String[] population;
    private Spinner spinner;
    private boolean isFirstSelected = true;

    int[] flags = {R.drawable.ban_icon,R.drawable.pak_icon,R.drawable.india_icon,R.drawable.aus_icon,
                R.drawable.nz_icon,R.drawable.eng_icon,R.drawable.sf_icon,R.drawable.wi_icon,
                R.drawable.afg_icon,R.drawable.sri_icon,R.drawable.ire_icon,R.drawable.zim_icon};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryNames = getResources().getStringArray(R.array.country_name);
        population = getResources().getStringArray(R.array.population);

        spinner = findViewById(R.id.spinnerID);

        CustomAdapter customAdapter = new CustomAdapter(countryNames,population,flags,MainActivity.this);
        spinner.setAdapter(customAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (isFirstSelected==true){
                    isFirstSelected = false;
                }
                else {
                    Toast.makeText(getApplicationContext(),countryNames[position]+"is selected",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
