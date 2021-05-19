import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteGUI extends JFrame {
    JTextField id = new JTextField("",100);
    private JLabel Messege = new JLabel("");

    public DeleteGUI(){
        super("Remove student");
        this.setBounds(100,100,300,300);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(10,4,2,2));
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(new ButtonDeleteEventListener());
        container.add(removeButton);
        JLabel label = new JLabel(" Student ID to delete");
        container.add(label);
        container.add(id);
    }

    class ButtonDeleteEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setConnection();
            studentInfo.removeStudent(Integer.parseInt(id.getText()));
            studentInfo.closeConnection();
            Messege.setText("Student was deleted");
            dispose();
        }
    }
}
