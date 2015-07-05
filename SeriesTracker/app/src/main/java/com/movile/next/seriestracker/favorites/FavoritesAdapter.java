package com.movile.next.seriestracker.favorites;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.movile.next.seriestracker.R;
import com.movile.next.seriestracker.database.dbFlow.FavoriteEntity;
import com.movile.next.seriestracker.database.dbFlow.FavoriteEntity$Adapter;
import com.movile.next.seriestracker.model.interfaces.OnShowClickListener;

/**
 * Created by movile on 05/07/15.
 */
public class FavoritesAdapter extends CursorAdapter {

    private Context mContext;
    private Cursor mCursor;
    private OnShowClickListener mClickListener;
    public FavoritesAdapter(Context context, Cursor c, OnShowClickListener listener) {
        super(context, c, 0);
        this.mContext = context;
        this.mCursor = c;
        mClickListener = listener;
    }

    public void setCursor(Cursor cursor){
        swapCursor(cursor);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        ViewHolder holder;
        int resource = R.layout.base_navigation_drawer_activity;
        View view = LayoutInflater.from(context).inflate(resource, parent, false);
        holder = new ViewHolder(view);
        view.setTag(holder);
        return view;
    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder holder = (ViewHolder) view.getTag();
        FavoriteEntity$Adapter adapter = new FavoriteEntity$Adapter();
        final FavoriteEntity entity = new FavoriteEntity();
        adapter.loadFromCursor(cursor, entity);
        Log.d("DEBUGANDO","Titulo recuperado"+entity.title());
        holder.name().setText(entity.title());
        holder.root().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onShowClick(entity.slug());
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private View mRoot;
        private TextView mFavoriteName;
        public ViewHolder (View itemView){
            super(itemView);
            mRoot = itemView;
            mFavoriteName = (TextView) itemView.findViewById(R.id.favorite_item_name);
        }
        public View root(){
            return mRoot;
        }
        public TextView name(){
            return mFavoriteName;
        }
    }
}