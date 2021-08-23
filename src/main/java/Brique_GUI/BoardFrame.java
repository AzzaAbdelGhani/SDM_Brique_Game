package Brique_GUI;

import Game.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class BoardFrame extends JFrame implements MouseListener {
    private JPanel board;
    private Player P1, P2;
    private int move_counter = 0;
    private Game game;
    private JLabel msg;
    private static int boardResolution = 720;
    private static final int boardSize = 15;
    private PositionPanel[][] grid = new PositionPanel[boardSize][boardSize];

    public BoardFrame(JFrame frame, Player P1, Player P2)
    {
        super("Brique Game");
        this.P1 = P1;
        this.P2 = P2;
        this.game = new Game(P1,P2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(730,740);
        msg = new JLabel(P1.getName() + "'s turn");
        this.add(msg, BorderLayout.NORTH);
        board = new JPanel(new GridLayout(boardSize, boardSize, 0, 0));
        board.setBorder(BorderFactory.createMatteBorder(5,0,5,0,Color.BLACK));
        board.setBackground(Color.WHITE);
        board.setSize(new Dimension(boardResolution, boardResolution));
        this.setResizable(false);
        this.setLocationRelativeTo(frame);

        for (int r = 0; r < boardSize ; r++)
        {
            for (int c = 0; c < boardSize; c++)
            {
                this.grid[r][c] = new PositionPanel(r, c);
                this.grid[r][c].addMouseListener(this);
            }
        }

        for (int r = boardSize-1; r >= 0; r--) { for(int c = 0; c < boardSize; c++){ board.add(this.grid[r][c]); } }

        this.add(board, BorderLayout.CENTER);
        this.setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        PositionPanel temp = (PositionPanel) source;
        int x = temp.getRow();
        int y = temp.getCol();
        Coordinates coordinates = new Coordinates(x,y);
        Move move = new Move(game.getBoard(), game.getActivePlayer(), game.getOtherPlayer());
        if(move.makeMove(coordinates)) {
            move_counter++;
            temp.setPieceColor(game.getOtherPlayer().getColor());
            GUI_escorts(x,y);
            msg.setText(game.getActivePlayer().getName() + "'s turn");
        }
        if(move_counter == 1) {
            if (GUI_settings.applyPieRule(P1,P2))
            {
                game.getActivePlayer().setActive(false);
                game.getOtherPlayer().setActive(true);
                msg.setText("Pie Rule Applied");
                msg.setText(game.getActivePlayer().getName() + "'s turn");
            }
        }
        if(move_counter > 28){
            if(P1.checkPath())
            {
                JOptionPane.showMessageDialog(this,
                        "Congrats "+P1.getName()+" WINS !");
                game.setStatus(Status.P1_WINS);
            }
            if(P2.checkPath())
            {
                JOptionPane.showMessageDialog(this,
                        "Congrats "+P2.getName()+" WINS !");
                game.setStatus(Status.P2_WINS);
            }
        }
        if(game.getStatus() != Status.ON) {
            System.out.println(game.getStatus().getString());
            setVisible(false);
            EventQueue.invokeLater(() -> {
                try {
                    WelcomeFrame g = new WelcomeFrame();
                    g.setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            });
        }

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

    public void GUI_escorts(int i, int j){
        Piece_Color current = this.grid[i][j].getPieceColor();
        Pos_Color color = this.grid[i][j].getPositionColor();
        if ( i != boardSize-1 && j != boardSize-1 ) {
            if (current == this.grid[i+1][j+1].getPieceColor() && color == Pos_Color.LIGHT) { this.grid[i][j+1].setPieceColor(current); }
            if (current == this.grid[i+1][j+1].getPieceColor() && color == Pos_Color.DARK) { this.grid[i+1][j].setPieceColor(current); }
        }
        if ( i != 0 && j != 0 ){
            if (current == this.grid[i-1][j-1].getPieceColor() && color == Pos_Color.LIGHT) { this.grid[i-1][j].setPieceColor(current); }
            if (current == this.grid[i-1][j-1].getPieceColor() && color == Pos_Color.DARK){ this.grid[i][j-1].setPieceColor(current); }
        }
    }
}
