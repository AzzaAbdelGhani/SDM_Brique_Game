package Brique_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeFrame extends JFrame implements ActionListener {

    private  JButton startGame;
    private JFrame main = new JFrame("Brique Game");

    public WelcomeFrame()
    {
        this.main.setSize(600,600);
        this.main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.startGame = new JButton("Start Game");
        this.main.add(this.startGame, BorderLayout.CENTER);
        this.main.setVisible(true);

    }

    public void actionPerformed(ActionEvent e)
    {

    }

    public static void main (String args[])
    {
        WelcomeFrame w = new WelcomeFrame();
    }
}
