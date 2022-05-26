package com.techelevator;

public class FruitTree {
    private String typeOfFruit;  //field
    private int piecesOfFruitLeft;  //field

    public String getTypeOfFruit() { //getter
        return typeOfFruit;
    }
    public int getPiecesOfFruitLeft() { //getter
        return piecesOfFruitLeft;
    }

    public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {  //constructors
        this.typeOfFruit = typeOfFruit;
        piecesOfFruitLeft = startingPiecesOfFruit;
    }

    public boolean pickFruit(int numberOfPiecesToRemove) {  //method
        if (piecesOfFruitLeft < numberOfPiecesToRemove) {
            return false;
        }

        piecesOfFruitLeft = piecesOfFruitLeft - numberOfPiecesToRemove;
        return true;
    }

}
