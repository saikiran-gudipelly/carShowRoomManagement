import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.*;

public class RequestCars {

    public void Email() {

        Scanner sc = new Scanner(System.in);
        // Set your email credentials and properties
        String username = "gudipellysaikiran9@gmail.com";
        String password = "uwcw frgr oxeo riyh";
        String toAddress = "ssai3585@gmail.com";
        String subject = "Test Email";
        System.out.println("Request your desired car through email");
        String messageBody = sc.nextLine();

        // Set up mail server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create a Session object with the specified properties and an authenticator
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a MimeMessage object
            Message message = new MimeMessage(session);

            // Set the sender address
            message.setFrom(new InternetAddress(username));

            // Set the recipient address
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));

            // Set the email subject and body
            message.setSubject(subject);
            message.setText(messageBody);

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
