package Brique_GUI;

import Game.Piece_Color;
import Game.Player;
import Game.Game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class BoardFrame extends JFrame implements MouseListener {
    private JFrame board;
    private ArrayList<PositionPanel> grid = new ArrayList<>();
    private Player P1, P2;

    public BoardFrame(JFrame frame, Player P1, Player P2)
    {
        this.P1 = P1;
        this.P2 = P2;
        Game game = new Game(this.P1,this.P2);
        this.board= new JFrame("Board");
        this.board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.board.setBackground(Color.BLACK);
        this. board.setLayout(new GridLayout(15,15,0,0));
        this.board.setSize(new Dimension(720,720));
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
    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        PositionPanel temp = (PositionPanel) source;
        temp.setPiece(Piece_Color.BLACK);
        temp.repaint();

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
