package Brique_GUI;

import Game.*;
import javax.swing.*;
import java.awt.*;

public class PositionPanel extends JPanel {
    private JPanel pos;
    private int row;
    private int col;
    private Piece_Color pColor = Piece_Color.BLANK;
    private Pos_Color posColor;

    public PositionPanel(int row, int col)
    {
        this.row = row;
        this.col = col;
        pos = new JPanel();
        pos.setSize(new Dimension(48,48));
        pos.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor((row + col) % 2 == 0 ? new Color(204,204,204) : new Color(153,153,153));
        g.fillRect(0,0,48,48);
        g.setColor(Color.BLACK);
        g.drawRect(0,0,48,48);
    }
}
