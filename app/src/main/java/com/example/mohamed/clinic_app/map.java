package com.example.mohamed.clinic_app;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class map extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    Button btnm;
    MarkerOptions marker;
    LatLng ll;
    Intent im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        im=getIntent();
        btnm=findViewById(R.id.btnm);


        btnm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(map.this, ll.latitude+"  "+ll.longitude,Toast.LENGTH_LONG).show();
                im.putExtra("lat",ll.latitude+" ");
                im.putExtra("lon",ll.longitude+" ");
                setResult(RESULT_OK,im);
                finish();
            }
        });
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        ll = new LatLng(31.205753, 29.924526);

        marker= new MarkerOptions();
        mMap.addMarker(marker.position(ll).title("Marker in Sydney")).setDraggable(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ll));
       // mMap.setMaxZoomPreference(13f);
       // mMap.setMinZoomPreference(13f);
        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {

            }

            @Override
            public void onMarkerDrag(Marker marker) {

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                ll=new LatLng(marker.getPosition().latitude,marker.getPosition().longitude );
                //=marker.getPosition().latitude;

            }
        });


    }
}
