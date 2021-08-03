package com.bridgelabz.selenium.bookswagon.utility;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailReport{
    private static final String USERNAME = "amarprajapati99@gmail.com";
    private static final String PASSWORD = "Pr@japati0777";
    private static final String RECIPIENT = "amarprajapati99@gmail.com";

    public static void sendMail() {

        String[] to = {RECIPIENT};
        String subject = "Test Report";
        String body = "BooksWagon test report please find the attached file";
        String reportPath = "";

        sendFromGMail(to, subject, body, reportPath);
    }

    private static void sendFromGMail(String[] to, String subject, String body, String reportPath) {

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication (USERNAME, PASSWORD);
            }
        });

        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(EmailReport.USERNAME));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (InternetAddress address : toAddress) {
                message.addRecipient(Message.RecipientType.TO, address);
            }
            message.setSubject(subject);

            BodyPart messageBodyPart = new MimeBodyPart ();

            // Now set the actual message
            messageBodyPart.setText(body);

            // Create a multiple message
            Multipart multipart = new MimeMultipart ();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String filename = "BooksWagon test report";
            DataSource source = new FileDataSource (reportPath);
            messageBodyPart.setDataHandler(new DataHandler (source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);

            Transport.send(message, message.getAllRecipients());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

