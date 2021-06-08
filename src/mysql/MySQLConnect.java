package mysql;

import ui.SelectCourseUI;

import java.sql.*;

import static javax.swing.UIManager.getInt;



public class MySQLConnect {
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/studentcoursedata";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "zsl8931l600";

    public static String sql = "";
    public static PreparedStatement prst = null;
    public static ResultSet resultSet;
    public static Connection connection = null;



    public static void connectMySQLToSelect() {
        try {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            //sql = "SELECT Sno, Sname FROM Student;";
            prst = connection.prepareStatement(sql);
            resultSet = prst.executeQuery();
            /*resultSet.close();
            prst.close();*/
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void connectMySQLToInsert(){
        try {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            prst = connection.prepareStatement(sql);
            prst.setString(1, SelectCourseUI.tempCno);
            prst.setString(2, SelectCourseUI.tempCname);
            prst.setInt(3, Integer.parseInt(SelectCourseUI.tempCcredit));
            prst.execute();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void connectMySQLToDelete(){
        try {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            prst = connection.prepareStatement(sql);
            prst.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void connectMySQLToUpdate(){
        try {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            prst = connection.prepareStatement(sql);
            prst.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static int calcDataCount(){
        int dataCount = 0;
        try {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            prst = connection.prepareStatement("SELECT COUNT(*) FROM mycourse;");
            resultSet = prst.executeQuery();
            while (resultSet.next()){
                dataCount += 1;
            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return dataCount;
    }
}



