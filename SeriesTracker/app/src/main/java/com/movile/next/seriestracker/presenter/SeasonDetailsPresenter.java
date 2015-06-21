package com.movile.next.seriestracker.presenter;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;

import com.movile.next.seriestracker.R;
import com.movile.next.seriestracker.model.episodeModels.Episode;
import com.movile.next.seriestracker.model.episodeModels.Show;
import com.movile.next.seriestracker.model.interfaces.EpisodeDetailsView;
import com.movile.next.seriestracker.model.interfaces.EpisodePresenterCallback;
import com.movile.next.seriestracker.model.remote.client.EpisodeRemoteClient;

import java.util.List;

/**
 * Created by movile on 21/06/15.
 */
public class SeasonDetailsPresenter  implements LoaderManager.LoaderCallbacks<Episode>, EpisodePresenterCallback {

    private EpisodeDetailsView view;
    private Context context;
    private EpisodeRemoteClient client;

    public SeasonDetailsPresenter( Context context, EpisodeDetailsView view){
        this.view = view;
        this.context = context;
        client =  new EpisodeRemoteClient( context.getString(R.string.api_url_base), this);
    }

    @Override
    public void onEpisodeDetailsSuccess(Episode episode) {

    }

    @Override
    public void onSeasonDetailsSuccess(List<Episode> episodes) {

    }

    @Override
    public void onShowDetailsSuccess(Show show) {

    }

    @Override
    public Loader<Episode> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Episode> loader, Episode data) {

    }

    @Override
    public void onLoaderReset(Loader<Episode> loader) {

    }
}
