/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DataBase.EmailDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author pablo
 */
public class Email {
    
    
    private String subject = new String();
    private String message = new String();    
    private String emailName = new String();
    private String template = new String();
    private int idEmail = 0;

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }    

    public int getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(int idEmail) {
        this.idEmail = idEmail;
    }    

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmailName() {
        return emailName;
    }

    public void setEmailName(String emailName) {
        this.emailName = emailName;
    }

    public Email() {
    }
    
    public void Edit(Email email) throws ClassNotFoundException, SQLException {
        EmailDB emailDB = new EmailDB();
        emailDB.setEmail(email);
        emailDB.Edit();
    }
    
    public void Edit() throws ClassNotFoundException, SQLException {        
        EmailDB emailDB = new EmailDB();
        emailDB.setEmail(this);
        emailDB.Edit();
    }
    
    
    public ArrayList <Email> List () throws ClassNotFoundException, SQLException {
        EmailDB emailDB = new EmailDB();
        ResultSet rs = emailDB.List();
        ArrayList<Email> list = new ArrayList<Email>();        
        
        while ( rs.next() ){
            Email e = new Email();
            e.setIdEmail(rs.getInt("idemail"));
            e.setEmailName(rs.getString("emailName"));
            e.setMessage(rs.getString("message"));
            e.setSubject(rs.getString("subject"));
            e.setTemplate(rs.getString("template"));
            list.add(e);
        }
        
        return list;
    }
    
    public void Find() throws ClassNotFoundException, SQLException {
            EmailDB eml = new EmailDB();
            eml.setEmail(this);
            ResultSet rs = eml.Find();
            rs.first();
            setIdEmail(rs.getInt("idemail"));
            setEmailName(rs.getString("emailName"));
            setSubject(rs.getString("subject"));
            setMessage(rs.getString("message"));
            setTemplate(rs.getString("template"));
    }
}
