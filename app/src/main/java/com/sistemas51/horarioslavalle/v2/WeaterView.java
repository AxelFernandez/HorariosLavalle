package com.sistemas51.horarioslavalle.v2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arthurivanets.bottomsheets.BaseBottomSheet;
import com.arthurivanets.bottomsheets.config.BaseConfig;
import com.arthurivanets.bottomsheets.config.Config;
import com.kwabenaberko.openweathermaplib.implementation.OpenWeatherMapHelper;
import com.sistemas51.horarioslavalle.R;
import com.sistemas51.horarioslavalle.api.WeatherSingleton;

public class WeaterView extends BaseBottomSheet {



    public WeaterView(@NonNull Activity hostActivity, @NonNull BaseConfig config) {
        super(hostActivity, config);

    }

    public WeaterView(@NonNull Activity hostActivity) {
        this(hostActivity, new Config.Builder(hostActivity).build());
    }

    @NonNull
    @Override
    protected View onCreateSheetContentView(@NonNull Context context) {
        View v  = LayoutInflater.from(context).inflate(R.layout.fragment_listview, this, false);
        RecyclerView rv = v.findViewById(R.id.recicler);
        int resIdAnim = R.anim.layout_anim_fall_down;
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getContext(),resIdAnim);
        rv.setLayoutAnimation(animation);

        OpenWeatherMapHelper openWeather = WeatherSingleton.getInstance();

        //rv.setAdapter(adapter);



        return null;
    }
}
