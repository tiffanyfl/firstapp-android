package com.example.tiffany.firstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by tiffany on 14/03/2018.
 */

public class ProjectDetailsActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_projects_list);


        Project[] projects = new Project[]{
                new Project("Toto", "description", "nodejs", "red", "url/link", "http://www.armor-chimie.fr/IMG/jpg/BLEU_ARMOR_01.jpg")
        };

        String s = getIntent().getStringExtra("test");

        RecyclerView list = findViewById(R.id.projects_list);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(new ListAdapter(projects));



    }
}

