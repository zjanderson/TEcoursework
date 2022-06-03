package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private int capacity;
    private List<Person> passengers = new ArrayList<>();

    public Vehicle(int capacity) {
        this.capacity = capacity;
    }

    public boolean addPassenger(Person person) {
        boolean didAddPassenger = false;

        if(capacity > 0) {
            passengers.add(person);
            capacity--;
            didAddPassenger = true;
        }

        return didAddPassenger;
    }

    public Person[] getPassengers() {
        // 1. create the destination collection (size it appropriately, if needed)
        Person[] passengersArray = new Person[passengers.size()];

        // 2. iterate through source collection
        for (int i = 0; i < passengers.size(); i++) {
            // 2a. for each item in the source collection, copy it into the destination collection
            passengersArray[i] = passengers.get(i);
        }

        // 3. return the destination collection
        return passengersArray;
    }

}
