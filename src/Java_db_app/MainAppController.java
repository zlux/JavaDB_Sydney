package Java_db_app;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class MainAppController {
    private final MainAppView hrcView;
    
    public MainAppController(MainAppView param1View)
    {
        this.hrcView = param1View;

        this.hrcView.addschooladdButtonListener(new SchoolButtonAddListener());
        this.hrcView.addteacheraddButtonListener(new TeacherAddButtonListener());
        this.hrcView.addschoolviewButtonListener(new SchoolButtonViewListener());
        this.hrcView.addteacherviewButtonListener(new TeacherViewButtonListener());
    }
    
    class SchoolButtonAddListener implements ActionListener
    {
         @Override
         public void actionPerformed(ActionEvent e) 
         {
            try 
            {

                SchoolView schoolView = new SchoolView();
                SchoolDataModel schoolModel = new SchoolDataModel();
                SchoolController schoolController = new SchoolController(schoolView,schoolModel);
                schoolView.setVisible(true);
                
            }
            catch(Exception ex)
            {
                hrcView.Message(ex.getMessage());
            }
         }
    }

    class SchoolButtonViewListener implements ActionListener
    {
         @Override
         public void actionPerformed(ActionEvent e) 
         {
            try 
            {

                ReportView reportview = new ReportView("RECORDS OF SCHOOL (HRC - Human Resource Consultancy Agency)");
                SchoolDataModel schoolModel = new SchoolDataModel();
                ReportController reportController = new ReportController(reportview,schoolModel);
                reportview.setVisible(true);
                
            }
            catch(Exception ex)
            {
                hrcView.Message(ex.getMessage());
            }
         }
    }

    class TeacherAddButtonListener implements ActionListener
    {
         @Override
         public void actionPerformed(ActionEvent e) 
         {
            try 
            {
                TeacherView teacherView = new TeacherView();
                TeacherDataModel teacherModel = new TeacherDataModel();
                TeacherController teacherController = new TeacherController(teacherView,teacherModel);
                teacherView.setVisible(true);
                
            }
            catch(Exception ex)
            {
                hrcView.Message(ex.getMessage());
            }
         }
    }
    
    class TeacherViewButtonListener implements ActionListener
    {
         @Override
         public void actionPerformed(ActionEvent e) 
         {
            try 
            {
                ReportView reportview = new ReportView("RECORDS OF TEACHERS (HRC - Human Resource Consultancy Agency)");
                TeacherDataModel teacherModel = new TeacherDataModel();
                ReportController reportController = new ReportController(reportview,teacherModel);
                reportview.setVisible(true);
                
            }
            catch(Exception ex)
            {
                hrcView.Message(ex.getMessage());
            }
         }
    }
}
