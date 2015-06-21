package com.movile.next.seriestracker.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.movile.next.seriestracker.R;

/**
 * Created by movile on 21/06/15.
 */
public class SeasonDetailsFragment extends Fragment {

    public static final String EXTRA_SHOW = "extra_show";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.show_seasons_fragment, container, false);
    }

}
