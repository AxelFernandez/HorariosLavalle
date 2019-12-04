package com.sistemas51.horarioslavalle.UtilidadesAdaptadores;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sistemas51.horarioslavalle.R;
import com.sistemas51.horarioslavalle.callback.Callback;

import java.util.List;

public class StepperRvAdapter extends RecyclerView.Adapter<StepperRvAdapter.ViewHolder> {
    private String selected;
    private List<String> selectedStepper;
    private Context context;
    int rowIndex = -1;
    Callback callback;
    int currentStep;

    public StepperRvAdapter(Context context, List<String> selectedStepper,Callback callback, int currentStep){
        this.context = context;
        this.selectedStepper = selectedStepper;
        this.callback = callback;
        this.currentStep = currentStep;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_step_selected,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        viewHolder.description.setText(selectedStepper.get(i));
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rowIndex=i;
                selected = selectedStepper.get(i);
                callback.callBack(selected,currentStep);
                notifyDataSetChanged();
            }
        });

        if(rowIndex==i){
            viewHolder.cardView.setBackgroundColor(Color.parseColor("#8bc34a"));
            viewHolder.description.setTextColor(Color.parseColor("#ffffff"));
        }
        else{
            viewHolder.cardView.setBackgroundColor(Color.parseColor("#ffffff"));
            viewHolder.description.setTextColor(Color.parseColor("#000000"));
        }

    }

    @Override
    public int getItemCount() {
        return selectedStepper.size();
    }

    public String getSelected(){
        notifyDataSetChanged();
        return selected;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
    CardView cardView;
    TextView description;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.cardViewStepper);
        description= itemView.findViewById(R.id.textStepper);
    }
}


}
