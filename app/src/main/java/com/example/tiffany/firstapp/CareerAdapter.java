package com.example.tiffany.firstapp;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Tiffany on 27/03/2018.
 */

public class CareerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {


    public final int TYPE_TITLE = 0;
    public final int TYPE_SKILL = 1;
    public final int TYPE_DEGREE = 2;
    public final int TYPE_EXPERIENCE = 3;

    @NonNull
    private final Skill[] skills;
    @NonNull
    private final String[] titles;
    @NonNull
    private final Degree[] degrees;
    @NonNull
    private final Experience[] experiences;

    @Nullable
    private final ClickListener listener;



    CareerAdapter(@NonNull String[] titles, @NonNull Skill[] skills, @NonNull Degree[] degrees, @NonNull Experience[] experiences, @Nullable ClickListener listener) {
        this.titles = titles;
        this.skills = skills;
        this.degrees = degrees;
        this.experiences = experiences;
        this.listener = listener;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case TYPE_TITLE:
                return new TitleHolder(layoutInflater.inflate(R.layout.career_titles, parent, false));
            case TYPE_SKILL:
                return new SkillHolder(layoutInflater.inflate(R.layout.career_skills, parent, false));
            case TYPE_DEGREE:
                return new DegreeHolder(layoutInflater.inflate(R.layout.career_degrees, parent, false));
            case TYPE_EXPERIENCE:
                return new ExperienceHolder(layoutInflater.inflate(R.layout.career_experiences, parent, false));
        }

        throw new IllegalArgumentException("Unknown viewType!" + viewType);
    }


    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case TYPE_TITLE:
                bindTitle(holder, position);
            case TYPE_SKILL:
                bindSkill(holder, position);
            case TYPE_DEGREE:
                bindDegree(holder, position);
            case TYPE_EXPERIENCE:
                bindExperience(holder, position);
        }
    }

    private void bindTitle(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TitleHolder) {
            final String title = titles[(int) Math.floor(position/4)];
            ((TitleHolder) holder).bindValue(title);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onTitleClicked(title);
                    }
                }
            });
        }
    }

    private void bindSkill(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SkillHolder) {
            final Skill skill = skills[(int) Math.floor(position/4)];
            ((SkillHolder) holder).bindValue(skill);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onSkillClicked(skill);
                    }
                }
            });
        }
    }

    private void bindDegree(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof DegreeHolder) {
            final Degree degree = degrees[(int) Math.floor(position/4)];
            ((DegreeHolder) holder).bindValue(degree);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onDegreeClicked(degree);
                    }
                }
            });
        }
    }

    private void bindExperience(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ExperienceHolder) {
            final Experience experience = experiences[(int) Math.floor(position/4)];
            ((ExperienceHolder) holder).bindValue(experience);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onExperienceClicked(experience);
                    }
                }
            });
        }
    }

    public int getItemViewType(int position) {
        switch (position % 4) {
            case 0:
                return TYPE_TITLE;
            case 1:
                return TYPE_SKILL;
            case 2:
                return TYPE_DEGREE;
            case 3:
                return TYPE_EXPERIENCE;
        }
        return position;
    }

    public int getItemCount() {
        return skills.length + titles.length + degrees.length + experiences.length ;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class TitleHolder extends RecyclerView.ViewHolder {

        private TextView title;

        TitleHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.list_title_name);
        }

        void bindValue(String title) {
            this.title.setText(title);
        }

    }

    static class SkillHolder extends RecyclerView.ViewHolder {

        private TextView skill;
        private TextView percentage;

        SkillHolder(@NonNull View itemView) {
            super(itemView);
            skill = itemView.findViewById(R.id.list_skill_name);
            percentage = itemView.findViewById(R.id.skill_percentage);
        }

        void bindValue(Skill skill) {

            this.skill.setText(skill.getName());
            this.percentage.setText(skill.getPercentage());
        }

    }

    static class DegreeHolder extends RecyclerView.ViewHolder {

        private TextView degree;
        private TextView establishment;
        private TextView place;
        private TextView graduation;

        DegreeHolder(@NonNull View itemView) {
            super(itemView);
            degree = itemView.findViewById(R.id.list_degree_name);
            establishment = itemView.findViewById(R.id.degree_establishment);
            place = itemView.findViewById(R.id.degree_place);
            graduation = itemView.findViewById(R.id.degree_graduation);

        }

        void bindValue(Degree degree) {
            this.degree.setText(degree.getName());
            this.establishment.setText(degree.getEstablishment());
            this.place.setText(degree.getPlace());
            this.graduation.setText(degree.getGraduation());
        }

    }

    static class ExperienceHolder extends RecyclerView.ViewHolder {

        private TextView experience;
        private TextView place;
        private TextView period;

        ExperienceHolder(@NonNull View itemView) {
            super(itemView);
            experience = itemView.findViewById(R.id.list_experience_name);
            place = itemView.findViewById(R.id.experience_place);
            period = itemView.findViewById(R.id.experience_period);
        }

        void bindValue(Experience experience) {
            this.experience.setText(experience.getEstablishment());
            this.place.setText(experience.getPlace());
            this.period.setText(experience.getPeriod());
        }

    }

    public interface ClickListener {
        void onTitleClicked(String title);
        void onSkillClicked(Skill skill);
        void onDegreeClicked(Degree degree);
        void onExperienceClicked(Experience experience);
    }


}
