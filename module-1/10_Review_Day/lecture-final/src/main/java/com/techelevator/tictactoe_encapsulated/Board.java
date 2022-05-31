package com.techelevator.tictactoe_encapsulated;

public class Board {

    private final TicTacToeCharacter[] board = new TicTacToeCharacter[9];

    public Board() {
        for (int a = 0; a < 9; a++) {
            board[a] = TicTacToeCharacter.EMPTY;
        }
    }

    public TicTacToeCharacter get(int slotNumber) {
        return board[slotNumber - 1];
    }

    private void set(int slotNumber, TicTacToeCharacter character) {
        board[slotNumber - 1] = character;
    }

    public boolean makeMove(TicTacToeCharacter character, int slotNumber) {
        if(!TicTacToe.VALID_SLOTS.contains(slotNumber)) {
            return false;
        }

        if(get(slotNumber).equals(TicTacToeCharacter.EMPTY)) {
            set(slotNumber, character);
            return true;
        }

        return false;
    }

    public boolean isDraw() {
        for(int i = 1; i <= board.length; i++) {
            if (get(i).equals(TicTacToeCharacter.EMPTY)) {
                return false;
            }
        }

        return true;
    }

    public boolean isWin() {
        // Horizontal
        if(get(1) != TicTacToeCharacter.EMPTY && get(1) == get(2) && get(2) == get(3)) {
            return true;
        }

        if(get(4) != TicTacToeCharacter.EMPTY && get(4) == get(5) && get(5) == get(6)) {
            return true;
        }

        if(get(7) != TicTacToeCharacter.EMPTY  && get(7) == get(8) && get(8) == get(9)) {
            return true;
        }

        // Vertical
        if(get(1) != TicTacToeCharacter.EMPTY && get(1) == get(4) && get(4) == get(7)) {
            return true;
        }

        if(get(4) != TicTacToeCharacter.EMPTY && get(2) == get(5) && get(5) == get(8)) {
            return true;
        }

        if(get(7) != TicTacToeCharacter.EMPTY  && get(3) == get(6) && get(6) == get(9)) {
            return true;
        }


        // Diagonal
        if(get(1) != TicTacToeCharacter.EMPTY && get(1) == get(5) && get(5) == get(9)) {
            return true;
        }

        return get(7) != TicTacToeCharacter.EMPTY && get(7) == get(5) && get(5) == get(3);
    }


    public String toString() {
        return  "|---|---|---|\n" +
                "| " + stringAt(1)  + " | " + stringAt(2)  + " | " + stringAt(3)  + " |\n" +
                "| " + stringAt(4)  + " | " + stringAt(5)  + " | " + stringAt(6)  + " |\n" +
                "| " + stringAt(7)  + " | " + stringAt(8)  + " | " + stringAt(9)  + " |\n" +
                "|---|---|---|";
    }

    private String stringAt(int slotNumber) {
        TicTacToeCharacter character = get(slotNumber);

        return character.equals(TicTacToeCharacter.EMPTY) ? String.valueOf(slotNumber) : character.toString();
    }
}
