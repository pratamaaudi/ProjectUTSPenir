package com.example.audi.projectutspenir;

import java.io.Serializable;

/**
 * Created by Audi on 4/2/2017.
 */

public class soal implements Serializable {
    private String gambar;
    private String[] jawaban;
    private String[] pilihan;

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String[] getPilihan() {
        return pilihan;
    }

    public void setPilihan(String[] isian) {
        this.pilihan = isian;
    }

    public String[] getJawaban() {
        return jawaban;
    }

    public void setJawaban(String[] jawaban) {
        this.jawaban = jawaban;
    }

    public soal(String gambar, String[] jawaban, String[] pilihan){
        setGambar(gambar);
        setJawaban(jawaban);
        setPilihan(pilihan);
    }
}
