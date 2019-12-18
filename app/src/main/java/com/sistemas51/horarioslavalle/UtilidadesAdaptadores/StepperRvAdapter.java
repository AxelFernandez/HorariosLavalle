package com.sistemas51.horarioslavalle.UtilidadesAdaptadores;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.sistemas51.horarioslavalle.R;
import com.sistemas51.horarioslavalle.callback.Callback;
import com.sistemas51.horarioslavalle.v2.SpecialHours;

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
                if (currentStep == 0 && i == 3) {
                    if (callback.getSpecial()) {
                        context.startActivity(new Intent(context, SpecialHours.class));
                    }else{
                        Snackbar.make(view, "No hay horarios especiales ahora, intenta nuevamente mas tarde", Snackbar.LENGTH_LONG).show();
                    }
                }else {
                    rowIndex = i;
                    selected = selectedStepper.get(i);
                    callback.callBack(selected, currentStep);
                    notifyDataSetChanged();
                }
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
