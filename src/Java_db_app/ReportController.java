package Java_db_app;

import java.sql.*;

public class ReportController {
    
    ReportController(ReportView preportView,SchoolDataModel pschoolModel)
    {
        try
        {
            ResultSet rs = pschoolModel.Select();
            
            preportView.displayDataOnGrid(rs);
        }
        catch(Exception ex)
        {
            preportView.displayErrorMessage(ex.getMessage());        
        }
            
    }
    
    ReportController(ReportView preportView,TeacherDataModel pteacherModel)
    {
        try
        {
            ResultSet rs = pteacherModel.Select();
            preportView.displayDataOnGrid(rs);
        }
        catch(Exception ex)
        {
            preportView.displayErrorMessage(ex.getMessage());
        }
        
    }


}
