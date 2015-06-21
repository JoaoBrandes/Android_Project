package com.movile.next.seriestracker.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.movile.next.seriestracker.R;
import com.movile.next.seriestracker.activity.base.BaseNavigationToolbarActivity;
import com.movile.next.seriestracker.fragments.ShowInformationFragment;
import com.movile.next.seriestracker.model.adapter.ShowContentAdapter;
import com.movile.next.seriestracker.model.episodeModels.Show;
import com.movile.next.seriestracker.model.interfaces.ShowDetailsView;
import com.movile.next.seriestracker.presenter.ShowDetailsPresenter;

public class ShowDetailsActivity extends BaseNavigationToolbarActivity implements ShowDetailsView {

    private ShowDetailsPresenter mPresenter;
    private ShowContentAdapter adapter;

    private String mSlug = "game-of-thrones";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        configureToolbar();

        ViewPager view = (ViewPager) findViewById(R.id.show_details_content);

        view.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

        adapter = new ShowContentAdapter(getSupportFragmentManager(), "");
        view.setAdapter(adapter);


        mPresenter = new ShowDetailsPresenter(this, this);
        view.

        mPresenter.loadShow(mSlug);
    }


    @Override
    public void displayShow(Show show) {

    }
}
