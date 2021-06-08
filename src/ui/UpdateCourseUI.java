package ui;

import mysql.MySQLConnect;
import util.MySQLUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class UpdateCourseUI extends JFrame {

    //JLabel tips = new JLabel("输入课号进行更换");
    JTextField input = new JTextField();
    JButton ok = new JButton("确定");
    JButton refresh = new JButton("刷新");
    JTable table;
    JScrollPane pane;
    String[][] tableData = new String[MySQLUtils.count][3];
    String[] courseName = {"课号", "课程名", "学分"};
    private List<String> list = new ArrayList<>();

    public static String tempCno = "";
    public static String tempCname = "";
    public static String tempCcredit = "";


    public UpdateCourseUI(){
        setTitle("选课");
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
        //tips.setBounds(240, 360, 140, 20);
        //tips.setFont(new Font("Dialog", Font.BOLD, 15));
        input.setBounds(380, 360, 120, 25);
        input.setFont(new Font("Dialog", Font.BOLD, 15));
        ok.setBounds(380, 400, 80, 20);
        ok.setFont(new Font("Dialog", Font.BOLD, 15));
        refresh.setBounds(520, 360, 80, 20);
        refresh.setFont(new Font("Dialog", Font.BOLD, 15));
        container.add(pane);
        //container.add(tips);
        container.add(input);
        container.add(ok);
        container.add(refresh);
        click();
        setSize(800, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    public static void main(String[] args) {
        new UpdateCourseUI();
    }

    public void click(){
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> tempList = new ArrayList<>();
                tempList = tempConnect();
                tempCno = input.getText();
                String tempStr = "";
                String tempCnoFlag = "";
                for (int i = 0; i < tempList.size(); i++) {
                    if (tempList.get(i).equals(tempCno)){
                        tempStr = tempList.get(i+1);
                    }
                }
                for (int i = 0; i < tempList.size(); i++) {
                    if (tempList.get(i).equals(tempStr) && !(tempList.get(i-1).equals(tempCno))){
                        tempCnoFlag = tempList.get(i-1);
                    }
                }
                if(tempCnoFlag.equals("")){
                    new TipsDialog<UpdateCourseUI>(UpdateCourseUI.this, "","更换失败!").setVisible(true);
                }else {
                    MySQLConnect.sql = "UPDATE mycourse SET Cno = " + tempCno + " WHERE Cno = " + tempCnoFlag + ";";
                    MySQLConnect.connectMySQLToUpdate();
                    new TipsDialog<UpdateCourseUI>(UpdateCourseUI.this, "","更换成功!").setVisible(true);
                }
            }
        });

        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                refreshData();
            }
        });
    }

    public void refreshData(){
        new UpdateCourseUI();
    }

    public List<String> tempConnect(){
        List<String> tempList = new ArrayList<>();
        MySQLConnect.sql = "SELECT Cno, Cname, Ccredit FROM course;";
        MySQLConnect.connectMySQLToSelect();
        try {
            while (MySQLConnect.resultSet.next()){
                String Cno = MySQLConnect.resultSet.getString("Cno");
                tempList.add(Cno);
                String Cname = MySQLConnect.resultSet.getString("Cname");
                tempList.add(Cname);
                String Ccredit = MySQLConnect.resultSet.getString("Ccredit");
                tempList.add(Ccredit);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return tempList;
    }
}
