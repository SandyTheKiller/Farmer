package com.yoga.farmer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.yoga.farmer.activity.DesFarmActivity;

public class FarmTips extends AppCompatActivity {
    Toolbar toolbar;
    private CardView cardFarm;
    LinearLayout linearFarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farm_tips);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.farm_tips);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        linearFarm=(LinearLayout) findViewById(R.id.lyt_parent);
        Log.v("clicghj","clicvk");
        linearFarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cardFarm=new Intent(getApplicationContext(),DesFarmActivity.class);
                Log.v("clic","click");
                startActivity(cardFarm);
            }
        });
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
