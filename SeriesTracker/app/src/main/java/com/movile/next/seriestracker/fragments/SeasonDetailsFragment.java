package com.movile.next.seriestracker.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.movile.next.seriestracker.R;
import com.movile.next.seriestracker.model.adapter.RecyclerAdapter;
import com.movile.next.seriestracker.model.episodeModels.Season;
import com.movile.next.seriestracker.model.interfaces.OnSeasonClickListener;

/**
 * Created by movile on 21/06/15.
 */
public class SeasonDetailsFragment extends Fragment {

    public static final String EXTRA_SHOW = "extra_show";
    private String mShow;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mShow =  getArguments().getSerializable(EXTRA_SHOW).toString();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.show_seasons_fragment, container, false);
    }
}