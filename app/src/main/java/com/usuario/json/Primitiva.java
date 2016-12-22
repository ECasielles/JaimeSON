package com.usuario.json;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;

public class Primitiva extends Activity {
    TextView informacion;
    Memoria memoria;
    Resultado resultado;
    public static final String FICHERO_PRIMITIVA = "primitiva.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout. activity_primitiva );

        informacion = (TextView) findViewById(R.id.txv_resultadoPrimitiva);
        memoria = new Memoria(this);
        resultado = memoria.leerAsset( FICHERO_PRIMITIVA );

        if (resultado.getCodigo())
            try {
            //llamar a analizarPrimitiva
                informacion.setText(Analisis.analizarPrimitiva(resultado.getContenido()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        else
            informacion.setText("Error al leer el fichero " + FICHERO_PRIMITIVA );
    }
}
