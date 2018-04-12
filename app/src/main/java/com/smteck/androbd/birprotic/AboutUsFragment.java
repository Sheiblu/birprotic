package com.smteck.androbd.birprotic;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class AboutUsFragment extends Fragment {


    public AboutUsFragment() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_about_us, container, false);
    }


    public void onButtonPressed(Uri uri) {
        int count = getFragmentManager().getBackStackEntryCount();
        if (count == 0) {
            //super.onBackPressed();
            //additional code
        } else {
            getFragmentManager().popBackStack();
        }
    }


}
