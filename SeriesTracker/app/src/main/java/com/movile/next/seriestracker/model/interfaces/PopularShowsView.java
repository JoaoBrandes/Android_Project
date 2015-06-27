package com.movile.next.seriestracker.model.interfaces;

import com.movile.next.seriestracker.model.episodeModels.Show;

import java.util.List;

/**
 * Created by movile on 27/06/15.
 */
public interface PopularShowsView {
    void displaySeasons(List<Show> seasons);
}
