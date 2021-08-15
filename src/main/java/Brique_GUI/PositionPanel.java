package Brique_GUI;

import Game.*;
import javax.swing.*;
import java.awt.*;

public class PositionPanel extends JPanel {
    private JPanel pos;
    private int row;
    private int col;
    private Piece_Color pColor = Piece_Color.BLANK;

    public PositionPanel(int row, int col)
    {
        this.row = row;
        this.col = col;
        pos = new JPanel();
        pos.setSize(new Dimension(48,48));
        pos.setVisible(true);
    }

    public void drawPiece(int i, int j, Graphics g, Color pieceColor)
    {
        g.setColor(pieceColor);
        g.fillOval(i,j,32,32);
        g.setColor(Color.BLACK);
        g.drawOval(i,j,32,32);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor((row + col) % 2 == 0 ? new Color(204,204,204) : new Color(153,153,153));
        g.fillRect(0,0,48,48);
        g.drawRect(0,0,48,48);
        if (pColor == Piece_Color.BLACK)
        {
            drawPiece(32,32,g,Color.BLACK);
        }
        else if (pColor == Piece_Color.WHITE)
        {
            drawPiece(32,32,g,Color.WHITE);
        }
    }

    public void setPiece(Piece_Color pColor) { this.pColor = pColor; }
}
