package Brique_GUI;
import Game.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class WelcomeFrame extends JFrame implements ActionListener {

    private JButton startGame = new JButton("Start Game");;
    private JButton changeSettings = new JButton("Change Settings");;
    private JLabel welcomeMessage = new JLabel("Welcome To Brique Game :) ");
    private JLabel defaultSettingsMessage = new JLabel("Default Settings : P1 (BLACK) vs P2 (WHITE)");
    private Player P1 = new Player("P1", Piece_Color.BLACK);
    private Player P2 = new Player("P2", Piece_Color.WHITE);
    private GUI_settings changeDialog = new GUI_settings(this,"Change Settings");

    public WelcomeFrame() throws IOException {

        setTitle("Brique");
        setResizable(false);
        setLayout(new BorderLayout());
        URL url = getClass().getResource("");
        System.out.println(url.toString());
        JLabel background = new JLabel(new ImageIcon(ImageIO.read(new File("bg.jpg"))));
        background.setLayout(new FlowLayout(FlowLayout.CENTER, 1,180));
        add(background,BorderLayout.CENTER);
        JPanel basePanel = new JPanel();
        basePanel.setOpaque(false);
        basePanel.setLayout(new GridLayout(5, 1, 5, 15));
        designButtonsAndLabels();
        basePanel.add(welcomeMessage);
        basePanel.add(defaultSettingsMessage);
        basePanel.add(changeSettings);
        basePanel.add(startGame);
        background.add(basePanel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void designButtonsAndLabels()
    {
        startGame.setFont(new Font("Arial", Font.PLAIN, 20));
        startGame.setForeground(Color.GREEN);
        startGame.setBorderPainted(false);
        startGame.setFocusPainted(false);
        startGame.setContentAreaFilled(false);
        changeSettings.setFont(new Font("Arial", Font.PLAIN, 20));
        changeSettings.setForeground(Color.CYAN);
        changeSettings.setBorderPainted(false);
        changeSettings.setFocusPainted(false);
        changeSettings.setContentAreaFilled(false);
        welcomeMessage.setFont(new Font("Serif", Font.ITALIC, 24));
        welcomeMessage.setForeground(Color.WHITE);
        defaultSettingsMessage.setFont(new Font("Serif", Font.ITALIC, 15));
        defaultSettingsMessage.setForeground(Color.lightGray);
        startGame.addActionListener(this);
        changeSettings.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == startGame)
        {
            this.setVisible(false);
            new BoardFrame(this,P1,P2);
        }
        if (e.getSource() == changeSettings)
        {
            if(!changeDialog.isVisible()) changeDialog.setVisible(true);
            changeDialog.addChangeListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    P1.setName(changeDialog.getP1Name());
                    P2.setName(changeDialog.getP2Name());
                    changeDialog.setVisible(false);
                }
            });
        }

    }

    public static void main (String args[])
    {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WelcomeFrame g = new WelcomeFrame();
                    g.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
