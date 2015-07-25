package Java_db_app;

import java.sql.*;

public class TeacherDataModel {
    private int ID;
    private String TeacherID;
    private String TeacherName;
    private String Telephone1;
    private String Qualification;
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

    public String getTeacherID()
    {
        return TeacherID;
    }
    
    public void setTeacherID(String pTeacherID)
    {
        TeacherID = pTeacherID;
    }

    public String getTeacherName()
    {
        return TeacherName;
    }

    public void setTeacherName(String pTeacherName)
    {
        TeacherName = pTeacherName;
    }
    
    public int getID()
    {
        return ID;
    }

    public String getTelephone1()
    {
        return Telephone1;
    }
    
    public void setTelephone1(String pTelephone1)
    {
        Telephone1 = pTelephone1;
    }
    
    public String getQualification()
    {
        return Qualification;
    }
    
    public void setQualification(String pQualification)
    {
        Qualification = pQualification;
    }
    
    
    public void Connect() throws SQLException, ClassNotFoundException  
    {
        
        String current = System.getProperty("user.dir");
        current += "/src/Java_db_app/hrc-school.accdb";
        //JOptionPane.showMessageDialog(null, current, "InfoBox: " + current, JOptionPane.INFORMATION_MESSAGE);
        //conn=DriverManager.getConnection("jdbc:ucanaccess:////Users//zlux//Documents//codeStream//Java//HRC-School//src//hrc//hrc-school.accdb;memory=false");
        String url = "jdbc:ucanaccess://" + current + ";memory=false";
        //JOptionPane.showMessageDialog(null, current, "InfoBox: " + current, JOptionPane.INFORMATION_MESSAGE);
        conn=DriverManager.getConnection(url);
    }
        
    public String GenerateID(String NextID)
    {
        String newID;
        
        newID = "T" + String.format("%05d", Integer.parseInt(NextID));
        
        return newID;
    }

    public void Add() throws Exception
    {
        this.Connect();

        String Query = "Insert into Teachers " +
                        "(TeacherID,TeacherName,Telephone1,Qualification,YrsOfExp) " +
                        "values " +
                        "('" + this.getTeacherID() + "','" + this.getTeacherName() + "','" + this.getTelephone1() + "','" + this.getQualification() + "'," + this.getYrsOfExp() + ")";

        Statement st =conn.createStatement();
        st.execute(Query);         
    }
    
    public void Remove() throws Exception
    {
        this.Connect();

        String query = "Delete from Teachers " + 
                       "Where TeacherID = '" + this.getTeacherID() + "' ";
        Statement st =conn.createStatement();
        st.execute(query);         
    }
    
    public void SaveChanges() throws Exception
    {
        this.Connect();

        String query = "Update Teachers " +
                       "Set TeacherID = '" + this.getTeacherID() + "', " + "TeacherName = '" + this.getTeacherName() + "', " + "Telephone1 = '" + this.getTelephone1() + "', " + "Qualification = '" + this.getQualification() + "', " + "YrsOfExp = " + this.getYrsOfExp() + " " +
                       "Where TeacherID = '" + this.getTeacherID() + "' ";
        Statement st =conn.createStatement();
        st.executeUpdate(query); 
    }

    public ResultSet Select() throws Exception
    {

        this.Connect();

        String Query = "Select * " +
                       "from Teachers ";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(Query);
        
        rs.next();

        return rs;
    }
    
    public ResultSet SelectNewID() throws Exception
    {

        this.Connect();

        String Query = "Select max(id) + 1 newid " +
                       "from Teachers ";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(Query);

        rs.next();
        
        return rs;
    }
    
    
    public ResultSet Select(String ID) throws Exception
    {
        this.Connect();

        String Query = "Select * " +
                       "from Teachers " +
                       "where TeacherID = '" + ID + "' ";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(Query);

        rs.next();
        
        return rs;
    }
    
    public Boolean IsTeacherRecordExist(String ID) throws Exception
    {

        this.Connect();

        String Query = "Select count(*) cnt " +
                       "from Teachers " +
                       "where TeacherID = '" + ID + "'";

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
