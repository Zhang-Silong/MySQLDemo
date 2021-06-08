package ui;

import javax.swing.*;
import java.awt.*;
public class TipsDialog<T> extends JDialog {

    public TipsDialog(T frame, String title, String msg){
        super((Frame) frame, title, true);
        Container container = getContentPane();
        container.add(new JLabel(msg));
        setLocationRelativeTo(null);
        setBounds(200, 200 , 280, 100);
    }
}
