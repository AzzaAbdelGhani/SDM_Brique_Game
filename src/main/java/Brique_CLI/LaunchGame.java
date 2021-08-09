package Brique_CLI;

import Game.*;

public class LaunchGame {
    private static Game game;
    private static  Player P1, P2;
    private static int move_counter;

    public static void Play()
    {
        P1 = new Player("Player 1", Piece_Color.BLACK);
        P2 = new Player("Player 2", Piece_Color.WHITE);
        game = new Game(P1, P2);
        move_counter = 0;
        while (game.getStatus() == Status.ON) {
            Display.printBoard(game.getBoard());
            Display.PlayerTurn(game.getActivePlayer());
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
