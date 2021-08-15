package Brique_GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BoardFrame extends JFrame {
    JFrame board;
    ArrayList<PositionPanel> grid = new ArrayList<>();

    public BoardFrame()
    {
        this.board= new JFrame("Board");
        this.board.setSize(600,600);
        this.board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.board.setSize(new Dimension(720,720));
        this.board.setBackground(Color.BLACK);
        this. board.setLayout(new GridLayout(15,15,0,0));

        for (int r = 0; r<15; r++)
        {
            for (int c = 0; c<15; c++)
            {
                this.grid.add(new PositionPanel(r,c));
                this.board.add(this.grid.get(r*15+c));
            }
        }
        board.setVisible(true);
    }
}
