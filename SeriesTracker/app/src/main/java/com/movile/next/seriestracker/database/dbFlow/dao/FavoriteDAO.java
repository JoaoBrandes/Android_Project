package com.movile.next.seriestracker.database.dbFlow.dao;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.movile.next.seriestracker.database.dbFlow.FavoriteEntity;
import com.movile.next.seriestracker.database.dbFlow.FavoriteEntity$Table;
import com.movile.next.seriestracker.database.manual.helper.ProviderUriHelper;
import com.movile.next.seriestracker.model.Favorite;
import com.raizlabs.android.dbflow.sql.builder.Condition;
import com.raizlabs.android.dbflow.sql.language.Delete;
import com.raizlabs.android.dbflow.sql.language.Select;

public class FavoriteDAO {

    private Context mContext;

    public FavoriteDAO(Context context) {
        mContext = context;
    }

    public void save(Favorite favorite) {
        FavoriteEntity entity = new FavoriteEntity();
        entity.slug = favorite.slug();
        entity.title = favorite.title();
        entity.save();
    }

    public Cursor all() {
        return new Select().from(FavoriteEntity.class).queryCursorList().getCursor();
    }

    public FavoriteEntity query(String slug) {
        FavoriteEntity entity = new Select()
                .from(FavoriteEntity.class)
                .where(Condition.column(FavoriteEntity$Table.SLUG).eq(slug))
                .querySingle();
        return entity;
    }

    public void delete(String slug) {
        new Delete()
        .from(FavoriteEntity.class)
                .where(Condition.column(FavoriteEntity$Table.SLUG).eq(slug))
                .queryClose();

    }

}
