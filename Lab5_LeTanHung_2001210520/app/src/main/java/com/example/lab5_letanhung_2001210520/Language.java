package com.example.lab5_letanhung_2001210520;

import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
public class Language {
    private long id;
    private String name;
    private float percent;
    public Language(long id, String name, float percent) {
        this.id = id;
        this.name = name;
        this.percent = percent;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getPercent() {
        return percent;
    }
    public void setPercent(float percent) {
        this.percent = percent;
    }
    public static List<Language> getLanguages( ) {
        Language javascript = new Language(1, "Javascript", 67.7f);
        Language htmlCss = new Language(2, "HTML/CSS", 63.1f);
        Language sql = new Language(3, "SQL", 54.7f);
        Language python = new Language(4, "Python", 44.1f);
        Language java = new Language(5, "Java", 40.2f);
        List<Language> list = new ArrayList<Language>();
        list.add(javascript);
        list.add(htmlCss);
        list.add(sql);
        list.add(python);
        list.add(java);
        return list;
    }
}
