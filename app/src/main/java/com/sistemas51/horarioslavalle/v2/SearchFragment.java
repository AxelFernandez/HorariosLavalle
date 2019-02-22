package com.sistemas51.horarioslavalle.v2;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.sistemas51.horarioslavalle.R;

import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {


    public SearchFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        final String type = bundle.getString(getResources().getString(R.string.Type));
        String[] spinner = getParams(type);

        View v = inflater.inflate(R.layout.fragment_fragment24, container, false);
        final Spinner spinnerorigen = (Spinner) v.findViewById(R.id.spinnerorigen);
        final Spinner spinnerllegada = (Spinner) v.findViewById(R.id.spinnerllegada);
        final Button botonbuscar = (Button) v.findViewById(R.id.button);


        //Adaptadores de Spinner
        ArrayAdapter<CharSequence> spinner_adapter = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,spinner);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerorigen.setAdapter(spinner_adapter);
        spinnerllegada.setAdapter(spinner_adapter);


        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        botonbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String origen = spinnerorigen.getSelectedItem().toString();
                String llegada = spinnerllegada.getSelectedItem().toString();
                int origennum = spinnerorigen.getSelectedItemPosition();
                int llegadanum = spinnerllegada.getSelectedItemPosition();
                Intent intent = new Intent(v.getContext(), Result.class);
                intent.putExtra("origen", origen.toString());
                intent.putExtra("llegada", llegada.toString());
                intent.putExtra("origennum", origennum);
                intent.putExtra("llegadanum", llegadanum);
                intent.putExtra(getString(R.string.Ruta),type);
                if(origennum==llegadanum){
                    Toast.makeText(getContext(), "No es posible seleccionar el mismo punto dos veces, Seleccione uno diferente", Toast.LENGTH_LONG).show();
                }
                else{ startActivityForResult(intent, 0);}
            }


        });

        return v;
    }

    /**
     * Return the correct spinner in one class
     * @param type Send 'Ruta24' 'Ruta40' or 'California'
     * @return Array whit data for spinners
     */
    private String[] getParams (String type){
        String[] result = null;
        Log.e("TYPE", type);
        if (type.equals(getString(R.string.Ruta24))){
            result = getResources().getStringArray(R.array.nombredelugares);
        }else if(type.equals(getString(R.string.Ruta40))){
            result = getResources().getStringArray(R.array.nombredelugaresr40);
        }else if (type.equals(getString(R.string.California))) {
            result = getResources().getStringArray(R.array.nombrelugarescalifornia);
        }
        return result;
    }

}
