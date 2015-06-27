package com.movile.next.seriestracker.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.movile.next.seriestracker.R;
import com.movile.next.seriestracker.activity.base.BaseNavigationToolbarActivity;
import com.movile.next.seriestracker.fragments.SeasonDetailsFragment;
import com.movile.next.seriestracker.model.adapter.RecyclerAdapter;
import com.movile.next.seriestracker.model.adapter.ShowContentAdapter;
import com.movile.next.seriestracker.model.episodeModels.Season;
import com.movile.next.seriestracker.model.episodeModels.Show;
import com.movile.next.seriestracker.model.interfaces.OnSeasonClickListener;
import com.movile.next.seriestracker.model.interfaces.ShowDetailsView;
import com.movile.next.seriestracker.presenter.ShowDetailsPresenter;

import java.util.List;

public class ShowDetailsActivity extends BaseNavigationToolbarActivity implements ShowDetailsView, OnSeasonClickListener {

    private ShowDetailsPresenter mPresenter;
    private ShowContentAdapter adapter;

    private String mSlug = "game-of-thrones";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        configureToolbar();
        ViewPager pager = (ViewPager) findViewById(R.id.show_details_content);
        adapter = new ShowContentAdapter(getSupportFragmentManager(), mSlug);
        pager.setAdapter(adapter);
        mPresenter = new ShowDetailsPresenter(this, this);
        mPresenter.loadShow(mSlug);
    }

    @Override
    public void displaySeasons(List<Season> seasons) {
        RecyclerView view = (RecyclerView) findViewById(R.id.recycler_view);

        view.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        RecyclerAdapter adapter = new RecyclerAdapter(this, this, R.layout.season_list_item);
        adapter.setContent(seasons);
        view.setAdapter(adapter);

        Log.d("DEBUGANDO", "Estou com a lista de temporadas. Size "+ seasons.size());
    }

    @Override
    public void onSeasonClick(Season content) {
        Log.d("DEBUGANDO","Season Clicked");
        Intent intent = new Intent(this, SeasonDetailsActivity.class);
        intent.putExtra(EpisodeDetailsActivity.EXTRA_SHOW, mSlug);
        intent.putExtra(EpisodeDetailsActivity.EXTRA_SEASON, content.number());
        startActivity(intent);
    }
}
