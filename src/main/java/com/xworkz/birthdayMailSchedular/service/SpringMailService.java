package com.xworkz.birthdayMailSchedular.service;

import org.springframework.mail.javamail.MimeMessagePreparator;

public interface SpringMailService {

	public boolean validateAndSendMailByMailId(MimeMessagePreparator messagePreparator);
}
