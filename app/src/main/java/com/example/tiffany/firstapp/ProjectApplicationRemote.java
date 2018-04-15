package com.example.tiffany.firstapp;

import android.app.Application;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import java.util.concurrent.TimeUnit;

/**
 * Created by tiffany on 16/03/2018.
 */

public class ProjectApplicationRemote extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseRemoteConfig remoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(BuildConfig.DEBUG)
                .build();
        remoteConfig.setConfigSettings(configSettings);
        remoteConfig.fetch(BuildConfig.DEBUG ? 0 : TimeUnit.DAYS.toMillis(1))
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            remoteConfig.activateFetched();
                        }
                    }
                });
    }
}
