package com.movile.next.seriestracker.model.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.movile.next.seriestracker.model.Episode;
import com.movile.next.seriestracker.utils.FetchLocalEpisodeDetails;
import com.movile.next.seriestracker.utils.FetchRemoteEpisodeDetails;

/**
 * Created by movile on 14/06/15.
 */
public class EpisodeLoader extends AsyncTaskLoader<Void> {

    private Context context;
    private EpisodeLoader loader;
    private Episode episode;
    private String url;
    public EpisodeLoader(Context context, EpisodeLoader loader, String url){
        super(context);
        this.loader = loader;
        this.context = context;
        this.url = url;
    }
    @Override
    public Void loadInBackground() {
        FetchRemoteEpisodeDetails a = new FetchRemoteEpisodeDetails();
        episode = a.get(context, url);
        return null;
    }
}
