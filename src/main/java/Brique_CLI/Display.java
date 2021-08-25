package Brique_CLI;

import Game.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Display {
    static Scanner sc = new Scanner(System.in);

    public static String displayAMsgAndGetUI(String disp) {
        System.out.println(disp);
        return sc.next();
    }

    public static Boolean IsInputYes(@NotNull String a) {
        if (a.equalsIgnoreCase("y")  || a.equalsIgnoreCase("yes")) return Boolean.TRUE;
        else if(a.equalsIgnoreCase("n")  || a.equalsIgnoreCase("no")) return Boolean.FALSE;
        else {
            System.out.println("Entered a different response than yes/no, response by default considered as no");
            return Boolean.FALSE;
        }
    }

    public static void printRules() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("BriqueRules.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static void gameWelcomeMessage(Player P1, Player P2) throws IOException {
        String a =  Display.displayAMsgAndGetUI("Welcome to Brique Game \n Would you like to know the Game Rules (y/n)?");
        if (Display.IsInputYes(a)) Display.printRules();
        a = Display.displayAMsgAndGetUI("Would you like to change the settings (y/n)?");
        if (Display.IsInputYes(a)) Settings.changeSettings(P1, P2);
    }

    public static Boolean isPieRuleApplied(Move move, Player P1, Player P2) {
        String a = Display.displayAMsgAndGetUI("Would you like to use Pie Rule? yes/no");
        if (Display.IsInputYes(a))
        {
            Settings.applyPieRule(P1,P2);
            move.changePlayerTurn();
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Contract(" -> new")
    public static @NotNull Coordinates getUserInputCoordinates(){
        System.out.print("Please enter the coordinates:\t");
        char a = sc.next().charAt(0);
        int y = (int) a - 97;
        int x = sc.nextInt() - 1;
        return new Coordinates(x,y);
    }

    public static void InvalidInput(){
        System.out.println("Invalid Coordinates Enter again");
    }

    public static void PlayerTurn(@NotNull Player player){
        System.out.println(player.getName() + "'s turn" );
    }

    public static void GameFinishMessage(Status status, String PlayerName)
    {
        if (status == Status.P1_WINS || status == Status.P2_WINS)
            System.out.println("Congratulations!!! "+ PlayerName + " WINS !!!");
        else
            System.out.println(status.getString());
    }

    public static void printBoard(@NotNull Board board){
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

}
