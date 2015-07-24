package hrc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SchoolView  extends JFrame {
    private final JButton saveButton = new JButton("Save");
    private final JButton clearButton = new JButton("Clear");
    private final JButton closeButton = new JButton("Close");
    private final JButton deleteButton = new JButton("Delete");
    private final JLabel schoolidLabel = new JLabel("ID: ");
    private final JTextField schoolidText = new JTextField();
    private final JLabel schoolnameLabel = new JLabel("Name: ");
    private final JTextField schoolnameText = new JTextField();
    private final JLabel addressLabel = new JLabel("Address: ");
    private final JTextField addressText = new JTextField();
    private final JLabel jobpositionLabel = new JLabel("Job Position: ");
    private final JTextField jobpositionText = new JTextField();
    private final JLabel yrsofexpLabel = new JLabel("Years of Experience: ");
    private final JTextField yrsofexpText = new JTextField();
    JPanel aPanel = new JPanel();
    JPanel bPanel = new JPanel();
    
    public String schoolID;
    public String schoolName;
    public String address;
    public String jobPosition;
    public int yrsOfExp;
    public String status;
    public String NewID;
        
    SchoolView()
    {
        this.setTitle(" ADD SCHOOL (HRC - Human Resource Consultancy Agency) ");
        Container bodypane = this.getContentPane();
        bodypane.setLayout(new GridLayout(0,2));    
        aPanel.setLayout(new GridLayout(1,2));
        bPanel.setLayout(new GridLayout(1,2));
        bodypane.add(schoolidLabel);
        bodypane.add(schoolidText);
        bodypane.add(schoolnameLabel);
        bodypane.add(schoolnameText);
        bodypane.add(addressLabel);
        bodypane.add(addressText);
        bodypane.add(jobpositionLabel);
        bodypane.add(jobpositionText);
        bodypane.add(yrsofexpLabel);
        bodypane.add(yrsofexpText);
        bodypane.add(aPanel);
        bodypane.add(bPanel);
        bPanel.add(closeButton);
        bPanel.add(saveButton);
        bPanel.add(clearButton);
        bPanel.add(deleteButton);
        this.pack();
        this.setLocationRelativeTo(null); 
        schoolnameText.grabFocus();
        
    }    

    public void GetAllData()
    {
        schoolID = this.schoolidText.getText();
        schoolName = this.schoolnameText.getText();
        address = this.addressText.getText();
        jobPosition = this.jobpositionText.getText();
        
        try
        {
            yrsOfExp = Integer.parseInt(this.yrsofexpText.getText());
        }
        catch (NumberFormatException ex)
        {
            yrsOfExp = 0;
        }
        
    }
    
    public void SetAllData()
    {
        schoolidText.setText(this.schoolID);
        schoolnameText.setText(this.schoolName);
        addressText.setText(this.address);
        jobpositionText.setText(this.jobPosition);
        yrsofexpText.setText(String.valueOf(this.yrsOfExp));
    }
    
    void addsaveButtonListener(ActionListener listenForSaveButton){
        saveButton.addActionListener(listenForSaveButton);
    }
    
    void addSchoolIDFocusListener(FocusListener listenForSchoolIDText){
        schoolidText.addFocusListener(listenForSchoolIDText);
    }    

    void addcloseButtonListener(ActionListener listenForCloseButton){
        closeButton.addActionListener(listenForCloseButton);
    }

    void addclearButtonListener(ActionListener listenForClearButton){
        clearButton.addActionListener(listenForClearButton);
    }
   
    void adddeleteButtonListener(ActionListener listenForDeleteButton){
        deleteButton.addActionListener(listenForDeleteButton);
    }
    
    public void GetNewID()
    {
        schoolidText.setText(this.NewID);
    }
    
    public void Close()
    {
        this.setVisible(false);
    }
    
    void Message(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }   
    
}
