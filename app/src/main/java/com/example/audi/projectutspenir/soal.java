package com.example.audi.projectutspenir;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Audi on 4/2/2017.
 */

public class soal implements Serializable {
    private String gambar;
    private String[] jawaban;
    private ArrayList<String> pilihan;
    private Boolean status;

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String[] getJawaban() {
        return jawaban;
    }

    public void setJawaban(String[] jawaban) {
        this.jawaban = jawaban;
    }

    public soal(String gambar, String[] jawaban, ArrayList<String> pilihan, Boolean status){
        setGambar(gambar);
        setJawaban(jawaban);
        setPilihan(pilihan);
        setStatus(status);
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ArrayList<String> getPilihan() {
        return pilihan;
    }

    public void setPilihan(ArrayList<String> pilihan) {
        this.pilihan = pilihan;
    }
}
