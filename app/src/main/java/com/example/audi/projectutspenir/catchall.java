package com.example.audi.projectutspenir;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class catchall extends AppCompatActivity {

    TextView txtsocial, txtbrand, txtapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hilangkanheader();
        setContentView(R.layout.activity_catchall);

        gantifont();
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
}
