package com.techelevator.crm;

import org.junit.*;

import java.util.Map;

public class CustomerTests {

    @Test
    public void getBalanceDue_returns_25_given_walking_10_and_grooming_15() {
        // Arrange
        Customer myCustomer = new Customer("", "");
        Map<String, Double> services = Map.of("Walking", 10.0, "Grooming", 15.0);

        // Act
        double total = myCustomer.getBalanceDue(services);

        // Assert
        Assert.assertEquals(25.0, total, 0.0);
    }
}
