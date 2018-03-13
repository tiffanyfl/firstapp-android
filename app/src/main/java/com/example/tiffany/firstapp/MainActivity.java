package com.example.tiffany.firstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this,
                "Hello world !",
                Toast.LENGTH_SHORT).show();

        Log.i("Hello World !", "text");

        Calendar birthday = Calendar.getInstance();
        birthday.set(Calendar.DAY_OF_MONTH, 1);
        birthday.set(Calendar.MONTH, 1);
        birthday.set(Calendar.YEAR, 2000);

        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);

        TextView ageText = findViewById(R.id.age);
        ageText.setText(getString(R.string.age, age));

    }


}
