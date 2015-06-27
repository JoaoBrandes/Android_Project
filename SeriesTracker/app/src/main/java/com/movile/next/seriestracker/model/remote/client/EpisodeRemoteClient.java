package com.movile.next.seriestracker.model.remote.client;

import android.util.Log;

import com.movile.next.seriestracker.model.episodeModels.Episode;
import com.movile.next.seriestracker.model.episodeModels.Season;
import com.movile.next.seriestracker.model.episodeModels.Show;
import com.movile.next.seriestracker.model.interfaces.EpisodePresenterCallback;
import com.movile.next.seriestracker.model.interfaces.EpisodeRemoteService;
import com.movile.next.seriestracker.model.loaders.EpisodeLoaderCallback;
import com.movile.next.seriestracker.presenter.EpisodeDetailsPresenter;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by movile on 20/06/15.
 */
public class EpisodeRemoteClient {
    private static final String TAG = EpisodeRemoteClient.class.getName();

    private RestAdapter mAdapter;
    private EpisodePresenterCallback mCallback;

    public EpisodeRemoteClient(String endpoint, EpisodePresenterCallback mCallback){
        mAdapter = new RestAdapter.Builder().setEndpoint(endpoint).build();
        this.mCallback = mCallback;
    }

    public void getEpisodeDetails(String show, Long season, Long episode){
        EpisodeRemoteService service = mAdapter.create(EpisodeRemoteService.class);
        service.getEpisodeDetails(show, season, episode, new Callback<Episode>() {
            @Override
            public void success(Episode episode, Response response) {
                mCallback.onEpisodeDetailsSuccess(episode);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("Error", "Failure to recover episode");
            }
        });
    }

    public void getSeasonDetails(String show, Long season) {
        EpisodeRemoteService service = mAdapter.create(EpisodeRemoteService.class);
        service.getSeasonDetails(show, season, new Callback<List<Episode>>() {
            @Override
            public void success(List<Episode> episodes, Response response) {
                mCallback.onSeasonDetailsSuccess(episodes);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("Error", "Failure to recover seasons");
            }
        });
    }

    public void getShowDetails(String show){
        EpisodeRemoteService service = mAdapter.create(EpisodeRemoteService.class);

        service.getShowSeasons(show, new Callback<List<Season>>() {
            @Override
            public void success(List<Season> seasons, Response response) {
                Log.d("DEBUGANDO", "Success");
                mCallback.onShowSeasonsDetailsSuccess(seasons);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("Error", "Failure to recover Show seasons." + error.getMessage() + " URL=" + error.getUrl());
            }
        });
    }

    public void getPopularShows(){
        EpisodeRemoteService service = mAdapter.create(EpisodeRemoteService.class);
        service.getPopularShows(new Callback<List<Show>>() {
            @Override
            public void success(List<Show> shows, Response response) {
                mCallback.onPopularShowsSuccess(shows);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("Error", "Failure to recover Show seasons."+error.getMessage()+" URL=" + error.getUrl());
            }
        });
    }
}
