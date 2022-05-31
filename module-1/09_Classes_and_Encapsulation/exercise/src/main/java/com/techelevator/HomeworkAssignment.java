package com.techelevator;

public class HomeworkAssignment {

    /*
        Fields, Properties, Member Variables, Instance Variables
     */

    private int earnedMarks; //need getter and setter, The total number of correct marks submitter received on the assignment.
    private int possibleMarks; //need getter, The number of possible marks on the assignment.
    private String submitterName; // need getter, The submitter's name for the assignment.
    private String letterGrade; // DERIVED, need getter, The letter grade for the assignment.


    /*
        Constructors
     */

    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }



    /*
        Getters and Setters
     */

    public int getEarnedMarks() {
        return earnedMarks;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public String getLetterGrade() {  //DERIVED PROPERTY calculated using earnedMarks and possibleMarks
        if (((float)earnedMarks/possibleMarks) >= 0.9 ) {
            letterGrade = "A";
        } else if (((float)earnedMarks/possibleMarks) >= 0.8 ) {
            letterGrade = "B";
        } else if (((float)earnedMarks/possibleMarks) >= 0.7) {
            letterGrade =  "C";
        } else if (((float)earnedMarks/possibleMarks) >= 0.6) {
            letterGrade =  "D";
        } else {
            letterGrade = "F";
        }

        return letterGrade;
    }

    /*
        Methods
     */

}
