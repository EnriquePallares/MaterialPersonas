package com.example.android.personasmaterial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class Principal extends AppCompatActivity {

    private Intent i;
    private RecyclerView lstOpciones;
    private ArrayList<Persona> personas;
    private LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lstOpciones = findViewById(R.id.lstPersonas);
        personas = Datos.obtener();

        AdaptadorPersonas adaptadorPersonas = new AdaptadorPersonas(personas);

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lstOpciones.setLayoutManager(llm);
        lstOpciones.setAdapter(adaptadorPersonas);

    }

    public void agregarPersonas(View v) {
        i = new Intent(Principal.this, AgregarPersonas.class);
        startActivity(i);
        finish();
    }
}
