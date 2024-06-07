package com.example.lab9_letanhung_2001210520.bai3_lab9.Model;

public class SinhVien {
    int maSV;
    String tenSV;
    public SinhVien(int maSV, String tenSV) {
        this.maSV = maSV;
        this.tenSV = tenSV;
    }

    public SinhVien() {

    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }
}
