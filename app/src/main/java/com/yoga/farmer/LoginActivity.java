package com.yoga.farmer;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.yoga.farmer.Fragment.LoginFragment;

public class LoginActivity extends AppCompatActivity {
    long back_pressed=0;
    Toast toast;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (SharedPrefManager.getInstance(getApplicationContext()).isLoggedIn()) {
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        initFragment();
    }

    private void initFragment() {
        Fragment fragment = new Fragment();

        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            fragment = new LoginFragment();
        }
        /*else {
            Intent intent=new Intent(this,ReportForm.class);
            startActivity(intent);
        }*/
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame,fragment);
        ft.commit();
    }
    @Override
    public void onBackPressed() {

        if (back_pressed + 2000 > System.currentTimeMillis()) {
            // need to cancel the toast here
            toast.cancel();
            // code for exit
            intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            toast = Toast.makeText(getBaseContext(), "Press once again to exit!", Toast.LENGTH_SHORT);
            toast.show();
        }
        back_pressed = System.currentTimeMillis();
    }
}
