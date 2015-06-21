package com.movile.next.seriestracker.model.interfaces;

import com.movile.next.seriestracker.model.episodeModels.Episode;

import java.util.List;

/**
 * Created by movile on 20/06/15.
 */
public interface EpisodePresenterCallback {
    void onEpisodeDetailsSuccess(Episode episode);

    void onSeasonDetailsSuccess(List<Episode> episodes);
}
