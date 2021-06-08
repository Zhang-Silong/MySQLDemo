package util;

import org.w3c.dom.CDATASection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Author ZSL
 * Date 2021/5/27 3:33
 */

public class MySQLUtils {

    public static final int count = 20;

    public static JTable limitEdit(String[][] tableData, String[] courseName){
        DefaultTableModel model = new DefaultTableModel(tableData, courseName){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        return new JTable(model);
    }


}
