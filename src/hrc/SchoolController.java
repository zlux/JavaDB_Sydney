package hrc;

import java.awt.event.*;
import java.sql.*;

public class SchoolController {
    private SchoolView schoolView;
    private SchoolDataModel schoolmodel;
    
    public SchoolController(SchoolView pschoolView,SchoolDataModel pschoolModel)
    {
        this.schoolView = pschoolView;
        this.schoolmodel = pschoolModel;
        this.schoolView.addcloseButtonListener(new CloseButtonListener());
        this.schoolView.adddeleteButtonListener(new DeleteButtonListener());
        this.schoolView.addsaveButtonListener(new SaveButtonListener());
        this.schoolView.addclearButtonListener(new ClearButtonListener());
        this.schoolView.addSchoolIDFocusListener(new SchoolIDFocusListener());
    }
    
        class SaveButtonListener implements ActionListener
        {
             @Override
             public void actionPerformed(ActionEvent e) 
             {
                try 
                {
                    schoolView.GetAllData();
                    
                    schoolmodel.setSchoolID(schoolView.schoolID);
                    schoolmodel.setSchoolName(schoolView.schoolName);
                    schoolmodel.setAddress(schoolView.address);
                    schoolmodel.setJobPosition(schoolView.jobPosition);
                    schoolmodel.setYrsOfExp(schoolView.yrsOfExp);
                    
                    if (schoolmodel.IsSchoolRecordExist(schoolView.schoolID)==false)
                    {
                        schoolmodel.Add();
                    }
                    else
                    {
                        schoolmodel.SaveChanges();
                    }

                    RemoveAllText();
                    
                }
                catch(Exception ex)
                {
                    schoolView.Message(ex.getMessage());
                }
             }
             
             private void RemoveAllText()
             {
                schoolView.schoolID = "";
                schoolView.schoolName = "";
                schoolView.address = "";
                schoolView.jobPosition = "";
                schoolView.yrsOfExp = 0;
                schoolView.SetAllData();
                 
             }
        }
    
        class CloseButtonListener implements ActionListener
        {
             @Override
             public void actionPerformed(ActionEvent e) 
             {
                try 
                {
                    schoolView.Close();
                }
                catch(Exception ex)
                {
                    schoolView.Message(ex.getMessage());
                }
             }
        }
        

        class SchoolIDFocusListener implements FocusListener
        {
            public void focusGained(FocusEvent e) 
            {
                    try 
                    {

                        ResultSet rs = schoolmodel.SelectNewID();
                        String NextID;
                        NextID = String.valueOf(rs.getInt("newid"));
                        
                        if ("0".equals(NextID))
                        {
                            NextID = "1";
                        }

                        String newID = schoolmodel.GenerateID(NextID);
                        
                        schoolView.NewID = newID;
                        schoolView.GetNewID();
                        
                    }
                    catch(Exception ex)
                    {
                        schoolView.Message(ex.getMessage());
                    }
                
            }
            
            public void focusLost(FocusEvent e) 
            {
                schoolView.GetAllData();
                
                if (schoolView.schoolID.length() !=0)
                {
                    try 
                    {
                        if (schoolmodel.IsSchoolRecordExist(schoolView.schoolID)==true)
                        {
                            ResultSet rs = schoolmodel.Select(schoolView.schoolID);
                            
                            schoolView.schoolID = rs.getString("School ID");
                            schoolView.schoolName = rs.getString("School Name");
                            schoolView.address = rs.getString("Address");
                            schoolView.jobPosition = rs.getString("Job Position");

                            try
                            {
                                schoolView.yrsOfExp = rs.getInt("Years of Experience");
                            }
                            catch (NumberFormatException ex)
                            {
                                schoolView.yrsOfExp = 0;
                            }
                            
                            schoolView.SetAllData();
                            

                        }

                    }
                    catch(Exception ex)
                    {
                        schoolView.Message(ex.getMessage());
                    }

                }
                
                
            }
        }

        class ClearButtonListener implements ActionListener
        {
             @Override
             public void actionPerformed(ActionEvent e) 
             {
                try 
                {

                    schoolView.schoolID = "";
                    schoolView.schoolName = "";
                    schoolView.address = "";
                    schoolView.jobPosition = "";
                    schoolView.yrsOfExp = 0;
                    schoolView.SetAllData();
                }
                catch(Exception ex)
                {
                    schoolView.Message(ex.getMessage());
                }
             }
        }

        class DeleteButtonListener implements ActionListener
        {
             @Override
             public void actionPerformed(ActionEvent e) 
             {
                try 
                {
                    schoolView.GetAllData();

                    if (schoolmodel.IsSchoolRecordExist(schoolView.schoolID)==true)
                    {
                        schoolmodel.setSchoolID(schoolView.schoolID);
                        
                        schoolmodel.Remove();
                        
                        RemoveAllText();
                        
                    }
                    
                }
                catch(Exception ex)
                {
                    schoolView.Message(ex.getMessage());
                }
             }
             
            private void RemoveAllText()
             {
                schoolView.schoolID = "";
                schoolView.schoolName = "";
                schoolView.address = "";
                schoolView.jobPosition = "";
                schoolView.yrsOfExp = 0;
                schoolView.SetAllData();
                 
             }             
        }
        
}
