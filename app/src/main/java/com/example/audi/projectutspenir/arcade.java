package com.example.audi.projectutspenir;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class arcade extends AppCompatActivity {

    ArrayList<Integer> historybutton = new ArrayList<>();
    ArrayList<soal> soal = new ArrayList<>();

    TextView txtkesempatan, txtskor;

    ImageView imgsoal;

    Integer panjang, width, kesempatan, skor, soalke, banyaksoal;

    Button btnisi1, btnisi2, btnisi3, btnisi4, btnisi5, btnisi6, btnisi7, btnjwb1, btnjwb2, btnjwb3, btnjwb4, btnjwb5, btnjwb6, btnjwb7, btnjwb8;
    Button[] kolom, pilihan;

    LinearLayout lljawab, llmain;

    String[] jawaban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hilangkanheader();
        setContentView(R.layout.activity_arcade);

        gantibackground();

        skor = 0;
        setskor(skor);

        kesempatan = 3;
        setkesempatan(kesempatan);

        buatsoal();

        soalke = 0;
        loadsoal(soalke);
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

    public void gantibackground() {
        String[] background = new String[]{"wpp1", "wpp2", "wpp3"};
        Random r = new Random();
        int i = r.nextInt(3 - 0);
        llmain = (LinearLayout) findViewById(R.id.llmain);
        int resID = getResources().getIdentifier(background[i], "drawable", getPackageName());
        llmain.setBackgroundResource(resID);
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
        soal.add(new soal("bbm", new String[]{"b", "b", "m",}, new ArrayList<String>() {{
            add("a");
            add("b");
            add("a");
            add("b");
            add("a");
            add("m");
            add("a");
            add("a");
        }}, false));
        soal.add(new soal("amazon", new String[]{"a", "m", "a", "z", "o", "n", "e"}, new ArrayList<String>() {{
            add("a");
            add("m");
            add("a");
            add("z");
            add("o");
            add("n");
            add("e");
            add("t");
        }}, false));
        soal.add(new soal("line", new String[]{"l", "i", "n", "e"}, new ArrayList<String>() {{
            add("l");
            add("i");
            add("n");
            add("e");
            add("s");
            add("z");
            add("w");
            add("a");
        }}, false));
        soal.add(new soal("aol", new String[]{"a", "o", "l"}, new ArrayList<String>() {{
            add("a");
            add("o");
            add("l");
            add("w");
            add("e");
            add("s");
            add("u");
            add("x");
        }}, false));
        soal.add(new soal("bing", new String[]{"b", "i", "n", "g"}, new ArrayList<String>() {{
            add("b");
            add("i");
            add("n");
            add("g");
            add("s");
            add("f");
            add("e");
            add("r");
        }}, false));
        soal.add(new soal("blog", new String[]{"b", "l", "o", "g"}, new ArrayList<String>() {{
            add("b");
            add("l");
            add("o");
            add("g");
            add("w");
            add("s");
            add("e");
            add("o");
        }}, false));
        soal.add(new soal("blogger", new String[]{"b", "l", "o", "g", "g", "e", "r"}, new ArrayList<String>() {{
            add("b");
            add("l");
            add("o");
            add("g");
            add("g");
            add("e");
            add("r");
            add("u");
        }}, false));
        soal.add(new soal("bmw", new String[]{"b", "m", "w"}, new ArrayList<String>() {{
            add("b");
            add("m");
            add("w");
            add("r");
            add("e");
            add("s");
            add("i");
            add("i");
        }}, false));
        soal.add(new soal("chrome", new String[]{"c", "h", "r", "o", "m", "e"}, new ArrayList<String>() {{
            add("c");
            add("h");
            add("r");
            add("o");
            add("m");
            add("e");
            add("x");
            add("f");
        }}, false));
        soal.add(new soal("drive", new String[]{"d", "r", "i", "v", "e"}, new ArrayList<String>() {{
            add("d");
            add("r");
            add("i");
            add("v");
            add("e");
            add("g");
            add("o");
            add("o");
        }}, false));
        soal.add(new soal("dropbox", new String[]{"d", "r", "o", "p", "b", "o", "x"}, new ArrayList<String>() {{
            add("d");
            add("r");
            add("o");
            add("p");
            add("b");
            add("o");
            add("x");
            add("s");
        }}, false));
        soal.add(new soal("github", new String[]{"g", "i", "t", "h", "u", "b"}, new ArrayList<String>() {{
            add("g");
            add("i");
            add("t");
            add("h");
            add("u");
            add("b");
            add("e");
            add("a");
        }}, false));
        soal.add(new soal("kaskus", new String[]{"k", "a", "s", "k", "u", "s"}, new ArrayList<String>() {{
            add("k");
            add("a");
            add("s");
            add("k");
            add("u");
            add("s");
            add("z");
            add("u");
        }}, false));
        soal.add(new soal("nexus", new String[]{"n", "e", "x", "u", "s"}, new ArrayList<String>() {{
            add("n");
            add("e");
            add("x");
            add("u");
            add("s");
            add("i");
            add("a");
            add("n");
        }}, false));
        soal.add(new soal("pandora", new String[]{"p", "a", "n", "d", "o", "r", "a"}, new ArrayList<String>() {{
            add("p");
            add("a");
            add("n");
            add("d");
            add("o");
            add("r");
            add("a");
            add("t");
        }}, false));
        soal.add(new soal("paypal", new String[]{"p", "a", "y", "p", "a", "l"}, new ArrayList<String>() {{
            add("p");
            add("a");
            add("y");
            add("p");
            add("a");
            add("l");
            add("o");
            add("l");
        }}, false));
        soal.add(new soal("ps", new String[]{"p", "s"}, new ArrayList<String>() {{
            add("p");
            add("s");
            add("l");
            add("a");
            add("y");
            add("t");
            add("o");
            add("n");
        }}, false));
        soal.add(new soal("skype", new String[]{"s", "k", "y", "p", "e"}, new ArrayList<String>() {{
            add("s");
            add("k");
            add("y");
            add("p");
            add("e");
            add("i");
            add("a");
            add("c");
        }}, false));
        soal.add(new soal("spotify", new String[]{"s", "p", "o", "t", "i", "f", "y"}, new ArrayList<String>() {{
            add("s");
            add("p");
            add("o");
            add("t");
            add("i");
            add("f");
            add("y");
            add("t");
        }}, false));
        soal.add(new soal("tesla", new String[]{"t", "e", "s", "l", "a"}, new ArrayList<String>() {{
            add("t");
            add("e");
            add("s");
            add("l");
            add("a");
            add("s");
            add("r");
            add("j");
        }}, false));
        soal.add(new soal("twitter", new String[]{"t", "w", "i", "t", "t", "e", "r"}, new ArrayList<String>() {{
            add("t");
            add("w");
            add("i");
            add("t");
            add("t");
            add("e");
            add("r");
            add("w");
        }}, false));
        soal.add(new soal("uber", new String[]{"u", "b", "e", "r"}, new ArrayList<String>() {{
            add("u");
            add("b");
            add("e");
            add("r");
            add("j");
            add("e");
            add("k");
            add("s");
        }}, false));
        soal.add(new soal("viber", new String[]{"v", "i", "b", "e", "r"}, new ArrayList<String>() {{
            add("v");
            add("i");
            add("b");
            add("e");
            add("r");
            add("a");
            add("t");
            add("e");
        }}, false));
        soal.add(new soal("vimeo", new String[]{"v", "i", "m", "e", "o"}, new ArrayList<String>() {{
            add("v");
            add("i");
            add("m");
            add("e");
            add("o");
            add("d");
            add("w");
            add("y");
        }}, false));
        soal.add(new soal("vlc", new String[]{"v", "l", "c"}, new ArrayList<String>() {{
            add("v");
            add("l");
            add("c");
            add("a");
            add("d");
            add("w");
            add("y");
            add("i");
        }}, false));
        soal.add(new soal("wechat", new String[]{"w", "e", "c", "h", "a", "t"}, new ArrayList<String>() {{
            add("w");
            add("e");
            add("c");
            add("h");
            add("a");
            add("t");
            add("v");
            add("o");
        }}, false));
        soal.add(new soal("xbox", new String[]{"x", "b", "o", "x"}, new ArrayList<String>() {{
            add("x");
            add("b");
            add("o");
            add("x");
            add("e");
            add("r");
            add("a");
            add("d");
        }}, false));
        soal.add(new soal("yahoo", new String[]{"y", "a", "h", "o", "o"}, new ArrayList<String>() {{
            add("y");
            add("a");
            add("h");
            add("h");
            add("o");
            add("o");
            add("a");
            add("y");
        }}, false));
        soal.add(new soal("youtube2", new String[]{"y", "o", "u", "t", "u", "b", "e"}, new ArrayList<String>() {{
            add("y");
            add("o");
            add("u");
            add("t");
            add("u");
            add("b");
            add("e");
            add("v");
        }}, false));
        soal.add(new soal("zynga", new String[]{"z", "y", "n", "g", "a"}, new ArrayList<String>() {{
            add("z");
            add("y");
            add("n");
            add("g");
            add("a");
            add("i");
            add("g");
            add("s");
        }}, false));


        banyaksoal = soal.size();
        Collections.shuffle(soal);
    }

    public void loadsoal(int soalke) {
        soal s = soal.get(soalke);

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

        ArrayList<String> jawaban = s.getPilihan();
        Collections.shuffle(jawaban);

        for (int i = 0; i < 8; i++) {
            pilihan[i].setVisibility(View.VISIBLE);
            pilihan[i].setText(jawaban.get(i));
        }
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

                    cekkotakhabis();
                }
            }
        }
    }

    public void cekkotakhabis(){
        for (int i2 = 6; i2 >= 0; i2--) {
            if (kolom[i2].isShown()) {
                if (kolom[i2].getText().toString().equals("")) {
                    i2 = -1;
                } else {
                    cekjawaban();
                    i2 = -1;
                }
            }
        }
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
            jawabanbenar();
        } else {
            jawabansalah();
        }
    }

    public void jawabanbenar() {
        skor += 100;
        setskor(skor);
        soalke++;
        if (soalke < 10) {
            loadsoal(soalke);
        } else {
            gameover();
        }
    }

    public void jawabansalah() {
        kesempatan--;
        if (kesempatan > 1) {
            buattoast("silahkan di revisi kembali, kesempatanmu berkurang menjadi " + kesempatan);
            setkesempatan(kesempatan);
        }
        if (kesempatan == 0) {
            buattoast("ini kesempatan terakhir, jangan di sia siakan broo!!");
            setkesempatan(kesempatan);
        }
        setkesempatan(kesempatan);
        if (kesempatan < 0) {
            gameover();
            setkesempatan(0);
        }
    }

    public void gameover() {
        Intent i = new Intent(getApplicationContext(), gameover.class);
        i.putExtra("skor", skor);
        startActivity(i);
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

    @Override
    public void onBackPressed() {
        buattoast("jangan melarikan diri brooo");
    }
}
