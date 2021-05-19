import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertGUI extends JFrame {
    private JLabel infoLabel = new JLabel("Input student information");
    private JTextField surnameText = new JTextField("",100);
    private JTextField nameText = new JTextField("",100);
    private JTextField patronymicText = new JTextField("",100);
    private JTextField birthdateText = new JTextField("",100);
    private JTextField groupText = new JTextField("",100);
    private JLabel Messege = new JLabel("");

    public InsertGUI(){
        super("Input student info");
        this.setBounds(100,100,300,300);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(10,4,2,2));
        container.add(new JLabel("Surname:"));
        container.add(surnameText);
        container.add(new JLabel("Name:"));
        container.add(nameText);
        container.add(new JLabel("Patronymic:"));
        container.add(patronymicText);
        container.add(new JLabel("Birth date(dd:mm:yyyy) :"));
        container.add(birthdateText);
        container.add(new JLabel("Group ID:"));
        container.add(groupText);
        JButton buttonInput = new JButton("Input");
        buttonInput.addActionListener(new ButtonInsertEventListener());
        container.add(buttonInput);
        container.add(Messege);
    }

    class ButtonInsertEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Messege.setText("");
            String surname = surnameText.getText();
            String name = nameText.getText();
            String patronymic = patronymicText.getText();
            Date birthDate = null;
            String birthDateString = "";
            birthDateString = birthdateText.getText();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd:mm:yyyy");
            try {
               birthDate = simpleDateFormat.parse(birthDateString);
            } catch (ParseException e) {
                actionPerformed(actionEvent);
            }
            int groupID = Integer.parseInt(groupText.getText());
            StudentInfo studentInfo = new StudentInfo();
            StudentInfo.setConnection();
            studentInfo.insertStudent(surname,name,patronymic,birthDate,groupID);
            StudentInfo.closeConnection();
            Messege.setText("Student was added");
            dispose();
        }
    }
}
