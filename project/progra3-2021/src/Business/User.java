/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DataBase.UsersDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felipe
 */
public class User {

    private String userName;
    private String fullName;
    private String email;
    private String password;
    private boolean status;

    public User(String userName, String fullName, String email, String password, boolean status) {
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void Create() throws ClassNotFoundException, SQLException {
        UsersDB udb = new UsersDB();
        udb.setUser(this);
        udb.Create();
    }

    public void Edit() throws ClassNotFoundException, SQLException {
        UsersDB udb = new UsersDB();
        udb.setUser(this);
        udb.Edit();

    }

    public void Delete() throws ClassNotFoundException, SQLException {
        UsersDB udb = new UsersDB();
        udb.setUser(this);
        udb.Delete();

    }

    public ArrayList<User> List() throws ClassNotFoundException, SQLException {
        UsersDB udb = new UsersDB();
        ResultSet rs = udb.List();
        ArrayList<User> list = new ArrayList<User>();

        try {
            while (rs.next()) {
                User u = new User();
                u.setUserName(rs.getString("username"));
                u.setFullName(rs.getString("fullname"));
                u.setEmail(rs.getString("email"));
                list.add(u);
            }
        } catch (Exception ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public void Find() {
        try {
            UsersDB udb = new UsersDB();
            udb.setUser(this);
            ResultSet rs = udb.Find();

            try {
                rs.first();
                this.setUserName(rs.getString("usename"));
                this.setFullName(rs.getString("fullname"));
                this.setEmail(rs.getString("email"));
                this.setPassword(rs.getString("password"));
                this.setStatus(rs.getBoolean("status"));

            } catch (SQLException e) {
                String error = e.getMessage();
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}