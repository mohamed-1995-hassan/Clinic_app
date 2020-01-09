package com.example.mohamed.clinic_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class patient_profile extends AppCompatActivity {
    private static Retrofit retrofit=null;
    ListView le;
    selectallhagz sh;
    String sw;
    EditText ds;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_profile);
      //  sh =(selectallhagz) getIntent().getExtras().getParcelable("px");
        TextView pattxt  = (TextView) findViewById(R.id.txtpat);
        le= (ListView) findViewById(R.id.le);
       String ss= getIntent().getExtras().getString("px");
        sw= getIntent().getExtras().getString("pw");

       ds= (EditText) findViewById(R.id.fnsd);

        pattxt.setText(ss);

        getclient("https://www.domaaaaain.com/");
        GetDataService getDataService = retrofit.create(GetDataService.class);

        getDataService.getAllchc(sw).enqueue(new Callback<List<select_all_chech>>() {
            @Override
            public void onResponse(Call<List<select_all_chech>> call, Response<List<select_all_chech>> response) {
                call_list(response.body());


            }

            @Override
            public void onFailure(Call<List<select_all_chech>> call, Throwable t) {

            }
        });




    }

    private void getclient(String baseUrl) {

        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }

    }


    private void call_list(final List<select_all_chech>ld) {
        BaseAdapter ba=new patient_profile_adapter(ld,this);
        le.setAdapter(ba);
        le.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              /*  Intent ii=new Intent(patient_profile.this,patient_profile.class);
                ii.putExtra("patientprofile",ld.get(i));
                startActivity(ii);*/
                Toast.makeText(patient_profile.this, "hello", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void add_check(View view) {
       EditText dd= (EditText) findViewById(R.id.edcheck);
     //  EditText mede = (EditText) findViewById(R.id.mede);
       Spinner day= (Spinner) findViewById(R.id.day);
       Spinner month= (Spinner) findViewById(R.id.month);
       Spinner year= (Spinner) findViewById(R.id.year);
       String dtt=day.getSelectedItem().toString()+"/"+month.getSelectedItem().toString()+"/"+year.getSelectedItem().toString();
        getclient("https://www.domaaaaain.com/");
        GetDataService getDataService = retrofit.create(GetDataService.class);
        getDataService.insert_check(getSharedPreferences("doctor",12).getString("d_password",""),sw,dd.getText().toString(),dtt).
                enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                      Log.i("reso",response.body().getResponse().toString());
                       // Toast.makeText(patient_profile.this,response.body().toString(),Toast.LENGTH_LONG).show();
                        if(response.isSuccessful())
                        {
                            setResult(RESULT_OK);
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                          Log.i("thg",t.toString());
                    }
                });




    }


    public void add_med(View view) {

       Spinner spn= (Spinner) findViewById(R.id.hour);
       Spinner sp2= (Spinner) findViewById(R.id.minit);
        Spinner sp3= (Spinner) findViewById(R.id.team);

        getclient("https://www.domaaaaain.com/");
        GetDataService getDataService = retrofit.create(GetDataService.class);

        getDataService.add_mede(sw,getSharedPreferences("doctor",12).getString("d_password",""),spn.getSelectedItem().toString(),sp2.getSelectedItem().toString(),sp3.getSelectedItem().toString(),ds.getText().toString()).enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
              if(response.isSuccessful())
              {
                  Toast.makeText(patient_profile.this,response.body().getResponse(),Toast.LENGTH_LONG).show();
              }


            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {



            }
        });




    }
}
