package com.yoga.farmer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.yoga.farmer.activity.DesSuccessActivity;

public class SuccessStoryActivity extends AppCompatActivity {
    Toolbar toolbar;
    LinearLayout linearSuccess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_story);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.success);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        linearSuccess=findViewById(R.id.lyt_success);
        linearSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cardSuccess=new Intent(getApplication(),DesSuccessActivity.class);
                Log.v("clic","click");
                startActivity(cardSuccess);
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
