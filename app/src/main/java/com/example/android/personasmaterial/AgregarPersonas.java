package com.example.android.personasmaterial;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Random;

public class AgregarPersonas extends AppCompatActivity {

    private EditText txtCedula, txtNombre, txtApellido;
    private Spinner cmbSexo;
    private ArrayAdapter<String> adapter;
    private String opc[];
    private ArrayList<Integer> fotos;
    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_personas);

        txtCedula = findViewById(R.id.txtCedula);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        cmbSexo = findViewById(R.id.cmbSexo);
        foto = findViewById(R.id.foto);

        fotos = new ArrayList<>();
        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);

        opc = getResources().getStringArray(R.array.sexo);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opc);
        cmbSexo.setAdapter(adapter);
    }

    public int fotoAleatoria(){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(this.fotos.size());

        return fotos.get(fotoSeleccionada);
    }

    public void guardar(View v){
        String ced, nomb, apell, foto, id;
        int sexo;

        //foto = this.fotoAleatoria();
        id = Datos.getId();
        foto = id+".jpg";
        ced = txtCedula.getText().toString();
        nomb = txtNombre.getText().toString();
        apell = txtApellido.getText().toString();
        sexo = cmbSexo.getSelectedItemPosition();

        Persona p = new Persona(id, foto, ced, nomb, apell, sexo);
        p.guardar();
        limpiar();

        Snackbar.make(v, getResources().getString(R.string.guardado_exitoso), Snackbar.LENGTH_SHORT).show();
    }

    public void limpiar(){
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        cmbSexo.setSelection(0);
        txtCedula.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(AgregarPersonas.this, Principal.class);
        startActivity(i);
    }

    public void limpiar(View v){
        limpiar();
    }
}
