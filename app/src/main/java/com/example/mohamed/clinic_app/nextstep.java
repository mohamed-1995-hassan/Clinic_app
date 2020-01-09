package com.example.mohamed.clinic_app;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mohamed on 12/10/2018.
 */
public class nextstep extends AppCompatActivity {
    private int ii=1;
    ImageView im;
    Bitmap bb;
    Spinner sp;
    String dialoge_stp="";
    private static Retrofit retrofit=null;
    String lat,lon;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor);
        im = (ImageView) findViewById(R.id.targ);
        sp= (Spinner) findViewById(R.id.osp);

    }

    public void chooseImage(View view) {

        Intent i=new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(i,100);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==100&&resultCode==RESULT_OK)
        {
            try{

                bb=MediaStore.Images.Media.getBitmap(getContentResolver(),data.getData());
               //Bitmap bmm= data.getExtras().get("data");

                im.setImageURI( data.getData());





            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        if (requestCode==200&&resultCode==RESULT_OK)
        {
            lat=data.getExtras().getString("lat");
            lon=data.getExtras().getString("lon");
            Toast.makeText(this,lat+"  "+lon,Toast.LENGTH_LONG).show();
        }
    }

    public void dialoge(View view) {

        final Dialog di=new Dialog(nextstep.this);
        di.setContentView(R.layout.dialoge);
       final EditText eed= di.findViewById(R.id.edo);
       Button bm= di.findViewById(R.id.okkk);
       Button bc= di.findViewById(R.id.cannn);
        bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoge_stp=eed.getText().toString();
               TextView tre= (TextView) nextstep.this.findViewById(R.id.tre);
                tre.setText(dialoge_stp);
                di.dismiss();


            }
        });
        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                di.dismiss();
            }
        });

        di.show();


    }

    private void getclient(String baseUrl) {

        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }

    }


    public String bitmap2string()
    {
        ByteArrayOutputStream baot =new ByteArrayOutputStream();
        bb.compress(Bitmap.CompressFormat.JPEG,100,baot);
        byte[]imbyte=baot.toByteArray();
        return Base64.encodeToString(imbyte,Base64.DEFAULT);
    }

    public void savein(View view) {
        try {
            String departement = sp.getSelectedItem().toString();
            Log.i("mna", bitmap2string());
            Log.i("dept", departement);
            getclient("https://www.domaaaaain.com/");
            GetDataService getNoticeDataService = retrofit.create(GetDataService.class);
            getNoticeDataService.getuser(getIntent().getExtras().getString("ed1"),
                    getIntent().getExtras().getString("ed2"),
                    getIntent().getExtras().getString("ed3"), bitmap2string(), departement, dialoge_stp, lat, lon).enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {
                    String ss = response.body().getResponse();
                    // Log.i("mna",ss);
                    //Toast.makeText(Register.this,response.body().getResponse(),Toast.LENGTH_LONG).show();
                    // if (ss.equals("ok")) {

                    //}
                    if (response.isSuccessful())
                        nextstep.this.finish();

                }

                @Override
                public void onFailure(Call<Example> call, Throwable t) {

                }
            });
        }catch (Exception e)
        {
            Toast.makeText(nextstep.this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }


    public void muni(View view) {
      Intent io=new Intent(this,map.class);
        startActivityForResult(io,200);
    }
}
