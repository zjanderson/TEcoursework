package connectfour;

public class Application {

    /*
        Nouns

        Game
         - play()
         - switchPlayer()
         - randomizeWhoGoesFirst()

            Player
                - Current Player
                - Piece
                  - Color
                  - Position
                - makeColumnChoice()
                - Wins Count
                - Losses Count
                - Draws Count

                Board
                 - Columns (Slots)
                  - Rows
                  - Collection of Pieces

                 - didWin()
                 - didTie()
                 - dropPiece()
                 - display()
                 - clear()

        Score Board
         - Wins
          - Time to win


        Verbs



        1) Game Play

        Prereqs: Players are chosen and Board is created

        a) Randomize who goes first

        b) in a loop, do the following
         -> current player makes their move

         -> if the move is invalid, let them know on the UI
         -> else drop the piece

         -> is the game over (win or tie)
         -> if yes, let them know
         -> if no, continue

       c) update the scoreboard
       d) ask them to play again or not


     */

}
