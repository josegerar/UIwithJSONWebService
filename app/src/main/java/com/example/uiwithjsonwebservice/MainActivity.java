package com.example.uiwithjsonwebservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uiwithjsonwebservice.WebService.Asynchtask;
import com.example.uiwithjsonwebservice.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> datos = new HashMap<String, String>();
        //WebService ws= new WebService("https://api-uat.kushkipagos.com/transfer-subscriptions/v1/bankList",
          //      datos, MainActivity.this, MainActivity.this);
        //ws.execute("GET","Public-Merchant-Id","84e1d0de1fbf437e9779fd6a52a9ca18");
    }


    public void btEnviar(View view){

        //Creamos el Intent
        Intent intent = new Intent(MainActivity.this, actValidaLogin.class);
        EditText txtNombre = (EditText)findViewById(R.id.txtUsr);
        EditText txtPass = (EditText)findViewById(R.id.txtpass);

        //Creamos la información a pasar entre actividades - Pares Key-Value
         Bundle b = new Bundle();
         b.putString("usr", txtNombre.getText().toString());
         b.putString("pass", txtPass.getText().toString());

        //Añadimos la información al intent
        intent.putExtras(b);
        // Iniciamos la nueva actividad
        startActivity(intent);

        }

    @Override
    public void processFinish(String result) throws JSONException {
        //TextView txtBancos = (TextView)findViewById(R.id .txtListaBancos);
        
        String lstBancos="";
        JSONArray JSONlista =  new JSONArray(result);
        for(int i=0; i< JSONlista.length();i++){
            JSONObject banco=  JSONlista.getJSONObject(i);
            lstBancos = lstBancos + "\n" + banco.getString("name").toString();
        }

        //txtBancos.setText("Respuesta WS Lista de Bancos" +  lstBancos);
    }
}