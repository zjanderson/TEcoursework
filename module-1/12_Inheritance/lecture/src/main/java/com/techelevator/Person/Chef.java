package com.techelevator.Person;

public class Chef extends Person {  //this line means Chef has everything Person has
    //you have to call the parent class constructor immediately, or it will use the default if avail
    private String cuisine; //this is a field of Chef


    public Chef(String firstNAme, String lastName, int age, String cuisine) {
        super(firstNAme, lastName, age);
        this.cuisine = cuisine;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

  /*  public String printResume() {  //this OVERRIDES the prentResume method in the Person class, they have the same name
        //print name age cuisine
        return getfullName() + ", " + getAge() + ", " + cuisine;
    }
*/
    //can just call parent printResume, and concatenate to not duplicate
    public String printResume() {  //this OVERRIDES the printResume method in the Person class, they have the same name
        //this version calls the parent printResume
        return super.printResume() + ", " + cuisine;
    }


}
