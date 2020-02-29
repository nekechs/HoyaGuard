package com.xcalic.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView isOnText;
    Switch btToggle;
    Button discover, pairNew;

    BluetoothAdapter mBlueAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bluetooth_pairscreen);

        btToggle = findViewById(R.id.btToggle);
        discover = findViewById(R.id.discover);
        isOnText = findViewById(R.id.isPaired);
        pairNew = findViewById(R.id.getDevice);

        btToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked) {
                    if(!mBlueAdapter.isEnabled()) {
                        showToast("Turning on bluetooth...");

                        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    }

                }

                else {

                }

            }
        });

        discover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        pairNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
