package com.example.mohamed.clinic_app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private static Retrofit retrofit=null;
    EditText e,ee;
    String bool;
    ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress=new ProgressDialog(MainActivity.this);

        e = (EditText) findViewById(R.id.us);
        ee = (EditText) findViewById(R.id.ps);
        final RadioButton doc = (RadioButton) findViewById(R.id.doc);
        final RadioButton pat = (RadioButton) findViewById(R.id.pat);
        doc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                pat.setChecked(false);
                if(b==true)
                    bool="doctor";
            }
        });

        pat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                doc.setChecked(false);
                if(b==true)
                    bool="patient";
            }
        });


    }

    private void getclient(String baseUrl) {

        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }

    }


    public void godoctor(View view) {
        Intent i=new Intent(MainActivity.this,Register.class);
        i.putExtra("flage","doctor");
        startActivity(i);

    }

    public void nextpage(View view) {


        if(!e.getText().toString().equals("")&&!ee.getText().toString().equals(""))
        {
            if (bool != null) {

          //      progress.setMessage("retrive");
            //    progress.setTitle("wait");
              //  progress.setIndeterminate(true);
              //  progress.show();

                getclient("https://www.domaaaaain.com/");
                GetDataService getDataService = retrofit.create(GetDataService.class);

                getDataService.getuserss(e.getText().toString(), ee.getText().toString(), bool).enqueue(new Callback<entity>() {
                    @Override
                    public void onResponse(Call<entity> call, Response<entity> response) {

                        if (response.isSuccessful()) {
                            if(response.body().getName().equals(e.getText().toString())&&response.body().getPassword().equals(ee.getText().toString()))

                            {
                //                progress.dismiss();
                                Log.i("name", response.body().getName());
                                Log.i("password", response.body().getPassword());

                                switch (bool) {
                                    case "doctor":
                                        getSharedPreferences("doctor", 12).edit().putString("d_username", response.body().getName()).commit();
                                        getSharedPreferences("doctor", 12).edit().putString("d_password", response.body().getPassword()).commit();
                                        Intent oop = new Intent(MainActivity.this, doctor_profile.class);
                                        startActivity(oop);
                                        break;
                                    case "patient":
                                        Intent io = new Intent(MainActivity.this, Home.class);
                                        startActivity(io);
                                        getSharedPreferences("patient", 11).edit().putString("p_username", response.body().getName()).commit();
                                        getSharedPreferences("patient", 11).edit().putString("p_password", response.body().getPassword()).commit();
                                        break;
                                }
                            }else {
                  //              if(progress.isShowing())
                    //            progress.dismiss();
                                Toast.makeText(MainActivity.this,"enter avalid data",Toast.LENGTH_LONG).show();
                            }
                        } else {
                      //      if(progress.isShowing())
                            Toast.makeText(MainActivity.this, "problem", Toast.LENGTH_LONG).show();
                        }


                    }

                    @Override
                    public void onFailure(Call<entity> call, Throwable t) {

                    }
                });
            } else {
                if(progress.isShowing())
              //  progress.dismiss();
                Toast.makeText(this, "enter your entity first", Toast.LENGTH_LONG).show();
            }
        }else {
            if(progress.isShowing())
           // progress.dismiss();
            Toast.makeText(MainActivity.this,"Fill all fields first",Toast.LENGTH_LONG).show();
        }
    }

    public void gopatient(View view) {
        Intent p=new Intent(MainActivity.this,Register.class);
        p.putExtra("flage","patient");
        startActivity(p);

    }
}


