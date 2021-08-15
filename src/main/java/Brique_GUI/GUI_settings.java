package Brique_GUI;
import Game.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_settings extends JDialog{

    private JTextField P1Name = new JTextField(15);
    private JTextField P2Name = new JTextField(15);
    private JButton changeButton = new JButton("Change");

    public GUI_settings (JFrame frame, String title)
    {
        super(frame, title, false);
        JPanel panel = new JPanel(new GridLayout(3,2,5,5));
        panel.add(new JLabel("Player1 Name: "));
        panel.add(P1Name);
        panel.add(new JLabel("Player2 Name: "));
        panel.add(P2Name);
        panel.add(changeButton);

        add(panel);
        pack();
        setLocationRelativeTo(frame);
    }
    public String getP1Name()
    {
        return P1Name.getText();
    }
    public String getP2Name()
    {
        return P2Name.getText();
    }

    public void addChangeListener(ActionListener listener)
    {
        changeButton.addActionListener(listener);
    }
    public static Boolean applyPieRule(Player p1, Player p2)
    {
        int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to apply Pie Rule ?", "choose", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            Piece_Color c = p1.getColor();
            p1.setPieceColor(p2.getColor());
            p2.setPieceColor(c);

            Graph g = p1.getGraph();
            p1.setGraph(p2.getGraph());
            p2.setGraph(g);
            return true;
        }
        return false;
    }

    public static void changeSettings(Player p1, Player p2)
    {
        JFrame changeSettingsFrame = new JFrame("Change Settings");
        JTextField p1Name;
        JTextField p2Name;

        JPanel newSettings = new JPanel(new GridLayout(2,2,10,2));
        newSettings.setBorder(BorderFactory.createTitledBorder("New Settings: "));

        newSettings.add(new JLabel("Player1 Name: "));
        p1Name = new JTextField(10);
        newSettings.add(p1Name);
        p1Name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p1NewName = p1Name.getText();
                p1.setName(p1NewName);
            }
        });
        newSettings.add(new JLabel("Player2 Name: "));
        p2Name = new JTextField(10);
        newSettings.add(p2Name);
        p2Name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p2NewName = p2Name.getText();
                p2.setName(p2NewName);
            }
        });

        changeSettingsFrame.add(newSettings);
        changeSettingsFrame.setSize(300,300);
        changeSettingsFrame.setVisible(true);
    }
}
