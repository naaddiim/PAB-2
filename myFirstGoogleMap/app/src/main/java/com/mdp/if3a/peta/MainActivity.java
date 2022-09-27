package com.mdp.if3a.peta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mdp.if3a.peta.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private ActivityMainBinding binding;
    private GoogleMap mMap;
    private List<Lokasi> restaurantList = new ArrayList<>();
    private List<Lokasi> hospitalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        restaurantList.add(new Lokasi("Pempek Raden", new LatLng(-2.9614593018651973, 104.7388806937143)));
        restaurantList.add(new Lokasi("Humble Burger", new LatLng(-2.9629271884545214, 104.74103718977838)));
        restaurantList.add(new Lokasi("City Restaurant", new LatLng(-2.9619200256141296, 104.74057584984945)));
        restaurantList.add(new Lokasi("Pempek Candy", new LatLng(-2.96122357835814, 104.73875194760694 )));
        restaurantList.add(new Lokasi("Sweetboobelly", new LatLng(-2.9606235656330906, 104.74161654676892)));
        restaurantList.add(new Lokasi("Restaurant Sederhana Basuki Rahmat", new LatLng(-2.9595384624023464, 104.73896299819299)));
        restaurantList.add(new Lokasi("Soto Betawi H Amir", new LatLng(-2.9614895016346074, 104.73702261503993)));
        restaurantList.add(new Lokasi("Abra19 Coffe And Resto", new LatLng(-2.9639109776456882, 104.73549912039093 )));
        restaurantList.add(new Lokasi("Rumah Makan Surya", new LatLng(-2.9672967493687468, 104.739940858422)));
        restaurantList.add(new Lokasi("Resto Ayam Nyenyes", new LatLng(-2.957932279440224, 104.74045584247438)));

        hospitalList.add(new Lokasi("Rumah Sakit Bhayangkara", new LatLng(-2.9583822727938935, 104.73732302170008)));
        hospitalList.add(new Lokasi("Rumah Sakit Umum Sriwijaya Palembang", new LatLng(-2.9594242610692727, 104.73695019475514 )));
        hospitalList.add(new Lokasi("Rumah Sakit Umum Daerah Muh Hosein", new LatLng(-2.96566009844806, 104.75021103572124 )));
        hospitalList.add(new Lokasi("Rumah Sakit Bersalin Aryodilla", new LatLng(-2.964074356200722, 104.7393105387959)));
        hospitalList.add(new Lokasi("Rumah Sakit Rakyat Kristen Charitas", new LatLng(-2.97476735800793, 104.7526572104737)));

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

        binding.fabRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.clear();

                for(int i =0; i < restaurantList.size(); i++){
                    mMap.addMarker(new MarkerOptions()
                            .position(restaurantList.get(i).getLatLng())
                            .title(restaurantList.get(i).getNama()))
                            .showInfoWindow();
                }

                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(restaurantList.get(4).getLatLng(), 17));
            }
        });

        binding.fabHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.clear();

                for(int i =0; i < hospitalList.size(); i++){
                    mMap.addMarker(new MarkerOptions()
                                    .position(hospitalList.get(i).getLatLng())
                                    .title(hospitalList.get(i).getNama())
                                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
                                    .showInfoWindow();
                }

                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(restaurantList.get(4).getLatLng(), 15));
            }
        });

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
//        mMap.setMyLocationEnabled(true);
        LatLng latLngUser = new LatLng(-2.961791, 104.739752);
        mMap.addMarker(new MarkerOptions().position(latLngUser).title("Lokasi Saya"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLngUser, 19 ));
    }
}