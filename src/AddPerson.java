
import java.awt.EventQueue;
        import javax.swing.JFrame;
        import javax.swing.JPanel;
        import javax.swing.JLabel;
        import javax.swing.JOptionPane;
        import javax.swing.JTextField;
        import javax.swing.JButton;
        import java.awt.event.ActionListener;
        import java.io.File;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.awt.event.ActionEvent;

public class AddPerson {

    JFrame frame;
    /**
     * @wbp.nonvisual location=-30,129
     */
    private final JPanel panel = new JPanel();
    private JTextField textField;
    private JTextField textField_1;
    String gender ="";

    /**
     * Create the application.
     */
    public AddPerson(String gen) {
        //	this.frame.setVisible(true);
        gender = gen ;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 256);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 434, 219);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JLabel lblAddPerson = new JLabel("Add Athlete");

        lblAddPerson.setBounds(158, 11, 108, 35);
        panel_1.add(lblAddPerson);

        JLabel lblName = new JLabel("Name :");
        panel_1.add(lblName);
        lblName.setBounds(105, 66, 225, 20);

        textField = new JTextField();
        textField.setBounds(150, 66, 225, 20);
        panel_1.add(textField);
        textField.setColumns(10);

        JLabel lblAge = new JLabel("Age:");
        panel_1.add(lblAge);
        lblAge.setBounds(110, 100, 140, 20);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(150, 97, 225, 20);
        panel_1.add(textField_1);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                File f= new File("per.csv");
                File fnew = new File(textField+".csv");
                try {
                    FileWriter fw = new FileWriter(f,true);
                    String name = textField.getText();
                    fw.write(name+","+gender+",true\n");
                    fw.close();
                    JOptionPane.showMessageDialog(null, name+ " " +" added");
                    frame.setVisible(false);
                    new MainMenu().frame.setVisible(true);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
        });

        btnAdd.setBounds(285, 150, 108, 23);
        panel_1.add(btnAdd);

        JButton btnMainMenu = new JButton("Main Menu");
        btnMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MainMenu().frame.setVisible(true);
            }
        });

        btnMainMenu.setBounds(49, 150, 108, 23);
        panel_1.add(btnMainMenu);
    }
}
