package com.empresaurios.petfriend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ListaVacunas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_vacunas);

        /*Bundle datos = getIntent().getExtras();
        int datosObtenidos = datos.getInt("ID");
        System.out.println(datosObtenidos);
         */

    }

    //Esto es necesario para crear el menu de 3 puntos
    public  boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuNuevo:
                nuevoRegistroVacunas();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void nuevoRegistroVacunas(){
        //llevamos el ID de la mascota entre ventanas
        Bundle datos = getIntent().getExtras();
        int datosObtenidos = datos.getInt("ID");

        System.out.println(datosObtenidos);
        Intent intent = new Intent(this,AgregarVacuna.class);
        intent.putExtra("IDmascota",datosObtenidos);
        startActivity(intent);
    }


}