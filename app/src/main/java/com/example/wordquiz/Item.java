package com.example.wordquiz;

public class Item {

    String point1;

    public Item(String name, String email, int image) {
        this.point1 = name;
    }

    public String getName() {
        return point1;
    }

    public void setName(String name) {
        this.point1 = name;
    }

}
