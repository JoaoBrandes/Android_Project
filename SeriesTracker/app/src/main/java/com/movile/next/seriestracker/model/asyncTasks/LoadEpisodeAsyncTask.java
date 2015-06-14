package com.movile.next.seriestracker.model.asyncTasks;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;


import com.movile.next.seriestracker.utils.FetchLocalEpisodeDetails;
import com.movile.next.seriestracker.model.Episode;
import com.movile.next.seriestracker.model.EpisodeLoader;

public class LoadEpisodeAsyncTask extends AsyncTask<Context, Void, Void> {
    private Episode episode;
    private EpisodeLoader loader;
    private Context context;
    public LoadEpisodeAsyncTask(Context context, EpisodeLoader loader){
        this.loader = loader;
        this.context = context;

    }

    public Void doInBackground(Context... params) {
        FetchLocalEpisodeDetails a = new FetchLocalEpisodeDetails();
        episode = a.get(context);
        return null;
    }

    protected void onPostExecute(Void result){
        loader.onEpisodeLoaded(episode);
    }

}