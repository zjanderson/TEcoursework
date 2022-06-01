package com.techelevator.person;

public class Application {
    public static void main(String[] args) {

        Person bobTheBuilder = new Person("Bob", "Builder", 35);

        System.out.println(bobTheBuilder.printResume());

        Chef chefBoyardee = new Chef("Chef", "Boyardee", 10000, "Ravioli");

        System.out.println(chefBoyardee.printResume());

    }
}
