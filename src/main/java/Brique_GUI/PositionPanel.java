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
    
}
