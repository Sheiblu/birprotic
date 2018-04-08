package com.smteck.androbd.birprotic.controler;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smteck.androbd.birprotic.R;
import com.smteck.androbd.birprotic.model.Muktijurda;
import com.smteck.androbd.birprotic.model.Muktijurda2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class DelailInfoFragment extends Fragment {

    String id = "567";
    JSONArray data ;
    String  name , place_birth , other_award , nationality ;
    String  work_edu , role_war , award;
    int  image;


    public DelailInfoFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_delail_info, container, false);

        Muktijurda2 muktijurda = new Muktijurda2();


        Log.d("Detail","Start");

        //id = getArguments().getString("id");
        Log.d("id",id);
        data = muktijurda.get_one_person_data(id);

        try {


            Log.d("Fieeeeeend", "1");
            JSONObject jsonObject = (JSONObject) data.get(0);

            Log.d("Fieeeeeend", "2");
            name = jsonObject.getString("muktijurda_name");
            Log.d("Fieeeeeend", "3");
            place_birth = jsonObject.getString("birthday_place");
            work_edu = jsonObject.getString("education_and_work");
            role_war = jsonObject.getString("roal_in_war");
            award = jsonObject.getString("award");
            other_award = jsonObject.getString("other_award");
            nationality = jsonObject.getString("nationality");

            Log.d("Fieeeeeend", nationality);

        }catch (Exception e){
            Log.d("reeor", String.valueOf(e)+ data.length());
        }

        Log.d("reeor", "Finish");



        return v;
    }



    public void convert_data_from_jesson_string(JSONArray response) throws JSONException {
        JSONObject jsonObject = new JSONObject();

        name = jsonObject.getString("muktijurda_name");
        place_birth = jsonObject.getString("birthday_place");
        work_edu = jsonObject.getString("education_and_work");
        role_war = jsonObject.getString("roal_in_war");
        award = jsonObject.getString("award");
        other_award = jsonObject.getString("other_award");
        nationality = jsonObject.getString("nationality");
    }


}
