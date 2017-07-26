package com.sistemas51.horarioslavalle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.sistemas51.horarioslavalle.Ruta24.Fragment24;

import java.util.ArrayList;

import in.galaxyofandroid.awesometablayout.AwesomeTabBarAdapter;

/**
 * Created by axelfernandez on 24/7/17.
 */

public class PagerAdapter extends AwesomeTabBarAdapter
{
    ArrayList<Fragment> fragments=new ArrayList<>();
    ArrayList<String> titles=new ArrayList<>();
    int[] colors={R.color.colorPrimary,R.color.colorPrimary,R.color.colorPrimary};
    int[] textColors={R.color.black};

    public PagerAdapter(FragmentManager fragmentManager)
    {
        super(fragmentManager);
        fragments.add(new Fragment24());
        fragments.add(new Fragment40());
        fragments.add(new Fragment_california());


        titles.add("Ruta 24");
        titles.add("Ruta 40");
        titles.add("California");


    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public int getColorResource(int position) {
        return colors[position];
    }

    @Override
    public int getTextColorResource(int position) {
        return textColors[0];
    }

    @Override
    public int getIconResource(int i) {
        return 0;
    }


}