package com.xworkz.birthdayMailSchedular.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import com.xworkz.birthdayMailSchedular.dto.Subscriber;

public interface MailSchedularService {

	public String birthadyMailSender() throws URISyntaxException, IOException;
	
	public List<Subscriber> getListOfSubscribersFromExcel() throws IOException;
}
