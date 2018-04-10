package com.smteck.androbd.birprotic.model;


import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.smteck.androbd.birprotic.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;

public class Muktijurda2 {
    String id;
    int point = 0 ;
    JSONArray data;
    String myURL = "https://undrooping-till.000webhostapp.com/muktijurda/android/getMuktijutdaDetail.php";

    public void get_all_data(){



    }

    public JSONArray get_one_person_data(JSONArray id1) {
        return  data;
    }


    public JSONArray get_one_person_data(String id1){
        id = id1;

        Log.d("Muktijurda2  = id-- ",id);
        myURL = "https://undrooping-till.000webhostapp.com/getMuktijurdaPersonalDetail.php?id="+id;
        Log.d("myurl", myURL);

         JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(myURL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("Delai in fo ","Found ");
                try {
                    data = new JSONArray(response.toString());

                    Log.d("Delai in fo ","Copy "+data.length());
                } catch (JSONException e) {
                    Log.d("Delai in fo ","Cant copy");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("--Volley Lod--",error);

            }
        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return data;

    }
}
