package Controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class SendEmail {

	public void sendEmail(String destinatar) {

		final String username = "libraapprecoverypass@gmail.com";
		final String password = "parola10";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(destinatar));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatar));
			message.setSubject("Password Recovery LibraApp");
			message.setText("Parola dv a fost resetata.\n Noua parola este : 123456");

			Transport.send(message);

			JOptionPane.showMessageDialog(null, " Mail sent succesfully!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
