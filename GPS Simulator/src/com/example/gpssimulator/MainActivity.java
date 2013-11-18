package com.example.gpssimulator;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

/***********  Create class and implements with LocationListener **************/
public class MainActivity extends Activity implements LocationListener {
     
        private LocationManager locationManager;
        TextView gpsLonLat;
         
        @Override
        protected void onCreate(Bundle savedInstanceState) {
         
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
             
            // Setup TextView
            gpsLonLat = (TextView) findViewById(R.id.tv_gps_long_lat);
            
            
            /********** get Gps location service LocationManager object ***********/
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
             
            /* CAL METHOD requestLocationUpdates */
               
              // Parameters :
              //   First(provider)    :  the name of the provider with which to register 
              //   Second(minTime)    :  the minimum time interval for notifications, 
              //                         in milliseconds. This field is only used as a hint 
              //                         to conserve power, and actual time between location 
              //                         updates may be greater or lesser than this value. 
              //   Third(minDistance) :  the minimum distance interval for notifications, in meters 
              //   Fourth(listener)   :  a {#link LocationListener} whose onLocationChanged(Location) 
              //                         method will be called for each location update 
            
            /*
            		Reference Links:
            		
            		Location Listener:
            		http://developer.android.com/reference/android/location/LocationListener.html
            		
            		Location Manager:
            		http://developer.android.com/reference/android/location/LocationManager.html#getGpsStatus(android.location.GpsStatus)
            
            		This program can be found here:
            		http://androidexample.com/GPS_Basic__-__Android_Example/index.php?view=article_discription&aid=68&aaid=93
             */
            
            
            
            locationManager.requestLocationUpdates( LocationManager.GPS_PROVIDER,
                    0,   // Immediate
                    0, this);
             
            /********* After registration onLocationChanged method  ********/
            /********* called periodically after each 3 sec ***********/
        }
         
        /************* Called Immediately when there is a change **********/
        @Override
        public void onLocationChanged(Location location) {
                
            String str = "Latitude: "+location.getLatitude()+" Longitude: "+location.getLongitude();

            gpsLonLat.setText(String.valueOf(str));
            
            //Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
        }
     
        @Override
        public void onProviderDisabled(String provider) {
             
            /******** Called when User off Gps *********/
             
            Toast.makeText(getBaseContext(), "Gps turned off ", Toast.LENGTH_LONG).show();
        }
     
        @Override
        public void onProviderEnabled(String provider) {
             
            /******** Called when User on Gps  *********/
             
            Toast.makeText(getBaseContext(), "Gps turned on ", Toast.LENGTH_LONG).show();
        }
     
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            // TODO Auto-generated method stub
             
        }
}
