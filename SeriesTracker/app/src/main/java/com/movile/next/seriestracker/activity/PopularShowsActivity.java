package com.movile.next.seriestracker.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.movile.next.seriestracker.R;
import com.movile.next.seriestracker.activity.base.BaseNavigationToolbarActivity;
import com.movile.next.seriestracker.model.episodeModels.Show;
import com.movile.next.seriestracker.model.interfaces.OnSeasonClickListener;
import com.movile.next.seriestracker.model.interfaces.OnShowClickListener;
import com.movile.next.seriestracker.model.interfaces.PopularShowsView;
import com.movile.next.seriestracker.model.interfaces.ShowDetailsView;

import java.util.List;

public class PopularShowsActivity  extends BaseNavigationToolbarActivity implements PopularShowsView, OnShowClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_shows);

    }

    @Override
    public void onShowClick(Show show) {

    }

    @Override
    public void displaySeasons(List<Show> seasons) {

    }
}
