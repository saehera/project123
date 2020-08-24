package com.his.app.utils;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.his.app.model.UserAccountModel;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender javaMailSender;

	/*public boolean sendEmail(String to, String subject, String body) {
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(to);
			msg.setSubject(subject);
			msg.setText(body);
			
			javaMailSender.send(msg);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
*/
public boolean sendUnlockEmail(UserAccountModel userAccount) {
	boolean isSent = false;
		try {

			MimeMessage mimeMsg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMsg);

			helper.setTo(userAccount.getEmail());
			helper.setSubject("Unlock Your Account");
			helper.setText(getUnlockAccEmailBody(userAccount), true);
			
			javaMailSender.send(mimeMsg);

	 isSent = true;
		} catch (Exception e) {

		}
		return isSent;
	}

	private String getUnlockAccEmailBody(UserAccountModel userAccount) throws IOException {
		StringBuffer sb = new StringBuffer("");
		FileReader fr = new FileReader("EmailBody.txt");
		BufferedReader br =new BufferedReader(fr);
		String line = br.readLine();
		while(line != null) {
			sb.append(line);
			line = br.readLine();
		}
		br.close();
		String mailBody = sb.toString();
		mailBody = mailBody.replace("{FNAME}", userAccount.getFirstName());
		mailBody = mailBody.replace("{LNAME}", userAccount.getLastName());
		mailBody = mailBody.replace("{TEMP-PWD}", userAccount.getUserPwd());
		mailBody = mailBody.replace("{EMAIL}", userAccount.getEmail());
		
		return mailBody;
	}

}

