import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class StudentInfo {
    private static Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/studentdb";
    private static String userName = "";
    private static String password = "";
    private String SQLquery = "";
    private Statement statement = null;
    private static boolean isRightConnection;

    public static void inputConnectionInfo(String userName, String password){
        StudentInfo.userName = userName;
        StudentInfo.password = password;
    }

    public static boolean isRightConnection() {
        return isRightConnection;
    }

    public static void setConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(url, userName, password);
            isRightConnection = true;
        } catch (SQLException | ClassNotFoundException e) {
            isRightConnection = false;
        }
    }

    public static void closeConnection(){
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertStudent(String surname, String name, String patronymic, Date birthDate, int groupID){
        SQLquery = String.format("INSERT INTO studentdb.students(Surname,Name,Patronymic,BirthDate,groupID) " +
                        "VALUES " +
                        "('%s','%s','%s','%tY-%tm-%td','%d')",
                surname,
                name,
                patronymic,
                birthDate,
                birthDate,
                birthDate,
                groupID);
        try {
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(SQLquery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeStudent(int ID){
        try {
            SQLquery = String.format("DELETE FROM students WHERE ID = %d",ID);
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(SQLquery);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public String getStudentsList(){
        StringBuilder stringBuilder = new StringBuilder("");
        try {
            SQLquery = "SELECT * FROM studentdb.students";
            statement = (Statement) connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQLquery);
            while (resultSet.next()){
                String result = String. format("ID - %d Surname - %s Name - %s Patronymic - %s Birth date - %td.%tm.%tY Group - %d\n",
                        resultSet.getInt("ID"),
                        resultSet.getString("Surname"),
                        resultSet.getString("Name"),
                        resultSet.getString("Patronymic"),
                        resultSet.getDate("BirthDate"),
                        resultSet.getDate("BirthDate"),
                        resultSet.getDate("BirthDate"),
                        resultSet.getInt("groupID"));
                stringBuilder.append(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
