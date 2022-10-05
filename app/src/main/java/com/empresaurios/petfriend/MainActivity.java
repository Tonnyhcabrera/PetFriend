package com.empresaurios.petfriend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CambiarpantallaPrincipal(View view) {
        Intent CambiarVentana3 = new Intent (this, PantallaPrincipal.class);
        startActivity(CambiarVentana3);
        finish();
    }
}