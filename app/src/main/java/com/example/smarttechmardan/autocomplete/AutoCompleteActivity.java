package com.example.smarttechmardan.autocomplete;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class AutoCompleteActivity extends AppCompatActivity {

    String[] countryNameList = {"India","China","Australia","New Zeland","England","Pakistan","Bangladesh","Iran"};

    String[] androidVersionNames = {"Aestro","Blender","CupCake","Donut","Eclair","Froyo","Gingerbread","HoneyComb","IceCream Sandwitch","JellyBean","Kitkat","Lollypop","Marshmellow","Nougat"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ///////////////////////////////////////////////////////
        //initiate AN auto complete text view
        AutoCompleteTextView simpleAutoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,countryNameList);

        simpleAutoCompleteTextView.setAdapter(adapter);
        simpleAutoCompleteTextView.setThreshold(1);//start searching from 1 character
        simpleAutoCompleteTextView.setAdapter(adapter);//seet an adapter for displaying country name list

        //initiate a MultiAutoCompleteTextView
        MultiAutoCompleteTextView sipleCompleteAutoCompleteTextView = (MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView2);
        //set adapter to fill the data
        ArrayAdapter<String> versionNames = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,androidVersionNames);
        sipleCompleteAutoCompleteTextView.setAdapter(versionNames);

        //
        sipleCompleteAutoCompleteTextView.setThreshold(1);

        //
        sipleCompleteAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_auto_complete, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_user) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
