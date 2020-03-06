package com.sistemas51.horarioslavalle.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.sistemas51.horarioslavalle.MainActivity;
import com.sistemas51.horarioslavalle.R;
import com.sistemas51.horarioslavalle.activity.Help;
import com.sistemas51.horarioslavalle.activity.ResultActivity;
import com.sistemas51.horarioslavalle.api.ApiRequest;
import com.sistemas51.horarioslavalle.models.SavedTrips;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ViewHolder> {
    List<SavedTrips> models;
    Context context;
    SharedPreferences sharedPreferences;
    View view;
    Activity activity;


    public DashboardAdapter(List<SavedTrips> models, Context context, SharedPreferences sharedPreferences, View view, Activity activity) {
        this.models = models;
        this.context = context;
        this.sharedPreferences = sharedPreferences;
        this.view = view;
        this.activity = activity;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_menu,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get().load(models.get(position).getDrawable()).into(holder.imageView);
        holder.description.setText(models.get(position).getName());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position==0){
                    new ApiRequest().forceDownload(sharedPreferences,context,view);

                }else if (position== 1){
                    Intent intent = new Intent(context, Help.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

                }else{
                    Map<String, String> args = new HashMap<>();
                    args.put(context.getResources().getString(R.string.from),models.get(position).getFrom());
                    args.put(context.getResources().getString(R.string.to),models.get(position).getTo());
                    args.put(context.getResources().getString(R.string.route),models.get(position).getRoute());
                    Intent intent = new Intent(context, ResultActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("args", (Serializable) args);
                    context.startActivity(intent);
                }

            }
        });

    }

    public void setModels(List<SavedTrips> models) {
        this.models = models;
    }
    @Override
    public int getItemCount() {
        return models.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView description;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_menu_image);
            description = itemView.findViewById(R.id.item_menu_description);
            linearLayout = itemView.findViewById(R.id.item_menu_linearLayout);
        }
    }
}
