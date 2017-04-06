package com.example.audi.projectutspenir;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    Button btnarcade, btncatch;
    ImageView imglogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imglogo = (ImageView) findViewById(R.id.imglogo);
        int resID = getResources().getIdentifier("welcome", "drawable", getPackageName());
        imglogo.setImageResource(resID);

        buttonarcadeonclick();
        buttoncatchonclick();
    }

    public void buttonarcadeonclick() {
        btnarcade = (Button) findViewById(R.id.btnarcade);
        btnarcade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), arcade.class);
                startActivity(i);
            }
        });
    }

    public void buttoncatchonclick() {
        btncatch = (Button) findViewById(R.id.btncatch);
        btncatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buattoast("button catch em all");
                Intent i = new Intent(getApplicationContext(), catchall.class);
                i.putExtra("page", 1);
                startActivity(i);
            }
        });
    }

    public void buattoast(String pesan) {
        Toast.makeText(MainActivity.this, pesan, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
