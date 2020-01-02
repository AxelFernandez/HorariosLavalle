package com.sistemas51.horarioslavalle.UtilidadesAdaptadores;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.sistemas51.horarioslavalle.R;
import com.sistemas51.horarioslavalle.router.OriginSelectedDirections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StepperRvAdapter extends RecyclerView.Adapter<StepperRvAdapter.ViewHolder> {
    private String selected;
    private List<String> selectedStepper;
    Map<String, String> hourSelected;
    private Context context;
    int rowIndex = -1;
    int currentStep;
    boolean special;

    public StepperRvAdapter(Context context, List<String> selectedStepper, int currentStep,  Map<String, String> hourSelected){
        this.context = context;
        this.selectedStepper = selectedStepper;
        this.currentStep = currentStep;
        this.hourSelected = hourSelected;
    }

    public StepperRvAdapter(Context context, List<String> selectedStepper, int currentStep,boolean special, Map<String, String> hourSelected){
        this.context = context;
        this.selectedStepper = selectedStepper;
        this.currentStep = currentStep;
        this.special = special;
        this.hourSelected = hourSelected;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_step_selected,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        viewHolder.description.setText(selectedStepper.get(i));
        if (currentStep == 2 && selectedStepper.get(i).equals(hourSelected.get(context.getResources().getString(R.string.from)))){
            viewHolder.cardView.setBackgroundColor(Color.parseColor("#fb8c00"));
            viewHolder.description.setTextColor(Color.parseColor("#ffffff"));
        }

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentStep == 0 && i == 5) {
                    if (special) {
                        Navigation.findNavController(view).navigate(R.id.to_specialHours_action);
                    }else{
                        Snackbar.make(view, "No hay horarios especiales ahora, intenta nuevamente mas tarde", Snackbar.LENGTH_LONG).show();
                    }
                }else if(currentStep == 0 && i !=5) {
                    hourSelected.put(context.getResources().getString(R.string.route), selectedStepper.get(i));
                    OriginSelectedDirections.NextAction action = OriginSelectedDirections.nextAction((HashMap) hourSelected);
                    Navigation.findNavController(view).navigate(action);
                }else if(currentStep == 1){
                    hourSelected.put(context.getResources().getString(R.string.from), selectedStepper.get(i));
                    OriginSelectedDirections.NextAction action = OriginSelectedDirections.nextAction((HashMap) hourSelected);
                    Navigation.findNavController(view).navigate(action);
                }else if(currentStep == 2){
                    hourSelected.put(context.getResources().getString(R.string.to), selectedStepper.get(i));
                    OriginSelectedDirections.NextAction action = OriginSelectedDirections.nextAction((HashMap) hourSelected);
                    Navigation.findNavController(view).navigate(action);
                }

            }
        });


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
