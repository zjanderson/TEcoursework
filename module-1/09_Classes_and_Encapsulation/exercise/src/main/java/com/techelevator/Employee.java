package com.techelevator;

public class Employee {


    /*
        Fields, Properties, Member Variables, Instance Variables
     */

    private int employeeId; // need getter, The employee ID.
    private String firstName; // need getter, The employee's first name.
    private String lastName; // need getter and setter, The employee's full name.
    private String fullName;  // DERIVED, fullName is a derived attribute that returns lastName, firstName
    private String department; // need getter and setter, The employee's department.
    private double annualSalary; //need getter, The employee's annual salary.


    /*
        Constructors
     */

    public Employee(int employeeId, String firstName, String lastName, double annualSalary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = annualSalary;
    }


    /*
        Getters and Setters
     */

    public int getEmployeeId() {
        return employeeId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        fullName = lastName + ", " + firstName;
       return fullName;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public double getAnnualSalary() {
        return annualSalary;
    }



    /*
        Methods
     */
    //Create a method called raiseSalary that accepts a double called percent and returns void.
    // The method increases the current annual salary by the percentage provided. For example, 5.5 represents 5.5%.

    public void raiseSalary(double percent) {
        annualSalary = annualSalary + (annualSalary * (percent/100));
    }


}
