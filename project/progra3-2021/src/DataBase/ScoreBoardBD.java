/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Business.Activity;
import Business.ScoreBoard;
import Business.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;

/**
 *
 * @author TZ
 */
public class ScoreBoardBD {

    private ScoreBoard ScoreBoard;
    private Activity Activity;
    private User User;

    public ScoreBoardBD() {
    }

    public ScoreBoardBD(ScoreBoard ScoreBoard, Activity Activity, User User) {
        this.ScoreBoard = ScoreBoard;
        this.Activity = Activity;
        this.User = User;
    }

    public ScoreBoardBD(ScoreBoard ScoreBoard) {
        this.ScoreBoard = ScoreBoard;
    }

    public ScoreBoard getScoreBoard() {
        return ScoreBoard;
    }

    public Activity getActivity() {
        return Activity;
    }

    public void setActivity(Activity Activity) {
        this.Activity = Activity;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User = User;
    }

    public void setScoreBoard(ScoreBoard ScoreBoard) {
        this.ScoreBoard = ScoreBoard;
    }

    public ResultSet ShowTable() throws ClassNotFoundException, SQLException {
        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);

        fmt.format("SELECT score.idScore,\n" +
"    score.idActivity,\n" +
"    score.userID,\n" +
"    score.date,\n" +
"    score.points,\n" +
"    user.fullname\n" +
"FROM score \n" +
"INNER JOIN user ON score.userid = user.userid ORDER BY score.points desc;");

        DataBaseConnection con = new DataBaseConnection(sbuf.toString(), true);
        con.setWaitForResults(true);
        con.ExecuteQuery();
        return con.getRs();
        
    }
    
        public ResultSet ShowTableCurrentYear() throws ClassNotFoundException, SQLException {
        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);

        fmt.format("SELECT score.idScore,\n" +
"    score.idActivity,\n" +
"    score.userID,\n" +
"    score.date,\n" +
"    score.points,\n" +
"    user.fullname\n" +
"FROM score \n" +
"INNER JOIN user ON score.userid = user.userid WHERE year(score.date) = YEAR(CURRENT_DATE()) ORDER BY score.points desc;");

        DataBaseConnection con = new DataBaseConnection(sbuf.toString(), true);
        con.setWaitForResults(true);
        con.ExecuteQuery();
        return con.getRs();
    }
        
      public void Create() throws ClassNotFoundException, SQLException {

        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);
        fmt.format("INSERT INTO score (idActivity, userID, date,points) "
                + "VALUES (%d,%d,%s,%d);",
                Activity.getIdActivity(), User.getUserID(), "CURDATE()", Activity.getPoints());

        DataBaseConnection con = new DataBaseConnection(sbuf.toString(), false);
        con.ExecuteQuery();
        
    }   
        
        
        
// INSERT INTO `proyectoprogra`.`score`(`idActivity`,`userID`,`date`,`points`) VALUES (idActivity, userID, CURDATE(), points);
}
