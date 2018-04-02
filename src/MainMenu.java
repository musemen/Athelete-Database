import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu {

    JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainMenu window = new MainMenu();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public MainMenu() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 639, 401);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 623, 362);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblWelcomeToClipboard = new JLabel("Welcome to Clipboard App");
        lblWelcomeToClipboard.setFont(new Font("Serif", Font.BOLD, 17));
        lblWelcomeToClipboard.setBounds(186, 26, 258, 35);
        panel.add(lblWelcomeToClipboard);

        JButton btnAddTimes = new JButton("Add Times");
        btnAddTimes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SelectDate().frame.setVisible(true);
                frame.setVisible(false);
            }
        });
        btnAddTimes.setFont(new Font("Serif", Font.ITALIC, 13));
        btnAddTimes.setForeground(Color.blue);
        btnAddTimes.setBackground(Color.DARK_GRAY);
        btnAddTimes.setBounds(242, 89, 129, 23);
        panel.add(btnAddTimes);

        JLabel label = new JLabel("");
        label.setBounds(242, 145, 46, 14);
        panel.add(label);

        JLabel lblCheckTimeFor = new JLabel("Check Time For Each Athelete");
        lblCheckTimeFor.setFont(new Font("Serif", Font.BOLD, 17));
        lblCheckTimeFor.setBounds(170, 145, 270, 35);
        panel.add(lblCheckTimeFor);

        JButton btnVarsityW = new JButton("Varsity Women");
        btnVarsityW.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new Women().frame.setVisible(true);
                frame.setVisible(false);
            }
        });
        btnVarsityW.setForeground(new Color(255, 255, 255));
        btnVarsityW.setFont(new Font("Serif", Font.ITALIC, 13));
        btnVarsityW.setForeground(Color.blue);
        btnVarsityW.setBackground(Color.DARK_GRAY);
        btnVarsityW.setBounds(116, 191, 129, 23);
        panel.add(btnVarsityW);

        JButton btnVarsityM = new JButton("Varsity Men");
        btnVarsityM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MenAthelete().frame.setVisible(true);
                frame.setVisible(false);
            }
        });
        btnVarsityM.setForeground(new Color(255, 255, 255));
        btnVarsityM.setFont(new Font("Serif", Font.ITALIC, 13));
        btnVarsityM.setForeground(Color.blue);
        btnVarsityM.setBackground(Color.DARK_GRAY);
        btnVarsityM.setBounds(372, 191, 129, 23);
        panel.add(btnVarsityM);

        JLabel lblfor = new JLabel("Created for: Brenda");
        lblfor.setBounds(217, 323, 152, 14);
        lblfor.setFont(new Font( "Serif", Font.BOLD,14));
        panel.add(lblfor);
    }
}

