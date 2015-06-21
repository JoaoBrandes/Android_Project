package com.movile.next.seriestracker.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.movile.next.seriestracker.R;
import com.movile.next.seriestracker.activity.base.BaseNavigationToolbarActivity;
import com.movile.next.seriestracker.model.adapter.EpisodeLoaderAdapter;
import com.movile.next.seriestracker.model.episodeModels.Episode;
import com.movile.next.seriestracker.model.interfaces.EpisodeDetailsView;
import com.movile.next.seriestracker.model.interfaces.OnContentClickListener;
import com.movile.next.seriestracker.presenter.EpisodeDetailsPresenter;

import java.util.List;

public class SeasonDetailsActivity extends BaseNavigationToolbarActivity implements OnContentClickListener, EpisodeDetailsView {
    private EpisodeLoaderAdapter adapter;

    private String show = "house";
    private Long season = 1l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season_details);
        configureToolbar();
        ListView view = (ListView) findViewById(R.id.list_view);
        View header = findViewById(R.id.season_details_header);
        //view.addHeaderView(header, null, false);
        adapter = new EpisodeLoaderAdapter(this, this);
        view.setAdapter(adapter);

        EpisodeDetailsPresenter client = new EpisodeDetailsPresenter(this, this);
        client.getSeasonDetails(show, season);
    }

    @Override
    public void displayEpisode(Episode episode) {

    }

    @Override
    public void displaySeason(List<Episode> eps) {
        adapter.updateEpisodesList(eps);
    }

    @Override
    public void onEpisodeClick(Episode episode) {
        Intent intent = new Intent(this, EpisodeDetailsActivity.class);
        intent.putExtra(EpisodeDetailsActivity.EXTRA_SHOW, show);
        intent.putExtra(EpisodeDetailsActivity.EXTRA_SEASON, season);
        intent.putExtra(EpisodeDetailsActivity.EXTRA_EPISODE, episode.number());
        startActivity(intent);
    }
}
