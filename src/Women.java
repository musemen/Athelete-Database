import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Women {

    JFrame frame;

    public Women() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 421, 273);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 413, 232);
        frame.getContentPane().add(panel);

        JLabel lblCheckTimeswomen = new JLabel("Check Times:Women");
        lblCheckTimeswomen.setBounds(125, 11, 157, 35);
        panel.add(lblCheckTimeswomen);

        JLabel label_1 = new JLabel("Select Name");
        label_1.setBounds(36, 55, 91, 14);
        panel.add(label_1);

        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"January", "Feburary", "March", "April", "May ", "June", "July", "August", "September", "October", "November", "December"}));
        comboBox_1.setBounds(36, 134, 127, 20);
        panel.add(comboBox_1);

        JComboBox comboBox_2 = new JComboBox();
        comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
        comboBox_2.setBounds(174, 133, 91, 20);
        panel.add(comboBox_2);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(36, 84, 229, 20);
        panel.add(comboBox);
        try {
            Scanner scan = new Scanner(new File("per.csv"));
            while(scan.hasNextLine()){
                String nam = scan.nextLine();
                String name = nam.split(",")[0];
                String gen = nam.split(",")[1];
                if(gen.contains("Wom")){
                    comboBox.addItem(name);
                }
            }
            scan.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }catch(IndexOutOfBoundsException e){

        }

        JButton button = new JButton("Check");
        button.addActionListener(new ActionListener() {
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


        button.setBounds(275, 130, 108, 23);
        panel.add(button);

        JButton button_1 = new JButton("Add Athelete");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                AddPerson ad = new AddPerson("Wom");
                ad.frame.setVisible(true);

            }
        });

        button_1.setBounds(251, 164, 132, 23);
        panel.add(button_1);

        JButton button_2 = new JButton("Delete Athelete");
        button_2.addActionListener(new ActionListener() {
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

        button_2.setBounds(251, 190, 132, 23);
        panel.add(button_2);

        JButton button_3 = new JButton("Main Menu");
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MainMenu().frame.setVisible(true);

            }
        });
        button_3.setBounds(33, 165, 108, 23);
        panel.add(button_3);

        JLabel lblSelectDate = new JLabel("Select Date\r\n");
        lblSelectDate.setBounds(36, 115, 91, 14);
        panel.add(lblSelectDate);
    }
}

