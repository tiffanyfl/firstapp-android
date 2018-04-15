package com.example.tiffany.firstapp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by tiffany on 15/03/2018.
 */

public class ProjectScreenViewProject extends ViewModel {
    private LiveData<Project[]> project;

    public LiveData<Project[]> getUser() {
        if (project == null) {
            project = new ProjectLiveData();
        }
        return project;
    }
}
