package com.movile.next.seriestracker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.movile.next.seriestracker.model.Episode;
import com.movile.next.seriestracker.model.EpisodeLoader;
import com.movile.next.seriestracker.model.Images;
import com.movile.next.seriestracker.model.asyncTasks.LoadEpisodeAsyncTask;
import com.movile.next.seriestracker.utils.FormatUtil;

import java.net.URI;
import java.util.Date;
import java.util.Map;

public class EpisodeDetailsActivity extends ActionBarActivity  implements EpisodeLoader{

    private String estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("onCreate", "onCreate");
        estado = "HUE";
        setContentView(R.layout.episode_details_activity);

        LoadEpisodeAsyncTask load = new LoadEpisodeAsyncTask(this.getApplicationContext(), this);
        load.execute();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d("onSaveInstanceState","onSaveInstanceState");
        outState.putString("Estado", estado);
        super.onSaveInstanceState(outState);

    }



    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("onRestoreInstanceState","onRestoreInstanceState");
        estado = savedInstanceState.getString("Estado");
        Log.d("onRestore","Estado restaurado:"+estado);
    }

    @Override
    protected void onPause(){
        Log.d("onPause", "onCreate");
        super.onPause();
    }

    @Override
    protected void onRestart(){
        Log.d("onRestart","onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume(){
        Log.d("onResume", "onResume");
        super.onResume();
    }

    @Override
    protected void onDestroy(){
        Log.d("onDestroy", "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onStart(){
        Log.d("onStart","onStart");
        super.onStart();
    }

    @Override
    public void onEpisodeLoaded(Episode episode) {
        TextView title = (TextView)findViewById(R.id.episode_title);
        title.setText(episode.title());
        TextView episodeOverview = (TextView)findViewById(R.id.episode_details_overview);
        episodeOverview.setText(episode.overview());
        TextView date = (TextView)findViewById(R.id.episode_details_exhibition_date);
        String da = episode.firstAired();
        Date d = FormatUtil.formatDate(da);
        String dateFinal = FormatUtil.formatDate(d);
        date.setText(dateFinal);
/*
        Images image = episode.images();
        Map<String, String> screenshot = image.screenshot();
        ImageView banner = (ImageView)findViewById(R.id.screenshot_image);
        URI u = URI.create(screenshot.get(Images.ImageSize.THUMB));
        banner.setImageURI(u);
*/
    }
}
