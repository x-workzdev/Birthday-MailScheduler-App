package com.xworkz.birthdayMailSchedular.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.xworkz.birthdayMailSchedular.service.MailSchedularService;


@RestController
@RequestMapping("/")
public class MailScheduleController {
	
	private Logger logger = LoggerFactory.getLogger(MailScheduleController.class);
	
	@Autowired
	private MailSchedularService mailSchedular;
       
	@Scheduled(cron = "${bday.cron.expression}" , zone = "IST")
	@RequestMapping(value = "/mailSchedule.do", method = RequestMethod.POST)
	public ModelAndView sendScheduleMail() {
		ModelAndView modelAndView = new ModelAndView("index");
		logger.info("invoked sendScheduleMail() in controller");
		try {
			String report = mailSchedular.birthadyMailSender();
            logger.info("Birthady Mails Task Exccution Done");
            modelAndView.addObject("mailReport", report);
			return modelAndView;
		} catch (URISyntaxException | IOException e) {
			logger.error(e.getMessage(), e);
		}
		return modelAndView;
	}
	
	
}
