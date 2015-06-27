package com.movile.next.seriestracker.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.movile.next.seriestracker.R;
import com.movile.next.seriestracker.activity.base.BaseLoadingActivity;
import com.movile.next.seriestracker.activity.base.BaseNavigationToolbarActivity;
import com.movile.next.seriestracker.model.episodeModels.Episode;
import com.movile.next.seriestracker.model.episodeModels.Images;
import com.movile.next.seriestracker.model.episodeModels.Season;
import com.movile.next.seriestracker.model.interfaces.EpisodeDetailsView;
import com.movile.next.seriestracker.presenter.EpisodeDetailsPresenter;
import com.movile.next.seriestracker.utils.FormatUtil;


import java.util.Date;
import java.util.List;


public class EpisodeDetailsActivity extends BaseNavigationToolbarActivity implements EpisodeDetailsView {

    public static final String EXTRA_SHOW = "extra_show";
    public static final String EXTRA_SEASON = "extra_season";
    public static final String EXTRA_EPISODE = "extra_episode";


    private String show;
    private long season;
    private long episode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.episode_details_activity);
        configureToolbar();
        showLoading();
        EpisodeDetailsPresenter client = new EpisodeDetailsPresenter(this, this);
        getExtras();
        client.getEpisodeDetails(show, season, episode);
    }

    @Override
    public void displayEpisode(Episode episode) {
        if(episode != null) {
            TextView title = (TextView) findViewById(R.id.episode_title);
            title.setText(episode.title());
            TextView episodeOverview = (TextView) findViewById(R.id.episode_details_overview);
            episodeOverview.setText(episode.overview());
            TextView date = (TextView) findViewById(R.id.episode_details_exhibition_date);
            String da = episode.firstAired();
            Date d = FormatUtil.formatDate(da);
            String dateFinal = FormatUtil.formatDate(d);
            date.setText(dateFinal);
            ImageView view = (ImageView)findViewById(R.id.screenshot_overlay);
            String screenshotURL = episode.images().screenshot().get(Images.ImageSize.THUMB);
            Glide.with(this).load(screenshotURL).placeholder(R.drawable.season_details_show_placeholder).centerCrop().into(view);

        } else {
            Log.w("Error", "Episode Null");
        }

        hideLoading();
    }

    @Override
    public void displaySeason(List<Episode> eps) {

    }

    @Override
    public void displaySeasonList(List<Season> seasons) {

    }

    private void getExtras(){
        Bundle bundle = getIntent().getExtras();
        show = bundle.getString(EXTRA_SHOW);
        season = bundle.getLong(EXTRA_SEASON);
        episode = bundle.getLong(EXTRA_EPISODE);
    }
}
