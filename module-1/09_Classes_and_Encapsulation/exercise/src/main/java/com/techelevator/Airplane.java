package com.techelevator;

public class Airplane {


    /*
        Fields, Properties, Member Variables, Instance Variables
     */

    private String planeNumber; //need getter, The six-character plane number.
    private int totalFirstClassSeats; //need getter, The total number of first class seats.
    private int bookedFirstClassSeats; //need getter, The number of already booked first class seats.
    private int availableFirstClassSeats; //DERIVED, need getter, The number of available first class seats.
    private int totalCoachSeats; //need getter, The total number of coach seats.
    private int bookedCoachSeats; //need getter, The number of already booked coach seats.
    private int availableCoachSeats; //DERIVED, need getter, The number of available coach seats.

    //below I am attempting to derive the two derived fields early, so I can simply 'get' them later UPDATE- didn't work
/*    private int AvailableFirstClassSeats() {
        availableFirstClassSeats = totalFirstClassSeats - bookedFirstClassSeats;
        return availableFirstClassSeats;
    }
    private int AvailableCoachSeats() {
        availableCoachSeats = totalCoachSeats - bookedCoachSeats;
        return availableCoachSeats;
    }
*/


    /*
        Constructors
     */

    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }



    /*
        Getters and Setters
     */

    public String getPlaneNumber() {
        return planeNumber;
    }
    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }
    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public void getAvailableFirstClassSeats(int availableFirstClassSeats) { /////idk if I need this, since it's derived
        this.availableFirstClassSeats = availableFirstClassSeats;
    }

    public int getAvailableFirstClassSeats() {
        return availableFirstClassSeats;
    }
    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }
    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }

    public void getAvailableCoachSeats(int availableCoachSeats) { ////same not as above, do i need this??
        this.availableCoachSeats = availableCoachSeats;
    }

    public int getAvailableCoachSeats() {
        return availableCoachSeats;
    }




    /*
        Methods
     */
    //Create a method called reserveSeats that returns a boolean and accepts two parameters:
    // a boolean called forFirstClass and an int called totalNumberOfSeats.

    //If forFirstClass is true, add totalNumberOfSeats to the value for BookedFirstClassSeats.
    //If forFirstClass is false, add totalNumberOfSeats to the value for BookedCoachSeats.
    //It returns true if there were enough seats to make the reservation,
    // otherwise it returns false and the number of booked seats doesn't change.

    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
        //if forFirstClass is true, check if totalNumberOfSeats > availableFirstClassSeats
        //if that's true, BookedFirstClassSeats = BookedFirstClassSeats + availableFirstClassSeats. same for coach.
        if (forFirstClass) {
            if (totalNumberOfSeats > this.availableFirstClassSeats) {  //added this. to the availableFirstClassSeats
                this.bookedFirstClassSeats = this.bookedFirstClassSeats + totalNumberOfSeats;
                return true;
            }
        } else if (!forFirstClass){
            if (totalNumberOfSeats > this.availableCoachSeats) {
                this.bookedCoachSeats = this.bookedCoachSeats + totalNumberOfSeats;
                return true;
            }
        }
        return false;
    }


}
