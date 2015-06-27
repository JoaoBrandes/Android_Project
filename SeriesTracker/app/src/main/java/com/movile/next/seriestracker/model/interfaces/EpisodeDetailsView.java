package com.movile.next.seriestracker.model.interfaces;

import com.movile.next.seriestracker.model.episodeModels.Episode;
import com.movile.next.seriestracker.model.episodeModels.Season;

import java.util.List;

/**
 * Created by movile on 14/06/15.
 */
public interface EpisodeDetailsView {
     void displayEpisode(Episode episode);

     void displaySeason(List<Episode> eps);

     void displaySeasonList(List<Season> seasons);
}
