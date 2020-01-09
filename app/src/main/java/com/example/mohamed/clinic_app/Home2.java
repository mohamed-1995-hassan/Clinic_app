package com.example.mohamed.clinic_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Home2 extends AppCompatActivity {
ListView ls;

private static Retrofit retrofit=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        TextView tgrah= (TextView) findViewById(R.id.grah);
        tgrah.setText(getIntent().getExtras().getString("fos"));

        ls= (ListView) findViewById(R.id.ls);
        getclient("https://www.domaaaaain.com/");
        GetDataService getDataService = retrofit.create(GetDataService.class);

        getDataService.getAlldoctors(getIntent().getExtras().getString("fos"),"departement").enqueue(new Callback<List<getdoctors>>() {
            @Override
            public void onResponse(Call<List<getdoctors>> call, Response<List<getdoctors>> response) {

              if(response.body().size()!=0)
              call_list(response.body());
                else
                  Toast.makeText(Home2.this,"no doctor register",Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<List<getdoctors>> call, Throwable t) {

            }
        });
    }

    private void call_list(final List<getdoctors>ld) {
        BaseAdapter ba=new depat_apter(ld,this);
        ls.setAdapter(ba);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent ii=new Intent(Home2.this,Home3.class);
                ii.putExtra("selected",ld.get(i));
                startActivity(ii);

            }
        });
    }

    private void getclient(String baseUrl) {

        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }

    }

    }

