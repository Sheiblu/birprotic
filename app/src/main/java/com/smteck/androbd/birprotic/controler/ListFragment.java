package com.smteck.androbd.birprotic.controler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.smteck.androbd.birprotic.model.AppController;
import com.smteck.androbd.birprotic.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ListFragment extends Fragment {


    TextView textWorning;
    ListView listViewName;

    String [] name ;
    String [] place_birth  ;
    String [] other_award ;
    String [] nationality ;
    String [] work_edu  ;
    String [] role_war ;



    public ListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View v = inflater.inflate(R.layout.fragment_list, container, false);

        listViewName = (ListView) v.findViewById(R.id.listViewName);
        textWorning = (TextView) v.findViewById(R.id.textWorning);

        fetchingData();

        return v;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listViewName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position1, long id) {

                // Intent i=new Intent(getActivity(),detailsInfo_activity.class);
                Log.d("Variable Inatial", "method :::::: "+position1);

                DetailFragment objdetailInfoFragment = new DetailFragment();
                Bundle args = new Bundle();

                args.putString("name",name[position1]);
                args.putString("place_birth",place_birth[position1]);
                args.putString("other_award",other_award[position1]);
                args.putString("nationality",nationality[position1]);
                args.putString("work_edu",work_edu[position1]);
                args.putString("role_war",role_war[position1]);


                objdetailInfoFragment.setArguments(args);

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame,objdetailInfoFragment).commit();
                // fragmentManager.beginTransaction().add(R.id.frame, objdetailInfoFragment).replace(R.id.frame, objdetailInfoFragment).commit();


            }
        });
    }



    void fetchingData() {

        String myURL = "https://undrooping-till.000webhostapp.com/getMuktijurdaDetail.php";


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(myURL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                name = new String[response.length()];
                place_birth = new String[response.length()] ;
                other_award = new String[response.length()];
                nationality = new String[response.length()];
                work_edu = new String[response.length()] ;
                role_war = new String[response.length()];





                for (int i = 0 ; i < response.length();i++){

                    try {
                        JSONObject jsonObject = (JSONObject) response.get(i);

                        name [i]  = jsonObject.getString("muktijurda_name");
                        place_birth [i] =  jsonObject.getString("birthday_place");
                        other_award [i]  = jsonObject.getString("other_award");
                        nationality [i]  = jsonObject.getString("nationality");
                        work_edu [i] =  jsonObject.getString("education_and_work");
                        role_war [i]  = jsonObject.getString("roal_in_war");

                        textWorning.setHeight(45);
                        textWorning.setText(" Name List");


                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.d("Exception","so");
                        Toast.makeText(getContext(),"Data Somethink Wrong "+e,Toast.LENGTH_SHORT).show();
                    }
                }

                Toast.makeText(getContext(),"Data  Found  ",Toast.LENGTH_LONG).show();
                listViewName.setAdapter(new ArrayAdapter(getContext(),R.layout.listshow,R.id.textViewName ,name));


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("--Volley Lod--",error);
                textWorning.setText(" Problem Please Check your internet");
            }
        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

    }

}
