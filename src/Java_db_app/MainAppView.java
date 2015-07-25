
package Java_db_app;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class MainAppView extends JFrame{
    private final JButton schoolButtonadd = new JButton("Add School");
    private final JButton teacherButtonadd = new JButton("Add Teacher");
    private final JButton schoolButtonview = new JButton("View School");
    private final JButton teacherButtonview = new JButton("View Teacher");
    private final JLabel lb_banner = new javax.swing.JLabel();
    
    MainAppView()
    {
	this.setTitle("Java Database App - Java Database for Human Resources");
         
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(schoolButtonadd)
                    .addComponent(schoolButtonview)
                    .addComponent(teacherButtonadd)
                    .addComponent(teacherButtonview))
                .addGap(67, 67, 67)
                .addComponent(lb_banner, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_banner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(schoolButtonadd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(schoolButtonview)
                        .addGap(58, 58, 58)
                        .addComponent(teacherButtonadd)
                        .addGap(27, 27, 27)
                        .addComponent(teacherButtonview)))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        schoolButtonadd.getAccessibleContext().setAccessibleName("schoolButtonadd");

        pack();                    

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
