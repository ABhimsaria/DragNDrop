package com.example.android.dragndrop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private static String value2 = "Maja_Aaya_kya";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String value1 = getIntent().getExtras().getString(value2);
        Toast.makeText(this, value1, Toast.LENGTH_LONG).show();
    }

}
