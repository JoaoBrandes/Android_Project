package com.movile.next.seriestracker.utils;

import android.content.Context;
import android.util.Log;

import com.movile.next.seriestracker.R;
import com.movile.next.seriestracker.model.episodeModels.Episode;
import com.movile.next.seriestracker.model.converter.ModelConverter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;

public class FetchRemoteEpisodeDetails {

    private static final String TAG = FetchRemoteEpisodeDetails.class.getSimpleName();
    //private static final String ASSET_NAME = "episode.json";

    public Episode get(Context context, String fUrl) {
        Episode episode = null;
        InputStreamReader reader = null;

        try {
            Log.w("Original URL VALUE", fUrl);
            String url = MessageFormat.format(fUrl, "game-of-thrones", 1, 1);
            Log.w("URL VALUE", url);
            HttpURLConnection connection = configureConnection(context, url);
            connection.connect();
            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream stream = connection.getInputStream();
                reader = new InputStreamReader(stream);
                episode = new ModelConverter().toEpisode(reader);
            }
        } catch (IOException e) {
            Log.e(TAG, "Error loading local content from file", e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    Log.e(TAG, "Error releasing resource", e);
                }
            }
        }
        return episode;
    }

    public HttpURLConnection configureConnection(Context context, String url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setReadTimeout(context.getResources().getInteger(R.integer.api_timeout_read));
        connection.setConnectTimeout(context.getResources().getInteger(R.integer.api_timeout_connect));
        connection.setRequestMethod("GET");
        connection.setDoInput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("trakt-api-version", "2");
        connection.setRequestProperty("trakt-api-key", context.getString(R.string.api_key));
        return connection;
    }
}
