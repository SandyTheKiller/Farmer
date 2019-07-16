package com.yoga.farmer.Fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yoga.farmer.AndroidUtils;
import com.yoga.farmer.ApiServices;
import com.yoga.farmer.MainActivity;
import com.yoga.farmer.R;
import com.yoga.farmer.SharedPrefManager;
import com.yoga.farmer.model.logindata.LoginData;
import com.yoga.farmer.net.respose.ResLogin;
import com.yoga.farmer.net.retrofit.CallGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;


public class LoginFragment extends Fragment implements View.OnClickListener {

    String BASE_URL1="http://pradipawar123.000webhostapp.com/";
    Button buttonLogin, buttonRegister;
   /* Retrofit retrofit;
    AndroidUtils androidUtils;
    ApiServices apiServices;*/
    long back_pressed = 0;
    Toast toast;
    Context context;
    String register;
    private EditText et_email1, et_password1;
    CheckBox mCbShowPwd;
    private TextView tv_forgot;
    private ProgressBar progress;
    Retrofit retrofit;
    AndroidUtils androidUtils;
    ApiServices apiServices;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.login_fragment, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {


        buttonLogin = view.findViewById(R.id.btn_login);
        buttonRegister = view.findViewById(R.id.btn_register);
        tv_forgot = view.findViewById(R.id.txt_forgot);
        et_email1 = view.findViewById(R.id.et_email);
        et_password1 = view.findViewById(R.id.et_pass);
        tv_forgot= view.findViewById(R.id.txt_forgot);
        mCbShowPwd = view.findViewById(R.id.cbShowPwd);

        tv_forgot.setOnClickListener(this);
        buttonLogin.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);
        tv_forgot.setOnClickListener(this);

        mCbShowPwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // checkbox status is changed from uncheck to checked.
                if (!isChecked) {
                    // show password
                    et_password1.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else
                    {
                    // hide password
                    et_password1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_login:

                //CheckValidate();

                // loginProcess();
                Intent homeFragment=new Intent(getActivity(), MainActivity.class);
                startActivity(homeFragment);
                break;

            case R.id.txt_forgot:
            Intent intent=new Intent(getActivity(), ForgotPassword.class);
            startActivity(intent);
                break;

            case R.id.btn_register:
                goToRegister();

                break;
        }
    }

    public void loginProcess(){
        final ProgressDialog progressDialog=new ProgressDialog(getActivity());
        progressDialog.setMessage("Login...");
        progressDialog.show();
        progressDialog.setCancelable(false);

        final String Mobile=et_email1.getText().toString().trim();
        final String Password=et_password1.getText().toString();

        CallGenerator.login("9049558657","password").enqueue(new Callback<ResLogin>() {
            @Override
            public void onResponse(Call<ResLogin> call, Response<ResLogin> response) {
                progressDialog.dismiss();
                try {
                    if (response.code()== 200) {
                        Log.v("Email Is", Mobile);
                        Log.v("Password Is", Password);
                        //Log.d("onResponse", "res " + response.code());
                        Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    } else {
                        Toast.makeText(getActivity(), response.errorBody().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e)
                {
                    e.getMessage();
                    Log.d("FailedCause","e"+e);
                }
            }

            @Override
            public void onFailure(Call<ResLogin> call, Throwable t) {
                progressDialog.dismiss();
                Log.d("FailedCause","e"+t);
                Toast.makeText(getActivity(), "Invalid Login Credential", Toast.LENGTH_SHORT).show();
                System.out.println("onFailure");
                System.out.println(t.fillInStackTrace());
            }
        });
        /*Call<LoginData>response=apiServices.logincall1(Mobile,Password);
        response.enqueue(new Callback<LoginData>() {
            @Override
            public void onResponse(Call<LoginData> call, Response<LoginData> response) {
                progressDialog.dismiss();
                System.out.println("onResponse");
                System.out.println(response.body().toString());
                try {
                    if (response.code()== 200) {
                        Log.v("Email Is", Mobile);
                        Log.v("Password Is", Password);
                        //Log.d("onResponse", "res " + response.code());
                        Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        SharedPrefManager.getInstance(getActivity()).userLogin(response.body().getResponse());
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    } else {
                        Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e)
                {
                    e.getMessage();
                    Log.d("FailedCause","e"+e);
                }
            }
            @Override
            public void onFailure(Call<LoginData> call, Throwable t) {
                progressDialog.dismiss();
                Log.d("FailedCause","e"+t);
                Toast.makeText(getActivity(), "Invalid Login Credential", Toast.LENGTH_SHORT).show();
                System.out.println("onFailure");
                System.out.println(t.fillInStackTrace());
            }
        });*/

    }

    @SuppressLint("LongLogTag")
    public void CheckValidate() {
        Log.d(TAG, "message");

        /*if (!validatePhone() && !validatePassword()) {
            onMessageFailed();
            return;
        }*/
        loginProcess();

    }


    private void onMessageFailed() {
        //  Toast.makeText(getActivity(), "Check Field", Toast.LENGTH_LONG).show();

        buttonLogin.setEnabled(true);
    }

    public boolean validate() {
       // boolean valid = true;
        String email = et_email1.getText().toString();
        String password = et_password1.getText().toString();

        if (email.isEmpty() || password.length() < 4 || password.length() > 10) {
            et_email1.setError("Invalid mobile no");
            return false;
        } else {
            et_email1.setError(null);
        }


        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            et_password1.setError("between 4 and 10 alphanumeric characters");
            return false;
        } else {
            et_password1.setError(null);
        }
        return true;
    }

    private boolean validatePhone() {
        String phone = et_email1.getText().toString().trim();
        if (TextUtils.isEmpty(phone) || !Patterns.PHONE.matcher(phone).matches()) {
            et_email1.setError("! Invalid Phone No");
            return false;
        } else {
            et_email1.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String password = et_password1.getText().toString();
        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            et_password1.setError("between 4 and 10 alphanumeric characters");
            return false;
        }
        return true;

    }

    private void goToRegister() {

        Fragment register = new RegisterFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame, register);
        ft.commit();
    }

}
