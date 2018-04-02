import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectDate {

    JFrame frame;
    private final JPanel panel = new JPanel();



    /**
     * Create the application.
     */
    public SelectDate() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 312);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        panel.setForeground(new Color(255, 0, 255));
        panel.setBackground(new Color(250, 235, 215));
        panel.setBounds(0, 0, 434, 273);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblSelectDate = new JLabel("Select Date");
        lblSelectDate.setBounds(166, 27, 258, 35);
        panel.add(lblSelectDate);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "Feburary", "March", "April", "May ", "June", "July", "August", "September", "October", "November", "December"}));
        comboBox.setBounds(44, 97, 127, 20);
        panel.add(comboBox);

        JLabel lblSelectMonth = new JLabel("select month :");
        lblSelectMonth.setBounds(42, 72, 68, 14);
        panel.add(lblSelectMonth);

        JLabel lblSelectDay = new JLabel("select Day:");
        lblSelectDay.setBounds(202, 73, 68, 14);
        panel.add(lblSelectDay);

        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
        comboBox_1.setBounds(202, 98, 127, 20);
        panel.add(comboBox_1);

        JButton btnNext = new JButton("Next ");
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String month = comboBox.getSelectedItem().toString();
                String day = comboBox_1.getSelectedItem().toString();
                frame.setVisible(false);
                addTimes ad = new addTimes(month+"/" +day +"/2017");
                ad.frame.setVisible(true);
            }
        });

        btnNext.setBounds(255, 202, 129, 23);
        panel.add(btnNext);

        JButton btnMainMenu = new JButton("Main Menu");
        btnMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MainMenu().frame.setVisible(true);
            }
        });

        btnMainMenu.setBounds(42, 203, 129, 23);
        panel.add(btnMainMenu);
    }
}
