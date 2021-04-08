/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;


import DataBase.ScoreBoardBD;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

}
