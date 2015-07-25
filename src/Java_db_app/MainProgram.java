package Java_db_app;

import java.sql.*;

public class MainProgram {

    public static void main(String[] args) 
    {
        MainAppView hrcView = new MainAppView();
        MainAppController hrcController = new MainAppController(hrcView);
        hrcView.setVisible(true);
    }
    
}
