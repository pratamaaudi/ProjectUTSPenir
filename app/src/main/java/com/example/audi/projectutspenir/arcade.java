package com.example.audi.projectutspenir;

import android.content.Intent;
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

    Button btnisi1, btnisi2, btnisi3, btnisi4, btnisi5, btnisi6, btnisi7;

    LinearLayout lljawab;

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
        soal.add(new soal("bbm", new String[]{"b", "b", "b", "b"}, new String[]{"b", "b", "b", "b", "m", "b", "b", "b"}));
    }

    public void loadsoal() {
        soal s = soal.get(0);

        int resID = getResources().getIdentifier(s.getGambar(), "drawable", getPackageName());
        imgsoal = (ImageView) findViewById(R.id.imgsoal);
        imgsoal.setImageResource(resID);

        panjang = Array.getLength(s.getJawaban());

        btnisi1 = (Button) findViewById(R.id.btnisi1);
        btnisi2 = (Button) findViewById(R.id.btnisi2);
        btnisi3 = (Button) findViewById(R.id.btnisi3);
        btnisi4 = (Button) findViewById(R.id.btnisi4);
        btnisi5 = (Button) findViewById(R.id.btnisi5);
        btnisi6 = (Button) findViewById(R.id.btnisi6);
        btnisi7 = (Button) findViewById(R.id.btnisi7);

        Button[] kolom = new Button[]{btnisi1, btnisi2, btnisi3, btnisi4, btnisi5, btnisi6, btnisi7};

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

    public void resizeJawaban(Integer selisih) {

        width = btnisi1.getWidth();
        buattoast(String.valueOf(width));
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
