package com.example.actividadandroid;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ValidarUsuario extends AsyncTask {

    private Context contexto;
    private ProgressBar barraInterfaz;
    private Button botonInterfaz;
    private TextView cajaMostrar;

    public ValidarUsuario(Context contexto, ProgressBar barraInterfaz, Button botonInterfaz, TextView cajaMostrar) {
        super();
        this.contexto = contexto;
        this.barraInterfaz = barraInterfaz;
        this.botonInterfaz = botonInterfaz;
        this.cajaMostrar = cajaMostrar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        this.barraInterfaz.setVisibility(View.VISIBLE);
        this.botonInterfaz.setEnabled(false);
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        this.barraInterfaz.setVisibility(View.INVISIBLE);
        this.botonInterfaz.setEnabled(true);
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
        this.cajaMostrar.setText(values[0].toString());
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        String user="";
        String pass= "";

        user = objects[0].toString();
        pass = objects[1].toString();

        publishProgress("se comienza la consulta a la base de datos");
        int respuesta = 1;
        respuesta = valUserPassBd(user,pass);

        if (respuesta==0){
            publishProgress("se finalizo la consulta a base de datos,"+"usuario validado Ok...");

        }else{
            publishProgress("se finaliza consulta a base de datos, "+"usuario o password invalido");
        }

        return respuesta;
    }

    private int valUserPassBd(String user,String pass) {
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        if (user.equals("fgajardo") && pass.equals("123456")){
            return 0;
        }else{
            return 1;
        }
    }
}
