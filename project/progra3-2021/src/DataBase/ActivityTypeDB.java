/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Business.ActivityType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;

/**
 *
 * @author pablo
 */
public class ActivityTypeDB {
    
    private ActivityType activityType;

    public ActivityTypeDB() {
    }
    
    public ActivityTypeDB(ActivityType activityType ) {
        this.activityType = activityType;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }
    
    public void Create() throws ClassNotFoundException, SQLException {
        
        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);               
        fmt.format("INSERT INTO ActivityType (Name, Description, Points) "
                + "VALUES ('%s','%s','%s');", activityType.getName(), activityType.getDescription(), activityType.getPoints());
        
        DataBaseConnection con = new DataBaseConnection(sbuf.toString(), false);
        con.ExecuteQuery();        
    }
    
    public ResultSet Find() throws ClassNotFoundException, SQLException
    {
        ActivityType a = this.getActivityType();
               
        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);
        
        fmt.format("SELECT idActivityType, Name, Description, Points FROM ActivityType  WHERE "
                + "idActivityType = %d;",activityType.getIdActivityType());
       
        DataBaseConnection con = new DataBaseConnection(sbuf.toString(), true);
        con.setWaitForResults(true);
        con.ExecuteQuery();
        return con.getRs();
    }
    
    public void Edit() throws ClassNotFoundException, SQLException
    {
        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);
        
        fmt.format("UPDATE ActivityType SET Name = '%s', Description = '%s', Points = %d "
                + "WHERE idActivityType = %d;",
                activityType.getName(),
                activityType.getDescription(),
                activityType.getPoints(),
                activityType.getIdActivityType());
       
        DataBaseConnection con = new DataBaseConnection(sbuf.toString(), false);        
        
        con.ExecuteQuery();        
    }
    
    public void Delete() throws ClassNotFoundException, SQLException
    {
        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);
        
        fmt.format("DELETE FROM ActivityType WHERE "
                + "idActivityType = %d;",activityType.getIdActivityType());
        
        DataBaseConnection con = new DataBaseConnection(sbuf.toString(), false);
        con.ExecuteQuery();
    }    
    
    public ResultSet List() throws ClassNotFoundException, SQLException
    {
        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);
        
        fmt.format("SELECT idActivityType, Name, Description, Points FROM ActivityType;");
                
        DataBaseConnection con = new DataBaseConnection(sbuf.toString(), true);
        con.setWaitForResults(true);
        con.ExecuteQuery();
        return con.getRs();
    }
}
