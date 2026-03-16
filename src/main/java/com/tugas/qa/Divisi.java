package com.tugas.qa;

import java.util.ArrayList;
import java.util.List;

public class Divisi {

    private String namaDivisi;
    private List<Karyawan> daftarKaryawan;

    public Divisi(String namaDivisi) {
        this.namaDivisi = namaDivisi;
        this.daftarKaryawan = new ArrayList<>();
    }

    public void tambahKaryawan(Karyawan karyawan) {
        if (karyawan == null) {
            throw new IllegalArgumentException("Karyawan tidak boleh null");
        }
        daftarKaryawan.add(karyawan);
    }

    public int getJumlahKaryawan() {
        return daftarKaryawan.size();
    }

    public String getNamaDivisi() {
        return namaDivisi;
    }
}