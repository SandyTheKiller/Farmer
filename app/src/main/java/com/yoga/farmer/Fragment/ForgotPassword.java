package com.yoga.farmer.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.yoga.farmer.R;

import static android.content.ContentValues.TAG;

public class ForgotPassword extends Activity implements View.OnClickListener {
    EditText email;
    Button buttonSend;
   /* Retrofit retrofit;
    AndroidUtils androidUtils;
    ApiServices apiServices;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);
        email = (EditText) findViewById(R.id.edt_email);
        buttonSend = (Button) findViewById(R.id.btn_send_pass);
       buttonSend.setOnClickListener( this);

    }

/*

    private void forgotpassword() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Sending Message...");
        progressDialog.show();

        final String email1 = email.getText().toString().trim();
        androidUtils = new AndroidUtils(getApplicationContext());
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(androidUtils.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        apiServices = retrofit.create(ApiServices.class);
        Call<DeleteData> call = apiServices.forgotpassword(email1);
        call.enqueue(new Callback<DeleteData>() {
            @Override
            public void onResponse(Call<DeleteData> call, retrofit2.Response<DeleteData> response) {
                progressDialog.dismiss();
                *//*Log.e("response", "" + response);
                Intent intent=new Intent(context,AdminActivity.class);
                ((Activity)context).finish();
                context.startActivity(intent);*//*
                email.setText("");
                 Toast.makeText(getApplicationContext(), "password send on your email ", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<DeleteData> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }*/

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_send_pass:
                forgot();
                break;
        }
    }
    public void forgot() {
        Log.d(TAG, "Signup");

        if (validate() == false) {
            onSignupFailed();
            return;
        }

       // forgotpassword();

    }
    public void onSignupFailed() {
       // Toast.makeText(this, "Registration failed", Toast.LENGTH_LONG).show();

        buttonSend.setEnabled(true);
    }
    public boolean validate() {
        boolean valid = true;
        String email1 =email.getText().toString();
        if (email1.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email1).matches()) {
            email.setError("enter a valid email address");
            valid = false;
        } else {
            email.setError(null);
        }
        return valid;
    }
}

