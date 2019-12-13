package com.sistemas51.horarioslavalle.UtilidadesAdaptadores;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.sistemas51.horarioslavalle.R;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);
        TextView texto = (TextView)findViewById(R.id.textView4);
        Toolbar toolbar = findViewById(R.id.toolbarHelp);
        toolbar.setTitle("Ayuda");
        toolbar.setSubtitle("Version Beta");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(10);
        }
        toolbar.bringToFront();
        texto.setText(R.string.large_text);

        Button contactMe = findViewById(R.id.contactMe);
        contactMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","axel_fernandez18@hotmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Horarios Lavalle - Contacto.");
                startActivity(Intent.createChooser(emailIntent,  "Horarios Lavalle Contacto"));
            }
        });


    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}
