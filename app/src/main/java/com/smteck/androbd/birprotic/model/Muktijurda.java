package com.smteck.androbd.birprotic.model;


import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Muktijurda {
    String id;
    String data;

    String myURL = "https://undrooping-till.000webhostapp.com/muktijurda/android/getMuktijutdaDetail.php";

    public void get_all_data(){



    }

    public String get_one_person_data(String id1){
        id = id1;
        Log.d("data",id);
         myURL = "https://undrooping-till.000webhostapp.com/getMuktijurdaPersonalDetail.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, myURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                data = response;
                Log.d("data come", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error","----------------");
                data = "error";

            }
        }) {
            protected Map<String,String> getParams() {
                Map<String ,String> parr = new HashMap<String,String>();
                parr.put("id",id);
                return parr;
            }

        };

        Log.d("Back Time","-----Back time----");
        AppController.getInstance().addToRequestQueue(stringRequest);
        return data;

    }
}
