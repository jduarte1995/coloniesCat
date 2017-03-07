package com.example.jess.mapscolonies;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Fragment2 extends Fragment {
    MapView mMapView;
    static GoogleMap googleMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment2_layout, container, false);

        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;


            // For dropping a marker at a point on the Map
            //LatLng sydney = new LatLng(41.5403156, 2.4207795);
            LatLng cccb = new LatLng(41.383885,2.1645923);
            LatLng macba = new LatLng(41.3828463,2.1649398);
            LatLng llatzer = new LatLng(41.3793929,2.1635763);
            LatLng creu = new LatLng(41.415727,2.1727505);
            LatLng teatre = new LatLng(41.3793714,2.1630354);
            LatLng municipal = new LatLng(41.3839306,2.167326);
            LatLng modernista = new LatLng(41.3814243,2.1665269);

            if(!preguntes.cccb){
                googleMap.addMarker(
                new MarkerOptions().position(cccb).title("CCCB"));
            }else{
                googleMap.addMarker(
                new MarkerOptions().position(cccb).title("CCCB").icon(BitmapDescriptorFactory.fromResource(R.drawable.green_marker)));
            }

            if(!preguntes.macba){
                googleMap.addMarker(
                new MarkerOptions().position(macba).title("MACBA"));
            }else {
                googleMap.addMarker(
                new MarkerOptions().position(macba).title("MACBA").icon(BitmapDescriptorFactory.fromResource(R.drawable.green_marker)));
            }

            if(!preguntes.llatzer){
                googleMap.addMarker(
                new MarkerOptions().position(llatzer).title("Esgèsia"));
            }else{
                googleMap.addMarker(
                new MarkerOptions().position(llatzer).title("Esgèsia").icon(BitmapDescriptorFactory.fromResource(R.drawable.green_marker)));
            }

            if(!preguntes.creu){
                googleMap.addMarker(
                new MarkerOptions().position(creu).title("Hospital"));
            }else{
                googleMap.addMarker(
                new MarkerOptions().position(creu).title("Hospital").icon(BitmapDescriptorFactory.fromResource(R.drawable.green_marker)));
            }

            if(!preguntes.teatre){
                googleMap.addMarker(
                new MarkerOptions().position(teatre).title("Teatre"));
            }else{
                googleMap.addMarker(
                new MarkerOptions().position(teatre).title("Teatre").icon(BitmapDescriptorFactory.fromResource(R.drawable.green_marker)));
            }


            if(!preguntes.municipal){
                googleMap.addMarker(
                new MarkerOptions().position(municipal).title("Ajuntament"));
                }else{
                googleMap.addMarker(
                new MarkerOptions().position(municipal).title("Ajuntament").icon(BitmapDescriptorFactory.fromResource(R.drawable.green_marker)));
            }

                if(!preguntes.modernisme){
                    googleMap.addMarker(
                    new MarkerOptions().position(modernista).title("Modernisme"));
                }else{
                    googleMap.addMarker(
                    new MarkerOptions().position(modernista).title("Modernisme").icon(BitmapDescriptorFactory.fromResource(R.drawable.green_marker)));
                }



                // For zooming automatically to the location of the marker
                /*CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();*/
                CameraPosition cameraPositionCCCB =        new CameraPosition.Builder().target(cccb).zoom(15).build();
                CameraPosition cameraPositionMACBA =       new CameraPosition.Builder().target(macba).zoom(15).build();
                CameraPosition cameraPositionLLATZER =     new CameraPosition.Builder().target(llatzer).zoom(15).build();
                CameraPosition cameraPositionCREU =        new CameraPosition.Builder().target(creu).zoom(15).build();
                CameraPosition cameraPositionTEATRE =      new CameraPosition.Builder().target(teatre).zoom(15).build();
                CameraPosition cameraPositionMUNICIPAL=    new CameraPosition.Builder().target(municipal).zoom(15).build();
                CameraPosition cameraPositionMODERNISTA =  new CameraPosition.Builder().target(modernista).zoom(15).build();

                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPositionCCCB));
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPositionMACBA));
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPositionLLATZER));
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPositionCREU));
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPositionTEATRE));
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPositionMUNICIPAL));
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPositionMODERNISTA));
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}
