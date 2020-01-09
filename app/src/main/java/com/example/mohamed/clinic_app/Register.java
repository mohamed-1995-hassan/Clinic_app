package com.example.mohamed.clinic_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mohamed on 11/10/2018.
 */
public class Register extends AppCompatActivity {

    EditText ed1;
    EditText ed2;
    EditText ed3;
    EditText ed4;
    AwesomeValidation wv;
    private static Retrofit retrofit=null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singed_up);

        wv=new AwesomeValidation(ValidationStyle.BASIC);

        ed1=(EditText) findViewById(R.id.ed1);
        ed2=(EditText) findViewById(R.id.ed2);
        ed3=(EditText) findViewById(R.id.ed3);
        ed4=(EditText) findViewById(R.id.ed4);

        wv.addValidation(this,R.id.ed1,"[a-zA-Z\\s]+",R.string.name_errore);
        wv.addValidation(this,R.id.ed2, Patterns.EMAIL_ADDRESS,R.string.email_errore);
        wv.addValidation(this,R.id.ed3,"^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$",R.string.password_errore);
        wv.addValidation(this,R.id.ed4,R.id.ed3,R.string.repassword_errore);

    }


    public void saveinbd(View view) {
        String wq=getIntent().getExtras().getString("flage");
        if(wv.validate())
        {
            if(wq.equals("patient"))
            {
                savedirect();
            }
            else if(wq.equals("doctor")) {
                Intent i = new Intent(Register.this, nextstep.class);
                i.putExtra("ed1", ed1.getText().toString());
                i.putExtra("ed2", ed2.getText().toString());
                i.putExtra("ed3", ed3.getText().toString());
                startActivity(i);
                finish();
            }
        }
        else {
            Toast.makeText(this,"errore in data",Toast.LENGTH_LONG).show();
        }
    }

    private void savedirect() {
        getclient("https://www.domaaaaain.com/");
        GetDataService getNoticeDataService = retrofit.create(GetDataService.class);
        getNoticeDataService.getuser2(ed1.getText().toString(),
                ed2.getText().toString(),
                ed3.getText().toString()).enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

         //       if (response.body().getResponse().equals("ok")) {

                  //  Intent ii=new Intent(Register.this,patient_home.class);
                  //  startActivity(ii);
           //         Log.i("patr",response.body().getResponse());
                if(response.isSuccessful())
                    Register.this.finish();


              //  }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

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