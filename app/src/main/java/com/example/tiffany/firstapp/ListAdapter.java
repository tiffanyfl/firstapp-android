package com.example.tiffany.firstapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

/**
 * Created by tiffany on 13/03/2018.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ProjectHolder> {

    private final Project[] projects;

    public ListAdapter(Project[] projects) {
        this.projects = projects;
    }

    @NonNull
    @Override
    public ProjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProjectHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item,
                                parent, false
                        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectHolder holder, int position) {
        holder.bindValue(projects[position]);
        Project positionProject = projects[position];
        holder.header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ProjectDetailsActivity.class);
                //intent.putExtra("test", projects);
                v.getContext().startActivity(intent);
            }
        });
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ProjectDetailsActivity.class);
                //intent.putExtra("test", projects);
                v.getContext().startActivity(intent);
            }
        });
        holder.tag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ProjectDetailsActivity.class);
                //intent.putExtra("test", projects);
                v.getContext().startActivity(intent);
            }
        });
        holder.description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ProjectDetailsActivity.class);
                //intent.putExtra("test", projects);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return projects.length;
    }

    public static class ProjectHolder extends RecyclerView.ViewHolder {

        private ImageView header;
        private TextView title;
        private TextView tag;
        private TextView description;

        public ProjectHolder(@NonNull View itemView) {
            super(itemView);
            header= itemView.findViewById(R.id.project_item_img);
            title = itemView.findViewById(R.id.project_item_title);
            tag = itemView.findViewById(R.id.project_item_tag);
            description = itemView.findViewById(R.id.project_item_description);
        }

        void bindValue(Project project) {
            title.setText(project.getName());
            tag.setText(project.getCategoryName());
            description.setText(project.getDescription());
            Picasso.get().load(project.getImg()).into(header);
        }
    }
}
