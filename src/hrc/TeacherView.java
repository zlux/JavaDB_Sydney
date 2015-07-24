package hrc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TeacherView   extends JFrame {
    private final JButton closeButton = new JButton("Close");
    private final JButton deleteButton = new JButton("Delete");
    private final JButton saveButton = new JButton("Save");
    private final JButton clearButton = new JButton("Clear");
    private final JLabel teacherIDLabel = new JLabel("ID: ");
    private final JTextField teacherIDText = new JTextField();
    private final JLabel teacherNameLabel = new JLabel("Name: ");
    private final JTextField teacherNameText = new JTextField();
    private final JLabel telephone1Label = new JLabel("Telephone: ");
    private final JTextField telephone1Text = new JTextField();
    private final JLabel qualificationLabel = new JLabel("Qualification: ");
    private final JTextField qualificationText = new JTextField();
    private final JLabel yrsofexpLabel = new JLabel("Yrs. of Exp.: ");
    private final JTextField yrsofexpText = new JTextField();
    JPanel aPanel = new JPanel();
    JPanel bPanel = new JPanel();

    public String TeacherID;
    public String TeacherName;
    public String Telephone1;
    public String Qualification;
    public int YrsOfExp;
    public String status;
    public String NewID;
    
    
    TeacherView()
    {
        
		this.setTitle(" ADD TEACHER (HRC - Human Resource Consultancy Agency) ");
        Container bodypane = this.getContentPane();
        bodypane.setLayout(new GridLayout(0,2));    
        aPanel.setLayout(new GridLayout(1,2));
        bPanel.setLayout(new GridLayout(1,2));
        bodypane.add(teacherIDLabel);
        bodypane.add(teacherIDText);
        bodypane.add(teacherNameLabel);
        bodypane.add(teacherNameText);
        bodypane.add(telephone1Label);
        bodypane.add(telephone1Text);
        bodypane.add(qualificationLabel);
        bodypane.add(qualificationText);
        bodypane.add(yrsofexpLabel);
        bodypane.add(yrsofexpText);
        bodypane.add(aPanel);
        bodypane.add(bPanel);
        bPanel.add(closeButton);
        bPanel.add(saveButton);
        bPanel.add(deleteButton);
        bPanel.add(clearButton);
        this.pack();
        this.setLocationRelativeTo(null); 
        teacherNameText.grabFocus();
    }
    
    public void GetAllData()
    {
    
        Qualification = this.qualificationText.getText(); 
        TeacherName = this.teacherNameText.getText(); 
        TeacherID = this.teacherIDText.getText(); 
        Telephone1 = this.telephone1Text.getText(); 
        
        try
        {
            YrsOfExp = Integer.parseInt(this.yrsofexpText.getText());
        }
        catch (NumberFormatException ex)
        {
            YrsOfExp = 0;
        }
        
    }
    
    public void SetAllData()
    {
        qualificationText.setText(this.Qualification);
        teacherNameText.setText(this.TeacherName);
        teacherIDText.setText(this.TeacherID);
        telephone1Text.setText(this.Telephone1);
        yrsofexpText.setText(String.valueOf(this.YrsOfExp));
    }

    void addTeacherIDFocusListener(FocusListener listenForTeacherIDText){
        teacherIDText.addFocusListener(listenForTeacherIDText);
    }

    void addclearButtonListener(ActionListener listenForClearButton){
        clearButton.addActionListener(listenForClearButton);
    }

    void addsaveButtonListener(ActionListener listenForSaveButton){
        saveButton.addActionListener(listenForSaveButton);
    }
    
    void adddeleteButtonListener(ActionListener listenForDeleteButton){
        deleteButton.addActionListener(listenForDeleteButton);
    }

    void addcloseButtonListener(ActionListener listenForCloseButton){
        closeButton.addActionListener(listenForCloseButton);
    }
       
    public void GetNewID()
    {
        teacherIDText.setText(this.NewID);
    }
    
    public void Close()
    {
        this.setVisible(false);
    }

    void Message(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }   
    
}
