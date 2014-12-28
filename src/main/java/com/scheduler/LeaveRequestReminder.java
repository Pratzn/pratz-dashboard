package com.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeaveRequestReminder {
    private static final Logger logger = LoggerFactory.getLogger(TaskTrackingReminder.class);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");

    public void run() {
        String dateString = getDateString();
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "www.iconext.co.th");
        props.put("mail.smtp.port", "25");
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("prat@iconext.co.th", "asdf_4568");
            }
        });
        
        try {
            session.setDebug(true);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("prat@iconext.co.th"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("prat@iconext.co.th,pasuwat@iconext.co.th"));
            message.setSubject("Reminder: Daily Leave request " + dateString);
            Multipart multipart = new MimeMultipart();
            MimeBodyPart mbp1 = new MimeBodyPart();
            mbp1.setContent("Dear all,<br/><br/>Leave request as of " + dateString + " from NSSOL.<br/><br/>No one request to leave.<br/><br/>Best regards,<br/>--"
                    + "Best Regards,<br/>"
                    + "Prat Nudklin<br/>"
                    + "Senior System Developer<br/>"
                    + "Mobile: 086-722-4100", "text/html");
            multipart.addBodyPart(mbp1);
            message.setContent(multipart);
            Transport.send(message);
            System.out.println("Done");
            
        } catch (MessagingException e) {
            logger.error("MessagingException",e);
        }
    }

    private static String getDateString() {
        return sdf.format(new Date());
    }
}
