package com.yoga.farmer.activity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;
import com.yoga.farmer.R;
import com.yoga.farmer.adapter.CustomSpinnerAdapter;
import com.yoga.farmer.adapter.VarientsSpinnerAdapter;
import com.yoga.farmer.dialog.ErrorDialogFragment;
import com.yoga.farmer.net.respose.ResCrop;
import com.yoga.farmer.net.respose.ResCropVariety;
import com.yoga.farmer.net.respose.ResMessage;
import com.yoga.farmer.net.respose.ResState;
import com.yoga.farmer.net.retrofit.CallGenerator;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Farm_Reg_Activity extends AppCompatActivity {

    private static final String DIALOG_ERROR = "Farm_Reg_Activity.Dialog.Error";
    private static final String LOG_TAG = "Farm_Reg_Activity";
    String[] Farm = {"Select Area", "Acers", "Gunta (R)", "Hecters"};
    String[] Crop = {"Select Crop", "Soyabean", "maka", "sugar-cane"};
    String[] Disease = {"Select Season", "Purv Hangami", "Hangami", "Aadsali", "Khodwa"};
    private EditText etNitrozen, etPhospher, etKtashium, etOtherName, etOther, etDatePlant, etSurye, spnSeseson,
            etArea, etFieldName, etSoilType,etPlotNo;
    private RadioButton rbIsWaterYes, rbIsWaterNo, rbSoilYes,rbSoilNo;
    private int isWaterYes, isWaterNo, soilYes,soilNo;
    private MaterialBetterSpinner spnAreaUnit;
    private Spinner spnVariaty,spnSubVariaty;
    private LinearLayout llCropDetails;
    private List<ResCrop.CropEntity> lsCropEntities;
    private List<ResCropVariety.CropEntity> lsCropVariety;
    private long cropId,crop_detail_id;
    private boolean spnflag=false;
    private Button btnFarmRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm__reg_);
        // spinner=(Spinner)findViewById(R.id.spinnerArea);
       /* ArrayList<String> list= new ArrayList<>();
        list.add("Select Area");
        list.add("Acers");
        list.add("Gunta (R)");
        list.add("Hecters");*/
        intiView();
        getCrop();
        setView();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, Farm);
        MaterialBetterSpinner materialDesignSpinner = (MaterialBetterSpinner)
                findViewById(R.id.spnAreaUnit);
        materialDesignSpinner.setAdapter(arrayAdapter);
       /* ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,list);
        spinner.setAdapter(adapter);*/

        /*ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, Crop);
        MaterialBetterSpinner materialDesignSpinner1 = (MaterialBetterSpinner)
                findViewById(R.id.spnVariaty);*/
       /* materialDesignSpinner1.setAdapter(arrayAdapter1);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, Disease);*/

/*
     materialDesignSpinner2.setAdapter(arrayAdapter2);
*/

      /*  spinner2=(Spinner)findViewById(R.id.spinnerSeseson);
        ArrayList<String> list2= new ArrayList<>();
        list2.add("Select Season");
        list2.add("Purv Hangami");
        list2.add("Hangami");
        list2.add("Aadsali ");
        list2.add("Khodwa ");
        ArrayAdapter<String>adapter2=new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,list2);
        spinner2.setAdapter(adapter2);*/
    }
    private void intiView() {
        etNitrozen = (EditText) findViewById(R.id.etNitrozen);
        etPhospher = (EditText) findViewById(R.id.etPhospher);
        etKtashium = (EditText) findViewById(R.id.etKtashium);
        etOtherName = (EditText) findViewById(R.id.etOtherName);
        etOther = (EditText) findViewById(R.id.etOther);
        etDatePlant = (EditText) findViewById(R.id.etDatePlant);
        etPlotNo = (EditText) findViewById(R.id.etPlotNo);
        etSurye = (EditText) findViewById(R.id.etSurye);
        spnSeseson = (EditText) findViewById(R.id.spnSeseson);
        etArea = (EditText) findViewById(R.id.etArea);
        etFieldName = (EditText) findViewById(R.id.etFieldName);
        etSoilType = (EditText) findViewById(R.id.etSoilType);

        spnAreaUnit = (MaterialBetterSpinner) findViewById(R.id.spnAreaUnit);
        spnVariaty = (Spinner) findViewById(R.id.spnVariaty);
        spnSubVariaty = (Spinner) findViewById(R.id.spnSubVariaty);
        rbIsWaterYes = (RadioButton) findViewById(R.id.rbIsWaterYes);
        rbIsWaterNo = (RadioButton) findViewById(R.id.rbIsWaterYes);
        rbSoilYes = (RadioButton) findViewById(R.id.rbSoilYes);
        rbSoilNo = (RadioButton) findViewById(R.id.rbSoilNo);
        llCropDetails = (LinearLayout) findViewById(R.id.llCropDetails);
        btnFarmRegister = (Button) findViewById(R.id.btnFarmRegister);
        TextWatcher tw = new TextWatcher() {
            private String current = "";
            private String ddmmyyyy = "DDMMYYYY";
            private Calendar cal = Calendar.getInstance();

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals(current)) {
                    String clean = s.toString().replaceAll("[^\\d.]|\\.", "");
                    String cleanC = current.replaceAll("[^\\d.]|\\.", "");

                    int cl = clean.length();
                    int sel = cl;
                    for (int i = 2; i <= cl && i < 6; i += 2) {
                        sel++;
                    }
                    //Fix for pressing delete next to a forward slash
                    if (clean.equals(cleanC)) sel--;

                    if (clean.length() < 8){
                        clean = clean + ddmmyyyy.substring(clean.length());
                    }else{
                        //This part makes sure that when we finish entering numbers
                        //the date is correct, fixing it otherwise
                        int day  = Integer.parseInt(clean.substring(0,2));
                        int mon  = Integer.parseInt(clean.substring(2,4));
                        int year = Integer.parseInt(clean.substring(4,8));

                        mon = mon < 1 ? 1 : mon > 12 ? 12 : mon;
                        cal.set(Calendar.MONTH, mon-1);
                        year = (year<1900)?1900:(year>2100)?2100:year;
                        cal.set(Calendar.YEAR, year);
                        // ^ first set year for the line below to work correctly
                        //with leap years - otherwise, date e.g. 29/02/2012
                        //would be automatically corrected to 28/02/2012

                        day = (day > cal.getActualMaximum(Calendar.DATE))? cal.getActualMaximum(Calendar.DATE):day;
                        clean = String.format("%02d%02d%02d",day, mon, year);
                    }

                    clean = String.format("%s/%s/%s", clean.substring(0, 2),
                            clean.substring(2, 4),
                            clean.substring(4, 8));

                    sel = sel < 0 ? 0 : sel;
                    current = clean;
                    etDatePlant.setText(current);
                    etDatePlant.setSelection(sel < current.length() ? sel : current.length());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
    };
        etDatePlant.addTextChangedListener(tw);


    }

    private void setView() {
        spnVariaty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spnflag)
                {
                    cropId= lsCropEntities.get(position).getId();
                    long langId = lsCropEntities.get(position).getLang_id();
                    // Toast.makeText(getContext(), "checkspnContest", Toast.LENGTH_SHORT).show();
                    getCropVarient(cropId,langId);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spnSubVariaty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spnflag)
                {
                    crop_detail_id = lsCropVariety.get(position).getCrop_detail_id();
                    long langId = lsCropEntities.get(position).getLang_id();
                    // Toast.makeText(getContext(), "checkspnContest", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnFarmRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateField() && validateOptions())
                {
                    callAddFarm();
                }
            }
        });
    }

    private void callAddFarm() {
        int sessionId=0;
        CallGenerator.registerFarm(etFieldName.getText().toString(),etArea.getText().toString(),cropId,crop_detail_id,etPlotNo.getText().toString(),sessionId,
                etSoilType.getText().toString(),isWaterYes,soilYes,etNitrozen.getText().toString(),etPhospher.getText().toString(),etKtashium.getText().toString(),
                etOtherName.getText().toString(),etOther.getText().toString(),etDatePlant.getText().toString(),etSurye.getText().toString())
                .enqueue(new Callback<ResMessage>() {
                    @Override
                    public void onResponse(Call<ResMessage> call, Response<ResMessage> response) {
                        if(response.isSuccessful())
                        {
                            ResMessage resMessage=response.body();
                            if(resMessage!=null)
                                Toast.makeText(getApplicationContext(), "@"+resMessage.getMessage() , Toast.LENGTH_SHORT).show();
                            //showErrorDialog(resMessage.getMessage());
                        }
                        else
                        {
                            ResMessage errorMessage = null;
                            try {
                                String errorRes = response.errorBody().string();

                                errorMessage = new GsonBuilder().create().fromJson(errorRes, ResMessage.class);
                                Toast.makeText(getApplicationContext(), "@"+errorMessage.getMessage() , Toast.LENGTH_SHORT).show();
                                showErrorDialog(errorMessage.getMessage());

                            } catch (IOException e) {
                                Log.e(LOG_TAG,"On Register : "+errorMessage.getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResMessage> call, Throwable t) {

                    }
                });
    }

    private boolean validateOptions() {

        if(rbIsWaterYes.isChecked())
            isWaterYes=1;
        else
            isWaterYes=0;
        if(rbSoilYes.isChecked())
            soilYes=1;
        else
            soilYes=0;
    return true;
    }

    private boolean validateField() {
        if(etArea.getText().toString().isEmpty())
        {
            etArea.setError("Invalid Area");
            return false;
        } else if(etFieldName.getText().toString().isEmpty())
        {
            etFieldName.setError("Invalid name");
            return false;
        }  else if(etSoilType.getText().toString().isEmpty())
        {
            etSoilType.setError("Invalid Soil type");
            return false;
        } else if(etNitrozen.getText().toString().isEmpty())
        {
            etNitrozen.setError("Invalid Nitrogen limit");
            return false;
        } else if(etPhospher.getText().toString().isEmpty())
        {
            etPhospher.setError("Invalid Phospher limit");
            return false;
        } else if(etKtashium.getText().toString().isEmpty())
        {
            etKtashium.setError("Invalid Potassium limit");
            return false;
        } else if(etPlotNo.getText().toString().isEmpty())
        {
            etPlotNo.setError("Invalid Plot No");
            return false;
        }else if(etDatePlant.getText().toString().isEmpty())
        {
            etDatePlant.setError("Invalid field");
            return false;
        }
        else
            return true;
    }

    private void getCropVarient(long cropId, long langId) {
        CallGenerator.getCropDetail(cropId,langId).enqueue(new Callback<ResCropVariety>() {
            @Override
            public void onResponse(Call<ResCropVariety> call, Response<ResCropVariety> response) {
                if(response.isSuccessful())
                {
                    ResCropVariety resCrop =response.body();
                    lsCropVariety=resCrop.getList();
                    ResCropVariety.CropEntity temp=new ResCropVariety.CropEntity();
                    temp.setCrop_detail_id(0);
                    temp.setSub_crop_name("Select crop");
                    lsCropVariety.add(temp);
                    if(lsCropVariety.isEmpty())
                    {

                    } else
                    {
                        llCropDetails.setVisibility(View.VISIBLE);
                        //spnVariaty.setAdapter(lsResStates);

                        VarientsSpinnerAdapter varientsAdapter=new VarientsSpinnerAdapter(getApplicationContext(),lsCropVariety);
                        spnSubVariaty.setAdapter(varientsAdapter);
                        spnflag=true;
                    }
                }
            }

            @Override
            public void onFailure(Call<ResCropVariety> call, Throwable t) {

            }
        });
    }

    private void getCrop() {
        CallGenerator.getCrops().enqueue(new Callback<ResCrop>() {
            @Override
            public void onResponse(Call<ResCrop> call, Response<ResCrop> response) {
                if(response.isSuccessful())
                {
                    ResCrop resCrop =resCrop=response.body();
                    lsCropEntities=resCrop.getList();
                    if(lsCropEntities.isEmpty())
                    {

                    } else
                    {
                        llCropDetails.setVisibility(View.VISIBLE);
                     //spnVariaty.setAdapter(lsResStates);
                        CustomSpinnerAdapter customAdapter=new CustomSpinnerAdapter(getApplicationContext(),lsCropEntities);
                        spnVariaty.setAdapter(customAdapter);
                        spnflag=true;
                    }
                }
            }

            @Override
            public void onFailure(Call<ResCrop> call, Throwable t) {

            }
        });
    }

    private void showErrorDialog(String dialogMessage) {

        ErrorDialogFragment errorDialog = ErrorDialogFragment.newInstance("Message", dialogMessage);
        errorDialog.show(getSupportFragmentManager(), DIALOG_ERROR);
    }
}
