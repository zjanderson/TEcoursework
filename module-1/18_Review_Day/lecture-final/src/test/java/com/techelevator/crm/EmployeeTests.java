package com.techelevator.crm;

import com.techelevator.hr.Employee;
import org.junit.*;

import java.util.Map;

public class EmployeeTests {

    @Test
    public void getBalanceDue_returns_20_given_walking_10_and_grooming_15() {
        // Arrange
        Employee myCustomer = new Employee("", "");
        Map<String, Double> services = Map.of("Walking", 10.0, "Grooming", 15.0);

        // Act
        double total = myCustomer.getBalanceDue(services);

        // Assert
        Assert.assertEquals(20.0, total, 0.0);
    }
}
