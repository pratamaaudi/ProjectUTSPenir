package com.example.audi.projectutspenir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class arcade extends AppCompatActivity {

    ArrayList<Integer> historybutton = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arcade);
    }

    public void buttonjwbklik(View view) {
        buattoast("button isian");

        historybutton.add(view.getId());
        view.setVisibility(View.INVISIBLE);

        buattoast("button "+view.getId()+" masuk ke array dan invisibel");
    }

    public void buttonisiklik(View view) {
        buattoast("button jawaban");

        int itemterakhir = historybutton.size()-1;
        Button restore = (Button) findViewById(historybutton.get(itemterakhir));

        restore.setVisibility(View.VISIBLE);

        historybutton.remove(itemterakhir);
    }

    public void buattoast(String pesan) {
        Toast.makeText(arcade.this, pesan, Toast.LENGTH_SHORT).show();
    }
}
