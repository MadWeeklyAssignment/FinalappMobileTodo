package com.example.finalappmobiletodo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class RatingFragment extends Fragment {

    private static final int YES = 0;
    private static final int NO = 1;

    public RatingFragment() {
        // Required empty public constructor
    }

    public static RatingFragment newInstance() {
        return new RatingFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_rating,
                container, false);


        return rootView;
    }
}