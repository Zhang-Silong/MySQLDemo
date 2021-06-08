/*
package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    JLabel title = new JLabel("选课系统");
    JLabel account = new JLabel("账号");
    JLabel password = new JLabel("密码");
    JButton login = new JButton("登录");

    JTextField accountInput = new JTextField();
    //JTextField passwordInput = new JTextField();
    JPasswordField passwordInput = new JPasswordField();


    public MainWindow(){
        //jLabel2.setFont(new Font("Dialog", Font.BOLD, 20));
        setTitle("数据库综合实验");
        setLayout(null);

        Container container = getContentPane();
        title.setBounds(380, 40, 120, 20);
        title.setFont(new Font("Dialog", Font.BOLD, 20));
        account.setBounds(320, 140, 80, 20);
        account.setFont(new Font("Dialog", Font.BOLD, 15));
        accountInput.setBounds(360, 142, 120, 20);
        password.setBounds(320, 180, 80, 20);
        password.setFont(new Font("Dialog", Font.BOLD, 15));
        passwordInput.setBounds(360, 182, 120, 20);
        login.setBounds(375, 240, 80, 20);
        login.setFont(new Font("Dialog", Font.BOLD, 15));
        click();
        container.add(title);
        container.add(account);
        container.add(accountInput);
        container.add(password);
        container.add(passwordInput);
        container.add(login);
        setVisible(true);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MainWindow();
    }

    //监听事件
    public void click(){
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = String.valueOf(passwordInput.getPassword()).trim();
                if (accountInput.getText().equals("1900301437") && password.equals("zsl")){
                    setVisible(false);
                    new SelectCourseWindow();
                }else {
                    new TipsDialog<MainWindow>(MainWindow.this, "输入异常","账号或密码输入错误,请重新输入!").setVisible(true);
                }
            }
        });
    }
}
*/
