package com.movile.next.seriestracker.model.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.movile.next.seriestracker.R;
import com.movile.next.seriestracker.model.episodeModels.Images;
import com.movile.next.seriestracker.model.episodeModels.Season;
import com.movile.next.seriestracker.model.interfaces.OnSeasonClickListener;

import java.util.List;

/**
 * Created by movile on 27/06/15.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private OnSeasonClickListener mListener;

    private int mLayout;
    private List<Season> mSeasons;
    private Context mContext;

    public RecyclerAdapter(Context context, OnSeasonClickListener clickListener, int layout) {
        mListener = clickListener;
        mLayout = layout;
        mContext = context;
    }

    public void setContent(List<Season> seasons){
        mSeasons = seasons;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mLayout, parent, false);
        return new ViewHolder(view);
    }
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Season content = mSeasons.get(position);

        holder.title().setText("Season " + content.number());
        holder.description().setText(content.episodeCount() + " episodes");

        String screenshotURL = content.images().poster().get(Images.ImageSize.THUMB);
        Glide.with(mContext).load(screenshotURL).placeholder(R.drawable.season_details_show_placeholder).centerCrop().into(holder.image());
        holder.mRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onSeasonClick(content);
            }
        });
    }
    public int getItemCount() {
        return mSeasons.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private View mRoot;
        private TextView mTitle;
        private TextView mDescription;
        private ImageView mImage;

        public ViewHolder(View itemView) {
            super(itemView);
            mRoot = itemView;
            mTitle = (TextView) itemView.findViewById(R.id.season_item_title);
            mDescription = (TextView) itemView.findViewById(R.id.season_item_episodes);
            mImage = (ImageView) itemView.findViewById(R.id.season_item_thumb);
        }

        public View root() {
            return mRoot;
        }

        public TextView title() {
            return mTitle;
        }

        public TextView description() {
            return mDescription;
        }

        public ImageView image() {return mImage; }
    }

}

