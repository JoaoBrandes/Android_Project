package com.movile.next.seriestracker.model.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.movile.next.seriestracker.fragments.SeasonDetailsFragment;
import com.movile.next.seriestracker.fragments.ShowInformationFragment;
import com.movile.next.seriestracker.model.episodeModels.Show;

/**
 * Created by movile on 21/06/15.
 */
public class ShowContentAdapter extends FragmentPagerAdapter{
    private static final int POSITION_OVERVIEW = 0;
    private static final int POSITION_SEASON   = 1;

    private Show show;
    public ShowContentAdapter(FragmentManager manager, Show show){
        super(manager);
        this.show = show;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        Bundle arguments = new Bundle();
        if(position == POSITION_OVERVIEW){
            arguments.putSerializable(ShowInformationFragment.EXTRA_SHOW, show);
            fragment = new ShowInformationFragment();
        } else {
            arguments.putSerializable(SeasonDetailsFragment.EXTRA_SHOW, show);
            fragment = new SeasonDetailsFragment();
        }
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
