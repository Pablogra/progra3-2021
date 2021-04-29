/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Business.Email;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;

/**
 *
 * @author pablo
 */
public class EmailDB {

    private Email email;
    
    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
    
    
    public ResultSet Find() throws ClassNotFoundException, SQLException
    {
        Email email = this.getEmail();
               
        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);
        
        fmt.format("SELECT idemail, emailname, subject, message, template FROM email  WHERE "
                + "idemail = %d;", email.getIdEmail());
       
        DataBaseConnection con = new DataBaseConnection(sbuf.toString(), true);
        con.setWaitForResults(true);
        con.ExecuteQuery();
        return con.getRs();
    }
    
    public void Edit() throws ClassNotFoundException, SQLException
    {
        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);
        
        fmt.format("UPDATE Email SET subject = '%s', message = '%s' "
                + "WHERE idemail = %d;",
                email.getSubject(),
                email.getMessage(),
                email.getIdEmail()
                
                );
       
        DataBaseConnection con = new DataBaseConnection(sbuf.toString(), false);        
        
        con.ExecuteQuery();        
    }
    
    public ResultSet List() throws ClassNotFoundException, SQLException
    {
        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);
        
        fmt.format("SELECT idemail, emailname, subject, message, template FROM email;");
                
        DataBaseConnection con = new DataBaseConnection(sbuf.toString(), true);
        con.setWaitForResults(true);
        con.ExecuteQuery();
        return con.getRs();
    }
}
