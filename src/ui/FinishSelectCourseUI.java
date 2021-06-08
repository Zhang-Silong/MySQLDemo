package ui;

import mysql.MySQLConnect;
import util.MySQLUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FinishSelectCourseUI extends JFrame {



    JTable table;
    JScrollPane pane;
    String[][] tableData = new String[MySQLUtils.count][3];
    String[] courseName = {"课号", "课程名", "学分"};
    private List<String> list = new ArrayList<>();



    public FinishSelectCourseUI(){
        setTitle("已选择课程");
        setLayout(null);
        Container container = getContentPane();
        MySQLConnect.sql = "SELECT Cno, Cname, Ccredit FROM mycourse;";
        MySQLConnect.connectMySQLToSelect();
        try {
            while (MySQLConnect.resultSet.next()){
                String Cno = MySQLConnect.resultSet.getString("Cno");
                list.add(Cno);
                String Cname = MySQLConnect.resultSet.getString("Cname");
                list.add(Cname);
                String Ccredit = MySQLConnect.resultSet.getString("Ccredit");
                list.add(Ccredit);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        int flagIndex = 0;
        for (int i = 0; i < MySQLUtils.count; i++) {
            for (int j = 0; j < 3; j++) {
                if ((flagIndex + 1) <= list.size()){
                    tableData[i][j] = list.get(flagIndex);
                    flagIndex++;
                }else {
                    break;
                }
            }

        }
        table = MySQLUtils.limitEdit(tableData, courseName);
        pane = new JScrollPane(table);
        pane.setBounds(240, 30, 300, 300);
        container.add(pane);
        setSize(800, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new FinishSelectCourseUI();
    }
}
