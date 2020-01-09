package com.example.mohamed.clinic_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Home3 extends AppCompatActivity {
    getdoctors doctor;
    TextView t1,t2;
    String ss="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home3);
        ImageView im= (ImageView) findViewById(R.id.targs);
        TextView tm= (TextView) findViewById(R.id.zek);
        t1= (TextView) findViewById(R.id.o7);
        t2= (TextView) findViewById(R.id.o8);
        doctor= getIntent().getExtras().getParcelable("selected");
        Picasso.with(this).load("https://www.domaaaaain.com/"+doctor.getImage()).into(im);
        tm.setText(doctor.getDiscription());







    }

    public void next(View view) {
        Intent ii=new Intent(Home3.this,payment.class);
        ii.putExtra("selectedd",doctor);
        ii.putExtra("dateh",ss);
        startActivity(ii);

    }

    public void tmam(View view) {
        switch (view.getId())
        {
            case R.id.o7:
               t1.setBackgroundResource(R.drawable.oop);
                t2.setBackgroundResource(R.drawable.fin);
                ss=t1.getText().toString();
                break;
            case R.id.o8:
                t1.setBackgroundResource(R.drawable.fin);
                t2.setBackgroundResource(R.drawable.oop);

                ss=t2.getText().toString();
                break;

        }
    }

    public void mapp(View view) {

        Intent imp=new Intent(this,map2.class);
        imp.putExtra("y",doctor.getLat());
        imp.putExtra("z",doctor.getLon());
        startActivity(imp);
    }
}
