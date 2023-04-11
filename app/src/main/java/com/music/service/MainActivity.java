/* Student name: Gavin McCarthy
 * Student id: 19237766
 */
package com.music.service;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonStartService,buttonStopService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        buttonStartService=findViewById(R.id.buttonStartServices);
        buttonStopService=findViewById(R.id.buttonStopServices);
        buttonStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // start services here
            }
        });
        buttonStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // stop services here
            }
        });

    }
}