package com.movile.next.seriestracker.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.movile.next.seriestracker.R;
import com.movile.next.seriestracker.model.episodeModels.Episode;
import com.movile.next.seriestracker.model.interfaces.OnEpisodeClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by movile on 20/06/15.
 */
public class EpisodeLoaderAdapter extends ArrayAdapter<Episode> {

    List<Episode> episodesList = new ArrayList<>();
    OnEpisodeClickListener listener;
    public EpisodeLoaderAdapter(Context context, OnEpisodeClickListener clickListener) {
        super(context, R.layout.activity_season_details);
        listener = clickListener;
    }

    public void updateEpisodesList(List<Episode> ep){
        episodesList = ep;
        notifyDataSetChanged();
    }

    public int getCount() {
        return episodesList.size();
    }
    public Episode getItem(int position) {
        return episodesList.get(position);
    }
    public long getItemId(int position) {
        return 0;
    }
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        int type = getItemViewType(position);
        if (view == null) {
            int resource = R.layout.episode_item;
//            if (type == TYPE_TBA) {
//                resource = R.layout.episode_item_tba;
//            }
            view = LayoutInflater.from(parent.getContext())
                    .inflate(resource, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        populateViewFromHolder(holder, position, type);

        return view;
    }

    private void populateViewFromHolder(ViewHolder holder, int position, int type){
        final Episode ep = getItem(position);

        ((TextView)holder.getEpisodeNumberView()).setText(ep.number().toString());
        ((TextView)holder.getEpisodeTitleView()).setText(ep.title());
        holder.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onEpisodeClick(ep);
            }
        });
    }

    public int getViewTypeCount() {
        return 1;
    }
    public int getItemViewType(int position) {
        return 1;
    }

    public static class ViewHolder {
        private View viewRoot;
        private TextView episodeNumberView;
        private TextView episodeTitleView;

        public ViewHolder(View root) {
            viewRoot = root;
            episodeNumberView = (TextView) root.findViewById(R.id.episode_item_number);
            episodeTitleView = (TextView) root.findViewById(R.id.episode_item_title);
        }
        public View getEpisodeNumberView() {
            return episodeNumberView;
        }

        public View getEpisodeTitleView(){
            return episodeTitleView;
        }

        public View getRoot(){
            return viewRoot;
        }

    }

}


