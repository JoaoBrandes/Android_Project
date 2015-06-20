package com.movile.next.seriestracker.view;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.movile.next.seriestracker.R;
import com.movile.next.seriestracker.model.episodeModels.Episode;
import com.movile.next.seriestracker.model.episodeModels.Images;
import com.movile.next.seriestracker.model.interfaces.EpisodeDetailsView;
import com.movile.next.seriestracker.presenter.EpisodeDetailsPresenter;
import com.movile.next.seriestracker.utils.FormatUtil;


import java.util.Date;


public class EpisodeDetailsActivity extends ActionBarActivity  implements EpisodeDetailsView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.episode_details_activity);
        String show = "game-of-thrones";
        Long season = Long.valueOf(5);
        Long episode = Long.valueOf(7);
        EpisodeDetailsPresenter client = new EpisodeDetailsPresenter(this, this);
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
    }
}
