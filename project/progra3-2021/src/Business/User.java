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

    private int userID;
    private String userName;
    private String fullName;
    private String email;
    private String password;
    private boolean status;
    private boolean isAdmin;

    public User(int userID, String userName, String fullName, String email, String password, boolean status, boolean isAdmin) {
        this.userID = userID;
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.status = status;
        this.isAdmin = isAdmin;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public User() {
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
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
                u.setUserID(rs.getInt("userId"));
                u.setUserName(rs.getString("username"));
                u.setFullName(rs.getString("fullname"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setStatus(rs.getBoolean("status"));
                u.setIsAdmin(rs.getBoolean("isAdmin"));
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
                setUserID(rs.getInt("userId"));
                setUserName(rs.getString("username"));
                setFullName(rs.getString("fullname"));
                setEmail(rs.getString("email"));
                setPassword(rs.getString("password"));
                setStatus(rs.getBoolean("status"));
                setIsAdmin(rs.getBoolean("isAdmin"));

            } catch (SQLException e) {
                String error = e.getMessage();
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean Login() {        
        try {
            UsersDB udb = new UsersDB();
            udb.setUser(this);
            ResultSet rs = udb.FindByCredentials();
            boolean loginResult = rs.first();
            
            if (loginResult){
                this.setUserName(rs.getString("username"));
                this.setFullName(rs.getString("fullname"));
                this.setEmail(rs.getString("email"));
                this.setPassword(rs.getString("password"));
                this.setStatus(rs.getBoolean("status"));
                this.setIsAdmin(rs.getBoolean("isAdmin"));
            }
            return loginResult;
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}

