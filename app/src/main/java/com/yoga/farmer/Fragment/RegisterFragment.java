package com.yoga.farmer.Fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;
import com.yoga.farmer.AndroidUtils;
import com.yoga.farmer.ApiServices;
import com.yoga.farmer.R;
import com.yoga.farmer.adapter.CustomSpinnerAdapter;
import com.yoga.farmer.adapter.SpinnerDistrictAdapter;
import com.yoga.farmer.adapter.SpinnerStateAdapter;
import com.yoga.farmer.adapter.SpinnerTalukaAdapter;
import com.yoga.farmer.adapter.SpinnerVillageAdapter;
import com.yoga.farmer.dialog.ProgressDialogFragment;
import com.yoga.farmer.net.respose.ResCrop;
import com.yoga.farmer.net.respose.ResDistrict;
import com.yoga.farmer.net.respose.ResMessage;
import com.yoga.farmer.net.respose.ResSpnEntity;
import com.yoga.farmer.net.respose.ResState;
import com.yoga.farmer.net.respose.ResTaluka;
import com.yoga.farmer.net.respose.ResVillage;
import com.yoga.farmer.net.retrofit.CallGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.content.ContentValues.TAG;
import static com.yoga.farmer.net.retrofit.CallGenerator.getTaluka;

public class RegisterFragment extends Fragment implements View.OnClickListener {
    private EditText et_name, et_mobile, et_email1, et_password1, et_c_password;
    private int stateId=0;
    private int districtId = 0;
    private int talukaId = 0;
    private int villageId=0;

    private static final String DIALOG_PROGRESS = "SignUpActivity.Dialog.Progress";
    Button buttonRegister;
    TextView tvLogin;
    private Spinner spnState, spnDistrict, spnTaluka, spnVillage;
    private List<ResState.StateEntity> lsState;
    private List<ResDistrict.DistrictEntity> lsDistrict;
    private List<ResTaluka.Entity> lsTaluka;
    private List<ResVillage.VillageEntity> lsVillage;
    private List<ResSpnEntity> listSpnState, listSpnVillage, listSpnDistrict, listSpnTaluka;

    private ProgressBar progress;
    long back_pressed = 0;
    Toast toast;
    String register;
    private ProgressDialogFragment progressDialog;
    String[] Country = {"INDIA"};
    String[] State = {"Maharashtra", "UttarPradesh", "Karanatka"};
    String[] District = {"Osmanabad", "Beed", "Nanded", "Latur"};
    String[] Taluka = {"Tuljapur", "Ausa", "Kej"};
    String[] Village = {"Wadi", "Ghatangri", "Khanapur", "Bemebli"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.register_fragment, container, false);
        initViews(view);
        setView(view);
        return view;
    }

    private void setView(View view) {
        setSpinnerFirstValues();
        getState();
        spnState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getDistrict(lsState.get(position).getId());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spnDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getTaluka(lsDistrict.get(position).getId());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spnTaluka.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getVillage(lsTaluka.get(position).getId());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spnVillage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              //  getVillage(lsVillage.get(position).getId());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initViews(View view) {
        et_name = (EditText) view.findViewById(R.id.et_name);
        et_mobile = (EditText) view.findViewById(R.id.et_mobile);
        et_password1 = (EditText) view.findViewById(R.id.et_pass1);
        et_c_password = (EditText) view.findViewById(R.id.et_c_pass);

        buttonRegister = (Button) view.findViewById(R.id.btn_reg);
        tvLogin = (TextView) view.findViewById(R.id.tvLogin);
        spnState = (Spinner) view.findViewById(R.id.spnState);
        spnDistrict = (Spinner) view.findViewById(R.id.spnDistrict);
        spnTaluka = (Spinner) view.findViewById(R.id.spnTaluka);
        spnVillage = (Spinner) view.findViewById(R.id.spnVillage);
        tvLogin.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_reg:
                boolean valid =
                        validateFirstName() &&
                                validatePhone() && validatePassword() && validateAddress();

                if (valid)
                    signup();

                /*Toast.makeText(getActivity(),"Register successful",Toast.LENGTH_SHORT).show();
                Fragment login = new LoginFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_frame, login);
                ft.commit();*/
                break;

            case R.id.tvLogin:
                goToLogin();
                break;

        }
    }

    private boolean validateAddress() {
        stateId = spnState.getSelectedItemPosition();
        districtId = spnDistrict.getSelectedItemPosition();
        talukaId = spnTaluka.getSelectedItemPosition();
        villageId = spnVillage.getSelectedItemPosition();

        if (stateId==0) {
            Toast.makeText(getActivity(),"Select State",Toast.LENGTH_LONG).show();
            return false;
        } else if (districtId==0) {
            Toast.makeText(getActivity(),"Select District",Toast.LENGTH_LONG).show();
            return false;
        } else if (talukaId==0)
        {
            Toast.makeText(getActivity(),"Select Taluka",Toast.LENGTH_LONG).show();
            return false;
        } else if (villageId==0)
        {
            Toast.makeText(getActivity(),"Select Village",Toast.LENGTH_LONG).show();
            return false;
        } else
        {
            return true;
        }
    }

    private boolean validatePassword() {
        String password = et_password1.getText().toString().trim();
        String confirmPassword = et_c_password.getText().toString().trim();
        if (TextUtils.isEmpty(password) || password.length()<5) {
            et_password1.setError("! Password at least 5 character..");
            return false;
        } else if (TextUtils.isEmpty(password) || !confirmPassword.equals(password)) {
            et_c_password.setError("! Password mismatch ..");
            return false;
        }  else
            {
            et_mobile.setError(null);
            return true;
        }
    }

    private void getState() {
        CallGenerator.getState().enqueue(new Callback<ResState>() {
            @Override
            public void onResponse(Call<ResState> call, Response<ResState> response) {
                if (response.isSuccessful()) {
                    ResState resState = response.body();
                    lsState = resState.getList();
                    if (lsState.isEmpty()) {

                    } else {
                        //spnVariaty.setAdapter(lsResStates);
                        SpinnerStateAdapter adapterState = new SpinnerStateAdapter(getActivity(), lsState);
                        spnState.setAdapter(adapterState);

                    }
                }
            }

            @Override
            public void onFailure(Call<ResState> call, Throwable t) {

            }
        });
    }

    private void getDistrict(long id) {
        CallGenerator.getDistrict(id).enqueue(new Callback<ResDistrict>() {
            @Override
            public void onResponse(Call<ResDistrict> call, Response<ResDistrict> response) {
                if (response.isSuccessful()) {
                    ResDistrict resDistrict = response.body();
                    lsDistrict = resDistrict.getList();
                    if (lsDistrict.isEmpty()) {

                    } else {
                        //spnVariaty.setAdapter(lsResStates);
                        SpinnerDistrictAdapter adapterState = new SpinnerDistrictAdapter(getActivity(), lsDistrict);
                        spnDistrict.setAdapter(adapterState);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResDistrict> call, Throwable t) {

            }
        });
    }

    private void getTaluka(long id) {
        CallGenerator.getTaluka(id).enqueue(new Callback<ResTaluka>() {
            @Override
            public void onResponse(Call<ResTaluka> call, Response<ResTaluka> response) {
                if (response.isSuccessful()) {
                    ResTaluka resTaluka= response.body();
                    lsTaluka = resTaluka.getList();
                    if (lsTaluka.isEmpty()) {

                    } else {
                        //spnVariaty.setAdapter(lsResStates);
                        SpinnerTalukaAdapter adapterState = new SpinnerTalukaAdapter(getActivity(), lsTaluka);
                        spnTaluka.setAdapter(adapterState);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResTaluka> call, Throwable t) {

            }
        });
    }

    private void    getVillage(long id) {
        CallGenerator.getVillage(id).enqueue(new Callback<ResVillage>() {
            @Override
            public void onResponse(Call<ResVillage> call, Response<ResVillage> response) {
                if (response.isSuccessful()) {
                    ResVillage resVillage = response.body();
                    lsVillage = resVillage.getList();
                    if (lsVillage.isEmpty()) {

                    } else {
                        //spnVariaty.setAdapter(lsResStates);
                        SpinnerVillageAdapter adapterState = new SpinnerVillageAdapter(getActivity(), lsVillage);
                        spnVillage.setAdapter(adapterState);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResVillage> call, Throwable t) {

            }
        });
    }

    /*   private void registerProcess() {

        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Signing Up...");

        final String user_name = et_name.getText().toString().trim();
        final String mobile_no = et_mobile.getText().toString().trim();
        final String password = et_password1.getText().toString();
       *//* final String country = et_country.getText().toString().trim();
        final String state = et_state.getText().toString().trim();
        final String district = et_district.getText().toString().trim();
        final String taluka = et_taluka.getText().toString().trim();
        final String village = et_village.getText().toString().trim();*//*
        Log.v("checking point1","check1");

        if (AndroidUtils.hasConnection(getActivity())) {
            progressDialog.show();
            progressDialog.setCancelable(false);
            androidUtils = new AndroidUtils(getActivity());
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            Log.v("checking point1","check1");
            retrofit = new Retrofit.Builder()
                    .baseUrl(AndroidUtils.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            apiServices = retrofit.create(ApiServices.class);
            Call<RegisterData> response = apiServices.registercall(user_name, mobile_no, password,country, state, district, taluka, village);

            response.enqueue(new Callback<RegisterData>() {
                @Override
                public void onResponse(Call<RegisterData> call, Response<RegisterData> response) {
                    Log.d("onResponse", "" + response);
                    //hiding progress dialog

                        progressDialog.dismiss();

                        Log.d("res", "value");
                        et_name.setText("");
                        et_mobile.setText("");
                        et_c_password.setText("");
                        et_country.setText("");
                        et_state.setText("");
                        et_district.setText("");
                        et_taluka.setText("");
                        et_village.setText("");

                        Log.v("password",password);
                        Log.v("mobile",mobile_no);
                    //hiding progress dialog

                    Toast.makeText(getActivity(),"Register successful",Toast.LENGTH_SHORT).show();
                        Fragment login = new LoginFragment();
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.fragment_frame, login);
                        ft.commit();
                 *//*   Intent intent = new Intent(getActivity(), LoginFragment.class);
                    startActivity(intent);*//*
                    }

                @Override
                public void onFailure(Call<RegisterData> call, Throwable t) {
                    Log.d("msg", "" + t.getMessage());
                    // Log.d(Constants.TAG,"failed");
                    //  Snackbar.make(getView(), t.getLocalizedMessage(), Snackbar.LENGTH_LONG).show();
                }
            });
        }
    }*/
    public void signup() {
        // showProgressDialog();
        Log.d(TAG, "Signup");
        lsState.get(stateId).getId();
            final ProgressDialog progressDialog=new ProgressDialog(getActivity());
            progressDialog.setMessage("Login...");
            progressDialog.show();
            progressDialog.setCancelable(false);
        CallGenerator.signUp(et_name.getText().toString(), et_mobile.getText().toString(), et_password1.getText().toString(),
                lsState.get(stateId).getId(),lsState.get(stateId).getId(),lsState.get(stateId).getId(),lsState.get(stateId).getId()).enqueue(new Callback<ResMessage>() {
            @Override
            public void onResponse(Call<ResMessage> call, Response<ResMessage> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                        Toast.makeText(getActivity(), "Registration failed", Toast.LENGTH_LONG).show();
                        goToLogin();
                } else {
                    Toast.makeText(getActivity(), response.errorBody().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResMessage> call, Throwable t) {

            }
        });
/*
        if (validate() == false) {
            onSignupFailed();
            return;
        }*/

        //  registerProcess();

    }

   /* private void showProgressDialog() {
        progressDialog = ProgressDialogFragment.newInstance(null, "Wait...\n" + "");
            progressDialog.setCancelable(false);
        progressDialog.show(getFragmentManager(), DIALOG_PROGRESS);
    }*/

    private void hideProgressDialog() {
        try {
            progressDialog.dismiss();
        } catch (Exception e) {
            //
        }
    }

    public void onSignupSuccess() {
        buttonRegister.setEnabled(true);
        getActivity().setResult(Activity.RESULT_OK, null);
        getActivity().finish();

    }

    private boolean validateFirstName() {
        String name = et_name.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            et_name.setError("! Empty Name");
            return false;
        } else {
            et_name.setError(null);
            return true;
        }
    }


    /*private boolean validateEmail() {
        String email = etEmail.getText().toString().trim();
        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            tilEmail.setError("! Invalid Email");
            return false;
        } else {
            tilEmail.setError(null);
            return true;
        }
    }*/

    private boolean validatePhone() {
        String phone = et_mobile.getText().toString().trim();
        if (TextUtils.isEmpty(phone) || !Patterns.PHONE.matcher(phone).matches()) {
            et_mobile.setError("! Invalid Phone");
            return false;
        } else {
            et_mobile.setError(null);
            return true;
        }
    }


    public void onSignupFailed() {
        Toast.makeText(getActivity(), "Registration failed", Toast.LENGTH_LONG).show();

        buttonRegister.setEnabled(true);
    }
/*    public boolean validate() {
        boolean valid = true;

        String name1 = et_name.getText().toString();
        String mobile1=et_mobile.getText().toString();
        String password = et_password1.getText().toString();
        String reEnterPassword = et_c_password.getText().toString();
        String country = et_country.getText().toString();
        String state = et_state.getText().toString();
        String district = et_district.getText().toString();
        String taluka = et_taluka.getText().toString();
        String village = et_village.getText().toString();


        if (name1.isEmpty() || name1.length() < 3) {
            et_name.setError("at least 3 characters");
            valid = false;
        } else {
            et_name.setError(null);
        }
        if (mobile1.isEmpty() || mobile1.length() < 9) {
            et_mobile.setError("at least 10 number");
            valid = false;
        } else {
            et_mobile.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            et_password1.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            et_password1.setError(null);
        }

        if (reEnterPassword.isEmpty() || reEnterPassword.length() < 4 || reEnterPassword.length() > 10 || !(reEnterPassword.equals(password))) {
            et_c_password.setError("Password Do not match");
            valid = false;
        } else {
            et_c_password.setError(null);
        }
        if (country.isEmpty() || country.length() < 3) {
            et_country.setError("at least 3 characters");
            valid = false;
        } else {
            et_country.setError(null);
        }
        if (state.isEmpty() || state.length() < 3) {
            et_state.setError("at least 3 characters");
            valid = false;
        } else {
            et_state.setError(null);
        }
        if (district.isEmpty() || district.length() < 3) {
            et_district.setError("at least 3 characters");
            valid = false;
        } else {
            et_district.setError(null);
        }
        if (taluka.isEmpty() || taluka.length() < 3) {
            et_taluka.setError("at least 3 characters");
            valid = false;
        } else {
            et_taluka.setError(null);
        }
        if (village.isEmpty() || village.length() < 3) {
            et_village.setError("at least 3 characters");
            valid = false;
        } else {
            et_village.setError(null);
        }
        return valid;
    }*/

    private void setSpinnerFirstValues() {
        ResState.StateEntity stateEntity = null;
        ResDistrict.DistrictEntity districtEntity = null;
        ResTaluka.Entity talukaEntity = null;
        ResVillage.VillageEntity villageEntity = null;

        stateEntity.setId(0);
        stateEntity.setState_name("Select State");
        lsState.add(stateEntity);

        districtEntity.setDistrict_name("Select District");
        districtEntity.setId(0);
        lsDistrict.add(districtEntity);

        talukaEntity.setId(0);
        talukaEntity.setTaluka_name("Select Taluka");
        lsTaluka.add(talukaEntity);

        villageEntity.setId(0);
        villageEntity.setVillage_name("Select Village");
        lsVillage.add(villageEntity);

        SpinnerStateAdapter stateAdapter= new SpinnerStateAdapter(getActivity(),lsState);
        spnState.setAdapter(stateAdapter);

        SpinnerDistrictAdapter districtAdapter= new SpinnerDistrictAdapter(getActivity(),lsDistrict);
        spnState.setAdapter(districtAdapter);

        SpinnerTalukaAdapter talukaAdapter= new SpinnerTalukaAdapter(getActivity(),lsTaluka);
        spnState.setAdapter(talukaAdapter);

        SpinnerVillageAdapter villageAdapter= new SpinnerVillageAdapter(getActivity(),lsVillage);
        spnState.setAdapter(villageAdapter);
    }

    private void goToLogin() {

        Fragment login = new LoginFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame, login);
        ft.commit();
    }
}