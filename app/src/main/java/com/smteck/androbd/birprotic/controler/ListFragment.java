package com.smteck.androbd.birprotic.controler;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.smteck.androbd.birprotic.AppController;
import com.smteck.androbd.birprotic.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ListFragment extends Fragment {

    TextView tbViewInfo;
    ListView listViewName;
    String [] dataId ;
    String [] dataName  ;
    String [] dataAge ;


    public ListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View v = inflater.inflate(R.layout.fragment_list, container, false);

        listViewName = (ListView) v.findViewById(R.id.listViewName);
       // fetchingData();

        String myURL = "https://undrooping-till.000webhostapp.com/getMuktijurdaDetail.php";
        //String myURL = "https://undrooping-till.000webhostapp.com/getdata.php";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(myURL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                dataId = new String[response.length()];
                dataName = new String[response.length()] ;
                dataAge = new String[response.length()];


                for (int i = 0 ; i < response.length();i++){

                    try {
                        JSONObject jsonObject = (JSONObject) response.get(i);

                        dataId [i]  = jsonObject.getString("muktijurda_id");
                        dataName [i] =  jsonObject.getString("muktijurda_name");
                        dataAge [i]  = jsonObject.getString("award");


//                        dataId [i]  = jsonObject.getString("Id");
//                        dataName [i] =  jsonObject.getString("Name");
//                        dataAge [i]  = jsonObject.getString("image");


                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.d("Exception","so");
                        Toast.makeText(getContext(),"Data Somethink Wrong "+e,Toast.LENGTH_SHORT).show();
                    }
                }

                Toast.makeText(getContext(),"Data  Found  ",Toast.LENGTH_LONG).show();
                listViewName.setAdapter(new ArrayAdapter(getContext(),R.layout.listshow,R.id.textViewName ,dataName));

                listViewName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

//                        Intent k = new Intent(getContext(),DetailActivity.class);
//
//                        k.putExtra("name",dataName[i]);
//                        k.putExtra("id",dataId[i]);
//                        k.putExtra("age",dataAge[i]);
//
//                        startActivity(k);
                        Toast.makeText(getContext(),"My id = "+dataId[i],Toast.LENGTH_LONG).show();

                    }
                });

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("--Volley Lod--",error);
            }
        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

        return v;
    }









    void fetchingData() {

      //  String myURL = "https://undrooping-till.000webhostapp.com/muktijurda/android/getMuktijutdaDetail.php";
        String myURL = "https://undrooping-till.000webhostapp.com/getdata.php";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(myURL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                dataId = new String[response.length()];
                dataName = new String[response.length()] ;
                dataAge = new String[response.length()];


                for (int i = 0 ; i < response.length();i++){

                    try {
                        JSONObject jsonObject = (JSONObject) response.get(i);

//                        dataId [i]  = jsonObject.getString("muktijurda_id");
//                        dataName [i] =  jsonObject.getString("muktijurda_name");
//                        dataAge [i]  = jsonObject.getString("image");

                        dataId [i]  = jsonObject.getString("Id");
                        dataName [i] =  jsonObject.getString("Name");
                        dataAge [i]  = jsonObject.getString("Age");


                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(getContext(),"Data Somethink Wrong "+e,Toast.LENGTH_SHORT).show();
                    }
                }

                Toast.makeText(getContext(),"Data  Found  ",Toast.LENGTH_LONG).show();
                listViewName.setAdapter(new ArrayAdapter(getContext(),R.layout.listshow,R.id.textViewName ,dataName));

                listViewName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

//                        Intent k = new Intent(getContext(),DetailActivity.class);
//
//                        k.putExtra("name",dataName[i]);
//                        k.putExtra("id",dataId[i]);
//                        k.putExtra("age",dataAge[i]);
//
//                        startActivity(k);
                        Toast.makeText(getContext(),"My id = "+dataId[i],Toast.LENGTH_LONG).show();

                    }
                });

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Volley Lod",error);
            }
        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);


    }



}
