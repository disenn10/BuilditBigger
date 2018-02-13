package com.example.disen.builditbigger;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.MyJokes;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;


public class MainActivityFragment extends Fragment {
    TextView textView;


    public MainActivityFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_activity, container, false);
        textView = view.findViewById(R.id.instructions_text_view);
        AdView adView = new AdView(getActivity());
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
        AdView mAdview = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);
        //MyJokes joke = new MyJokes();
        //textView.setText(joke.getJoke());
        // Inflate the layout for this fragment
        return view;
    }

}
