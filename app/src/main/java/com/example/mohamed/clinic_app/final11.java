package com.example.mohamed.clinic_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class final11 extends AppCompatActivity {
    alertnot al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final11);
        // al = getIntent().getExtras().getParcelable("nmb");
         TextView tb= (TextView) findViewById(R.id.drnm);
        tb.setText(getSharedPreferences("note",45).getString("full_nnm",""));
         TextView tr=(TextView)findViewById(R.id.mdnmn);
        CircleImageView cv= (CircleImageView) findViewById(R.id.hpp);
        Picasso.with(this).load("https://www.domaaaaain.com/"+getSharedPreferences("note",45).getString("imo","")).into(cv);
        tr.setText(getSharedPreferences("note",45).getString("modo",""));

        //   tr.setText();

    }
}
