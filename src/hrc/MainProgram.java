package hrc;

import java.sql.*;

public class MainProgram {

    public static void main(String[] args) 
    {
        HRCView hrcView = new HRCView();
        HRCController hrcController = new HRCController(hrcView);
        hrcView.setVisible(true);
    }
    
}
