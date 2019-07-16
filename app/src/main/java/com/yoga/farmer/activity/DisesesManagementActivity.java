package com.yoga.farmer.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;
import com.yoga.farmer.R;

public class DisesesManagementActivity extends AppCompatActivity {
    Toolbar toolbar;
    String[] Farm = {"Shivar", "Maal-Raan", "Mava"};
    String[] Crop= {"SugarCane","Corn"};
    String[] Disease= {"Mava","White-Mava","Black-Mava"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseses_management);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.Rog);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, Farm);
        MaterialBetterSpinner materialDesignSpinner = (MaterialBetterSpinner)
                findViewById(R.id.choose_farm);
        materialDesignSpinner.setAdapter(arrayAdapter);

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, Crop);
        MaterialBetterSpinner materialDesignSpinner1= (MaterialBetterSpinner)
                findViewById(R.id.choose_crop);
        materialDesignSpinner1.setAdapter(arrayAdapter1);

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, Disease);
        MaterialBetterSpinner materialDesignSpinner2= (MaterialBetterSpinner)
                findViewById(R.id.choose_disase);
        materialDesignSpinner2.setAdapter(arrayAdapter2);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                overridePendingTransition(R.anim.enter, R.anim.exit);
                break;

            default:
                return super.onOptionsItemSelected(menuItem);
        }
        return true;
    }
}
