
package hrc;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class HRCView extends JFrame{
    private final JButton schoolButtonadd = new JButton("Add School");
    private final JButton teacherButtonadd = new JButton("Add Teacher");
    private final JButton schoolButtonview = new JButton("View School");
    private final JButton teacherButtonview = new JButton("View Teacher");
    
    private JLabel picLabel;

    JMenuBar menuMenuBar = new JMenuBar();
    JLabel pad1 = new JLabel("");
    JLabel pad2 = new JLabel("");
    JLabel pad3 = new JLabel("");
    JLabel pad4 = new JLabel("");
    
    HRCView()
    {
	this.setTitle("HRC - Human Resource Consultancy Agency");
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        JPanel body = new JPanel();
        JPanel footer = new JPanel();

        Container contentpane = this.getContentPane();
        contentpane.setLayout(new GridLayout(2,1));    
        
        body.setLayout(new GridLayout(1,1));
        footer.setLayout(new GridLayout(3,4));
        
        leftPanel.setLayout(new GridLayout(1,2));
        rightPanel.setLayout(new GridLayout(1,2));
        
        
        this.setJMenuBar(menuMenuBar);
               
        leftPanel.add(schoolButtonadd);
        leftPanel.add(teacherButtonadd);
        rightPanel.add(schoolButtonview);
        rightPanel.add(teacherButtonview);
        
        footer.add(pad1);
        footer.add(pad2);
        footer.add(pad3);
        footer.add(pad4);
        footer.add(leftPanel);
        footer.add(rightPanel);
        
        contentpane.add(body);
        contentpane.add(footer);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        this.pack();
        this.setLocationRelativeTo(null);

    }
        
    void addschooladdButtonListener(ActionListener listenForschoolButton){
        schoolButtonadd.addActionListener(listenForschoolButton);
    }
    
    void addteacheraddButtonListener(ActionListener listenForteacherButton){
        teacherButtonadd.addActionListener(listenForteacherButton);
    }
    
    void addschoolviewButtonListener(ActionListener listenForschoolButton){
        schoolButtonview.addActionListener(listenForschoolButton);
    }
    
    void addteacherviewButtonListener(ActionListener listenForteacherButton){
        teacherButtonview.addActionListener(listenForteacherButton);
    }

    void Message(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }   
    
    
}
