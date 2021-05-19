import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectionGUI extends JFrame {
    private JTextField userName = new JTextField("",100);
    private JTextField password = new JTextField("",100);
    private JTextArea error = new JTextArea();
    public ConnectionGUI(){
        super("Connection Info");
        this.setBounds(100,100,300,300);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(10,4,2,2));
        container.add(new JLabel("Input User name:"));
        container.add(userName);
        container.add(new JLabel("Input password:"));
        container.add(password);
        JButton inputButton = new JButton("Input");
        inputButton.addActionListener(new ConnectionButtonEventListener());
        container.add(inputButton);
        container.add(error);
    }

    class ConnectionButtonEventListener implements ActionListener{

        public void actionPerformed(ActionEvent actionEvent) {
            StudentInfo.inputConnectionInfo(userName.getText(),password.getText());
            StudentInfo.setConnection();
            if(StudentInfo.isRightConnection()){
                dispose();
                StudentInfoGUI studentInfoGUI = new StudentInfoGUI();
                studentInfoGUI.setVisible(true);
                StudentInfo.closeConnection();
            }
            else {
                error.setText("Error. Try again");
                dispose();
            }
        }
    }

}
