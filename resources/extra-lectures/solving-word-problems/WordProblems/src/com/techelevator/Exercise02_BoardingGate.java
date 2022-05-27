package com.techelevator;

public class Exercise02_BoardingGate {
    /*
    Local Jetways is a regional airline operating at local airports.
    They use a basic passenger manifest to represent seat occupancy on their plane.
        Each passenger seat is represented as an element in a boolean array.
        A value of TRUE indicates that seat is currently available.
        A value of FALSE indicates the seat is not available.
     */

    /*
    A nearby airport has an incoming flight from Local Jetways. As the passengers disembark, the gate
    attendant's first responsibility is to generate a new seating chart with each seat initially available.

    Implement the logic to generate a seating chart using the required number of seats. Make sure to indicate
    that each seat is initially available (TRUE).

    Note: The number of seats is guaranteed not to be negative.

    Examples:
    generateSeatingChart(7) → [true, true, true, true, true, true, true]
    generateSeatingChart(5) → [true, true, true, true, true]
    generateSeatingChart(2) → [true, true]
     */

    public static void main(String[] args) {
        boolean[] S1 = generateSeatingChart(7);
        boolean[] S2 = generateSeatingChart(5);
        boolean[] S3 = generateSeatingChart(2);

        int count1 = getAvailableSeatCount(new boolean[]{true, false, false, false});
        int count2 = getAvailableSeatCount(new boolean[]{false, false, false, false, false, false});
        int count3 = getAvailableSeatCount(new boolean[]{true, true, true, false});
        int count4 = getAvailableSeatCount(new boolean[]{});

        int row1 = getNumberOfFullRows(new boolean[]{false, false, false, true, true, true});
        int row2 = getNumberOfFullRows(new boolean[]{true, true, true, true, true, true});
        int row3 = getNumberOfFullRows(new boolean[]{false, true, false, false, true, true});

        System.out.println("");
    }

    public static boolean[] generateSeatingChart(int numberOfSeats) {
        boolean[] seatingChart = new boolean[numberOfSeats];

        for (int i = 0; i < seatingChart.length; i++) {
            seatingChart[i] = true;
        }

        return seatingChart;
    }

    /*
    Once passengers begin boarding the plane, gate attendants need a way to determine how many available
    seats there are on the plane.

    Using the array provided, implement the logic to count the number of available seats in the seating chart.
    A seat is available if the value is TRUE.

    Examples:
    getAvailableSeatCount([true, false, false, false]) → 1
    getAvailableSeatCount([false, false, false, false, false, false]) → 0
    getAvailableSeatCount([true, true, true, false]) → 3
    getAvailableSeatCount([]) → 0
     */
    public static int getAvailableSeatCount(boolean[] seatingChart) {
        int availableSeatCount = 0;

        for (int i = 0; i < seatingChart.length; i++) {
            if (seatingChart[i]) {
                availableSeatCount++;
            }
        }
        return availableSeatCount;
    }

    /*
    The crew determined that it would be nice to know how many rows on the plane are at full occupancy.
    Each row has three seats and a row is at full occupancy if all three seats have someone sitting in them.

    Using the boolean array, implement the logic to count the number of full rows on the plane.
    Note: A new row starts at every third element. For example, row one begins with index 0, row two begins with index 3, and so on.

    Examples:
    getNumberOfFullRows([false, false, false, true, true, true]) → 1
    getNumberOfFullRows([true, true, true, true, true, true]) → 2
    getNumberOfFullRows([false, true, true, false, true, true]) → 0
     */
    public static int getNumberOfFullRows(boolean[] seatingChart) {
        int numberOfFullRows = 0;
        int seatCount = 0;
        //break down the seatingChart into groups of 3
        //check each element if the value == false
        //row is full if all values in the row are false

        for (int i = 0; i < seatingChart.length; i++ ) {
            if (i % 3 == 0) {
                seatCount = 0;
            }

            if (seatingChart[i] == false) {
                seatCount++;
            }

            if (seatCount == 3) {
                numberOfFullRows++;
            }

        }


        return numberOfFullRows;
    }

}
