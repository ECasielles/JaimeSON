package com.usuario.json;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;


public class PrimitivaRed extends Activity implements View.OnClickListener{
    public static final String TAG = "MyTag";
    public static final String WEB = "https://portadaalta.club/acceso/primitiva.json";
    Button mButton;
    TextView mTxtDisplay;
    RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout. activity_primitiva_red );
        mButton = (Button) findViewById(R.id.btn_descargarPrimitiva);
        mButton.setOnClickListener(this);
        mTxtDisplay = (TextView) findViewById(R.id.txv_resultadoPrimitivaRed);
        mRequestQueue = MySingleton.getInstance(this.getApplicationContext()).getRequestQueue();
    }


    @Override
    public void onClick(View view) {
        if (view == mButton)
            descarga();
    }

    private void descarga() {
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, WEB, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            mTxtDisplay.setText(Analisis.analizarPrimitiva(response));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Toast.makeText(getApplicationContext(), "VolleyError: " + error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        // Set the tag on the request.
        jsObjRequest.setTag(TAG);
        // Set retry policy
        jsObjRequest.setRetryPolicy(new DefaultRetryPolicy(3000, 1, 1));
        // Add the request to the RequestQueue.
        mRequestQueue.add(jsObjRequest);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll( TAG );
        }
    }
}
