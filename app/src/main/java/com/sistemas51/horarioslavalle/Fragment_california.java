package com.sistemas51.horarioslavalle;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_california extends Fragment {


    public Fragment_california() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_fragment_california, container, false);

        final Spinner spinnerorigen = (Spinner) v.findViewById(R.id.spinnerorigencali);
        final Spinner spinnerllegada = (Spinner) v.findViewById(R.id.spinnerllegadacali);
        final Button botonbuscar = (Button) v.findViewById(R.id.buttoncali);

        //Adaptadores de Spinner
        ArrayAdapter spinner_adapter = ArrayAdapter.createFromResource( getContext(), R.array.nombrelugarescalifornica, android.R.layout.simple_spinner_item);
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
                Intent intent = new Intent(v.getContext(), Busquedacalifornia.class);
                intent.putExtra("origen", origen.toString());
                intent.putExtra("llegada", llegada.toString());
                intent.putExtra("origennum", origennum);
                intent.putExtra("llegadanum", llegadanum);
                if(origennum==llegadanum){
                    Toast.makeText(getContext(), "No es posible seleccionar el mismo punto dos veces, Seleccione uno diferente", Toast.LENGTH_LONG).show();
                }
                else{   startActivityForResult(intent, 0);}
            }


        });

        return v;
    }

}
