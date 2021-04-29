/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;


import DataBase.ScoreBoardBD;
import DataBase.UsersDB;
import Presentation.PanelActivityTypeAdd;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TZ
 */
public class ScoreBoard {

    private int idScore;
    private int idActivity;
    private int userID;
    private int points;
    private Date date;
    private String fullname;
    private User user;
    private Activity activity;

    public ScoreBoard() {
    }

    public ScoreBoard(int idScore, int idActivity, int userID, int points, Date date) {
        this.idScore = idScore;
        this.idActivity = idActivity;
        this.userID = userID;
        this.points = points;
        this.date = date;
        this.fullname = fullname;
    }

    public ScoreBoard(User user, Activity activity) {
        this.user = user;
        this.activity = activity;
    }
    

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    
    public int getIdScore() {
        return idScore;
    }

    public void setIdScore(int idScore) {
        this.idScore = idScore;
    }

    public int getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(int idActivity) {
        this.idActivity = idActivity;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<ScoreBoard> ShowTable() throws SQLException, ClassNotFoundException {
        ScoreBoardBD scoreBoard = new ScoreBoardBD();
        ResultSet rs = scoreBoard.ShowTable();
        ArrayList<ScoreBoard> list = new ArrayList<ScoreBoard>();

        try {
            while (rs.next()) {
                ScoreBoard a = new ScoreBoard();
                a.setFullname(rs.getString("fullName"));
                a.setIdActivity(rs.getInt("points"));
                a.setUserID(rs.getInt("userID"));
                a.setDate(rs.getDate("date"));
                a.setPoints(rs.getInt("points"));
                a.setIdScore(rs.getInt("idScore"));
                list.add(a);
                
            }
        } catch (Exception ex) {
            Logger.getLogger(PanelActivityTypeAdd.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    public ArrayList<ScoreBoard> ShowTableCurrentYear() throws SQLException, ClassNotFoundException {
        ScoreBoardBD scoreBoard = new ScoreBoardBD();
        ResultSet rs = scoreBoard.ShowTableCurrentYear();
        ArrayList<ScoreBoard> list = new ArrayList<ScoreBoard>();

        try {
            while (rs.next()) {
                ScoreBoard a = new ScoreBoard();
                a.setFullname(rs.getString("fullName"));
                a.setIdActivity(rs.getInt("points"));
                a.setUserID(rs.getInt("userID"));
                a.setDate(rs.getDate("date"));
                a.setPoints(rs.getInt("points"));
                a.setIdScore(rs.getInt("idScore"));
                list.add(a);
                
            }
        } catch (Exception ex) {
            Logger.getLogger(PanelActivityTypeAdd.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    
        public void Create() throws ClassNotFoundException, SQLException {
        ScoreBoardBD sbbd = new ScoreBoardBD();
        sbbd.setScoreBoard(this);
        sbbd.setUser(this.getUser());
        sbbd.setActivity(this.getActivity());
        sbbd.Create();
        
    }

}
