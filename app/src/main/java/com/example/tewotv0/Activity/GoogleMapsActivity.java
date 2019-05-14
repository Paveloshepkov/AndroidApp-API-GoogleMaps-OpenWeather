package com.example.tewotv0.Activity;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.Toast;
import com.example.tewotv0.CustomInfo.CWadapter;
import com.example.tewotv0.R;
import com.example.tewotv0.models.hotelModels.hotelPrice.HotelPriceModel;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.Objects;



public class GoogleMapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final String ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUES_CODE = 1111;


    private RatingBar ratingBar;

    private static List<HotelPriceModel> hotelPriceModelList;
    private static List<LatLng> hotelsCoordinateList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.google_maps_activity);

        ratingBar = findViewById(R.id.ratingBar);

        initMap();
        initRatingBar();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        googleMap.setInfoWindowAdapter(new CWadapter(this));
        googleMap.animateCamera(setCameraUpdate());
        googleMap.setOnInfoWindowClickListener(initInfoWindowClickListener());
        try {
            for (int i = 0; i < hotelsCoordinateList.size(); i++) {
                HotelPriceModel hotelPriceModel = hotelPriceModelList.get(i);
                LatLng hotelCoordinateModel = hotelsCoordinateList.get(i);
                googleMap.addMarker(getMarkerMyMarker(hotelPriceModel, hotelCoordinateModel));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private GoogleMap.OnInfoWindowClickListener initInfoWindowClickListener() {
        return marker -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(GoogleMapsActivity.this);
            builder.setMessage(marker.getSnippet())
                    .setCancelable(false)
                    .setPositiveButton("Yes", (dialog, which) -> dialog.dismiss())
                    .setNegativeButton("No", (dialog, which) -> dialog.cancel());
            AlertDialog alert = builder.create();
            alert.show();
        };
    }

    private CameraUpdate setCameraUpdate(){
        LatLngBounds.Builder builder = new LatLngBounds.Builder();

        for (LatLng latLng : hotelsCoordinateList) {
            builder.include(latLng);
        }
        LatLngBounds bounds = builder.build();

        return CameraUpdateFactory.newLatLngBounds(bounds, 180);
    }

    private MarkerOptions getMarkerMyMarker(HotelPriceModel hotelPriceModel, LatLng hotelCoordinateModel) {
        String str = "Hotel Name: " + hotelPriceModel.getHotelName() + "\n"
                + "Stars: " + hotelPriceModel.getStars() + "\n"
                + "Average price: " + hotelPriceModel.getPriceAvg() + "\n";
        return new MarkerOptions()
                .title(hotelPriceModel.getHotelName())
                .snippet(str)
                .draggable(false)
                .icon(getTheRightPictureDependingOnTheStars(hotelPriceModel.getStars()))
                .position(hotelCoordinateModel);
    }
    private void initRatingBar() {
        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) ->
                Toast.makeText(GoogleMapsActivity.this,
                        "Вы выбрали " + rating, Toast.LENGTH_LONG).show()
        );
    }

    private void initMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        Objects.requireNonNull(mapFragment).getMapAsync(this);
    }
    private BitmapDescriptor getTheRightPictureDependingOnTheStars(int stars) {
        BitmapDescriptor bitmapDescriptor = null;
        switch (stars) {
            case 0:
                break;
            case 1:
                bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.hotel1star);
                break;
            case 2:
                bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.hotel2stars);
                break;
            case 3:
                bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.hotel3stars);
                break;
            case 4:
                bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.hotel4stars);
                break;
            case 5:
                bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.hotel5stars);
                break;
        }
        return bitmapDescriptor;
    }

    public static void setHotelsInCity(List<HotelPriceModel> hotelPriceModel) {
        hotelPriceModelList = hotelPriceModel;
    }

    public static void setHotelsCoordinateList(List<LatLng> list) {
        hotelsCoordinateList = list;
    }
}

