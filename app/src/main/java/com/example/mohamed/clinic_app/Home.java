package com.example.mohamed.clinic_app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Home extends AppCompatActivity implements View.OnClickListener {
TextView t1,t2,t3,t4,t5;
private static Retrofit retrofit=null;
    List<alertnot> mine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        t1= (TextView) findViewById(R.id.t1);
        t2= (TextView) findViewById(R.id.t2);
        t3= (TextView) findViewById(R.id.t3);
        t4= (TextView) findViewById(R.id.t4);
        t5= (TextView) findViewById(R.id.t5);

         ImageView iy= (ImageView) findViewById(R.id.grsa);
         ImageView i2= (ImageView) findViewById(R.id.insta);
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iiu=new Intent(Home.this,instruction.class);
                startActivity(iiu);
            }
        });


        registerForContextMenu(iy);












        LinearLayout l1= (LinearLayout) findViewById(R.id.l1);
        l1.setOnClickListener(this);
       LinearLayout l2= (LinearLayout) findViewById(R.id.l2);
        l2.setOnClickListener(this);
       LinearLayout l3= (LinearLayout) findViewById(R.id.l3);
        l3.setOnClickListener(this);
       LinearLayout l4= (LinearLayout) findViewById(R.id.l4);
        l4.setOnClickListener(this);
       LinearLayout l5= (LinearLayout) findViewById(R.id.l5);
        l5.setOnClickListener(this);

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

          getMenuInflater().inflate(R.menu.grass,menu);
        menu.add("all_docrors");
          fill_context(menu);





    }

    private void fill_context(final ContextMenu menu) {

        getclient("https://www.domaaaaain.com/");
        GetDataService getDataService = retrofit.create(GetDataService.class);
        getDataService.get_mede( getSharedPreferences("patient",11).getString("p_password",""))
                .enqueue(new Callback<List<alertnot>>() {
                    @Override
                    public void onResponse(Call<List<alertnot>> call, Response<List<alertnot>> response) {

                        if(response.isSuccessful())
                        {
                            if(response.body().size()!=0) {
                                mine=response.body();
                                  for (int i = 0; i < response.body().size(); i++) {
                                 menu.add(0,i,Menu.NONE,response.body().get(i).getFull_name());



                                 }
                                Log.i("de",response.body().get(0).getFull_name());
                            }else {
                                Toast.makeText(Home.this,"no one has been regisered",Toast.LENGTH_LONG).show();
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<List<alertnot>> call, Throwable t) {

                    }
                });




    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int Idd = item.getItemId();
        alertnot alnt = mine.get(Idd);


        Calendar cl=Calendar.getInstance();
        cl.set(Calendar.HOUR_OF_DAY,Integer.parseInt(alnt.getHour()));
        cl.set(Calendar.MINUTE,Integer.parseInt(alnt.getMinit()));
        cl.set(Calendar.SECOND,30);
        Intent ii=new Intent(this,nota.class);
       // ii.putExtra("nmb",alnt);
        getSharedPreferences("note",45).edit().putString("full_nnm",alnt.getFull_name()).commit();
        getSharedPreferences("note",45).edit().putString("imo",alnt.getImage()).commit();
       getSharedPreferences("note",45).edit().putString("modo",alnt.getMedecine()).commit();
       // getSharedPreferences("note",45).edit().putString("full_nnm",alnt.getFull_name());
       // getSharedPreferences("note",45).edit().putString("full_nnm",alnt.getFull_name());
       // getSharedPreferences("note",45).edit().putString("full_nnm",alnt.getFull_name());

        PendingIntent pi=PendingIntent.getBroadcast(this,12,ii,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager al = (AlarmManager) getSystemService(ALARM_SERVICE);
        al.setRepeating(AlarmManager.RTC_WAKEUP,cl.getTimeInMillis(),(1000*60*60*24)/Integer.parseInt(alnt.getTime()),pi);



        return super.onContextItemSelected(item);



    }

    private void getclient(String baseUrl) {

        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }

    }


    private void call_next(TextView textView) {
        Intent ii=new Intent(Home.this,Home2.class);
        ii.putExtra("fos",textView.getText().toString());

        startActivity(ii);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.l1:
                call_next(t1);
                break;
            case R.id.l2:
                call_next(t2);
                break;
            case R.id.l3:
                call_next(t3);
                break;
            case R.id.l4:
                call_next(t4);
                break;
            case R.id.l5:
                call_next(t5);
                break;

        }
    }
}
