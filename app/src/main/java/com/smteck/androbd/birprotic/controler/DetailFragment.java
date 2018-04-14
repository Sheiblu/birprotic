package com.smteck.androbd.birprotic.controler;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smteck.androbd.birprotic.R;



public class DetailFragment extends Fragment {

    TextView tvName,tvDetail,tvAward,tvEducation,tvVumika, tvNationality;

    private String name;
    private String place_birth;
    private String work_edu;
    private String role_war;
    private String other_award;
    private String nationality;

    public DetailFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_detail, container, false);


        name = getArguments().getString("name");
        place_birth = getArguments().getString("place_birth");
        work_edu = getArguments().getString("work_edu");
        role_war = getArguments().getString("role_war");
        other_award = getArguments().getString("other_award");
        nationality = getArguments().getString("nationality");


        tvName = (TextView) v.findViewById(R.id.textViewName);
        tvAward = (TextView) v.findViewById(R.id.textViewAward);
        tvDetail = (TextView) v.findViewById(R.id.textViewDetail);
        tvEducation = (TextView) v.findViewById(R.id.textViewEducation);
        tvVumika = (TextView) v.findViewById(R.id.textViewVumica);
        tvNationality = (TextView) v.findViewById(R.id.textViewNationality);

        tvName.setText(name);
        tvAward.setText(other_award);
        tvDetail.setText(place_birth);
        tvEducation.setText(work_edu);
        tvVumika.setText(role_war);
        tvNationality.setText(nationality);



        return v;
    }



}
