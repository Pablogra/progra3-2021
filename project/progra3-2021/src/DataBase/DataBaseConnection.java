/* 
 * To change this license header, choose License Headers in Project Properties. 
 * To change this template file, choose Tools | Templates 
 * and open the template in the editor. 
 */ 
package DataBase; 
 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
 
/** 
 * 
 * @author pablo 
 */ 
public class DataBaseConnection { 
     
    private String Sql; 
    private ResultSet Rs; 
    private boolean WaitForResults; 
     
    public DataBaseConnection(String sql, boolean waitForResults) { 
        this.Sql = sql; 
        this.WaitForResults = waitForResults; 
    } 
     
     
    public void ExecuteQuery () throws ClassNotFoundException, SQLException 
    { 
        Connection cnx = null; 
        Statement sta = null; 
         
        Class.forName("com.mysql.jdbc.Driver");         
        //cnx = DriverManager.getConnection("jdbc:mysql://bnmqwhdnubsxsb37eiyi-mysql.services.clever-cloud.com/bnmqwhdnubsxsb37eiyi?user=uyry0qniuj7nebv4&password=RTGlmgsZdfWFl26AHzWl&useSSL=false"); 
        // cnx = DriverManager.getConnection("jdbc:mysql://bnmqwhdnubsxsb37eiyi-mysql.services.clever-cloud.com:3306/bnmqwhdnubsxsb37eiyi","user=uyry0qniuj7nebv4","password=RTGlmgsZdfWFl26AHzWl&useSSL=true"); 
  
        cnx = DriverManager.getConnection("jdbc:mysql://localhost/progra3db?user=progra3&password=123456&useSSL=false");
        sta = cnx.createStatement(); 
         
        if (isWaitForResults()) { 
             
            setRs(sta.executeQuery(getSql())); 
        } 
        else { 
            sta.executeUpdate(getSql()); 
            sta.close(); 
            cnx.close(); 
        }        
    } 
 
    /** 
     * @return the Sql 
     */ 
    public String getSql() { 
        return Sql; 
    } 
 
    /** 
     * @param Sql the Sql to set 
     */ 
    public void setSql(String Sql) { 
        this.Sql = Sql; 
    } 
 
    /** 
     * @return the Rs 
     */ 
    public ResultSet getRs() { 
        return Rs; 
    } 
 
    /** 
     * @param Rs the Rs to set 
     */ 
    public void setRs(ResultSet Rs) { 
        this.Rs = Rs; 
    } 
 
    /** 
     * @return the WaitForResults 
     */ 
    public boolean isWaitForResults() { 
        return WaitForResults; 
    } 
 
    /** 
     * @param WaitForResults the WaitForResults to set 
     */ 
    public void setWaitForResults(boolean WaitForResults) { 
        this.WaitForResults = WaitForResults; 
    } 
} 
