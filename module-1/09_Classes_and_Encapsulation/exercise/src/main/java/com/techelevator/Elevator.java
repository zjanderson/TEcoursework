package com.techelevator;

public class Elevator {


    /*
        Fields, Properties, Member Variables, Instance Variables
     */

    private int currentFloor = 1; //need getter, The current floor that the elevator is on. Always starts at 1.
    private int numberOfFloors; //need getter, The number of floors available to the elevator. coule make it FINAL
    private boolean doorOpen; //need getter, Whether the elevator door is open or not.



    /*
        Constructors
     */
    public Elevator(int numberOfLevels) {
        this.numberOfFloors = numberOfLevels;
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
    public boolean isdoorOpen() {
        return doorOpen;
    }



    /*
        Methods
     */

    public void openDoor() {
        this.doorOpen = true;
    }

    public void closeDoor() {
        this.doorOpen = false;
    }

    public void goUp(int desiredFloor) {
        //sends the elevator upward to the desired floor as long 1- as the door isn't open.
        // 2- The elevator can't go past the last floor.
        //3- i am below desired floor

        if (!doorOpen && currentFloor < desiredFloor && desiredFloor <= numberOfFloors ) {
            currentFloor = desiredFloor;
        }

    }

    public void goDown(int desiredFloor) {

        if (!doorOpen && currentFloor > desiredFloor && desiredFloor >= 1 ) {
            currentFloor = desiredFloor;
        }

    }

}
