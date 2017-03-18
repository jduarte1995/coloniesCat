package com.example.jess.myapplicationmaps;

import android.*;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Fragment2 extends Fragment {

    MapView mMapView;

    static GoogleMap googleMap;

    LatLng origin;
    LatLng dest;
    LatLng yo = null;
    LatLng cccb = new LatLng(41.383787, 2.166781);
    LatLng macba = new LatLng(41.383368, 2.166856);
    LatLng llatzer = new LatLng(41.379786, 2.166436);
    LatLng creu = new LatLng(41.412662, 2.174351);
    LatLng teatre = new LatLng(41.379527, 2.165050);
    LatLng municipal = new LatLng(41.383931, 2.169326);
    LatLng modernista = new LatLng(41.3814243, 2.1665269);

    String origen;
    String destino;
    private String provider;

    Location lYo = null;

    Criteria criteria;

    int i = 0;

    private LocationManager locationManager;


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


            posaMarkers();



                // For zooming automatically to the location of the marker
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

                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        1);


                //User has previously accepted this permission
                //demanar permisos
                    if (ActivityCompat.checkSelfPermission(getActivity(),
                            Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                } else {
                    //Not in api-23, no need to prompt
                    googleMap.setMyLocationEnabled(true);
                }

                    googleMap.setMyLocationEnabled(true);
                    // Get the location manager
                    locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
                    // Define the criteria how to select the locatioin provider -> use
                    // default
                    criteria = new Criteria();
                    provider = locationManager.getBestProvider(criteria, false);
                    lYo = locationManager.getLastKnownLocation(provider);

                    googleMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
                        @Override
                        public boolean onMyLocationButtonClick() {
                            try {
                                double yoLat = lYo.getLatitude();
                                double yoLon = lYo.getLongitude();

                                yo = new LatLng(yoLat, yoLon);

                                Toast.makeText(getActivity(), yo.toString(), Toast.LENGTH_LONG).show();

                                googleMap.addMarker(new MarkerOptions().position(yo).title("Jo").icon(BitmapDescriptorFactory.fromResource(R.drawable.stickman)));
                            }catch(Exception e){
                                Toast.makeText(getActivity(), "No pot establir-se la ubicació", Toast.LENGTH_LONG).show();
                            }

                            return true;
                        }
                    });


                googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {

                        if(yo == null){
                           Toast.makeText(getActivity(),"Has d'apretar el botó de geolocalitzar",Toast.LENGTH_SHORT).show();
                        }else {
                            if(i>0){
                                i=0;
                                googleMap.clear();
                                posaMarkers();
                            }
                            origin = yo;

                            dest = marker.getPosition();

                            // Getting URL to the Google Directions API
                            String url = getDirectionsUrl(origin, dest);

                            DownloadTask downloadTask = new DownloadTask();

                            // Start downloading json data from Google Directions API
                            downloadTask.execute(url);
                            i++;
                        }

                        return false;
                    }
                });

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

    private class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... url) {

            String data = "";

            try {
                data = downloadUrl(url[0]);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask();


            parserTask.execute(result);

        }
    }


    /**
     * A class to parse the Google Places in JSON format
     */
    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();

                routes = parser.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList points = null;
            PolylineOptions lineOptions = null;
            MarkerOptions markerOptions = new MarkerOptions();

            for (int i = 0; i < result.size(); i++) {
                points = new ArrayList();
                lineOptions = new PolylineOptions();

                List<HashMap<String, String>> path = result.get(i);

                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                lineOptions.addAll(points);
                lineOptions.width(12);
                lineOptions.color(Color.parseColor("#ffa500"));
                lineOptions.geodesic(true);

            }

            // Drawing polyline in the Google Map for the i-th route
            googleMap.addPolyline(lineOptions);

        }
    }

    private String getDirectionsUrl(LatLng origin, LatLng dest) {

        // Origin of route
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;

        // Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;

        // Sensor enabled
        String sensor = "sensor=false";
        String mode = "mode=walking";
        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + sensor + "&" + mode;

        // Output format
        String output = "json";

        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters;


        return url;
    }

    /**
     * A method to download json data from url
     */
    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.connect();

            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        } catch (Exception e) {
            Log.d("Exception", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    public void posaMarkers(){
        if(!preguntes.cccb){
            googleMap.addMarker(
                    new MarkerOptions().position(cccb).title("CCCB"));
        }else{
            googleMap.addMarker(
                    new MarkerOptions().position(cccb).title("CCCB").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        }

        if(!preguntes.macba){
            googleMap.addMarker(
                    new MarkerOptions().position(macba).title("MACBA"));
        }else {
            googleMap.addMarker(
                    new MarkerOptions().position(macba).title("MACBA").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        }

        if(!preguntes.llatzer){
            googleMap.addMarker(
                    new MarkerOptions().position(llatzer).title("Esgèsia"));
        }else{
            googleMap.addMarker(
                    new MarkerOptions().position(llatzer).title("Esgèsia").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        }

        if(!preguntes.creu){
            googleMap.addMarker(
                    new MarkerOptions().position(creu).title("Hospital"));
        }else{
            googleMap.addMarker(
                    new MarkerOptions().position(creu).title("Hospital").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        }

        if(!preguntes.teatre){
            googleMap.addMarker(
                    new MarkerOptions().position(teatre).title("Teatre"));
        }else{
            googleMap.addMarker(
                    new MarkerOptions().position(teatre).title("Teatre").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        }


        if(!preguntes.municipal){
            googleMap.addMarker(
                    new MarkerOptions().position(municipal).title("Ajuntament"));
        }else{
            googleMap.addMarker(
                    new MarkerOptions().position(municipal).title("Ajuntament").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        }

        if(!preguntes.modernisme){
            googleMap.addMarker(
                    new MarkerOptions().position(modernista).title("Modernisme"));
        }else{
            googleMap.addMarker(
                    new MarkerOptions().position(modernista).title("Modernisme").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        }
    }


}
