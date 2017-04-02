package com.example.audi.projectutspenir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class arcade extends AppCompatActivity {

    ArrayList<Integer> historybutton = new ArrayList<>();
    TextView txtkesempatan, txtskor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hilangkanheader();
        setContentView(R.layout.activity_arcade);

        setskor(0);

        setkesempatan(3);
    }

    public void hilangkanheader() {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
    }

    public void setskor(int skor) {
        txtskor = (TextView) findViewById(R.id.txtskor);
        txtskor.setText("Skor : " + String.valueOf(skor));
    }

    public void setkesempatan(int kesempatan) {
        txtkesempatan = (TextView) findViewById(R.id.txtkesempatan);
        txtkesempatan.setText("Kesempatan : " + String.valueOf(kesempatan));
    }

    public void buttonjwbklik(View view) {
        buattoast("button isian");

        historybutton.add(view.getId());
        view.setVisibility(View.INVISIBLE);

        buattoast("button " + view.getId() + " masuk ke array dan invisibel");
    }

    public void buttonisiklik(View view) {
        buattoast("button jawaban");

        int itemterakhir = historybutton.size() - 1;
        if (itemterakhir >= 0) {
            restorebutton(itemterakhir);
        }
    }

    public void restorebutton(int itemterakhir) {
        Button restore = (Button) findViewById(historybutton.get(itemterakhir));

        restore.setVisibility(View.VISIBLE);

        historybutton.remove(itemterakhir);
    }

    public void imageklik(View view) {
        buattoast("salah sasaran bosku -_-");
    }

    public void buattoast(String pesan) {
        Toast.makeText(arcade.this, pesan, Toast.LENGTH_SHORT).show();
    }
}
