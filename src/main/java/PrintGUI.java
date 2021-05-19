import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PrintGUI extends JFrame {

    public PrintGUI(){
        super("Students list");
        this.setBounds(100,100,300,300);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout());
        TextArea output = new TextArea();
        container.add(output);
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setConnection();
        output.setText(studentInfo.getStudentsList());
        studentInfo.closeConnection();
    }
}
