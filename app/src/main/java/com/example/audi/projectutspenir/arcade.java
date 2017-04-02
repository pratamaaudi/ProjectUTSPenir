package com.example.audi.projectutspenir;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class arcade extends AppCompatActivity {

    ArrayList<Integer> historybutton = new ArrayList<>();
    ArrayList<soal> soal = new ArrayList<>();

    TextView txtkesempatan, txtskor;

    ImageView imgsoal;

    Integer panjang, width;

    Button btnisi1, btnisi2, btnisi3, btnisi4, btnisi5, btnisi6, btnisi7, btnjwb1, btnjwb2, btnjwb3, btnjwb4, btnjwb5, btnjwb6, btnjwb7, btnjwb8;
    Button[] kolom, pilihan;

    LinearLayout lljawab;

    String[] jawaban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hilangkanheader();
        setContentView(R.layout.activity_arcade);

        setskor(0);

        setkesempatan(3);

        buatsoal();

        loadsoal();
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

    public void setskor(int skor) {
        txtskor = (TextView) findViewById(R.id.txtskor);
        txtskor.setText("Skor : " + String.valueOf(skor));
    }

    public void setkesempatan(int kesempatan) {
        txtkesempatan = (TextView) findViewById(R.id.txtkesempatan);
        txtkesempatan.setText("Kesempatan : " + String.valueOf(kesempatan));
    }

    public void buatsoal() {
        soal.add(new soal("bbm", new String[]{"b", "b", "m",}, new String[]{"c", "b", "w", "b", "m", "n", "b", "b"}));
        soal.add(new soal("bbm", new String[]{"l", "i", "n", "e"}, new String[]{"b", "l", "b", "e", "n", "b", "i", "b"}));
    }

    public void loadsoal() {
        soal s = soal.get(0);

        loadgambar(s);

        panjang = Array.getLength(s.getJawaban());

        listsemuabuttonjawaban();
        munculkankotak();

        isihurufkebutton(s);

        jawaban = s.getJawaban();
    }

    public void loadgambar(soal s) {
        int resID = getResources().getIdentifier(s.getGambar(), "drawable", getPackageName());
        imgsoal = (ImageView) findViewById(R.id.imgsoal);
        imgsoal.setImageResource(resID);
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

    public void isihurufkebutton(soal s) {
        btnjwb1 = (Button) findViewById(R.id.btnjwb1);
        btnjwb2 = (Button) findViewById(R.id.btnjwb2);
        btnjwb3 = (Button) findViewById(R.id.btnjwb3);
        btnjwb4 = (Button) findViewById(R.id.btnjwb4);
        btnjwb5 = (Button) findViewById(R.id.btnjwb5);
        btnjwb6 = (Button) findViewById(R.id.btnjwb6);
        btnjwb7 = (Button) findViewById(R.id.btnjwb7);
        btnjwb8 = (Button) findViewById(R.id.btnjwb8);

        pilihan = new Button[]{btnjwb1, btnjwb2, btnjwb3, btnjwb4, btnjwb5, btnjwb6, btnjwb7, btnjwb8};

        String[] jawaban = s.getPilihan();

        for (int i = 0; i < 8; i++) {
            pilihan[i].setText(jawaban[i]);
        }
    }

    public void munculkankotak() {
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

    public void cekjawaban() {
        buattoast("cek jawaban . . .");

        int jawabanke = 0;
        int terjawab = 0;
        for (int i = 0; i < 7; i++) {
            if (kolom[i].isShown()) {
                buattoast("kolom " + kolom[i].getText().toString() + " sama dengan kolom : " + jawaban[jawabanke]);
                if (kolom[i].getText().toString().equals(jawaban[jawabanke])) {
                    terjawab++;
                } else {
                    kolom[i].setBackgroundColor(Color.parseColor("#FF0000"));
                }
                jawabanke++;
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

    public void imageklik(View view) {
        buattoast("salah sasaran bosku -_-");
    }

    public void buattoast(String pesan) {
        Toast.makeText(arcade.this, pesan, Toast.LENGTH_SHORT).show();
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
}
