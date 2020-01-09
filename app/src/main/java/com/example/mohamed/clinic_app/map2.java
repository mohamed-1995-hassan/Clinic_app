package com.example.mohamed.clinic_app;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class map2 extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    float lat,lon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map2);
        lat=Float.parseFloat(getIntent().getExtras().getString("y"));
        lon=Float.parseFloat(getIntent().getExtras().getString("z"));
        Toast.makeText(this,getIntent().getExtras().getString("y")+" "+getIntent().getExtras().getString("z"),Toast.LENGTH_LONG).show();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map2);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

       LatLng ll = new LatLng(lat, lon);

       MarkerOptions marker= new MarkerOptions();
        mMap.addMarker(marker.position(ll).title("Marker in Sydney")).setDraggable(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ll));
      //  mMap.setMaxZoomPreference(13f);
      //  mMap.setMinZoomPreference(13f);

    }
}
