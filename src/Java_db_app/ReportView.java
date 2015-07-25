package Java_db_app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.*;

public class ReportView extends JFrame {
    JLabel summaryLabel = new JLabel();
    
    ReportView(String Title)
    {
        this.setTitle(Title);
    }
    
    void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }   

    public void displayDataOnGrid(ResultSet rs)
    {
        try
        {
            JTable table = new JTable(buildTableModel(rs));

            add(new JScrollPane(table), BorderLayout.CENTER);
            
            summaryLabel.setText("Total Number: " + String.valueOf(table.getRowCount()));
            
            add(summaryLabel, BorderLayout.SOUTH);
            this.pack();
            this.setLocationRelativeTo(null); 

        }
        catch(SQLException ex)
        {
            displayErrorMessage(ex.getMessage());
        }
    }
    
    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);
    }

}
