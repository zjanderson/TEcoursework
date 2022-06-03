package com.techelevator.fruittree;

import org.junit.*;

public class FruitTreeTest  {
    //design a test with a few edge cases and happy path options

    @Test
    public void fruitTree_constructor_initializes_pieces_of_fruit_and_type_of_fruit() {

        //Arrange
        String type = "Apple";
        int pieces = 10;

        //Act
        FruitTree actualFruitTree = new FruitTree(type, pieces);


        //Assert
        Assert.assertEquals(type, actualFruitTree.getTypeOfFruit());
        Assert.assertEquals(pieces, actualFruitTree.getPiecesOfFruitLeft());
    }

    @Test
    public void pickFruit_returns_false_given_negative_input() {
        //Arrange
        FruitTree testFruitTree = new FruitTree("Apple", 10); //let's make a new tree so we can test it

        //Act
        boolean didPickFruit = testFruitTree.pickFruit(-1);

        //Assert
        Assert.assertEquals(false, didPickFruit);
        Assert.assertEquals(10, testFruitTree.getPiecesOfFruitLeft());
    }

    @Test
    public void pickFruit_returns_true_given_one_to_pick_two_to_start() {
        //Arrange
        FruitTree testFruitTree = new FruitTree("Apple", 2); //let's make a new tree so we can test it

        //Act
        boolean didPickFruit = testFruitTree.pickFruit(1);

        //Assert
        Assert.assertEquals(true, didPickFruit);
        Assert.assertEquals(1, testFruitTree.getPiecesOfFruitLeft());
    }

    @Test
    public void pickFruit_returns_false_given_three_to_pick_two_to_start() {
        //Arrange
        FruitTree testFruitTree = new FruitTree("Apple", 2); //let's make a new tree so we can test it

        //Act
        boolean didPickFruit = testFruitTree.pickFruit(3);

        //Assert
        Assert.assertEquals(false, didPickFruit);
        Assert.assertEquals(2, testFruitTree.getPiecesOfFruitLeft());
    }


}
