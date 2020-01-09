package com.example.mohamed.clinic_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Mohamed on 21/10/2018.
 */
public class instruction extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructionlinks);

    }

    public void go1(View view) {
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=hDZXSMU2lAk&feature=youtu.be&fbclid=IwAR3seMt-Qyd7hkC8R-5gHU3bH2o4Oxup49c5J10Zy90Zygm1oVQ4fTeFtHM"));
        startActivity(i);
    }

    public void go2(View view) {
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=qY1avLBQJ7k&feature=youtu.be&fbclid=IwAR0gsnFOXZoFNFqWDyYWmAYVj9lohQaS33AZoAJ_GOjzOF9GySBlJ0-fKok"));
        startActivity(i);
    }

    public void go3(View view) {

        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=LQ24EfM7sEw&feature=youtu.be&fbclid=IwAR0l6v632V6JVv3pbw7GeKKqAv4ItkTPREA7nCD37dBbCE587DeUxl5rFis"));
        startActivity(i);
    }
}
