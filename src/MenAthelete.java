import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class MenAthelete {

    JFrame frame;



    public MenAthelete() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 429, 271);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 413, 232);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblCheckTimesmen = new JLabel("Check Times:Men");
        lblCheckTimesmen.setBounds(142, 11, 140, 35);
        panel.add(lblCheckTimesmen);

        JLabel lblNewLabel = new JLabel("Select Name");
        lblNewLabel.setBounds(36, 55, 91, 14);
        panel.add(lblNewLabel);


        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(36, 72, 229, 20);
        try {
            Scanner scan = new Scanner(new File("per.csv"));
            while(scan.hasNextLine()){
                String nam = scan.nextLine();
                String name = nam.split(",")[0];
                String gen = nam.split(",")[1];
                if(gen.contains("Men")){
                    comboBox.addItem(name);
                }
            }
            scan.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }catch(IndexOutOfBoundsException e ){

        }
        panel.add(comboBox);
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"January", "Feburary", "March", "April", "May ", "June", "July", "August", "September", "October", "November", "December"}));
        comboBox_1.setBounds(36, 116, 127, 20);
        panel.add(comboBox_1);

        JComboBox comboBox_2 = new JComboBox();
        comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
        comboBox_2.setBounds(173, 116, 91, 20);
        panel.add(comboBox_2);

        JButton btnCheck = new JButton("Check");
        btnCheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("here ");
                File f = new File("per.csv");
                System.out.println("here 2");
                try {
                    Scanner scan = new Scanner(f);
                    int i=0;
                    System.out.println("here 3");
                    while(scan.hasNextLine()){
                        i++;
                        String name = scan.nextLine().split(",")[0];

                        String sel = comboBox.getSelectedItem().toString();
                        System.out.println(name);
                        System.out.println(sel);
                        if(name.equalsIgnoreCase(sel)){
                            scan.close();
                            System.out.println(name);
                            String dte = comboBox_1.getSelectedItem().toString()+"/"+comboBox_2.getSelectedItem().toString()+"/2017";
                            new IndividualCheck(name+":"+i+":"+dte).frame.setVisible(true);

                        }
                    }
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        btnCheck.setBounds(275, 115, 108, 23);
        panel.add(btnCheck);

        JButton btnAddAthelete = new JButton("Add Athelete");
        btnAddAthelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                AddPerson ad = new AddPerson("Men");
                ad.frame.setVisible(true);

            }
        });

        btnAddAthelete.setBounds(251, 164, 132, 23);
        panel.add(btnAddAthelete);

        JButton btnDeleteAthelete = new JButton("Delete Athelete");
        btnDeleteAthelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int num =0;
                System.out.println("here ");
                File f = new File("per.csv");
                System.out.println("here 2");
                try {
                    Scanner scan = new Scanner(f);
                    int i=0;
                    System.out.println("here 3");
                    String bari = "";
                    while(scan.hasNextLine()){
                        i++;
                        String nae = scan.nextLine();
                        String name = nae.split(",")[0];
                        String sel = comboBox.getSelectedItem().toString();
                        System.out.println(name);
                        System.out.println(sel);
                        if(name.equalsIgnoreCase(sel)){
                            System.out.println("Got it at " + i);
                            num = i ;
                        }else{
                            bari += nae +"\n" ;
                        }
                    }

                    scan.close();
                    File ft = new File("per.csv");
                    FileWriter fw = new FileWriter(ft);
                    fw.write(bari);
                    fw.close();

                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


                /////60meter file//////


                try {File ft60 = new File("date60 meter.csv");
                    Scanner scan = new Scanner(ft60);
                    String news1 = "";
                    while(scan.hasNextLine()){
                        String news = scan.nextLine();
                        int sp = news.split(",").length;
                        if(sp>num){
                            String news2 = "";
                            String[] flow = news.split(",");
                            for(int i=0;i<flow.length;i++){
                                if(i==num){
                                    continue;
                                }
                                if(i==0){
                                    news2+=flow[i];
                                }else{
                                    news2+=","+flow[i];
                                }
                            }

                            news1+=news2+"\n";

                        }else{
                            news1+=news+"\n";
                        }

                    }

                    File ftn= new File("date60 meter.csv");
                    FileWriter fw = new FileWriter(ftn);
                    fw.write(news1);
                    fw.close();
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block

                } catch (IOException e) {

                }

                //////////////////////



                /////100meter file//////


                try {File ft60 = new File("date100 meter.csv");
                    Scanner scan = new Scanner(ft60);
                    String news1 = "";
                    while(scan.hasNextLine()){
                        String news = scan.nextLine();
                        int sp = news.split(",").length;
                        if(sp>num){
                            String news2 = "";
                            String[] flow = news.split(",");
                            for(int i=0;i<flow.length;i++){
                                if(i==num){
                                    continue;
                                }
                                if(i==0){
                                    news2+=flow[i];
                                }else{
                                    news2+=","+flow[i];
                                }
                            }

                            news1+=news2+"\n";

                        }else{
                            news1+=news+"\n";
                        }

                    }

                    File ftn= new File("date100 meter.csv");
                    FileWriter fw = new FileWriter(ftn);
                    fw.write(news1);
                    fw.close();
                } catch (FileNotFoundException e) {

                } catch (IOException e) {

                }

                //////////////////////



                /////150meter file//////


                try {File ft60 = new File("date150 meter.csv");
                    Scanner scan = new Scanner(ft60);
                    String news1 = "";
                    while(scan.hasNextLine()){
                        String news = scan.nextLine();
                        int sp = news.split(",").length;
                        if(sp>num){
                            String news2 = "";
                            String[] flow = news.split(",");
                            for(int i=0;i<flow.length;i++){
                                if(i==num){
                                    continue;
                                }
                                if(i==0){
                                    news2+=flow[i];
                                }else{
                                    news2+=","+flow[i];
                                }
                            }

                            news1+=news2+"\n";

                        }else{
                            news1+=news+"\n";
                        }

                    }

                    File ftn= new File("date150 meter.csv");
                    FileWriter fw = new FileWriter(ftn);
                    fw.write(news1);
                    fw.close();
                } catch (FileNotFoundException e) {

                } catch (IOException e) {

                }

                //////////////////////





                /////200meter file//////


                try {File ft60 = new File("date200 meter.csv");
                    Scanner scan = new Scanner(ft60);
                    String news1 = "";
                    while(scan.hasNextLine()){
                        String news = scan.nextLine();
                        int sp = news.split(",").length;
                        if(sp>num){
                            String news2 = "";
                            String[] flow = news.split(",");
                            for(int i=0;i<flow.length;i++){
                                if(i==num){
                                    continue;
                                }
                                if(i==0){
                                    news2+=flow[i];
                                }else{
                                    news2+=","+flow[i];
                                }
                            }

                            news1+=news2+"\n";

                        }else{
                            news1+=news+"\n";
                        }

                    }

                    File ftn= new File("date200 meter.csv");
                    FileWriter fw = new FileWriter(ftn);
                    fw.write(news1);
                    fw.close();
                } catch (FileNotFoundException e) {

                } catch (IOException e) {

                }

                //////////////////////





                /////300meter file//////


                try {File ft60 = new File("date300 meter.csv");
                    Scanner scan = new Scanner(ft60);
                    String news1 = "";
                    while(scan.hasNextLine()){
                        String news = scan.nextLine();
                        int sp = news.split(",").length;
                        if(sp>num){
                            String news2 = "";
                            String[] flow = news.split(",");
                            for(int i=0;i<flow.length;i++){
                                if(i==num){
                                    continue;
                                }
                                if(i==0){
                                    news2+=flow[i];
                                }else{
                                    news2+=","+flow[i];
                                }
                            }

                            news1+=news2+"\n";

                        }else{
                            news1+=news+"\n";
                        }

                    }

                    File ftn= new File("date300 meter.csv");
                    FileWriter fw = new FileWriter(ftn);
                    fw.write(news1);
                    fw.close();
                } catch (FileNotFoundException e) {

                } catch (IOException e) {

                }

                //////////////////////





                /////400meter file//////


                try {File ft60 = new File("date400 meter.csv");
                    Scanner scan = new Scanner(ft60);
                    String news1 = "";
                    while(scan.hasNextLine()){
                        String news = scan.nextLine();
                        int sp = news.split(",").length;
                        if(sp>num){
                            String news2 = "";
                            String[] flow = news.split(",");
                            for(int i=0;i<flow.length;i++){
                                if(i==num){
                                    continue;
                                }
                                if(i==0){
                                    news2+=flow[i];
                                }else{
                                    news2+=","+flow[i];
                                }
                            }

                            news1+=news2+"\n";

                        }else{
                            news1+=news+"\n";
                        }

                    }

                    File ftn= new File("date400 meter.csv");
                    FileWriter fw = new FileWriter(ftn);
                    fw.write(news1);
                    fw.close();
                } catch (FileNotFoundException e) {

                } catch (IOException e) {

                }

                //////////////////////


            }
        });
        btnDeleteAthelete.setBounds(251, 190, 132, 23);
        panel.add(btnDeleteAthelete);

        JButton btnMainMenu = new JButton("Main Menu");
        btnMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MainMenu().frame.setVisible(true);
            }
        });
        btnMainMenu.setBounds(33, 165, 108, 23);
        panel.add(btnMainMenu);



        JLabel lblSelectDate = new JLabel("Select Date");
        lblSelectDate.setBounds(36, 101, 91, 14);
        panel.add(lblSelectDate);
    }

}
