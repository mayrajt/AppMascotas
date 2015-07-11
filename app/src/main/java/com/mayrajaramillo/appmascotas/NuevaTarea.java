package com.mayrajaramillo.appmascotas;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;


public class NuevaTarea extends AppCompatActivity implements OnItemSelectedListener {
    private Spinner spinnerFrec;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_tarea);
        toolbar =(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        spinnerFrec= (Spinner) findViewById(R.id.spinnerFrecuencia);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item){

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View vista = super.getView(position, convertView, parent);
                if (position == getCount()) {
                    ((TextView)vista.findViewById(android.R.id.text1)).setText("");
                    ((TextView)vista.findViewById(android.R.id.text1)).setHint(getItem(getCount()));
                }

                return vista;
            }

            @Override
            public int getCount() {
                return super.getCount()-1;
            }


        };

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.add("Diario");
        adapter.add("Semanal");
        adapter.add("Quincenal");
        adapter.add("Mensual");
        adapter.add("Frecuencia");


        spinnerFrec.setAdapter(adapter);
        spinnerFrec.setSelection(adapter.getCount());
        spinnerFrec.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nueva_tarea, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_inicio) {
            startActivity(new Intent(getBaseContext(), Inicio.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP));
            finish();
            return true;

        }
        if(id==R.id.action_lista_tareas){
            Intent intent = new Intent(getApplicationContext(), ListaTareas.class);
            startActivity(intent);
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
