import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;

public class addTimes {

JFrame frame;
    String dt ;
    /**
     * Create the application.
     */
    public addTimes(String date) {
        dt = date;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 589, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 573, 461);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblAddTimes = new JLabel("Add Times");

        lblAddTimes.setBounds(218, 11, 140, 35);
        panel.add(lblAddTimes);

        JButton button = new JButton("Next ");
        button.setText(dt);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        button.setBounds(365, 75, 177, 23);
        panel.add(button);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"60 meter", "100 meter", "150 meter", "200 meter", "300 meter", "400 meter"}));
        comboBox.setBounds(20, 91, 260, 20);
        panel.add(comboBox);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(20, 138, 522, 278);
        panel.add(panel_1);
        //panel_1.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 522, 278);
        //panel_1.add(scrollPane);

        GridLayout gd = new GridLayout(0, 2);
        panel_1.setLayout(gd);

        ArrayList<JLabel> jl = new ArrayList<JLabel>();
        ArrayList<JTextField> jt = new ArrayList<JTextField>();
	 try {
            Scanner scan = new Scanner(new File("per.csv"));
            while(scan.hasNextLine()){
                String name = scan.nextLine().split(",")[0];
                jl.add(new JLabel(name));
		 jt.add(new JTextField());
		 jl.get(jl.size()-1).setHorizontalTextPosition(0);
		 panel_1.add(jl.get(jl.size()-1));
		 panel_1.add(jt.get(jt.size()-1));

            }
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }





        JLabel lblName = new JLabel("Name");
        lblName.setBounds(116, 107, 119, 29);
        panel.add(lblName);

        JLabel lblTime = new JLabel("Time");
        lblTime.setBounds(360, 107, 119, 29);
        panel.add(lblTime);




        JButton btnSaveTimes = new JButton("Save Times");
        btnSaveTimes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    String name = comboBox.getSelectedItem().toString();
                    FileWriter fw = new FileWriter(new File("date"+name+".csv"),true);
                    String fin = "\n" + dt ;
                    for(int i=0;i<jt.size();i++){
                        fin+=","+jt.get(i).getText() ;
                        try{
                            double db = Double.parseDouble(jt.get(i).getText());
                        }catch(Exception ed){
                            JOptionPane.showMessageDialog(null, "Please enter the correct Value");
                            fw.close();
                            return ;
                        }

                    }
                    fw.write(fin+"");
                    fw.close();
                    JOptionPane.showMessageDialog(null, "Successfully done");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });
        btnSaveTimes.setBounds(413, 427, 129, 23);
        panel.add(btnSaveTimes);

        JButton btnMainMenu = new JButton("Main Menu");
        btnMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MainMenu().frame.setVisible(true);
            }
        });
        btnMainMenu.setBounds(20, 428, 129, 23);
        panel.add(btnMainMenu);

        JLabel lblNewLabel = new JLabel("Select the distance");
        lblNewLabel.setBounds(20, 66, 129, 14);
        panel.add(lblNewLabel);

    }
}
