package com.sistemas51.horarioslavalle.Ruta24;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.sistemas51.horarioslavalle.R;

import java.util.ArrayList;

import in.galaxyofandroid.awesometablayout.AwesomeTabBarAdapter;

/**
 * Created by axelfernandez on 24/7/17.
 */

public class PagerAdapter24 extends AwesomeTabBarAdapter
{
    ArrayList<Fragment> fragments=new ArrayList<>();
    ArrayList<String> titles=new ArrayList<>();
    int[] colors={R.color.colorPrimary,R.color.colorPrimary,R.color.colorPrimary};
    int[] textColors={R.color.black};

    public PagerAdapter24(FragmentManager fragmentManager)
    {
        super(fragmentManager);
        fragments.add(new Fragment_semana24());
        fragments.add(new Fragment_sabado24());
        fragments.add(new Fragment_domingo24());


        titles.add("Semana");
        titles.add("Sabado");
        titles.add("Domingo");

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