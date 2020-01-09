package com.example.mohamed.clinic_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mohamed on 20/10/2018.
 */
public class payment extends AppCompatActivity {
    private static Retrofit retrofit=null;
    EditText as;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);
       as= (EditText) findViewById(R.id.pta);
    }

    public void reset(View view) {
        String aas=as.getText().toString();
        try {
            int num=Integer.parseInt(aas);
            getdoctors dd = getIntent().getExtras().getParcelable("selectedd");
            String ddt = getIntent().getExtras().getString("dateh");
            getclient("https://www.domaaaaain.com/");
            GetDataService getDataService = retrofit.create(GetDataService.class);

            getDataService.update(dd.getPassword(), getSharedPreferences("patient", 11).getString("p_password", ""), ddt).enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {


                    Log.i("resu", response.body().getResponse());
                    Toast.makeText(payment.this, response.body().getResponse().toString(), Toast.LENGTH_LONG).show();


                }

                @Override
                public void onFailure(Call<Example> call, Throwable t) {

                }
            });
        }catch (NumberFormatException nm)
        {
            Toast.makeText(payment.this,"is not anumber",Toast.LENGTH_LONG).show();
        }

    }
    private void getclient(String baseUrl) {

        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }

    }
}
