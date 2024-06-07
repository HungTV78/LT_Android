package com.example.lab5_letanhung_2001210520;
import java.util.ArrayList;

public class Language_Bai6 {
    private int idImg;
    private String name;

    public Language_Bai6(int idImg, String name) {
        this.idImg = idImg;
        this.name = name;
    }

    public static ArrayList<Language_Bai6> initArrayListLanguage(int[] lsIdImg, String[] lsName) {
        ArrayList<Language_Bai6> languages = new ArrayList<>();
        for (int i = 0; i < lsIdImg.length; i++) {
            languages.add(new Language_Bai6(lsIdImg[i], lsName[i]));
        }
        return languages;
    }

    public int getIdImg() {
        return idImg;
    }

    public String getName() {
        return name;
    }
}
