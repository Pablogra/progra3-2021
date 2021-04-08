/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DataBase.ActivityDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class Activity {
    private int idActivity;
    private int idActivityType;
    private String Name;
    private String Description;
    private String Title;
    private int Points;

    public Activity() {
    }

    public Activity(int idActivity, String Name, String Description, String Title, int Points) {
        this.idActivity = idActivity;
        this.Name = Name;
        this.Description = Description;
        this.Title = Title;
        this.Points = Points;
    }
    
    public int getIdActivityType() {
        return idActivityType;
    }

    public void setIdActivityType(int idActivityType) {
        this.idActivityType = idActivityType;
    }

    public int getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(int idActivity) {
        this.idActivity = idActivity;
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

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public int getPoints() {
        return Points;
    }

    public void setPoints(int Points) {
        this.Points = Points;
    }
    
    public void Create() throws ClassNotFoundException, SQLException {
        ActivityDB activityDB = new ActivityDB();
        activityDB.setActivity(this);
        activityDB.Create();
    }
    
    public void Edit(Activity activity) throws ClassNotFoundException, SQLException {
        ActivityDB activityDB = new ActivityDB();
        activityDB.setActivity(activity);
        activityDB.Edit();
    }
    
    public void Edit() throws ClassNotFoundException, SQLException {        
        ActivityDB activityDB = new ActivityDB();
        activityDB.setActivity(this);
        activityDB.Edit();
    }
    
    public void Delete() throws ClassNotFoundException, SQLException {
        ActivityDB activityDB = new ActivityDB();
        activityDB.setActivity(this);
        activityDB.Delete();
    } 
    
    public ArrayList <Activity> List () throws ClassNotFoundException, SQLException {
        ActivityDB activity = new ActivityDB();
        ResultSet rs = activity.List();
        ArrayList<Activity> list = new ArrayList<Activity>();
        
        try {             
            while ( rs.next() ){
                Activity a = new Activity();
                a.setIdActivity(rs.getInt("IdActivity"));
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
            ActivityDB activity = new ActivityDB();
            activity.setActivity(this);
            ResultSet rs = activity.Find();
            
            rs.first();
            
            setIdActivity(rs.getInt("IdActivity"));
            setIdActivityType(rs.getInt("idActivityType"));
            setName(rs.getString("Name"));
            setDescription(rs.getString("Description"));               
            setPoints(rs.getInt("Points"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
    
}
