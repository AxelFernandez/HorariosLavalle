package com.sistemas51.horarioslavalle.Ruta24;


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

import com.sistemas51.horarioslavalle.Especial.Asuncion.EspecialAsuncion;
import com.sistemas51.horarioslavalle.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment24 extends Fragment {


    public Fragment24() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
View v = inflater.inflate(R.layout.fragment_fragment24, container, false);
        final Spinner spinnerorigen = (Spinner) v.findViewById(R.id.spinnerorigen);
        final Spinner spinnerllegada = (Spinner) v.findViewById(R.id.spinnerllegada);
        final Button botonbuscar = (Button) v.findViewById(R.id.button);
        final Button butonEspecial =(Button) v.findViewById(R.id.especial);


        //Adaptadores de Spinner
        ArrayAdapter spinner_adapter = ArrayAdapter.createFromResource( getContext(), R.array.nombredelugares, android.R.layout.simple_spinner_item);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerorigen.setAdapter(spinner_adapter);
        spinnerllegada.setAdapter(spinner_adapter);


        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        butonEspecial.setVisibility(View.GONE);


        botonbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String origen = spinnerorigen.getSelectedItem().toString();
                String llegada = spinnerllegada.getSelectedItem().toString();
                int origennum = spinnerorigen.getSelectedItemPosition();
                int llegadanum = spinnerllegada.getSelectedItemPosition();
                Intent intent = new Intent(v.getContext(), Busqueda24.class);
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
butonEspecial.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent= new Intent (v.getContext(), EspecialAsuncion.class);
        startActivity(intent);
    }
});
        return v;
    }


}
