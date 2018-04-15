package com.example.tiffany.firstapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tiffany on 14/03/2018.
 */

public class WhoAmIFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_whoiam, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.Facebook).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "44444444444";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel:" +number));
                startActivity(intent);
            }
        });

        view.findViewById(R.id.Twitter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "44444444444";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel:" +number));
                startActivity(intent);
            }
        });

        view.findViewById(R.id.Linkedin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "44444444444";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel:" +number));
                startActivity(intent);
            }
        });
    }
}
