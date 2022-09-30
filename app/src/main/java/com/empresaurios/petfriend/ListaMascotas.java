package com.empresaurios.petfriend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.empresaurios.petfriend.DB.DbMascotas;
import com.empresaurios.petfriend.adaptadores.ListaMascotasAdapter;
import com.empresaurios.petfriend.entidades.Mascotas;

import java.util.ArrayList;

public class ListaMascotas extends AppCompatActivity {

    RecyclerView listaMascotas;
    ArrayList<Mascotas> listaArrayMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascotas);

        listaMascotas = findViewById(R.id.listaMascotas);

         listaMascotas.setLayoutManager(new LinearLayoutManager(this));

        DbMascotas dbMascotas = new DbMascotas(ListaMascotas.this);

        listaArrayMascotas = new ArrayList<>();

        ListaMascotasAdapter adapter = new ListaMascotasAdapter(dbMascotas.mostrarMascotas());
        listaMascotas.setAdapter(adapter);

    }


    public void CambiarVentana3(View view) {
        Intent CambiarVentana3 = new Intent (this, AgregarMascota.class);
        startActivity(CambiarVentana3);
        finish();
    }

    public  boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuNuevo:
                nuevoRegistro();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void nuevoRegistro(){
        Intent intent = new Intent(this,AgregarMascota.class);
        startActivity(intent);
    }
}