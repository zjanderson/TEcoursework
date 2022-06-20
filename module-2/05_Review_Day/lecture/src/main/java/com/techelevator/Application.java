package com.techelevator;

public class Application {

    public static void main(String[] args) {
        Cat oliver = new Cat();
        String oliversName = oliver.getName();


        Person walt = new Person("Walt", 50, oliver);
        walt.setName("Walt");

        Person bob = new Person("Bob", 20, oliver);
        bob.setName("Bob");



        String money = Utility.formatMoney(1.5);
    }

    private String getOne() {
        return "1";
    }
}
