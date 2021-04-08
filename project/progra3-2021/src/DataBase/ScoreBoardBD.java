/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Business.ScoreBoard;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;

/**
 *
 * @author TZ
 */
public class ScoreBoardBD {

    private ScoreBoard ScoreBoard;

    public ScoreBoardBD() {
    }

    public ScoreBoardBD(ScoreBoard ScoreBoard) {
        this.ScoreBoard = ScoreBoard;
    }

    public ScoreBoard getScoreBoard() {
        return ScoreBoard;
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
"INNER JOIN user ON score.userid = user.userid;");

        DataBaseConnection con = new DataBaseConnection(sbuf.toString(), true);
        con.setWaitForResults(true);
        con.ExecuteQuery();
        return con.getRs();
    }

}
