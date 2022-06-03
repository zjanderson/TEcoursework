package com.techelevator.fruittree;

public class FruitTree {
    private final String typeOfFruit;
    private int piecesOfFruitLeft;

    public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {
        this.piecesOfFruitLeft = startingPiecesOfFruit;
        this.typeOfFruit = typeOfFruit;
    }

    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }


    /*
        input: negative number?  output: false, piecesOfFruitLeft should remain unchanged
        input: numberOfPiecesToRemove: 1, piecesOfFruitLeft: 2  output: true, piecesOfFruitLeft: 1
        input: numberOfPiecesToRemove: 3, piecesOfFruitLeft: 2  output: false, piecesOfFruitLeft: 2
     */
    public boolean pickFruit(int numberOfPiecesToRemove) {
        if (numberOfPiecesToRemove < 0) {
            return false;
        }

        if (piecesOfFruitLeft - numberOfPiecesToRemove >= 0) {
            piecesOfFruitLeft -= numberOfPiecesToRemove;
            return true;
        } else {
            return false;
        }
    }
}
