package com.movile.next.seriestracker.favorites;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.movile.next.seriestracker.R;
import com.movile.next.seriestracker.model.episodeModels.Show;
import com.movile.next.seriestracker.model.interfaces.EpisodeDetailsView;
import com.movile.next.seriestracker.model.interfaces.FavoritesListView;
import com.movile.next.seriestracker.model.interfaces.OnShowClickListener;
import com.movile.next.seriestracker.model.remote.client.EpisodeRemoteClient;

/**
 * Created by movile on 05/07/15.
 */
public class FavoritesLoaderCallback implements LoaderManager.LoaderCallbacks<Cursor>{

    private FavoritesListView loader;
    private FavoritesLoader client;
    public FavoritesLoaderCallback(FavoritesListView loader, Context context){
        client =  new FavoritesLoader( context.getString(R.string.api_url_base), context, this);
        this.loader = loader;
    }

    public Cursor getFavorites(){
       return client.loadInBackground();
    }

    public void getShowDetails(String slug){
        client.getShowDetails(slug);
    }

    public Loader<Cursor> onCreateLoader(int id, Bundle bundle) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> l, Cursor data) {
        loader.displayFavorites(data);
    }
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    public void onShowLoaded(Show show){

    }


}
