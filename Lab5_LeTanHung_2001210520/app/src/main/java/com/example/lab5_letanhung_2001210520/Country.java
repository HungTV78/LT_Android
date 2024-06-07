package com.example.lab5_letanhung_2001210520;

import java.util.ArrayList;

public class Country {
    private int idImg;
    private String name;

    public Country(int idImg, String name) {
        this.idImg = idImg;
        this.name = name;
    }

    public static ArrayList<Country> initArrayListCountry(int[] lsIdImg, String[] lsName) {
        ArrayList<Country> countrys = new ArrayList<>();
        for (int i = 0; i < lsIdImg.length; i++) {
            countrys.add(new Country(lsIdImg[i], lsName[i]));
        }
        return  countrys;
    }

    public int getIdImg() {
        return idImg;
    }

    public String getName() {
        return name;
    }

}