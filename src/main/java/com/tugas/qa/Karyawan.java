package com.tugas.qa;

public class Karyawan {
    private String nama;
    private String jabatan;
    private double gajiPokok;

    public Karyawan(String nama, String jabatan, double gajiPokok) {
        this.nama = nama;
        this.jabatan = jabatan;
        this.gajiPokok = gajiPokok;
    }

       public double hitungGajiTotal() {
        double tunjangan = 0.0;

        if (jabatan.equals("Manager")) {
            tunjangan = 5000000;
        } else if (jabatan.equals("Staff")) {
            tunjangan = 2000000;
        }

        return gajiPokok + tunjangan;
    }

        public void updateGaji(double persen) {
        if (persen < 0) {
            throw new IllegalArgumentException("Persentase kenaikan tidak boleh negatif");
        }

        double kenaikan = gajiPokok * (persen / 100.0);
        gajiPokok = gajiPokok + kenaikan;
    }
        public double getGajiPokok() {
        return gajiPokok;
    }


}