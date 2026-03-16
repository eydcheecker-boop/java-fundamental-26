package com.tugas.qa;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DivisiTest {

    @Test
    public void testTambahKaryawanDanJumlah() {
        Divisi divisi = new Divisi("IT");
        Karyawan k1 = new Karyawan("Budi", "Staff", 7000000);
        Karyawan k2 = new Karyawan("Siti", "Manager", 12000000);

        divisi.tambahKaryawan(k1);
        divisi.tambahKaryawan(k2);

        Assert.assertEquals(divisi.getJumlahKaryawan(), 2);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTambahKaryawanNull() {
        Divisi divisi = new Divisi("HR");
        divisi.tambahKaryawan(null);
    }
}