package Brique_CLI;

import Game.Board;
import Game.Piece_Color;
import Game.Player;
import Game.Status;

import java.util.Scanner;

public class Display {
    private static Scanner sc = new Scanner(System.in);

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
                if (board.getPos(i,j).getPieceColor() == Piece_Color.BLACK) {
                    System.out.print("|" + "B");
                } else if (board.getPos(i,j).getPieceColor() == Piece_Color.WHITE) {
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
    public static int getInputChar(){
        System.out.print("Enter the coordinates:");
        char a = sc.next().charAt(0);
        return (int) a - 97;
    }
    public static int getInputInt(){
        int x = sc.nextInt();
        return x-1;
    }
    public static void InvalidInput(){
        System.out.println("Invalid Coordinates Enter again");
    }
    public static void PlayerTurn(Player player){
        System.out.println(player.getName() + "'s turn" );
    }

    public static void GameFinishMessage(Status status){
        System.out.println(status.getString());
    }

}
