package com.example.audi.projectutspenir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    Button btnarcade, btncatch;
    ArrayList<soal> soal = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonarcadeonclick();
        buttoncatchonclick();
    }

    public void buttonarcadeonclick() {
        btnarcade = (Button) findViewById(R.id.btnarcade);
        btnarcade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buattoast("button arcade");
                Intent i = new Intent(getApplicationContext(), arcade.class);
                startActivity(i);
            }
        });
    }

    public void buttoncatchonclick(){
        btncatch = (Button) findViewById(R.id.btncatch);
        btncatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buattoast("button catch em all");
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
