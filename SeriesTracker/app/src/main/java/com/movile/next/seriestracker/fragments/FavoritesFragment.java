package com.movile.next.seriestracker.fragments;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.movile.next.seriestracker.R;
import com.movile.next.seriestracker.favorites.FavoritesAdapter;
import com.movile.next.seriestracker.favorites.FavoritesLoaderCallback;
import com.movile.next.seriestracker.model.interfaces.FavoritesListView;
import com.movile.next.seriestracker.model.interfaces.OnShowClickListener;

/**
 * Created by movile on 05/07/15.
 */
public class FavoritesFragment extends Fragment implements OnShowClickListener, FavoritesListView{
    private FavoritesAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d("DEBUGANDO","TO NO FAVORITES FRAGMENT");
        Context c = getActivity();
        FavoritesLoaderCallback callback = new FavoritesLoaderCallback(this, c);
        Log.d("DEBUGANDO","Começando a carregar os favoritos");
        Cursor favorites = callback.getFavorites();
        Log.d("DEBUGANDO","Favoritos carregados ");


        adapter = new FavoritesAdapter(getActivity(), favorites, this);
        adapter.swapCursor(favorites);
        ListView view = (ListView)getActivity().findViewById(R.id.favorites_items);
        view.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.base_navigation_drawer_activity, container, false);
    }

    @Override
    public void onShowClick(String slug) {

    }



    @Override
    public void displayFavorites(Cursor cursor) {

    }
}
