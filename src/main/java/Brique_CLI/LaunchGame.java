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
        System.out.println("Would you like to know the Game Rules (y/n)?");
        String a =  scanner.next();
        if (Display.IsInputYes(a)) Display.printRules(new Game(P1, P2));
        System.out.println("Would you like to change the settings (y/n)?");
        a = scanner.next();
        if (Display.IsInputYes(a)) Settings.changeSettings(P1, P2);
        game = new Game(P1, P2);
        while (game.getStatus() == Status.ON) {
            Display.printBoard(game.getBoard());
            Display.PlayerTurn(game.getActivePlayer());
            if (move_counter == 1)
            {
                System.out.println("Would you like to use Pie Rule? yes/no");
                String in = scanner.next();
                while (!in.equals("yes") && !in.equals("no")) {
                    System.out.println("Please enter yes or no : ");
                    in = scanner.next();
                }
                if (in.equals("yes"))
                {
                    Settings.applyPieRule(P1,P2);
                    game.getActivePlayer().setActive(false);
                    game.getOtherPlayer().setActive(true);
                    move_counter++;
                    continue;
                }

            }
            Move move = new Move(game.getBoard(), game.getActivePlayer(), game.getOtherPlayer());
            int y = Display.getInputChar();
            int x = Display.getInputInt();
            while (!move.makeMove(x, y)) {
                Display.InvalidInput();
                y = Display.getInputChar();
                x = Display.getInputInt();
            }
            move_counter++;
            if (move_counter > 28) {
                if (P1.checkPath()) game.setStatus(Status.P1_WINS);
                if (P2.checkPath()) game.setStatus(Status.P2_WINS);
                if (move_counter > 225) game.setStatus(Status.OVER);
            }
            Display.GameFinishMessage(game.getStatus());
        }
    }

}
