package com.example.tiffany.firstapp;

import android.arch.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by tiffany on 15/03/2018.
 */

public class ProjectLiveData extends MutableLiveData<Project[]> {
    public void onActive() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Projects");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Project> projects = new ArrayList<>();
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    projects.add(child.getValue(Project.class));
                }

                postValue(projects.toArray(new Project[projects.size()]));

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });


    }

    public void onInactive() {

    }
}
