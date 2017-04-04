package com.example.audi.projectutspenir;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class gameover extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hilangkanheader();
        setContentView(R.layout.activity_gameover);

        TextView txtskor = (TextView) findViewById(R.id.txtskor);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/font.ttf");

        txtskor.setTypeface(custom_font);

        Intent i = getIntent();
        Integer skor = i.getIntExtra("skor", 0);


        txtskor.setText("SKOR ANDA : \n" + String.valueOf(skor));
    }

    public void hilangkanheader() {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
    }

    public void retry(View view) {
        Intent i = new Intent(getApplicationContext(), arcade.class);
        startActivity(i);
    }

    public void mainmenu(View view) {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

    public void buattoast(String pesan) {
        Toast.makeText(gameover.this, pesan, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
}
