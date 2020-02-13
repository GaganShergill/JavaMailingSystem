package com.gagan.ejb;

import java.util.Properties;
import javax.ejb.Stateless;

@Stateless
public class MailSenderBean {
	
    public void sendEmail(String fromEmail, String username, String password,
    		String toEmail, String subject, String message) {
        
    	Properties props = System.getProperties();
    	props.put("mail.smtp.host","smtp.gmail.com");
    	props.put("mail.smtp.auth","true");
    	props.put("mail.smtp.port","465");
    	props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
    	props.put("mail.smtp.socketFactory.port","465");
    	props.put("mail.smtp.socketFactory.fallback","false");
    	
    	
    	Session mailSession = Session.getDefaultInstance(props, null);
    	
    }

}
