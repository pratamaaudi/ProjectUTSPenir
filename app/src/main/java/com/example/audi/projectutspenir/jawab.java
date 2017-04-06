package com.example.audi.projectutspenir;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class jawab extends AppCompatActivity {

    ArrayList<Integer> historybutton = new ArrayList<>();

    Button btnisi1, btnisi2, btnisi3, btnisi4, btnisi5, btnisi6, btnisi7, btnjwb1, btnjwb2, btnjwb3, btnjwb4, btnjwb5, btnjwb6, btnjwb7, btnjwb8;
    Button[] kolom;

    Integer panjang, width, position;

    LinearLayout lljawab;

    String array;
    String[] jawaban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hilangkanheader();
        setContentView(R.layout.activity_jawab);

        Intent in = getIntent();
        String gambar = in.getStringExtra("gambar");

        position = in.getIntExtra("position", 0);

        int resID = getResources().getIdentifier(gambar, "drawable", getPackageName());
        ImageView imgsoal = (ImageView) findViewById(R.id.imgsoal);
        imgsoal.setImageResource(resID);

        ArrayList<String> button = in.getStringArrayListExtra("pilihan");

        btnjwb1 = (Button) findViewById(R.id.btnjwb1);
        btnjwb2 = (Button) findViewById(R.id.btnjwb2);
        btnjwb3 = (Button) findViewById(R.id.btnjwb3);
        btnjwb4 = (Button) findViewById(R.id.btnjwb4);
        btnjwb5 = (Button) findViewById(R.id.btnjwb5);
        btnjwb6 = (Button) findViewById(R.id.btnjwb6);
        btnjwb7 = (Button) findViewById(R.id.btnjwb7);
        btnjwb8 = (Button) findViewById(R.id.btnjwb8);

        Button[] pilihan = new Button[]{btnjwb1, btnjwb2, btnjwb3, btnjwb4, btnjwb5, btnjwb6, btnjwb7, btnjwb8};

        Collections.shuffle(button);

        for (int i = 0; i < 8; i++) {
            pilihan[i].setVisibility(View.VISIBLE);
            pilihan[i].setText(button.get(i));
        }

        jawaban = in.getStringArrayExtra("jawaban");

        panjang = Array.getLength(jawaban);

        array = in.getStringExtra("array");

        listsemuabuttonjawaban();
        munculkankotak();
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //Here you can get the size!

        if (panjang > 1) {
            resizeJawaban(1);
        }
        if (panjang > 2) {
            Integer ganjilgenap = panjang % 2;
            if (ganjilgenap.equals(0)) {
                resizeJawaban((panjang / 2) - 1);
            } else {
                //set linear layout margin
                lljawab = (LinearLayout) findViewById(R.id.lljawab);
                LinearLayout.LayoutParams param = (LinearLayout.LayoutParams) lljawab.getLayoutParams();
                param.setMargins(35, 0, 35, 0);
                lljawab.setLayoutParams(param);
            }
        }
    }

    public void hilangkanheader() {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
    }

    public void listsemuabuttonjawaban() {
        btnisi1 = (Button) findViewById(R.id.btnisi1);
        btnisi2 = (Button) findViewById(R.id.btnisi2);
        btnisi3 = (Button) findViewById(R.id.btnisi3);
        btnisi4 = (Button) findViewById(R.id.btnisi4);
        btnisi5 = (Button) findViewById(R.id.btnisi5);
        btnisi6 = (Button) findViewById(R.id.btnisi6);
        btnisi7 = (Button) findViewById(R.id.btnisi7);

        kolom = new Button[]{btnisi1, btnisi2, btnisi3, btnisi4, btnisi5, btnisi6, btnisi7};
    }

    public void munculkankotak() {
        for (int i = 0; i < 7; i++) {
            kolom[i].setVisibility(View.INVISIBLE);
        }

        for (int i = 0; i < panjang; i++) {
            //memunculkan kotak
            kolom[i].setVisibility(View.VISIBLE);
            //membersihkan isi kotak jika berisi jawaban dari soal sebelumnya
            kolom[i].setText("");
        }

        if (panjang > 1) {
            resizeJawaban(1);
        }
        if (panjang > 2) {
            Integer ganjilgenap = panjang % 2;
            if (ganjilgenap.equals(0)) {
                resizeJawaban((panjang / 2) - 1);
            } else {
                //set linear layout margin
                lljawab = (LinearLayout) findViewById(R.id.lljawab);
                LinearLayout.LayoutParams param = (LinearLayout.LayoutParams) lljawab.getLayoutParams();
                param.setMargins(35, 0, 35, 0);
                lljawab.setLayoutParams(param);
            }
        }
    }

    public void resizeJawaban(Integer selisih) {

        width = btnisi1.getWidth();
        if (selisih.equals(2)) {
            lljawab = (LinearLayout) findViewById(R.id.lljawab);
            LinearLayout.LayoutParams param = (LinearLayout.LayoutParams) lljawab.getLayoutParams();
            param.setMargins((width / 2 * selisih) + 35, 0, 35, 0);
            lljawab.setLayoutParams(param);
        } else {
            //set linear layout margin
            lljawab = (LinearLayout) findViewById(R.id.lljawab);
            LinearLayout.LayoutParams param = (LinearLayout.LayoutParams) lljawab.getLayoutParams();
            param.setMargins((width * selisih) + 35, 0, 35, 0);
            lljawab.setLayoutParams(param);
        }

    }

    public void buttonisiklik(View view) {
        listbuttonjawabanurut();

        for (int i = 6; i >= 0; i--) {
            if (kolom[i].isShown()) {
                if (kolom[i].getText().toString().equals("")) {
                } else {
                    kolom[i].setText("");
                    kolom[i].setBackgroundResource(android.R.drawable.editbox_dropdown_light_frame);
                    i = -1;
                }
            }
        }

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

    public void buttonjwbklik(View view) {
        listbuttonjawabanurut();

        Button b = (Button) view;
        String dipilih = b.getText().toString();

        for (int i = 0; i < 7; i++) {
            if (kolom[i].isShown()) {
                if (kolom[i].getText().toString().equals("")) {
                    kolom[i].setText(dipilih);
                    view.setVisibility(View.INVISIBLE);
                    historybutton.add(view.getId());
                    i = 7;
                }
            }
        }

        for (int i = 6; i >= 0; i--) {
            if (kolom[i].isShown()) {
                if (kolom[i].getText().toString().equals("")) {
                    i = -1;
                } else {
                    cekjawaban();
                    i = -1;
                }
            }
        }
    }

    public void listbuttonjawabanurut() {
        btnisi1 = (Button) findViewById(R.id.btnisi1);
        btnisi2 = (Button) findViewById(R.id.btnisi2);
        btnisi3 = (Button) findViewById(R.id.btnisi3);
        btnisi4 = (Button) findViewById(R.id.btnisi4);
        btnisi5 = (Button) findViewById(R.id.btnisi5);
        btnisi6 = (Button) findViewById(R.id.btnisi6);
        btnisi7 = (Button) findViewById(R.id.btnisi7);

        kolom = new Button[]{btnisi6, btnisi4, btnisi2, btnisi1, btnisi3, btnisi5, btnisi7};
    }

    public void cekjawaban() {
        int jawabanke = 0;
        int terjawab = 0;
        for (int i = 0; i < 7; i++) {
            if (kolom[i].isShown()) {
                if (kolom[i].getText().toString().equals(jawaban[jawabanke])) {
                    terjawab++;
                } else {
                    kolom[i].setBackgroundColor(Color.parseColor("#FF0000"));
                }
                jawabanke++;
            }
        }

        if (terjawab == jawabanke) {
            Intent in = new Intent(getApplicationContext(), catchall.class);
            if (array.equals("social")) {
                catchall.social.get(position).setStatus(true);
                in.putExtra("page", 1);
            } else if (array.equals("brand")) {
                catchall.brand.get(position).setStatus(true);
                in.putExtra("page", 2);
            } else {
                catchall.app.get(position).setStatus(true);
                in.putExtra("page", 3);
            }
            startActivity(in);
        } else {
            buattoast("jawaban salah");
        }
    }

    public void buattoast(String pesan) {
        Toast.makeText(jawab.this, pesan, Toast.LENGTH_SHORT).show();
    }

}
