package com.example.tiffany.firstapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(findViewById(R.id.main_toolbar));

        TabLayout tabLayout = findViewById(R.id.main_tabs);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                changeContentTo(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        changeContentTo(0);
    }

    private void changeContentTo(int position) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new WhoAmIFragment();
                break;
            case 1:
                fragment = new MyProjectFragment();
                break;
            case 2:
                fragment = new MyCareerFragment();
        }

        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, fragment)
                    .commitAllowingStateLoss();
        }

        //throw new NullPointerException();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        FirebaseRemoteConfig remoteConfig = FirebaseRemoteConfig.getInstance();
        if(remoteConfig.getBoolean("mail")){
            getMenuInflater().inflate(R.menu.menu_activity, menu);
        }

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

            if (item.getItemId() == R.id.phone) {
                String number = "44444444444";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" +number));
                startActivity(intent);
            }



        if (item.getItemId() == R.id.email) {
            String to = "test@gmail.com";
            String mailTo = "mailto:" + to;
            Intent emailIntent = new Intent(Intent.ACTION_VIEW);
            emailIntent.setData(Uri.parse(mailTo));
            startActivity(emailIntent);
        }


        return super.onOptionsItemSelected(item);
    }
}
