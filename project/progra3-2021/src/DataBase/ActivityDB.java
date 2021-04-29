/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Business.Activity;
import Business.ActivityType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;

/**
 *
 * @author pablo
 */
public class ActivityDB {
    
    private Activity activity;

    public ActivityDB() {
    }
    
    public ActivityDB(Activity activity ) {
        this.activity = activity;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
    
    public void Create() throws ClassNotFoundException, SQLException {
        
        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);               
        fmt.format("INSERT INTO Activity (idActivityType, Name, Description, Points) "
                + "VALUES (%d,'%s','%s',%d);", 
                activity.getIdActivityType(),
                activity.getName(),                
                activity.getDescription(),
                activity.getPoints());
        
        DataBaseConnection con = new DataBaseConnection(sbuf.toString(), false);
        con.ExecuteQuery();        
    }
    
    public ResultSet Find() throws ClassNotFoundException, SQLException
    {
        Activity a = this.getActivity();
               
        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);
        
        fmt.format("SELECT idActivity, idActivityType, Name, Description, Points FROM Activity  WHERE "
                + "idActivity = %d;",activity.getIdActivity());
       
        DataBaseConnection con = new DataBaseConnection(sbuf.toString(), true);
        con.setWaitForResults(true);
        con.ExecuteQuery();
        return con.getRs();
    }
    
    public void Edit() throws ClassNotFoundException, SQLException
    {
        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);
        
        fmt.format("UPDATE Activity SET Name = '%s', Description = '%s', Points = %d "
                + "WHERE idActivity = %d;",
                activity.getName(),
                activity.getDescription(),
                activity.getPoints(),
                activity.getIdActivity());
       
        DataBaseConnection con = new DataBaseConnection(sbuf.toString(), false);        
        
        con.ExecuteQuery();        
    }
    
    public void Delete() throws ClassNotFoundException, SQLException
    {
        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);
        
        fmt.format("DELETE FROM ActivityType WHERE "
                + "idActivity = %d;",activity.getIdActivity());
        
        DataBaseConnection con = new DataBaseConnection(sbuf.toString(), false);
        con.ExecuteQuery();
    }    
    
    public ResultSet List() throws ClassNotFoundException, SQLException
    {
        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);
        
        fmt.format("SELECT idActivity, idActivityType, Name, Description, Points FROM Activity;");
                
        DataBaseConnection con = new DataBaseConnection(sbuf.toString(), true);
        con.setWaitForResults(true);
        con.ExecuteQuery();
        return con.getRs();
    }
}
