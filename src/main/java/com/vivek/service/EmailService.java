package com.vivek.service;

import com.vivek.entity.EmailDtls;

public interface EmailService {

	String sendSimpleMail(EmailDtls emailDtls);

	String sendMailWithAttachment(EmailDtls emailDtls);

}
