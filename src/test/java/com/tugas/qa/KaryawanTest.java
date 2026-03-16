package com.tugas.qa;

import org.testng.Assert;
import org.testng.annotations.Test;

public class KaryawanTest {

    @Test
    public void testHitungGajiTotalManager() {
        // Arrange
        Karyawan karyawan = new Karyawan("Budi", "Manager", 10000000);

        // Act
        double gajiTotal = karyawan.hitungGajiTotal();

        // Assert
        double expected = 15000000; // 10.000.000 + 5.000.000
        Assert.assertEquals(gajiTotal, expected);
    }

    @Test
    public void testUpdateGajiPositif() {
        // Arrange
        Karyawan karyawan = new Karyawan("Siti", "Staff", 8000000);

        // Act
        karyawan.updateGaji(10); // naik 10%

        // Assert
        double expected = 8800000; // 8.000.000 + 10% = 8.800.000
        Assert.assertEquals(karyawan.getGajiPokok(), expected);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testUpdateGajiPersenNegatif() {
        Karyawan karyawan = new Karyawan("Andi", "Staff", 7000000);

        // Act: harus lempar IllegalArgumentException
        karyawan.updateGaji(-5);
    }
}