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

    private final static int REQUEST_ENABLE_BT = 0;
    private final static int REQUEST_DISCOVER_BT = 1;

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
                        startActivityForResult(intent, REQUEST_ENABLE_BT);
                    }
                    else {
                        showToast("Bluetooth is already on :p");
                    }

                }

                else {
                    if(mBlueAdapter.isEnabled()) {
                        mBlueAdapter.disable();
                        showToast("Turning BT on");
                    }
                    else {
                    }
                }

            }
        });

        discover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mBlueAdapter.isDiscovering()) {
                    showToast("Making your phone discoverable");
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivityForResult(intent, REQUEST_DISCOVER_BT);
                }
            }
        });

        pairNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case REQUEST_ENABLE_BT:
                if(resultCode == RESULT_OK) {
                    showToast("BT is on");
                }
                else {
                    showToast("Bluetooth unavailable. lol XD");
                }
                break;

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
