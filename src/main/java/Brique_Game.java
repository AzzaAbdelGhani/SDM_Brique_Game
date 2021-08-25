import Brique_CLI.LaunchGame;
import Brique_GUI.WelcomeFrame;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class Brique_Game {
    public static void main(String[] args) throws IOException {
        System.out.println("WELCOME TO BRIQUE GAME : ");
        System.out.println("Would you like to play in CLI or GUI ?");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        while (!input.equalsIgnoreCase("cli") && !input.equalsIgnoreCase("gui")) {
            System.out.println("Please enter cli or gui : ");
            input = scanner.next();
        }
        if (input.equalsIgnoreCase("cli")) { LaunchGame.Play(); }
        else
        {
            EventQueue.invokeLater(() -> {
                try {
                    WelcomeFrame g = new WelcomeFrame();
                    g.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
        }
    }
}

