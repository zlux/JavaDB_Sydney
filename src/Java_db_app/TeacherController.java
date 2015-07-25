package Java_db_app;

import java.awt.event.*;
import java.sql.*;

public class TeacherController {
    private TeacherView teacherView;
    private TeacherDataModel teachermodel;
    
    TeacherController(TeacherView param1View,TeacherDataModel param2Model)
    {
        this.teacherView = param1View;
        this.teachermodel = param2Model;
        this.teacherView.addcloseButtonListener(new CloseButtonListener());
        this.teacherView.adddeleteButtonListener(new DeleteButtonListener());
        this.teacherView.addsaveButtonListener(new SaveButtonListener());
        this.teacherView.addclearButtonListener(new ClearButtonListener());
        this.teacherView.addTeacherIDFocusListener(new TeacherIDFocusListener());
    }
    
    
        class SaveButtonListener implements ActionListener
        {
             @Override
             public void actionPerformed(ActionEvent e) 
             {
                try 
                {
                    teacherView.GetAllData();
                    
                    teachermodel.setTeacherID(teacherView.TeacherID);
                    teachermodel.setTeacherName(teacherView.TeacherName);
                    teachermodel.setTelephone1(teacherView.Telephone1);
                    teachermodel.setQualification(teacherView.Qualification);
                    teachermodel.setYrsOfExp(teacherView.YrsOfExp);
                    
                    if (teachermodel.IsTeacherRecordExist(teacherView.TeacherID)==false)
                    {
                        teachermodel.Add();
                    }
                    else
                    {
                        teachermodel.SaveChanges();
                    }

                    RemoveAllText();
                    
                }
                catch(Exception ex)
                {
                    teacherView.Message(ex.getMessage());
                }
             }
             
             private void RemoveAllText()
             {
                teacherView.TeacherID = "";
                teacherView.TeacherName = "";
                teacherView.Telephone1 = "";
                teacherView.Qualification = "";
                teacherView.YrsOfExp = 0;
                teacherView.SetAllData();
                 
             }
             
        }
        
        class CloseButtonListener implements ActionListener
        {
             @Override
             public void actionPerformed(ActionEvent e) 
             {
                try 
                {
                    teacherView.Close();
                }
                catch(Exception ex)
                {
                    teacherView.Message(ex.getMessage());
                }
             }
        }

        
        class TeacherIDFocusListener implements FocusListener
        {
            public void focusGained(FocusEvent e) 
            {
                    try 
                    {

                        ResultSet rs = teachermodel.SelectNewID();
                        String NextID;
                        NextID = String.valueOf(rs.getInt("newid"));
                        
                        if ("0".equals(NextID))
                        {
                            NextID = "1";
                        }

                        String newID = teachermodel.GenerateID(NextID);
                        
                        teacherView.NewID = newID;
                        teacherView.GetNewID();
                        
                    }
                    catch(Exception ex)
                    {
                        teacherView.Message(ex.getMessage());
                    }
                
            }
            
            public void focusLost(FocusEvent e) 
            {
                teacherView.GetAllData();
                
                if (teacherView.TeacherID.length() !=0)
                {
                    try 
                    {
                        if (teachermodel.IsTeacherRecordExist(teacherView.TeacherID)==true)
                        {
                            ResultSet rs = teachermodel.Select(teacherView.TeacherID);
                            
                            teacherView.TeacherID = rs.getString("TeacherID");
                            teacherView.TeacherName = rs.getString("TeacherName");
                            teacherView.Telephone1 = rs.getString("Telephone1");
                            teacherView.Qualification = rs.getString("Qualification");

                            try
                            {
                                teacherView.YrsOfExp = rs.getInt("YrsOfExp");
                            }
                            catch (NumberFormatException ex)
                            {
                                teacherView.YrsOfExp = 0;
                            }
                            
                            teacherView.SetAllData();
                            

                        }

                    }
                    catch(Exception ex)
                    {
                        teacherView.Message(ex.getMessage());
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
                    teacherView.TeacherID = "";
                    teacherView.TeacherName = "";
                    teacherView.Telephone1 = "";
                    teacherView.Qualification = "";
                    teacherView.YrsOfExp = 0;
                    teacherView.SetAllData();
                }
                catch(Exception ex)
                {
                    teacherView.Message(ex.getMessage());
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
                    teacherView.GetAllData();

                    if (teachermodel.IsTeacherRecordExist(teacherView.TeacherID)==true)
                    {
                        teachermodel.setTeacherID(teacherView.TeacherID);
                        
                        teachermodel.Remove();
                        
                        RemoveAllText();
                        
                    }
                    
                }
                catch(Exception ex)
                {
                    teacherView.Message(ex.getMessage());
                }
             }
             
             private void RemoveAllText()
             {
                teacherView.TeacherName = "";
                teacherView.Telephone1 = "";
                teacherView.Qualification = "";
                teacherView.YrsOfExp = 0;
                teacherView.SetAllData();
                 
             }
        }
        
}
