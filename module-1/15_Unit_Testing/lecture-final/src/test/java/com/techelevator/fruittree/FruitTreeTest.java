package com.techelevator.fruittree;

import org.junit.*;

public class FruitTreeTest {


    @Test
    public void constructor_initializes_pieces_of_fruit_and_type_of_fruit() {
        // Arrange
        String type = "Apple";
        int pieces = 10;

        // Act
        FruitTree actualFruitTree = new FruitTree(type, pieces);

        // Assert
        Assert.assertEquals(type, actualFruitTree.getTypeOfFruit());
        Assert.assertEquals(pieces, actualFruitTree.getPiecesOfFruitLeft());
    }

     /*
        input: negative number?  output: false, piecesOfFruitLeft should remain unchanged
        input: numberOfPiecesToRemove: 1, piecesOfFruitLeft: 2  output: true, piecesOfFruitLeft: 1
        input: numberOfPiecesToRemove: 3, piecesOfFruitLeft: 2  output: false, piecesOfFruitLeft: 2
     */

    @Test
    public void pickFruit_returns_false_given_negative_input() {
        // Arrange
        FruitTree fruitTree = new FruitTree("Apple", 10);
        int piecesOfFruitLeftBeforePicking = fruitTree.getPiecesOfFruitLeft();

        // Act
        boolean didPickFruit = fruitTree.pickFruit(-1);

        // Assert
        Assert.assertEquals(false, didPickFruit);
        Assert.assertEquals(piecesOfFruitLeftBeforePicking, fruitTree.getPiecesOfFruitLeft());
    }

    @Test
    public void pickFruit_returns_true_given_1_to_pick_and_2_to_start() {
        // Arrange
        int startingAmountOfFruit = 2;
        int fruitToPick = 1;
        FruitTree fruitTree = new FruitTree("Apple", startingAmountOfFruit);

        // Act
        boolean didPickFruit = fruitTree.pickFruit(fruitToPick);

        // Assert
        Assert.assertEquals(true, didPickFruit);
        Assert.assertEquals(startingAmountOfFruit - fruitToPick, fruitTree.getPiecesOfFruitLeft());
    }

}
