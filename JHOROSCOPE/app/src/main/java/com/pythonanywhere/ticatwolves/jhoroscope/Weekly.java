package com.pythonanywhere.ticatwolves.jhoroscope;


import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.content.Context.CONNECTIVITY_SERVICE;
import static android.content.Context.MODE_APPEND;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class Weekly extends Fragment {
    static TextView zdetail;
    String week = "http://horoscope-api.herokuapp.com/horoscope/week/";
    ConnectivityManager myconnManager;
    NetworkInfo myinfo;
    Fetchdetails c1;
    String name;
    public Weekly(String name) {
        this.name = name;
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weekly, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        zdetail = (TextView)getActivity().findViewById(R.id.zodiacwdetails);
        zdetail.setText("Mother");
        myconnManager = (ConnectivityManager)getActivity().getSystemService(CONNECTIVITY_SERVICE);
        myinfo = myconnManager.getActiveNetworkInfo();
/*
        if(myinfo!=null && myinfo.isConnected()){
            //c1 = new Fetchdetails(getContext(),1,1);
            //week = week + name;
            //c1.execute(week);
        }
        else {*/
            SharedPreferences sh1 = getActivity().getSharedPreferences("Zodiacoffline",MODE_APPEND);
            String s = sh1.getString(name+"w","");
            zdetail.setText(s.toString());
        //}

    }
}
