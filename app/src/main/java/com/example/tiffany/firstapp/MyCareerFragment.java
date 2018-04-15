package com.example.tiffany.firstapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by Tiffany on 26/03/2018.
 */

public class MyCareerFragment extends Fragment {


    private RecyclerView recycler;
    private TextView titles;
    private TextView skills;
    private TextView degrees;
    private TextView experiences;

    private String[] titlesTab  = new String[] {
            "Mes compétences",
            "Mes diplômes",
            "Mon parcours"
    };

    private Skill[] skillsTab = new Skill[] {
            new Skill("HTML/CSS", "85"),
            new Skill("Javascript", "70"),
            new Skill("PHP", "60")
    };
    private Degree[] degreesTab = new Degree[] {
            new Degree("Baccalauréat Littéraire", "Lycée Christophe Colomb", "Sucy-en-Brie", "2014"),
            new Degree("DUT MMI", "IUT", "Champs-sur-Marne", "2017"),
            new Degree("Licence professionnelle", "Université", "Cergy Pontoise", "2018")
    };
    private Experience[] experiencesTab = new Experience[] {
            new Experience("Les Tontons Livreurs", "Paris", "2017-2018"),
            new Experience("AZApp", "Saint Thibault des Vignes", "2017"),
            new Experience("Simply Market", "Sucy-en-Brie", "2014-2017")
    };

    CareerAdapter.ClickListener clickListenerTab = new CareerAdapter.ClickListener() {
        @Override
        public void onTitleClicked(String title) {

        }

        @Override
        public void onSkillClicked(Skill skill) {

        }

        @Override
        public void onDegreeClicked(Degree degree) {

        }

        @Override
        public void onExperienceClicked(Experience experience) {

        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.career_main, container, false);
        View view = inflater.inflate(R.layout.fragment_career_list,container,false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.career_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        CareerAdapter adapter = new CareerAdapter(titlesTab, skillsTab, degreesTab, experiencesTab, clickListenerTab);
        recyclerView.setAdapter(adapter);
        //recyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        titles = (TextView) view.findViewById(R.id.list_title_name);
        skills = (TextView) view.findViewById(R.id.list_skill_name);
        degrees = (TextView) view.findViewById(R.id.list_degree_name);
        experiences = (TextView) view.findViewById(R.id.list_experience_name);


    }
}
