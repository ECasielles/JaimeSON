package com.usuario.json;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.loopj.android.http.FileAsyncHttpResponseHandler;

import org.json.JSONException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class Creacion extends Activity implements View.OnClickListener {
    public static final String WEB = "http://www.alejandrosuarez.es/feed/";
    //public static final String WEB = "http://192.168.2.110/acceso/alejandro.rss";
    public static final String RESULTADO_JSON = "resultado.json";
    public static final String RESULTADO_GSON = "resultado_gson.json";
    public static final String TEMPORAL = "alejandro.xml";

    ArrayList<Noticia> noticias;
    Button boton;
    ViewGroup mLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creacion);
        boton = (Button) findViewById(R.id.btn_crearJson);
        boton.setOnClickListener(this);
        mLayout = (RelativeLayout) findViewById(R.id.activity_creacion);
    }

    @Override
    public void onClick(View v) {
        if (v == boton)
            descarga(WEB, TEMPORAL);
    }

    //obtener el rss y escribir los ficheros
    private void descarga(String web, String temporal) {
        final ProgressDialog progreso = new ProgressDialog(this);
        File miFichero = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), temporal);

        RestClient.get(web, new FileAsyncHttpResponseHandler(miFichero) {
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, File file) {
                progreso.dismiss();
                Snackbar.make(mLayout, "Fallo: " + throwable.getMessage(), Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, File file) {
                try {
                    progreso.dismiss();
                    noticias = Analisis.analizarNoticias(file);
                    Analisis.escribirJSON(noticias, RESULTADO_JSON);
                    Toast.makeText(getApplicationContext(), "Fichero descargador OK\n" + RESULTADO_JSON, Toast.LENGTH_SHORT).show();
                    Analisis.escribirGSON(noticias, RESULTADO_GSON);
                } catch (XmlPullParserException e) {
                    Toast.makeText(getApplicationContext(), "Excepción XML: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "Excepción I/O: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onStart() {
                super.onStart();
                progreso.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progreso.setMessage("Conectando . . .");
                progreso.setCancelable(false);
                progreso.show();
            }
        });
    }
}
