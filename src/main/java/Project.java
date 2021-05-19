import java.awt.*;

public class Project {
    public static void main(String[] args) {
        ConnectionGUI connectionGUI = new ConnectionGUI();

        while (!StudentInfo.isRightConnection()) {
            connectionGUI.setVisible(true);
        }
    }
}
