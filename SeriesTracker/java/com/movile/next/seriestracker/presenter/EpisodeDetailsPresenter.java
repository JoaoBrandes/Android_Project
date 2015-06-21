package com.movile.next.seriestracker.presenter;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;

import com.movile.next.seriestracker.R;
import com.movile.next.seriestracker.model.episodeModels.Episode;
import com.movile.next.seriestracker.model.interfaces.EpisodeDetailsView;
import com.movile.next.seriestracker.model.interfaces.EpisodePresenterCallback;
import com.movile.next.seriestracker.model.loaders.EpisodeLoaderCallback;
import com.movile.next.seriestracker.model.remote.client.EpisodeRemoteClient;

/**
 * Created by movile on 20/06/15.
 */
public class EpisodeDetailsPresenter implements LoaderManager.LoaderCallbacks<Episode>, EpisodePresenterCallback {
    private EpisodeDetailsView view;
    private Context context;
    private EpisodeRemoteClient client;

    public EpisodeDetailsPresenter( Context context, EpisodeDetailsView view){
        this.view = view;
        this.context = context;
        client =  new EpisodeRemoteClient( context.getString(R.string.api_url_base), this);
    }

    public void onEpisodeDetailsSuccess(Episode episode) {
        view.displayEpisode(episode);
    }

    public void getEpisodeDetails(String show, Long season, Long episode){
        client.getEpisodeDetails(show, season, episode);
    }
//
//    private String getMockUrl(){
//        return context.getString(R.string.api_url_base) + context.getString(R.string.api_url_episode) + "?extended=full, images";
//    }


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
