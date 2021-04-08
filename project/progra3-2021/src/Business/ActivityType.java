/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DataBase.ActivityTypeDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class ActivityType {
    
    private int idActivityType;
    private String Name;
    private String Description;
    private int Points;

    public ActivityType() {
    }

    public ActivityType(int idActivityType, String Name, String Description, int Points) {
        this.idActivityType = idActivityType;
        this.Name = Name;
        this.Description = Description;
        this.Points = Points;
    }    
    
    public int getIdActivityType() {
        return idActivityType;
    }

    public void setIdActivityType(int idActivityType) {
        this.idActivityType = idActivityType;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getPoints() {
        return Points;
    }

    public void setPoints(int Points) {
        this.Points = Points;
    }
    
    public void Create() throws ClassNotFoundException, SQLException {
        ActivityTypeDB activityTypeDB = new ActivityTypeDB();
        activityTypeDB.setActivityType(this);
        activityTypeDB.Create();
    }
    
    public void Edit(ActivityType activityType) throws ClassNotFoundException, SQLException {
        ActivityTypeDB activityTypeDB = new ActivityTypeDB();
        activityTypeDB.setActivityType(activityType);
        activityTypeDB.Edit();
    }
    
    public void Edit() throws ClassNotFoundException, SQLException {        
        ActivityTypeDB activityTypeDB = new ActivityTypeDB();
        activityTypeDB.setActivityType(this);
        activityTypeDB.Edit();
    }
    
    public void Delete() throws ClassNotFoundException, SQLException {
        ActivityTypeDB activityTypeDB = new ActivityTypeDB();
        activityTypeDB.setActivityType(this);
        activityTypeDB.Delete();
    } 
    
    public ArrayList <ActivityType> List () throws ClassNotFoundException, SQLException {
        ActivityTypeDB activityType = new ActivityTypeDB();
        ResultSet rs = activityType.List();
        ArrayList<ActivityType> list = new ArrayList<ActivityType>();
        
        try {             
            while ( rs.next() ){
                ActivityType a = new ActivityType();
                a.setIdActivityType(rs.getInt("IdActivityType"));
                a.setName(rs.getString("Name"));
                a.setDescription(rs.getString("Description"));
                a.setPoints(rs.getInt("Points"));
                list.add(a);
            }            
        } catch (Exception ex) {
            Logger.getLogger(ActivityType.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        return list;
    }
    
    public void Find() {
        try {
            ActivityTypeDB activity = new ActivityTypeDB();
            activity.setActivityType(this);
            ResultSet rs = activity.Find();
            
            try {
                rs.first();
                
                setIdActivityType(rs.getInt("IdActivityType"));
                setName(rs.getString("Name"));
                setDescription(rs.getString("Description"));
                setPoints(rs.getInt("Points"));
                
            } catch (SQLException e) {
                String error = e.getMessage();
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ActivityType.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
