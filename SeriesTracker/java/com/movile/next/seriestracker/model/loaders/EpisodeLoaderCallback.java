package com.movile.next.seriestracker.model.loaders;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;

import com.movile.next.seriestracker.model.episodeModels.Episode;
import com.movile.next.seriestracker.model.interfaces.EpisodeDetailsView;

/**
 * Created by movile on 14/06/15.
 */
public class EpisodeLoaderCallback implements LoaderManager.LoaderCallbacks<Episode> {
    private Context context ;
    private String url;
    private EpisodeDetailsView loader;
    public EpisodeLoaderCallback(Context context, EpisodeDetailsView loader, String url){
        this.context = context;
        this.url = url;
        this.loader = loader;
    }

    @Override
    public Loader<Episode> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Episode> l, Episode data) {
        loader.displayEpisode(data);
    }

    public void onEpisodeLoaded(Episode episode){
        loader.displayEpisode(episode);
    }

    @Override
    public void onLoaderReset(Loader<Episode> loader) {

    }
}
