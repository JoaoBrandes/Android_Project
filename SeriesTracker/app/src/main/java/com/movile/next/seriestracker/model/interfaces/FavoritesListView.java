package com.movile.next.seriestracker.model.interfaces;

import android.database.Cursor;
import android.os.Bundle;

/**
 * Created by movile on 05/07/15.
 */
public interface FavoritesListView {
    void displayFavorites(Cursor cursor);
}
