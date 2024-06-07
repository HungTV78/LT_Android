package com.example.ktl1_may14_letanhung_st4;

import java.util.ArrayList;
public class Flag {
    int id;
    String name;
    public Flag(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public static ArrayList initFlag(){
        ArrayList<Flag> arrayList = new ArrayList<>();
        arrayList.add(new Flag(R.drawable.iphone_15_promax, "Iphone 15 Pro Max"));
        arrayList.add(new Flag(R.drawable.iphone_14, "Iphone 14"));
        arrayList.add(new Flag(R.drawable.img, "Samsung Galaxy S23 Ultra"));
        arrayList.add(new Flag(R.drawable.samsung_flip4, "Samsung Galaxy Z Flip 4"));
        arrayList.add(new Flag(R.drawable.mi_12_pro, "Mi 12 Pro"));
        arrayList.add(new Flag(R.drawable.xiaomi_note_12, "Xiaomi Redmi Note 12"));
        arrayList.add(new Flag(R.drawable.vivo_x90, "Vivo X90"));
        arrayList.add(new Flag(R.drawable.vivo_v25, "Vivo V25"));
        arrayList.add(new Flag(R.drawable.oppo_find_x5pro, "Oppo Find X5 Pro"));
        arrayList.add(new Flag(R.drawable.oppo_reno7, "Oppo Reno 7"));
        return arrayList;
    }
}
