package taw.takeawalk;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

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

        Button nineOneOneButton = (Button) findViewById(R.id.nineOneOneButton);
        nineOneOneButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:911"));
                try {
                    startActivity(callIntent);
                } catch (SecurityException e) {

                }
                return true;
            }
        });

        Button safeRideButton = (Button) findViewById(R.id.saferideButton);
        safeRideButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:2172657433"));
                try {
                    startActivity(callIntent);
                } catch (SecurityException e) {

                }
                return true;
            }
        });
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

            PolylineOptions rectOptions = new PolylineOptions()
                    .add(new LatLng(40.114501, -88.223998))
                    .add(new LatLng(40.110562, -88.223955))
                    .add(new LatLng(40.110373, -88.227742));

            Polyline polyline = mMap.addPolyline(rectOptions);
        } else {
            LatLng burnham = new LatLng(40.113091, -88.234671);
            mMap.addMarker(new MarkerOptions().position(burnham));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(burnham, 16.0f));

            PolylineOptions rectOptions = new PolylineOptions()
                    .add(new LatLng(40.112673, -88.234697))
                    .add(new LatLng(40.112686, -88.232082))
                    .add(new LatLng(40.111488, -88.232072))
                    .add(new LatLng(40.111488, -88.235387))
                    .add(new LatLng(40.112686, -88.235419))
                    .add(new LatLng(40.112673, -88.234697));

            Polyline polyline = mMap.addPolyline(rectOptions);
        }
    }

    public void goToStats(View view) {
        Intent intent = new Intent (this, StatsActivity.class);
        startActivity(intent);
    }

    public void goToContacts(View view) {
        Intent intent = new Intent (this, ContactsActivity.class);
        startActivity(intent);
    }
}
