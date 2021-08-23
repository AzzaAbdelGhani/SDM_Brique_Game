package Brique_CLI;

import Game.*;

import java.io.IOException;
import java.util.Scanner;

public class LaunchGame {
    private static Game game;
    private static  Player P1, P2;
    private static int move_counter;
    private final static int first_move = 1;
    private final static int check_moves = 28;

    public static void Play() throws IOException {
        P1 = new Player("Player 1", Piece_Color.BLACK);
        P2 = new Player("Player 2", Piece_Color.WHITE);
        move_counter = 0;
        Display.gameWelcomeMessage(P1,P2);
        game = new Game(P1, P2);
        while (game.getStatus() == Status.ON) {
            Display.printBoard(game.getBoard());
            Display.PlayerTurn(game.getActivePlayer());
            Move move = new Move(game.getBoard(), game.getActivePlayer(), game.getOtherPlayer());
            if (move_counter == first_move && Display.isPieRuleApplied(move, P1, P2)) { move_counter++; continue; }
            while (!move.makeMove(Display.getUserInputCoordinates())) { Display.InvalidInput(); }
            move_counter++;
            if (move_counter > check_moves)  game.checkVictory();
        }
        Display.printBoard(game.getBoard());
        Display.GameFinishMessage(game.getStatus(), game.getOtherPlayer().getName());
    }

}
