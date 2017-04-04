package com.example.audi.projectutspenir;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class catchall extends AppCompatActivity {

    TextView txtsocial, txtbrand, txtapp;

    String[] v;

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hilangkanheader();
        setContentView(R.layout.activity_catchall);

        gantifont();

        v = new String[]{"a","b","c","a","b","c","a","b","c"};
        loadlist(v);
    }

    public void hilangkanheader() {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
    }

    public void gantifont() {
        txtsocial = (TextView) findViewById(R.id.txtsocial);
        txtbrand = (TextView) findViewById(R.id.txtbrand);
        txtapp = (TextView) findViewById(R.id.txtapp);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/font.ttf");

        txtsocial.setTypeface(custom_font);
        txtbrand.setTypeface(custom_font);
        txtapp.setTypeface(custom_font);
    }

    public void txtsocialonclick(View view){
        v = new String[]{"a","b"};
        loadlist(v);
    }

    public void loadlist(String[] v){
        list = (ListView) findViewById(R.id.list);
        CustomView aa = new CustomView(this,v);
        list.setAdapter(aa);
    }

    public void buattoast(String pesan) {
        Toast.makeText(catchall.this, pesan, Toast.LENGTH_SHORT).show();
    }
}
