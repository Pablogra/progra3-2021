/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Business.User;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.Formatter;

/**
 *
 * @author Felipe
 */
public class UsersDB {

    private User user;

    public UsersDB() {
    }

    public UsersDB(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void Create() throws ClassNotFoundException, SQLException {

        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);
        fmt.format("INSERT INTO User (username, fullname, email,password,status,isAdmin) "
                + "VALUES ('%s','%s','%s','%s',%b,%b);", user.getUserName(), user.getFullName(), user.getEmail(), user.getPassword(), user.isStatus(), user.isIsAdmin());

        DataBaseConnection con = new DataBaseConnection(sbuf.toString(), false);
        con.ExecuteQuery();
    }

    public ResultSet Find() throws ClassNotFoundException, SQLException {
        User u = this.getUser();
        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);

        fmt.format("SELECT userid,username, fullname, email,password,status,isAdmin FROM User  WHERE "
                + "userId = %d;", u.getUserID());

        DataBaseConnection con = new DataBaseConnection(sbuf.toString(), true);
        con.setWaitForResults(true);
        con.ExecuteQuery();
        return con.getRs();
    }

      public ResultSet FindByCredentials() throws ClassNotFoundException, SQLException {
        User u = this.getUser();
        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);

        fmt.format("SELECT username, fullname, email,password,status, isAdmin FROM User  WHERE "
                + "username = '%s' AND password = '%s';", u.getUserName(),u.getPassword());

        DataBaseConnection con = new DataBaseConnection(sbuf.toString(), true);
        con.setWaitForResults(true);
        con.ExecuteQuery();
        return con.getRs();
    }
    
    public ResultSet Edit() throws ClassNotFoundException, SQLException {
        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);

        fmt.format("UPDATE User SET username = '%s',fullname = '%s', email = '%s', password = '%s', status = %b, isAdmin = %b "
                + "WHERE userId = %d;",
                user.getUserName(),
                user.getFullName(),
                user.getEmail(),
                user.getPassword(),
                user.isStatus(),
                user.isIsAdmin(),
                user.getUserID());

        DataBaseConnection con = new DataBaseConnection(sbuf.toString(), false);
        con.ExecuteQuery();
        return con.getRs();
    }

    public void Delete() throws ClassNotFoundException, SQLException {
        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);

        fmt.format("DELETE FROM User WHERE "
                + "userId = %d;", user.getUserID());

        DataBaseConnection con = new DataBaseConnection(sbuf.toString(), false);
        con.ExecuteQuery();
    }

    public ResultSet List() throws ClassNotFoundException, SQLException {
        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);

        fmt.format("SELECT userId,username, fullname, email,password,status,isAdmin FROM User;");

        DataBaseConnection con = new DataBaseConnection(sbuf.toString(), true);
        con.setWaitForResults(true);
        con.ExecuteQuery();
        return con.getRs();
    }

}
