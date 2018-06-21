package com.spring.service;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendImpl implements Send {

	private static final Logger logger = LoggerFactory.getLogger(SendImpl.class);

	public void setSend(String to, String title, String text) throws IOException {
		AllProperties allProperties = new AllPropertiesImpl();
		Properties prop = allProperties.getAllEmail();

		Connect connect = new ConnectImpl();
		Session session = connect.connctEmail(prop);
		try {
			Message message = new MimeMessage(session);
			// from
			message.setFrom(new InternetAddress(prop.getProperty("mail.username")));
			// to
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			// title
			message.setSubject(title);
			// text
			message.setText(prop.getProperty("mail.greeting") + " " + text);

			Transport.send(message);

			logger.info("Email Sent successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
