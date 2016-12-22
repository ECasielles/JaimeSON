package com.usuario.json;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{
    private Button btnPrimitiva;
    private Button btnPrimitivaRed;
    private Button btnListaContactos;
    private Button btnListaGson;
    private Button btnCreacion;
    private Button btnNoticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPrimitiva = (Button) findViewById(R.id.btn_primitiva);
        btnPrimitivaRed = (Button) findViewById(R.id.btn_primitivaRed);
        btnListaContactos = (Button) findViewById(R.id.btn_listaContactos);
        btnListaGson = (Button) findViewById(R.id.btn_ListaGson);
        btnCreacion = (Button) findViewById(R.id.btn_creacion);
        btnNoticias = (Button) findViewById(R.id.btn_noticias);

        btnPrimitiva.setOnClickListener(this);
        btnPrimitivaRed.setOnClickListener(this);
        btnListaContactos.setOnClickListener(this);
        btnListaGson.setOnClickListener(this);
        btnCreacion.setOnClickListener(this);
        btnNoticias.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        if (v == btnPrimitiva)
            intent = new Intent(this, Primitiva.class);
        if (v == btnPrimitivaRed)
            intent = new Intent(this, PrimitivaRed.class);
        if (v == btnListaContactos)
            intent = new Intent(this, ListaContactos.class);
        if (v == btnListaGson)
            intent = new Intent(this, ListaContactosGson.class);
        if (v == btnCreacion)
            intent = new Intent(this, Creacion.class);
        if (v == btnNoticias)
            intent = new Intent(this, Noticias.class);

        if (intent != null)
            startActivity(intent);
    }
}
