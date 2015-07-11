package com.mayrajaramillo.appmascotas;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Inicio extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        toolbar =(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

       ImageButton boton1=(ImageButton) findViewById(R.id.btn1);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NuevaMascotas.class);
                startActivity(intent);
            }
        });

        final ListView listView = (ListView) findViewById(R.id.listMascotas);
        String[] valores = new String[]{"Winky","Jack","Black","Chester"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1
        , android.R.id.text1,valores);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String itemValor = (String) listView.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),"Mascota "+itemValor,
                        Toast.LENGTH_LONG).show();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
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
            return true;

        }
        if(id==R.id.action_lista_tareas){

            Intent intent = new Intent(getApplicationContext(), ListaTareas.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
}
