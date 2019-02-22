package com.sistemas51.horarioslavalle.v2;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.sistemas51.horarioslavalle.R;

import java.util.ArrayList;

import in.galaxyofandroid.awesometablayout.AwesomeTabBarAdapter;

public class ResultPagerAdapter extends AwesomeTabBarAdapter
{
    ArrayList<Fragment> fragments=new ArrayList<>();
    ArrayList<String> titles=new ArrayList<>();
    int[] colors={R.color.colorPrimary,R.color.colorPrimary,R.color.colorPrimary};
    int[] textColors={R.color.black};
    String TYPE = "type";
    String ruta;

    public ResultPagerAdapter(FragmentManager fragmentManager, Context context,String ruta)
    {
        super(fragmentManager);
        this.ruta=ruta;
        fragments.add(getFragment(context.getString(R.string.Semana)));
        fragments.add(getFragment(context.getString(R.string.Sabado)));
        fragments.add(getFragment(context.getString(R.string.Domingo)));


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


    protected ResultFragment getFragment(String type){
        Bundle bundle = new Bundle();
        bundle.putString(TYPE,type);//dia de la semana
        bundle.putString("Ruta",ruta);
        ResultFragment resultFragment = new ResultFragment();
        resultFragment.setArguments(bundle);
        return resultFragment;
    }

}