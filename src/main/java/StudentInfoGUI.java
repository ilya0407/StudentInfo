import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentInfoGUI extends JFrame {

    private StudentInfo studentInfo;

    public StudentInfoGUI() {
        super("Simple Example");
        this.setBounds(100,100,1000,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(10,2,2,2));
        JButton buttonInSert = new JButton("Insert");
        buttonInSert.addActionListener(new ButtonInsertEventListener());
        container.add(buttonInSert);
        JButton buttonDelete = new JButton("Delete");
        buttonDelete.addActionListener(new ButtonDeleteEventListener());
        container.add(buttonDelete);
        JButton buttonPrint = new JButton("Print");
        buttonPrint.addActionListener(new ButtonPrintEventListener());
        container.add(buttonPrint);
        studentInfo = new StudentInfo();
    }

    class ButtonInsertEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            InsertGUI insertGUI = new InsertGUI();
            insertGUI.setVisible(true);
        }
    }

    class ButtonDeleteEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            DeleteGUI deleteGUI = new DeleteGUI();
            deleteGUI.setVisible(true);
        }
    }

    class ButtonPrintEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            PrintGUI printGUI = new PrintGUI();
            printGUI.setVisible(true);
        }

    }



}
