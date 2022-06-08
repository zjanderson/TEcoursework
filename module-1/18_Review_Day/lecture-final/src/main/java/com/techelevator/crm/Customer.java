package com.techelevator.crm;

import com.techelevator.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Customer extends Person {
    private String phoneNumber;
    private List<Pet> pets = new ArrayList<>();

    public Customer(String firstName, String lastName, String phoneNumber) {
        super(firstName, lastName);
        this.phoneNumber = phoneNumber;
    }

    public Customer(String firstName, String lastName) {
        this(firstName, lastName, "");
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    /*
       { "Walking" -> $10.00, "Grooming" -> $15.50 }

       entrySet
       {
            key: "Walking", value: $10.00,
            key: "Grooming", value: $15.50
       }

       keySet
       {
          "Walking",
          "Grooming"
       }


     */

    @Override
    public double getBalanceDue(Map<String, Double> servicesRendered) {
        double total = 0;

        for (Map.Entry<String, Double> entry : servicesRendered.entrySet()) {
            double serviceCost = entry.getValue();

            total = total + serviceCost;
        }

        return total;
    }
}
