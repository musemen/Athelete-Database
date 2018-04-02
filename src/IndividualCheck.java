import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class IndividualCheck {

    JFrame frame;
String nm ;
    /**
     * @wbp.nonvisual location=-30,139
     */
    private final JPanel panel = new JPanel();

    String t ,u ;
    public IndividualCheck(String st) {
        nm = st.split(":")[0] ;
        t = st.split(":")[1];
        u=st.split(":")[2];
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 650, 525);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 624, 486);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        GridLayout gd = new GridLayout(0,6);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(22, 101, 569, 128);
        panel_1.add(panel_2);
        panel_2.setLayout(gd);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(22, 268, 569, 128);
        panel_1.add(panel_3);
        GridLayout gd2 = new GridLayout(0,6);
        panel_3.setLayout(gd2);


        JLabel jb = new JLabel("60 meter");
        jb.setHorizontalAlignment(0);
        jb.setVerticalAlignment(0);
        jb.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel jbh = new JLabel("60 meter");
        jbh.setHorizontalAlignment(0);
        jbh.setVerticalAlignment(0);
        jbh.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_2.add(jb);
        panel_3.add(jbh);


        JLabel jb1 = new JLabel("100 meter");
        jb1.setHorizontalAlignment(0);
        jb1.setVerticalAlignment(0);
        jb1.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel jbh1 = new JLabel("100 meter");
        jbh1.setHorizontalAlignment(0);
        jbh1.setVerticalAlignment(0);
        jbh1.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_2.add(jb1);
        panel_3.add(jbh1);

        JLabel jb2 = new JLabel("150 meter");
        jb2.setHorizontalAlignment(0);
        jb2.setVerticalAlignment(0);
        jb2.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel jbh2 = new JLabel("150 meter");
        jbh2.setHorizontalAlignment(0);
        jbh2.setVerticalAlignment(0);
        jbh2.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_2.add(jb2);
        panel_3.add(jbh2);

        JLabel jb3 = new JLabel("200 meter");
        jb3.setHorizontalAlignment(0);
        jb3.setVerticalAlignment(0);
        jb3.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel jbh3 = new JLabel("200 meter");
        jbh3.setHorizontalAlignment(0);
        jbh3.setVerticalAlignment(0);
        jbh3.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_2.add(jb3);
        panel_3.add(jbh3);

        JLabel jb4 = new JLabel("300 meter");
        jb4.setHorizontalAlignment(0);
        jb4.setVerticalAlignment(0);
        jb4.setBorder(BorderFactory.createLineBorder(Color.black));

        JLabel jbh4 = new JLabel("300 meter");
        jbh4.setHorizontalAlignment(0);
        jbh4.setVerticalAlignment(0);
        jbh4.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_2.add(jbh4);
        panel_3.add(jb4);

        JLabel jb5 = new JLabel("400 meter");
        jb5.setHorizontalAlignment(0);
        jb5.setVerticalAlignment(0);
        jb5.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel jbh5 = new JLabel("400 meter");
        jbh5.setHorizontalAlignment(0);
        jbh5.setVerticalAlignment(0);
        jbh5.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_2.add(jb5);
        panel_3.add(jbh5);


        JLabel label = new JLabel(nm);
        label.setFont(new Font("Serif", Font.BOLD, 16));
        label.setBackground(Color.DARK_GRAY);
        label.setBounds(251, 11, 108, 35);
        panel_1.add(label);


        Double sm60 = 0.0 ;
        String hod ="";
        File f = new File("date60 meter.csv");
        try {
            Scanner scan = new Scanner(f);
            while(scan.hasNextLine()){
                String li = scan.nextLine();
                String st = li.split(",")[0];

                String dte = u;
                System.out.println(u);
                if(dte.equals(st)){
                    System.out.println("");
                    int num = Integer.parseInt(t);
                    sm60 = Double.parseDouble(li.split(",")[1]);
                    for(int i=2;i<li.split(",").length;i++){
                        if(sm60 > Double.parseDouble(li.split(",")[i]))
                            sm60 = Double.parseDouble(li.split(",")[i]);
                    }

                    try{
                        hod= li.split(",")[num];
                    }catch(ArrayIndexOutOfBoundsException aiou){
                        hod = "";
                    }


                    System.out.println(hod);

                }

            }

            scan.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        JLabel jb7 = new JLabel(hod);
        jb7.setHorizontalAlignment(0);
        jb7.setVerticalAlignment(0);
        jb7.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_2.add(jb7);

        //// 100 meter
        Double sm100 = 0.0 ;
        hod ="";
        f = new File("date100 meter.csv");
        try {
            Scanner scan = new Scanner(f);
            while(scan.hasNextLine()){
                String li = scan.nextLine();
                String st = li.split(",")[0];

                String dte = u;
                System.out.println(u);
                if(dte.equals(st)){
                    System.out.println("");
                    int num = Integer.parseInt(t);
                    sm100 = Double.parseDouble(li.split(",")[1]);
                    for(int i=2;i<li.split(",").length;i++){
                        if(sm100 > Double.parseDouble(li.split(",")[i]))
                            sm100 = Double.parseDouble(li.split(",")[i]);
                    }

                    try{
                        hod= li.split(",")[num];
                    }catch(ArrayIndexOutOfBoundsException aiou){
                        hod = "";
                    }


                    System.out.println(hod);

                }

            }

            scan.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        JLabel jb8 = new JLabel(hod);
        jb8.setHorizontalAlignment(0);
        jb8.setVerticalAlignment(0);
        jb8.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_2.add(jb8);


        ////150 meter 
        Double sm150 = 0.0 ;
        hod ="";
        f = new File("date150 meter.csv");
        try {
            Scanner scan = new Scanner(f);
            while(scan.hasNextLine()){
                String li = scan.nextLine();
                String st = li.split(",")[0];

                String dte = u;
                System.out.println(u);
                if(dte.equals(st)){
                    System.out.println("");
                    int num = Integer.parseInt(t);
                    sm150 = Double.parseDouble(li.split(",")[1]);
                    for(int i=2;i<li.split(",").length;i++){
                        if(sm150 > Double.parseDouble(li.split(",")[i]))
                            sm150 = Double.parseDouble(li.split(",")[i]);
                    }

                    try{
                        hod= li.split(",")[num];
                    }catch(ArrayIndexOutOfBoundsException aiou){
                        hod = "";
                    }


                    System.out.println(hod);

                }

            }

            scan.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        JLabel jb9 = new JLabel(hod);
        jb9.setHorizontalAlignment(0);
        jb9.setVerticalAlignment(0);
        jb9.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_2.add(jb9);

        ////200 meter
        Double sm200 = 0.0 ;
        hod ="";
        f = new File("date200 meter.csv");
        try {
            Scanner scan = new Scanner(f);
            while(scan.hasNextLine()){
                String li = scan.nextLine();
                String st = li.split(",")[0];

                String dte = u;
                System.out.println(u);
                if(dte.equals(st)){
                    System.out.println("");
                    int num = Integer.parseInt(t);
                    sm200 = Double.parseDouble(li.split(",")[1]);
                    for(int i=2;i<li.split(",").length;i++){
                        if(sm200 > Double.parseDouble(li.split(",")[i]))
                            sm200 = Double.parseDouble(li.split(",")[i]);
                    }

                    try{
                        hod= li.split(",")[num];
                    }catch(ArrayIndexOutOfBoundsException aiou){
                        hod = "";
                    }

                    System.out.println(hod);

                }

            }

            scan.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        JLabel jb10 = new JLabel(hod);
        jb10.setHorizontalAlignment(0);
        jb10.setVerticalAlignment(0);
        jb10.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_2.add(jb10);



        ////300 meter

        hod ="";
        f = new File("date300 meter.csv");
        Double sm300 =0.0 ;
        try {
            Scanner scan = new Scanner(f);
            while(scan.hasNextLine()){
                String li = scan.nextLine();
                String st = li.split(",")[0];

                String dte = u;
                System.out.println(u);
                if(dte.equals(st)){
                    System.out.println("");
                    int num = Integer.parseInt(t);
                    sm300 = Double.parseDouble(li.split(",")[1]);
                    for(int i=2;i<li.split(",").length;i++){
                        if(sm300 > Double.parseDouble(li.split(",")[i]))
                            sm300 = Double.parseDouble(li.split(",")[i]);
                    }

                    try{
                        hod= li.split(",")[num];
                    }catch(ArrayIndexOutOfBoundsException aiou){
                        hod = "";
                    }


                    System.out.println(hod);

                }

            }

            scan.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        JLabel jb11 = new JLabel(hod);
        jb11.setHorizontalAlignment(0);
        jb11.setVerticalAlignment(0);
        jb11.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_2.add(jb11);

        ////400 meter

        Double sm400 = 0.0 ;
        hod ="";
        f = new File("date400 meter.csv");
        try {
            Scanner scan = new Scanner(f);
            while(scan.hasNextLine()){
                String li = scan.nextLine();
                String st = li.split(",")[0];

                String dte = u;
                System.out.println(u);
                if(dte.equals(st)){
                    System.out.println("");
                    int num = Integer.parseInt(t);
                    sm400 = Double.parseDouble(li.split(",")[1]);
                    for(int i=2;i<li.split(",").length;i++){
                        if(sm400 > Double.parseDouble(li.split(",")[i]))
                            sm400 = Double.parseDouble(li.split(",")[i]);
                    }

                    try{
                        hod= li.split(",")[num];
                    }catch(ArrayIndexOutOfBoundsException aiou){
                        hod = "";
                    }


                    System.out.println(hod);

                }

            }

            scan.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        JLabel jb12 = new JLabel(hod);
        jb12.setHorizontalAlignment(0);
        jb12.setVerticalAlignment(0);
        jb12.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_2.add(jb12);




        JLabel lblFastest = new JLabel("Fastest");
        lblFastest.setBounds(21, 243, 46, 14);
        panel_1.add(lblFastest);

        JLabel jbh6 = new JLabel(sm60+"");
        jbh6.setHorizontalAlignment(0);
        jbh6.setVerticalAlignment(0);
        jbh6.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_3.add(jbh6);

        JLabel jbh16 = new JLabel(sm100+"");
        jbh16.setHorizontalAlignment(0);
        jbh16.setVerticalAlignment(0);
        jbh16.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_3.add(jbh16);

        JLabel jbh26 = new JLabel(sm150+"");
        jbh26.setHorizontalAlignment(0);
        jbh26.setVerticalAlignment(0);
        jbh26.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_3.add(jbh26);

        JLabel jbh36 = new JLabel(sm200+"");
        jbh36.setHorizontalAlignment(0);
        jbh36.setVerticalAlignment(0);
        jbh36.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_3.add(jbh36);

        JLabel jbhw6 = new JLabel(sm300+"");
        jbhw6.setHorizontalAlignment(0);
        jbhw6.setVerticalAlignment(0);
        jbhw6.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_3.add(jbhw6);

        JLabel jbhq6 = new JLabel(sm400+"");
        jbhq6.setHorizontalAlignment(0);
        jbhq6.setVerticalAlignment(0);
        jbhq6.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_3.add(jbhq6);


        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        btnBack.setFont(new Font("Serif", Font.ITALIC, 13));
        btnBack.setBounds(483, 420, 108, 23);
        panel_1.add(btnBack);

        JButton btnMainMenu = new JButton("Main Menu");
        btnMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MainMenu().frame.setVisible(true);
            }
        });
        btnMainMenu.setFont(new Font("Serif", Font.ITALIC, 13));
        btnMainMenu.setBounds(21, 421, 108, 23);
        panel_1.add(btnMainMenu);

    }

}
