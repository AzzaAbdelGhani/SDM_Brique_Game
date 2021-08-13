package Brique_CLI;

import Game.*;

import java.util.Scanner;

public class LaunchGame {
    private static Game game;
    private static  Player P1, P2;
    private static int move_counter;

    public static void Play()
    {
        P1 = new Player("Player 1", Piece_Color.BLACK);
        P2 = new Player("Player 2", Piece_Color.WHITE);
        Scanner scanner = new Scanner(System.in);
        move_counter = 0;
        System.out.println("Welcome to Brique Game");
        String a =  Display.displayAMsgAndGetUI("Would you like to know the Game Rules (y/n)?");
        if (Display.IsInputYes(a)) Display.printRules(new Game(P1, P2));
        a = Display.displayAMsgAndGetUI("Would you like to change the settings (y/n)?");
        if (Display.IsInputYes(a)) Settings.changeSettings(P1, P2);
        game = new Game(P1, P2);
        while (game.getStatus() == Status.ON) {
            Display.printBoard(game.getBoard());
            Display.PlayerTurn(game.getActivePlayer());
            Move move = new Move(game.getBoard(), game.getActivePlayer(), game.getOtherPlayer());
            if (move_counter == 1)
            {
                a = Display.displayAMsgAndGetUI("Would you like to use Pie Rule? yes/no");
                if (Display.IsInputYes(a))
                {
                    Settings.applyPieRule(P1,P2);
                    move.changePlayerTurn();
                    move_counter++;
                    continue;
                }

            }
            while (!move.makeMove(Display.getUserInputCoordinates())) { Display.InvalidInput(); }
            move_counter++;
            if (move_counter > 28)  game.checkVictory();
        }
        Display.printBoard(game.getBoard());
        Display.GameFinishMessage(game.getStatus(), game.getOtherPlayer().getName());
    }

}
