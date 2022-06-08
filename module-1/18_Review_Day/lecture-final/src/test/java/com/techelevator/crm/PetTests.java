package com.techelevator.crm;

import org.junit.*;

import java.util.List;

public class PetTests {

    @Test
    public void listVaccinations_returns_nothing_when_none_were_added() {
        // Arrange
        Pet myPet = new Pet("", "");

        // Act
        String formattedVaccinations = myPet.listVaccinations();

        // Assert
        Assert.assertEquals("", formattedVaccinations);
    }

    @Test
    public void listVaccinations_returns_Rabies_Distemper_Parvo() {
        // Arrange
        Pet myPet = new Pet("", "");
        List<String> vaccinations = List.of("Rabies", "Distemper", "Parvo");
        myPet.setVaccinations(vaccinations);

        // Act
        String formattedVaccinations = myPet.listVaccinations();

        // Assert
        Assert.assertEquals("Rabies, Distemper, Parvo", formattedVaccinations);
    }

}
