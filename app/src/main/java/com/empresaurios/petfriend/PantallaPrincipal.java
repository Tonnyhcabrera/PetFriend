package com.empresaurios.petfriend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PantallaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);
    }
    public void CambiarVentanaListaVacunas(View view) {
        Intent CambiarVentana3 = new Intent (this, ListaVacunas.class);
        startActivity(CambiarVentana3);
        finish();
    }
    public void CambiarVentanaListaMascotas(View view) {
        Intent CambiarVentana3 = new Intent (this, ListaMascotas.class);
        startActivity(CambiarVentana3);
        finish();
    }

}