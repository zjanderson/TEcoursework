package com.techelevator.tictactoe_encapsulated;

import java.util.Set;

public class TicTacToe {
    private final Board board;
    private final UserInterface userInterface;
    private TicTacToeCharacter currentCharacter;
    public static final Set<Integer> VALID_SLOTS = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

    public TicTacToe(Board board, UserInterface userInterface) {
        this.board = board;
        this.userInterface = userInterface;
        this.currentCharacter = TicTacToeCharacter.X;
    }

    public void play() {
        do {
            userInterface.displayBoard(board);
            switchCurrentCharacter();

            int slotNumber;
            do {
                slotNumber = userInterface.getSlotNumber(currentCharacter);

                if(!VALID_SLOTS.contains(slotNumber)) {
                    userInterface.displayInvalidSlot();
                }

            } while(!board.makeMove(currentCharacter, slotNumber));


        } while(!isGameOver());


        userInterface.displayBoard(board);

        if(board.isDraw()) {
            userInterface.displayDraw();
        } else {
            userInterface.displayWin(currentCharacter);
        }

    }

    private void switchCurrentCharacter() {
        if(currentCharacter.equals(TicTacToeCharacter.X)) {
            currentCharacter = TicTacToeCharacter.O;
        } else {
            currentCharacter = TicTacToeCharacter.X;
        }
    }

    private boolean isGameOver() {
        return board.isWin() || board.isDraw();
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(new Board(), new UserInterface());
        ticTacToe.play();
    }
}
