package com.example.lab5_letanhung_2001210520;

import java.util.ArrayList;

public class Fruit {
    private int idImg;
    private String name;
    private double price;

    public Fruit(int idImg, String name, double price) {
        this.idImg = idImg;
        this.name = name;
        this.price = price;
    }

    public static ArrayList<Fruit> initArrayListFruit(int[] lsIdImg, String[] lsName, double[] lsPrice) {
        ArrayList<Fruit> fruits = new ArrayList<>();
        for (int i = 0; i < lsIdImg.length; i++) {
            fruits.add(new Fruit(lsIdImg[i], lsName[i], lsPrice[i]));
        }
        return fruits;
    }

    public int getIdImg() {
        return idImg;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

