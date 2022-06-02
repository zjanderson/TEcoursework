package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {

    private String name; //getter and setter, The account holder name that the account belongs to.

    private String address; //getter and setter, The address of the customer.

    private String phoneNumber; //getter and setter, The phone number of the customer.

    private List<Accountable> accounts; // getter - The getAccounts() method returns an array,
                               // but since you need to add accounts whenever the addAccount() method is called,
                               // you'll use a List to store the accounts.
                               // The customer's list of Accountables.


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


 //   public ArrayList getAccounts() {
 //       return Accountable[accounts];
 //   }
}
