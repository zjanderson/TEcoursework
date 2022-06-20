package com.techelevator;

public class Person {
    private String name;
    private final int age;
    private final Cat cat;

    public Person(String name, int age, Cat cat) {
        this.name = name;
        this.age = age;
        this.cat = cat;
    }


    public void setName(String name) {
        this.name = name;
    }
}
