package com.movile.next.seriestracker.model.interfaces;

import com.movile.next.seriestracker.model.episodeModels.Episode;

/**
 * Created by movile on 20/06/15.
 */
public interface EpisodePresenterCallback {
    void onEpisodeDetailsSuccess(Episode episode);
}
