package hrc;

import java.sql.*;
import javax.swing.JOptionPane;

public class SchoolDataModel {
    private String SchoolID;
    private String SchoolName;
    private int ID; 
    private String Address;
    private String JobPosition;
    private int YrsOfExp;
    private Connection conn;

    public int getYrsOfExp()
    {
        return YrsOfExp;
    }
    
    public void setYrsOfExp(int pYrsOfExp)
    {
        YrsOfExp = pYrsOfExp;
    }

    public String getSchoolName()
    {
        return SchoolName;
    }
    
    public void setSchoolName(String pSchoolName)
    {
        SchoolName = pSchoolName;
    }
    
    public String getSchoolID()
    {
        return SchoolID;
    }
    
    public void setSchoolID(String pSchoolID)
    {
        SchoolID = pSchoolID;
    }
    
    public int getID()
    {
        return ID;
    }

    public String getAddress()
    {
        return Address;
    }
    
    public void setAddress(String pAddress)
    {
        Address = pAddress;
    }
    
    public String getJobPosition()
    {
        return JobPosition;
    }
    
    public void setJobPosition(String pJobPosition)
    {
        JobPosition = pJobPosition;
    }
    
    public void Connect() throws SQLException, ClassNotFoundException  
    {
        String current = System.getProperty("user.dir");
        current += "/src/hrc/hrc-school.accdb";
        //JOptionPane.showMessageDialog(null, current, "InfoBox: " + current, JOptionPane.INFORMATION_MESSAGE);
        //conn=DriverManager.getConnection("jdbc:ucanaccess:////Users//zlux//Documents//codeStream//Java//HRC-School//src//hrc//hrc-school.accdb;memory=false");
        String url = "jdbc:ucanaccess://" + current + ";memory=false";
        //JOptionPane.showMessageDialog(null, current, "InfoBox: " + current, JOptionPane.INFORMATION_MESSAGE);
        conn=DriverManager.getConnection(url);
    }
    
    public String GenerateID(String NextID)
    {
        String newID;
        
        newID = "S" + String.format("%05d", Integer.parseInt(NextID));
        
        return newID;
    }
    
    public void Add() throws Exception
    {
        this.Connect();

        String Query = "Insert into Schools " +
                        "(SchoolID,SchoolName,Address,JobPosition,YrsOfExp) " +
                        "values " +
                        "('" + this.getSchoolID() + "','" + this.getSchoolName() + "','" + this.getAddress() + "','" + this.getJobPosition() + "'," + this.getYrsOfExp() + ")";

        Statement st =conn.createStatement();
        st.execute(Query);         
    }
    
    public void Remove() throws Exception
    {
        this.Connect();

        String query = "Delete from Schools " + 
                       "Where SchoolID = '" + this.getSchoolID() + "' ";
        Statement st =conn.createStatement();
        st.execute(query);         
    }
    
    public void SaveChanges() throws Exception
    {
        this.Connect();

        String query = "Update Schools " +
                       "Set SchoolID = '" + this.getSchoolID() + "', " +"SchoolName = '" + this.getSchoolName() + "', " + "Address = '" + this.getAddress() + "', " + "JobPosition = '" + this.getJobPosition() + "', " + "YrsOfExp = " + this.getYrsOfExp() + " " +
                       "Where SchoolID = '" + this.getSchoolID() + "' ";
        Statement st =conn.createStatement();
        st.executeUpdate(query); 
    }

    public ResultSet Select() throws Exception
    {        
        this.Connect();

        String Query = "Select * " +
                       "from Schools ";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(Query);

        rs.next();
        
        return rs;
    }
    
    public ResultSet SelectNewID() throws Exception
    {
        this.Connect();

        String Query = "Select max(id) + 1 newid " +
                       "from Schools ";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(Query);

        rs.next();
        
        return rs;
    }

    public ResultSet Select(String ID) throws Exception
    {
        this.Connect();

        String Query = "Select * " +
                       "from Schools " +
                       "where SchoolID = '" + ID + "' ";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(Query);

        rs.next();
        
        return rs;
    }

    public Boolean IsSchoolRecordExist(String ID) throws Exception
    {
        this.Connect();

        String Query = "Select count(*) cnt " +
                       "from Schools " +
                       "where SchoolID = '" + ID + "'";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(Query);
        
        rs.next();
        
        int cnt = rs.getInt("cnt");
        
        if (cnt==0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
}
