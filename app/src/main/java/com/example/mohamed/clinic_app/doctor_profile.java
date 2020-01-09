package com.example.mohamed.clinic_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class doctor_profile extends AppCompatActivity {
ListView lz;
private static Retrofit retrofit=null;
    BaseAdapter ba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctorprofile);
        lz= (ListView) findViewById(R.id.lz);
        final TextView tidrn= (TextView) findViewById(R.id.idrn);
        final de.hdodenhof.circleimageview.CircleImageView ci= (CircleImageView) findViewById(R.id.de);
        Log.i("tst",getSharedPreferences("doctor",12).getString("d_password",""));
        getclient("https://www.domaaaaain.com/");
        GetDataService getDataService = retrofit.create(GetDataService.class);

        getDataService.getAllpatients(getSharedPreferences("doctor",12).getString("d_password","")).enqueue(new Callback<List<selectallhagz>>() {
            @Override
            public void onResponse(Call<List<selectallhagz>> call, Response<List<selectallhagz>> response) {
                call_list(response.body());
              //  Log.i("dov",response.body().get(0).getPrice());
                //Log.i("dovv","hello");

            }

            @Override
            public void onFailure(Call<List<selectallhagz>> call, Throwable t) {
             Log.i("fffffff",t.toString());
            }
        });
        getDataService.getAlldoctors(getSharedPreferences("doctor",12).getString("d_password",""),"password").enqueue(new Callback<List<getdoctors>>() {
            @Override
            public void onResponse(Call<List<getdoctors>> call, Response<List<getdoctors>> response) {
                Log.i("pui",response.body().get(0).getEmail_address());
                Picasso.with(doctor_profile.this).load("https://www.domaaaaain.com/"+response.body().get(0).getImage()).into(ci);
                tidrn.setText(response.body().get(0).getDiscription().toString());

            }

            @Override
            public void onFailure(Call<List<getdoctors>> call, Throwable t) {

            }
        });
    }
    private void call_list(final List<selectallhagz>ld) {
        ba=new docprofile_adapt(ld,this);
        lz.setAdapter(ba);
        lz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent ii=new Intent(doctor_profile.this,patient_profile.class);
                ii.putExtra("px",ld.get(i).getFull_name());
                ii.putExtra("pw",ld.get(i).getPassword());
                startActivityForResult(ii,11);
           //  Log.i("sd",ld.get(i).getFull_name());

            }
        });
    }

    private void getclient(String baseUrl) {

        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==11&&resultCode==RESULT_OK)
        {
            getclient("https://www.domaaaaain.com/");
            GetDataService getDataService = retrofit.create(GetDataService.class);

            getDataService.getAllpatients(getSharedPreferences("doctor",12).getString("d_password","")).enqueue(new Callback<List<selectallhagz>>() {
                @Override
                public void onResponse(Call<List<selectallhagz>> call, Response<List<selectallhagz>> response) {
                    call_list(response.body());


                }

                @Override
                public void onFailure(Call<List<selectallhagz>> call, Throwable t) {
                    Log.i("fffffff",t.toString());
                }
            });
        }
    }

    public void ccv(View view) {
        Uri uri=Uri.parse("google.streetview:cbll=46.414382,10.013988");
        Intent mintent=new Intent(Intent.ACTION_VIEW,uri);
        mintent.setPackage("com.google.android.apps.maps");
        startActivity(mintent);
    }
}
