package com.example.audi.projectutspenir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnarcade, btncatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnarcade = (Button) findViewById(R.id.btnarcade);
        btnarcade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buattoast("button arcade");
                Intent i = new Intent(getApplicationContext(), arcade.class);
                startActivity(i);
            }
        });

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
}
