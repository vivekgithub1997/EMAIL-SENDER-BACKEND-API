package com.vivek.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.vivek.entity.EmailDtls;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public String sendSimpleMail(EmailDtls emailDtls) {
		try {

			SimpleMailMessage mailMessage = new SimpleMailMessage();

			mailMessage.setFrom("info.demo.api@gmail.com");
			mailMessage.setTo(emailDtls.getTo());
			mailMessage.setText(emailDtls.getMsg());
			mailMessage.setSubject(emailDtls.getSubject());

			javaMailSender.send(mailMessage);
			return "Mail Sent Successfully...";
		}

		catch (Exception e) {
			return "Error while Sending Mail";
		}
	}

	@Override
	public String sendMailWithAttachment(EmailDtls emailDtls) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		MimeMessageHelper mimeMessageHelper;

		try {

			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom("info.demo.api@gmail.com");
			mimeMessageHelper.setTo(emailDtls.getTo());
			mimeMessageHelper.setText(emailDtls.getMsg());
			mimeMessageHelper.setSubject(emailDtls.getSubject());

			FileSystemResource file = new FileSystemResource(new File(emailDtls.getAttachment()));

			mimeMessageHelper.addAttachment(file.getFilename(), file);

			javaMailSender.send(mimeMessage);
			return "Mail sent Successfully";
		}

		catch (MessagingException e) {
			return "Error while sending mail!!!";
		}
	}
}
