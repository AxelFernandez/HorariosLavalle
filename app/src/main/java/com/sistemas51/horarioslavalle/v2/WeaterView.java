package com.sistemas51.horarioslavalle.v2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;

import com.arthurivanets.bottomsheets.BaseBottomSheet;
import com.arthurivanets.bottomsheets.config.BaseConfig;
import com.arthurivanets.bottomsheets.config.Config;
import com.sistemas51.horarioslavalle.R;

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
        View v  = LayoutInflater.from(context).inflate(R.layout.stepper_main, this, false);


        return null;
    }
}
