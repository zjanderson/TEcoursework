package com.techelevator;

public class Elevator {


    /*
        Fields, Properties, Member Variables, Instance Variables
     */

    private int currentFloor; //need getter, The current floor that the elevator is on.
    private int numberOfFloors; //need getter, The number of floors available to the elevator.
    private boolean doorOpen; //need getter, Whether the elevator door is open or not.



    /*
        Constructors
     */
    public Elevator(int numberOfLevels) {
        this.numberOfFloors = numberOfLevels;
        this.currentFloor = 1;
    }



    /*
        Getters and Setters
     */
    public int getCurrentFloor() {
        return currentFloor;
    }
    public int getNumberOfFloors() {
        return numberOfFloors;
    }
    public boolean getdoorOpen() {
        return doorOpen;
    }



    /*
        Methods
     */


}
