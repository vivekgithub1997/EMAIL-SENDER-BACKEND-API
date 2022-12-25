package com.vivek.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.entity.EmailDtls;
import com.vivek.service.EmailService;

@RestController
@CrossOrigin
public class EmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/sendmail")
	public String sendMail(@RequestBody EmailDtls emailDtls) {
		String status = emailService.sendSimpleMail(emailDtls);
		System.out.println(emailDtls);
		return status;
	}

	@PostMapping("/sendMailWithAttachment")
	public String sendMailWithAttachment(@RequestBody EmailDtls emailDtls) {
		String status = emailService.sendMailWithAttachment(emailDtls);

		return status;
	}

}
