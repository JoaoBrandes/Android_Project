package com.movile.next.seriestracker.favorites;

import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.util.Log;

import com.movile.next.seriestracker.database.dbFlow.dao.FavoriteDAO;
import com.movile.next.seriestracker.model.episodeModels.Show;
import com.movile.next.seriestracker.model.interfaces.EpisodeRemoteService;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by movile on 05/07/15.
 */
public class FavoritesLoader extends CursorLoader {
    private Context mContext;
    private FavoritesLoaderCallback mCallback;
    private RestAdapter mAdapter;
    public FavoritesLoader(String endpoint, Context context, FavoritesLoaderCallback callback) {
        super(context);
        this.mContext = context;
        mCallback = callback;
        mAdapter = new RestAdapter.Builder().setEndpoint(endpoint).build();
    }

    public Cursor loadInBackground() {
        Log.d("DEBUGANDO","loadInBackground");
        FavoriteDAO dao = new FavoriteDAO(mContext);
        Cursor cursor = dao.all();
        return cursor;
    }

    public void getShowDetails(String show){
        EpisodeRemoteService service = mAdapter.create(EpisodeRemoteService.class);

        service.getShow(show, new Callback<Show>() {
            @Override
            public void success(Show show, Response response) {
                mCallback.onShowLoaded(show);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("Error", "Failure to recover Show seasons." + error.getMessage() + " URL=" + error.getUrl());
            }
        });
    }
}

