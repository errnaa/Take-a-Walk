package taw.takeawalk;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        String mode = extra.getString("mode");

        mMap = googleMap;

        if (mode.equals("direct")) {
            LatLng seibel = new LatLng(40.114206, -88.224808);
            mMap.addMarker(new MarkerOptions().position(seibel));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(seibel, 15.0f));
            LatLng illini = new LatLng(40.109625, -88.227256);
            mMap.addMarker(new MarkerOptions().position(illini));
        } else {
            LatLng burnham = new LatLng(40.113091, -88.234671);
            mMap.addMarker(new MarkerOptions().position(burnham));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(burnham, 15.0f));
        }
    }
}
