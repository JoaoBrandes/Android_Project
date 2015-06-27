package com.movile.next.seriestracker.model.interfaces;

import com.movile.next.seriestracker.model.episodeModels.Season;
import com.movile.next.seriestracker.model.episodeModels.Show;

import java.util.List;

/**
 * Created by movile on 21/06/15.
 */
public interface ShowDetailsView {
    void displaySeasons(List<Season> seasons);
}
