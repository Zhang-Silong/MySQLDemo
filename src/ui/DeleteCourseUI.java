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
public class DeleteCourseUI extends JFrame {

    JLabel tips = new JLabel("输入课号进行退课");
    JTextField input = new JTextField();
    JButton ok = new JButton("提交");
    JButton refresh = new JButton("刷新");
    Container container;
    JTable table;
    JScrollPane pane;
    String[][] tableData = new String[MySQLUtils.count][3];
    String[] courseName = {"课号", "课程名", "学分"};
    private List<String> list = new ArrayList<>();

    public static String tempCno = "";
    public static String tempCname = "";
    public static String tempCcredit = "";

    public DeleteCourseUI(){
        setTitle("退课");
        setLayout(null);
        container = getContentPane();
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
        tips.setBounds(240, 360, 140, 20);
        tips.setFont(new Font("Dialog", Font.BOLD, 15));
        input.setBounds(380, 360, 120, 25);
        input.setFont(new Font("Dialog", Font.BOLD, 15));
        ok.setBounds(380, 400, 80, 20);
        ok.setFont(new Font("Dialog", Font.BOLD, 15));
        refresh.setBounds(520, 360, 80, 20);
        refresh.setFont(new Font("Dialog", Font.BOLD, 15));
        click();
        container.add(pane);
        container.add(tips);
        container.add(input);
        container.add(ok);
        container.add(refresh);
        setSize(800, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new DeleteCourseUI();
    }

    public void click(){
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tempCno = input.getText();
                int flag = 0;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).equals(tempCno)){
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0){
                    new TipsDialog<DeleteCourseUI>(DeleteCourseUI.this, "输入异常","你未选择此课程,请重新输入!").setVisible(true);
                }else {
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).equals(tempCno)){
                            tempCname = list.get(i+1);
                            tempCcredit = list.get(i+1);
                        }
                    }
                    MySQLConnect.sql = "DELETE FROM mycourse WHERE Cno = " + tempCno + ";";
                    MySQLConnect.connectMySQLToDelete();
                    new TipsDialog<DeleteCourseUI>(DeleteCourseUI.this, "","退课成功!").setVisible(true);

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
       new DeleteCourseUI();
    }
}
