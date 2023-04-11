/* Student name: Gavin McCarthy
 * Student id: 19237766
 */
package com.music.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buttonStartService,buttonStopService;
    private Intent serviceIntent;
    SensorManager sensorManager;
    Sensor gyroscopeSensor;
    SensorEventListener gyroscopeListener;
    TextView textViewGyroscopeSensorX,
            textViewGyroscopeSensorY,
            textViewGyroscopeSensorZ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        serviceIntent = new Intent(this, MusicService.class);
        initGyroscopeSensor();
        initViews();
    }

    private void initGyroscopeSensor() {
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        gyroscopeListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
                    // Get the angular speed around the x, y, and z axes
                    float x = event.values[0];
                    float y = event.values[1];
                    float z = event.values[2];
                    textViewGyroscopeSensorX.setText("X=" + x);
                    textViewGyroscopeSensorY.setText("Y=" + y);
                    textViewGyroscopeSensorZ.setText("Z=" + z);

                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                // Do nothing
            }
        };

        sensorManager.registerListener(gyroscopeListener, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    private void initViews() {
        buttonStartService=findViewById(R.id.buttonStartServices);
        buttonStopService=findViewById(R.id.buttonStopServices);
        textViewGyroscopeSensorX=findViewById(R.id.textViewGyroscopeSensorX);
        textViewGyroscopeSensorY=findViewById(R.id.textViewGyroscopeSensorY);
        textViewGyroscopeSensorZ=findViewById(R.id.textViewGyroscopeSensorZ);

        buttonStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(serviceIntent);
            }
        });
        buttonStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(serviceIntent);
            }
        });

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        sensorManager.unregisterListener(gyroscopeListener);
    }

}