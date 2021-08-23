package Brique_CLI;

import Game.*;

import java.util.Scanner;

public class Display {
    private static Scanner sc = new Scanner(System.in);
    public Display() {}
    public static void printRules(Game game){
        System.out.println("The Brique Game consists of two players: Player 1, Player 2 with two Pieces - Black and White" );
        System.out.println("By default Player 1 has the Black Piece  and Player 2 has White Piece");
        System.out.println("The player names and colors can be changed in the settings");
        System.out.println("Player with black begins first");
        System.out.println("The board is given as follows with light and dark positions");
        printBoard(game.getBoard());
        System.out.println("The goal is to connect the two borders through an orthogonal path:" );
        System.out.println( " Top & Bottom borders for Black (borders with alphabets), " +
                "Right & Left borders for White (borders with numbers)");
        System.out.println("Each position is identified using two co-ordinates: first is an alphabet ranging" +
                "from a - o and the second is a number from 1-15");
        System.out.println("The game is played as follows");
        System.out.println("Player 1 fills the 'a 1' position by entering the coordinates as follows");
        PlayerTurn(game.getActivePlayer());
        System.out.println("Enter the coordinates: a 1");
        System.out.println("The position 'a 1' is filled as follows");
        Move move = new Move(game.getBoard(), game.getActivePlayer(), game.getOtherPlayer());
        move.makeMove(new Coordinates(0,0));
        printBoard(game.getBoard());
        System.out.println("Only empty positions can be filled; except any filled position can be refilled through escort rules");
        System.out.println("ESCORT RULES: The light and dark position colors have escort rules");
        System.out.println("The escorts of dark position e.g. 'a 2' are 'a 1' and 'b 2': " +
                " the positions immediately in front of it and to the left of it");
        System.out.println("Similarly the escorts of a light position e.g. 'd 4' are 'c 4' and 'd 5': " +
                "i.e the positions immediately behind it and to the right of it");
        System.out.println("If the escorts are filled with the same color," +
                " the position also gets filled by the same color even if it is already filled by other player");
        System.out.println("It is shown as follows:");
        PlayerTurn(game.getActivePlayer());
        move = new Move(game.getBoard(), game.getActivePlayer(), game.getOtherPlayer());
        move.makeMove(new Coordinates(1,1));
        printBoard(game.getBoard());
        PlayerTurn(game.getActivePlayer());
        move = new Move(game.getBoard(), game.getActivePlayer(), game.getOtherPlayer());
        move.makeMove(new Coordinates(2,2));
        printBoard(game.getBoard());
        System.out.println("The white in position 'a 2' got replaced by black due to escort rules");
        System.out.println("And the game continues until an orthogonal path connecting the borders are achieved by one player");
        //Should we put this?? We have to play the game to show it!!
        // System.out.println("A possible configuration of connecting the borders can be given as ");
        System.out.println("We hope you will enjoy playing the game!");
    }
    public static void printBoard(Board board){
        int size = board.getSize();
        System.out.print("   ");
        for (int i = size-1 ; i >= 0; i--) {
            System.out.print(" " + (char) ('o' - i));
        }
        System.out.println(" ");
        for (int i = size-1; i >= 0; i--) {
            if (i < 9) System.out.print(" ");
            System.out.print(i + 1 + " ");
            for (int j = 0; j < size; j = j + 1) {
                Coordinates coordinates = new Coordinates(i,j);
                if (board.getPos(coordinates).getPieceColor() == Piece_Color.BLACK) {
                    System.out.print("|" + "B");
                } else if (board.getPos(coordinates).getPieceColor() == Piece_Color.WHITE) {
                    System.out.print("|" + "W");
                } else if ((i + j) % 2 == 0) {
                    System.out.print("| ");
                } else {
                    System.out.print("|#");
                }
            }
            System.out.print("| ");
            System.out.println(i+1);
        }
        System.out.print("   ");
        for (int i = size-1; i >= 0; i--) {
            System.out.print(" " + (char) ('o' - i ));
        }
        System.out.println();
        System.out.println("-------------------------------------------------------------");

    }

    public static Coordinates getUserInputCoordinates(){
        System.out.print("Please enter the coordinates:\t");
        Scanner scanner = new Scanner(System.in);
        char a = scanner.next().charAt(0);
        int y = (int) a - 97;
        int x = scanner.nextInt() - 1;
        return new Coordinates(x,y);
    }

    public static void InvalidInput(){
        System.out.println("Invalid Coordinates Enter again");
    }

    public static void PlayerTurn(Player player){
        System.out.println(player.getName() + "'s turn" );
    }

    public static void GameFinishMessage(Status status, String PlayerName)
    {
        if (status == Status.P1_WINS || status == Status.P2_WINS)
            System.out.println("Congratulations!!! "+ PlayerName + " WINS !!!");
        else
            System.out.println(status.getString());
    }

    public static String displayAMsgAndGetUI(String disp) {
        System.out.println(disp);
        return sc.next();
    }

    public static Boolean IsInputYes(String a) {
        if (a.equals("y") || a.equals("Y") || a.equalsIgnoreCase("yes")) return Boolean.TRUE;
        else if(a.equals("n") || a.equals("N") || a.equalsIgnoreCase("no")) return Boolean.FALSE;
        else {
            System.out.println("Entered a different response than yes/no, response by default considered as no");
            return Boolean.FALSE;
        }
    }

}
