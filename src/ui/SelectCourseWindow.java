package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SelectCourseWindow extends JFrame {
    JButton selectCourse = new JButton("选课");//增
    JButton deleteCourse = new JButton("退课");//删
    JButton updateCourse = new JButton("更换课程");//改
    JButton myCourse = new JButton("我的课程");//查

    JTextField selectCourseInput = new JTextField();
    JTextField deleteCourseInput = new JTextField();
    JTextField updateCourseInput = new JTextField();

    public SelectCourseWindow(){
        setTitle("个人课程系统");
        setLayout(null);
        Container container = getContentPane();
        selectCourse.setBounds(200, 100, 80, 20);
        selectCourse.setFont(new Font("Dialog", Font.BOLD, 15));
        selectCourseInput.setBounds(400, 98, 120, 25);
        selectCourseInput.setFont(new Font("Dialog", Font.BOLD, 15));
        deleteCourse.setBounds(300, 100, 80 ,20);
        deleteCourse.setFont(new Font("Dialog", Font.BOLD, 15));
        deleteCourseInput.setBounds(400, 138, 120, 25);
        deleteCourseInput.setFont(new Font("Dialog", Font.BOLD, 15));
        updateCourse.setBounds(400, 100, 100, 20);
        updateCourse.setFont(new Font("Dialog", Font.BOLD, 15));
        updateCourseInput.setBounds(420, 178, 120, 25);
        updateCourseInput.setFont(new Font("Dialog", Font.BOLD, 15));
        myCourse.setBounds(530, 100, 120, 20);
        myCourse.setFont(new Font("Dialog", Font.BOLD, 15));
        JTable table = new JTable();
        table.setBounds(300, 300, 100, 100);
        container.add(selectCourse);
        container.add(deleteCourse);
        //container.add(deleteCourseInput);
        container.add(updateCourse);
        //container.add(updateCourseInput);
        container.add(myCourse);
        //container.add(table);
        click();
        setVisible(true);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SelectCourseWindow();
    }

    public void click(){
        selectCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectCourseUI();
            }
        });

        deleteCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteCourseUI();
            }
        });

        updateCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateCourseUI();
            }
        });

        myCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FinishSelectCourseUI();
            }
        });

    }
}
