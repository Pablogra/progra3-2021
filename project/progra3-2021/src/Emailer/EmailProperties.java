/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Emailer;

/**
 *
 * @author pablo
 */
public class EmailProperties {
    
    private String subject = new String();
    private String message = new String();
    private String recipient = new String();
    private String recipientName = new String();

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }
    private String from;

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

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
    
    public EmailProperties() {
    }

    public EmailProperties(String subject, String message, String recipient, String recipientName, String from) {
        this.subject = subject;
        this.message = message;
        this.recipient = recipient;
        this.recipientName = recipientName;
        this.from = from;
    }
}
