package com.example.audi.projectutspenir;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class catchall extends AppCompatActivity {

    CustomView customview;

    ListView list;

    ProgressBar prgtotal;

    TextView txtsocial, txtbrand, txtapp, txttotal;

    Typeface custom_font;

    Integer page;

    public static ArrayList<soal> social = new ArrayList<>();
    public static ArrayList<soal> brand = new ArrayList<>();
    public static ArrayList<soal> app = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hilangkanheader();
        setContentView(R.layout.activity_catchall);

        gantifont();

        Intent i = getIntent();
        page = i.getIntExtra("page", 0);
        buattoast("load page ke " + page);

        if (social.isEmpty()) {
            buatlistsocial();
        }
        if (brand.isEmpty()) {
            buatlistbrand();
        }
        if (app.isEmpty()) {
            buatlistapp();
        }

        if (page == 1) {
            loadlist(social);
            setprogressbar(social);
            listviewonclick(social, "social");
        } else if (page == 2) {
            loadlist(brand);
            setprogressbar(brand);
            listviewonclick(brand, "brand");
        } else if (page == 3) {
            loadlist(app);
            setprogressbar(app);
            listviewonclick(app, "app");
        } else if (page == 0) {
            buattoast("ga masuk");
        }
    }

    public void hilangkanheader() {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
    }

    public void gantifont() {
        txtsocial = (TextView) findViewById(R.id.txtsocial);
        txtbrand = (TextView) findViewById(R.id.txtbrand);
        txtapp = (TextView) findViewById(R.id.txtapp);

        custom_font = Typeface.createFromAsset(getAssets(), "fonts/font.ttf");

        txtsocial.setTypeface(custom_font);
        txtbrand.setTypeface(custom_font);
        txtapp.setTypeface(custom_font);
    }

    public void buatlistsocial() {
        social.add(new soal("bbm", new String[]{"b", "b", "m",}, new ArrayList<String>() {{
            add("a");
            add("b");
            add("a");
            add("b");
            add("a");
            add("m");
            add("a");
            add("a");
        }}, false));
        social.add(new soal("line", new String[]{"l", "i", "n", "e"}, new ArrayList<String>() {{
            add("l");
            add("i");
            add("n");
            add("e");
            add("s");
            add("z");
            add("w");
            add("a");
        }}, false));
        social.add(new soal("kaskus", new String[]{"k", "a", "s", "k", "u", "s"}, new ArrayList<String>() {{
            add("k");
            add("a");
            add("s");
            add("k");
            add("u");
            add("s");
            add("z");
            add("u");
        }}, false));
        social.add(new soal("twitter", new String[]{"t", "w", "i", "t", "t", "e", "r"}, new ArrayList<String>() {{
            add("t");
            add("w");
            add("i");
            add("t");
            add("t");
            add("e");
            add("r");
            add("w");
        }}, false));
        social.add(new soal("vimeo", new String[]{"v", "i", "m", "e", "o"}, new ArrayList<String>() {{
            add("v");
            add("i");
            add("m");
            add("e");
            add("o");
            add("d");
            add("w");
            add("y");
        }}, false));
        social.add(new soal("wechat", new String[]{"w", "e", "c", "h", "a", "t"}, new ArrayList<String>() {{
            add("w");
            add("e");
            add("c");
            add("h");
            add("a");
            add("t");
            add("v");
            add("o");
        }}, false));
    }

    public void buatlistbrand() {
        brand.add(new soal("amazon", new String[]{"a", "m", "a", "z", "o", "n", "e"}, new ArrayList<String>() {{
            add("a");
            add("m");
            add("a");
            add("z");
            add("o");
            add("n");
            add("e");
            add("t");
        }}, false));
        brand.add(new soal("bmw", new String[]{"b", "m", "w"}, new ArrayList<String>() {{
            add("b");
            add("m");
            add("w");
            add("r");
            add("e");
            add("s");
            add("i");
            add("i");
        }}, false));
        brand.add(new soal("nexus", new String[]{"n", "e", "x", "u", "s"}, new ArrayList<String>() {{
            add("n");
            add("e");
            add("x");
            add("u");
            add("s");
            add("i");
            add("a");
            add("n");
        }}, false));
        brand.add(new soal("paypal", new String[]{"p", "a", "y", "p", "a", "l"}, new ArrayList<String>() {{
            add("p");
            add("a");
            add("y");
            add("p");
            add("a");
            add("l");
            add("o");
            add("l");
        }}, false));
        brand.add(new soal("tesla", new String[]{"t", "e", "s", "l", "a"}, new ArrayList<String>() {{
            add("t");
            add("e");
            add("s");
            add("l");
            add("a");
            add("s");
            add("r");
            add("j");
        }}, false));
        brand.add(new soal("xbox", new String[]{"x", "b", "o", "x"}, new ArrayList<String>() {{
            add("x");
            add("b");
            add("o");
            add("x");
            add("e");
            add("r");
            add("a");
            add("d");
        }}, false));
        brand.add(new soal("yahoo", new String[]{"y", "a", "h", "o", "o"}, new ArrayList<String>() {{
            add("y");
            add("a");
            add("h");
            add("h");
            add("o");
            add("o");
            add("a");
            add("y");
        }}, false));
        brand.add(new soal("zynga", new String[]{"z", "y", "n", "g", "a"}, new ArrayList<String>() {{
            add("z");
            add("y");
            add("n");
            add("g");
            add("a");
            add("i");
            add("g");
            add("s");
        }}, false));
    }

    public void buatlistapp() {
        app.add(new soal("aol", new String[]{"a", "o", "l"}, new ArrayList<String>() {{
            add("a");
            add("o");
            add("l");
            add("w");
            add("e");
            add("s");
            add("u");
            add("x");
        }}, false));
        app.add(new soal("bing", new String[]{"b", "i", "n", "g"}, new ArrayList<String>() {{
            add("b");
            add("i");
            add("n");
            add("g");
            add("s");
            add("f");
            add("e");
            add("r");
        }}, false));
        app.add(new soal("blog", new String[]{"b", "l", "o", "g"}, new ArrayList<String>() {{
            add("b");
            add("l");
            add("o");
            add("g");
            add("w");
            add("s");
            add("e");
            add("o");
        }}, false));
        app.add(new soal("blogger", new String[]{"b", "l", "o", "g", "g", "e", "r"}, new ArrayList<String>() {{
            add("b");
            add("l");
            add("o");
            add("g");
            add("g");
            add("e");
            add("r");
            add("u");
        }}, false));
        app.add(new soal("chrome", new String[]{"c", "h", "r", "o", "m", "e"}, new ArrayList<String>() {{
            add("c");
            add("h");
            add("r");
            add("o");
            add("m");
            add("e");
            add("x");
            add("f");
        }}, false));
        app.add(new soal("drive", new String[]{"d", "r", "i", "v", "e"}, new ArrayList<String>() {{
            add("d");
            add("r");
            add("i");
            add("v");
            add("e");
            add("g");
            add("o");
            add("o");
        }}, false));
        app.add(new soal("dropbox", new String[]{"d", "r", "o", "p", "b", "o", "x"}, new ArrayList<String>() {{
            add("d");
            add("r");
            add("o");
            add("p");
            add("b");
            add("o");
            add("x");
            add("s");
        }}, false));
        app.add(new soal("github", new String[]{"g", "i", "t", "h", "u", "b"}, new ArrayList<String>() {{
            add("g");
            add("i");
            add("t");
            add("h");
            add("u");
            add("b");
            add("e");
            add("a");
        }}, false));
        app.add(new soal("pandora", new String[]{"p", "a", "n", "d", "o", "r", "a"}, new ArrayList<String>() {{
            add("p");
            add("a");
            add("n");
            add("d");
            add("o");
            add("r");
            add("a");
            add("t");
        }}, false));
        app.add(new soal("paypal", new String[]{"p", "a", "y", "p", "a", "l"}, new ArrayList<String>() {{
            add("p");
            add("a");
            add("y");
            add("p");
            add("a");
            add("l");
            add("o");
            add("l");
        }}, false));
        app.add(new soal("spotify", new String[]{"s", "p", "o", "t", "i", "f", "y"}, new ArrayList<String>() {{
            add("s");
            add("p");
            add("o");
            add("t");
            add("i");
            add("f");
            add("y");
            add("t");
        }}, false));
        app.add(new soal("uber", new String[]{"u", "b", "e", "r"}, new ArrayList<String>() {{
            add("u");
            add("b");
            add("e");
            add("r");
            add("j");
            add("e");
            add("k");
            add("s");
        }}, false));
        app.add(new soal("viber", new String[]{"v", "i", "b", "e", "r"}, new ArrayList<String>() {{
            add("v");
            add("i");
            add("b");
            add("e");
            add("r");
            add("a");
            add("t");
            add("e");
        }}, false));
        app.add(new soal("vlc", new String[]{"v", "l", "c"}, new ArrayList<String>() {{
            add("v");
            add("l");
            add("c");
            add("a");
            add("d");
            add("w");
            add("y");
            add("i");
        }}, false));
        app.add(new soal("youtube2", new String[]{"y", "o", "u", "t", "u", "b", "e"}, new ArrayList<String>() {{
            add("y");
            add("o");
            add("u");
            add("t");
            add("u");
            add("b");
            add("e");
            add("v");
        }}, false));
    }

    public void buattoast(String pesan) {
        Toast.makeText(catchall.this, pesan, Toast.LENGTH_SHORT).show();
    }

    public void txtsocialonclick(View view) {
        setprogressbar(social);
        loadlist(social);
        listviewonclick(social, "social");
    }

    public void txtbrandonclick(View view) {
        setprogressbar(brand);
        loadlist(brand);
        listviewonclick(brand, "brand");
    }

    public void txtapponclick(View view) {
        loadlist(app);
        setprogressbar(app);
        listviewonclick(app, "app");
    }

    public void setprogressbar(ArrayList<soal> hitung) {
        int max = hitung.size();
        int terjawab = 0;
        for (int i = 0; i < max; i++) {
            if (hitung.get(i).getStatus() == true) {
                terjawab++;
            }
        }

        prgtotal = (ProgressBar) findViewById(R.id.prgtotal);
        prgtotal.setMax(max);
        prgtotal.setProgress(terjawab);

        txttotal = (TextView) findViewById(R.id.txttotal);
        txttotal.setText(String.valueOf(terjawab) + "/" + String.valueOf(max));
    }

    public void loadlist(ArrayList<soal> s) {
        list = (ListView) findViewById(R.id.list);
        customview = new CustomView(this, s);
        list.setAdapter(customview);
    }

    public void listviewonclick(final ArrayList<soal> soal, final String array) {
        ListView list = (ListView) findViewById(R.id.list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (soal.get(position).getStatus() == true) {
                    buattoast("yang ini sudah terjawab broh");
                } else {
                    String gambar = soal.get(position).getGambar();

                    ArrayList<String> pilihanlist = new ArrayList<String>(soal.get(position).getPilihan());

                    String[] jawaban = soal.get(position).getJawaban();

                    Intent i = new Intent(getApplicationContext(), jawab.class);
                    i.putExtra("gambar", gambar);
                    i.putStringArrayListExtra("pilihan", pilihanlist);
                    i.putExtra("jawaban", jawaban);
                    i.putExtra("array", array);
                    i.putExtra("position", position);
                    startActivity(i);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
}
