package com.techelevator;

import org.junit.*;

public class AnimalGroupNameTest {

    @Test
    public void gethHerd_returns_group_name_when_given_animal_name() {
        //Arrange
        AnimalGroupName testAnimalGroupName = new AnimalGroupName();

        //Act
        String getHerd = testAnimalGroupName.getHerd("CrOw");


        //Assert
        Assert.assertEquals("Murder", getHerd);

    }

    @Test
    public void gethHerd_returns_unknown_name_when_given_incorrect_input() {
        //Arrange
        AnimalGroupName testAnimalGroupName = new AnimalGroupName();

        //Act
        String getHerd = testAnimalGroupName.getHerd("1773");


        //Assert
        Assert.assertEquals("unknown", getHerd);

    }


}
