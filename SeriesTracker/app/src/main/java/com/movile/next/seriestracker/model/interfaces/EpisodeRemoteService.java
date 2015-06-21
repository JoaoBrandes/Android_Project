package com.movile.next.seriestracker.model.interfaces;

import com.movile.next.seriestracker.model.episodeModels.Episode;
import com.movile.next.seriestracker.model.episodeModels.Show;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;

/**
 * Created by movile on 20/06/15.
 */
public interface EpisodeRemoteService {

    @Headers({
            "trakt-api-version: " + 2,
            "trakt-api-key: " + "e3241d30014ea9657997695fae248f5369fff759daed9a3400e7b9cffb6f6c62"
    })
    @GET("/shows/{show}/seasons/{season}/episodes/{episode}?extended=full,images")
    void getEpisodeDetails(
            @Path("show") String show,
            @Path("season") Long season,
            @Path("episode") Long episode,
            Callback<Episode> callback);

    @Headers({
            "trakt-api-version: " + 2,
            "trakt-api-key: " + "e3241d30014ea9657997695fae248f5369fff759daed9a3400e7b9cffb6f6c62"
    })
    @GET("/shows/{show}/seasons/{season}?extended=full,images")
    void getSeasonDetails(
            @Path("show") String show,
            @Path("season") Long season,
            Callback<List<Episode>> callback);

    @Headers({
            "trakt-api-version: " + 2,
            "trakt-api-key: " + "e3241d30014ea9657997695fae248f5369fff759daed9a3400e7b9cffb6f6c62"
    })
    @GET("/shows/{show}?extended=full,images")
    void getShow(
            @Path("show") String show,
            Callback<Show> callback);

}
