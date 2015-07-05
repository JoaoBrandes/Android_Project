package com.movile.next.seriestracker.model.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.movile.next.seriestracker.R;
import com.movile.next.seriestracker.model.episodeModels.Episode;
import com.movile.next.seriestracker.model.episodeModels.Images;
import com.movile.next.seriestracker.model.episodeModels.Season;
import com.movile.next.seriestracker.model.episodeModels.Show;
import com.movile.next.seriestracker.model.interfaces.OnShowClickListener;

import java.util.List;

/**
 * Created by JoaoEduardo on 02/07/2015.
 */
public class GridAdapter extends ArrayAdapter<Show> {
    private Context mContext;
    private int mLayout;
    private OnShowClickListener mListener;
    private List<Show> content;
    public GridAdapter(Context context, OnShowClickListener listener, int layout) {
        super(context, layout);
        mContext = context;
        mLayout = layout;
        mListener = listener;
    }
    public void setContent(List<Show> showList){
        content = showList;
    }
    public int getCount() {
        return content.size();
    }
    public Show getItem(int position) {
        return content.get(position);
    }

    public long getItemId(int position){
        return position;
    }

    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        int type = getItemViewType(position);
        if (view == null) {
            int resource = R.layout.popular_show_fragment;
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
        final Show show = getItem(position);
        String screenshotURL = show.images().poster().get(Images.ImageSize.THUMB);
        Glide.with(mContext).load(screenshotURL).placeholder(R.drawable.season_details_show_placeholder).centerCrop().into(holder.image());
        holder.root().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onShowClick(show.ids().slug());
            }
        });
    }
    public static class ViewHolder {
        private View mRoot;
        private ImageView mImage;

        public ViewHolder(View itemView) {
            mRoot = itemView;
            mImage = (ImageView) itemView.findViewById(R.id.popular_show_fragment);
        }

        public View root() {
            return mRoot;
        }

        public ImageView image() {return mImage; }
    }
}
