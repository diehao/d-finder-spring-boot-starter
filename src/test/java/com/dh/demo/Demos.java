package com.dh.demo;

import lombok.Data;

@Data
public class Demos {
    private String name;
    private int age;
    private String local;

    public Demos(String name, int age, String local) {
        this.name = name;
        this.age = age;
        this.local = local;
    }
}
