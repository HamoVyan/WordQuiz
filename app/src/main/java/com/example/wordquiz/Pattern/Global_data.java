package com.example.wordquiz.Pattern;

import java.util.ArrayList;
import java.util.List;

public class Global_data {

    public static  Global_data instance = new Global_data();
    private List<String> data = new ArrayList<>();

    public static Global_data getInstance() {
        return instance;
    }

    public static void setInstance(Global_data instance) {
        Global_data.instance = instance;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

}
