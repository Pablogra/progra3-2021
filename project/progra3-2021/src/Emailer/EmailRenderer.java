/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Emailer;

import Business.Email;
import Business.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;
import javax.mail.internet.AddressException;

/**
 *
 * @author pablo
 */
public class EmailRenderer {

    public EmailRenderer() {
    }
    
    
    
    public String LoadHTMLTemplate(String template) throws IOException, URISyntaxException {
        StringBuilder contentBuilder = new StringBuilder();        
        File pto = new File(EmailRenderer.class.getProtectionDomain().getCodeSource().getLocation().toURI());        
        String appPath = pto.getAbsolutePath();
        
        try (BufferedReader in = 
                new BufferedReader(new FileReader(appPath + "\\Email\\" + template))) {
            String str;
            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
        }
        
        return contentBuilder.toString();
    }
    
    
    public String RenderEmail(String template, Hashtable<String, String> values){        
        String result = template;
        Set<String> keys = values.keySet();
        for(String key: keys){
            result = result.replaceAll("\\[" + key + "\\]", values.get(key));
        }        
        return result; 
    } 
    
    public Hashtable<String, String> DecomposeEmailPropertiesIntoTokens(EmailProperties emailProperties) {
        Hashtable<String, String> values = new Hashtable<> ();
        values.put("USER", emailProperties.getRecipientName());        
        values.put("SUBJECT", emailProperties.getSubject());
        values.put("MESSAGE", emailProperties.getMessage());
        return values;
    }
    
    public void SendEmail(int template) 
            throws ClassNotFoundException, SQLException, MessagingException, IOException, URISyntaxException {
        
        try {
            User user = new User();
            ArrayList<User> usersList = user.List();
            
            
            for (int i = 0; i < usersList.size(); i++){
                SendEmail(usersList.get(i).getEmail(), usersList.get(i).getFullName(), 2);
            }
            
        } catch (ClassNotFoundException | SQLException | MessagingException | IOException | URISyntaxException ex) {
            Logger.getLogger(EmailRenderer.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }    
    
    public void SendEmail(String address, String fullName, int template) throws ClassNotFoundException, SQLException, MessagingException, IOException, URISyntaxException {
        Email email = new Email();
        email.setIdEmail(template);
        email.Find();
        
        EmailProperties emailProperties = new EmailProperties();        
        emailProperties.setMessage(email.getMessage());        
        emailProperties.setSubject(email.getSubject());
        emailProperties.setRecipient(address);
        emailProperties.setRecipientName(fullName);
        emailProperties.setFrom("Scoreboards");
        
        Hashtable<String, String> values = DecomposeEmailPropertiesIntoTokens(emailProperties);
        String templateSource = LoadHTMLTemplate(email.getTemplate());
        String rendered = RenderEmail(templateSource, values);
        
        emailProperties.setMessage(rendered);
        SendEmail(emailProperties);
    }
    
    public void SendEmail(EmailProperties emailProperties ) throws AddressException, MessagingException {        
        Thread hilo = new Thread(new emailSender(emailProperties), "Email Sending");
        hilo.start();
    }
}

class emailSender implements Runnable{

    private EmailProperties emailProperties;
    
    public emailSender(EmailProperties emailProps) {
        emailProperties = emailProps;
    }   
    
    @Override
    public void run(){                                
        try {
            SendEmail();
        } catch (MessagingException ex) {
            Logger.getLogger(emailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void SendEmail() throws AddressException, MessagingException {
        Properties props = new Properties();
        //SI EL CORREO DEL QUE SE ENVIA UTILIZA AUTENTICACION
        String user = "pruebaprogralatina@gmail.com";
        String password = "Latina-12345";
        // el host de correo, en nuestro caso gmail
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        //el puerto que vamos a usar
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", user);
        //le indicamos que es necesario autentificarse
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
        
        Session session = Session.getInstance(props,
        new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(user, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(user));
        message.setRecipients(Message.RecipientType.TO, 
                InternetAddress.parse(emailProperties.getRecipient()));
        message.setSubject(emailProperties.getSubject());
        String mensaje = emailProperties.getMessage();        
        message.setContent(mensaje, "text/html");
        
        Transport.send(message);    
    }
}

