package com.example.tiffany.firstapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tiffany on 14/03/2018.
 */

public class MyProjectFragment extends Fragment {

    public final static String name = "Project";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_projects_list, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        // Récupérer le ViewModel
        ProjectScreenViewProject vm =
                ViewModelProviders.of(this).get(ProjectScreenViewProject.class);

        // Ecouter les données
        vm.getUser().observe(this, new Observer<Project[]>() {
            @Override
            public void onChanged(@Nullable Project[] projects) {

                RecyclerView list = view.findViewById(R.id.projects_list);
                list.setLayoutManager(new LinearLayoutManager(getActivity()));
                list.setAdapter(new ListAdapter(projects));

                //Intent intent = new Intent(view.getContext(), ProjectDetailsActivity.class);
                //intent.putExtra(MyProjectFragment.name, projects);
                //startActivity(intent);


            }



        });








    }
}
