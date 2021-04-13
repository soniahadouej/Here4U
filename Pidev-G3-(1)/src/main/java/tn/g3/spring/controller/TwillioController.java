package tn.g3.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.g3.spring.service.TwillioService;



@RestController
public class TwillioController {



	@Autowired
	TwillioService twillioService;

	@Value("${app.twillio.fromPhoneNo}")
	private String from;

	@Value("${app.twillio.toPhoneNo}")
	private String to;

	@GetMapping("/sendSms")
	public String sendSms() {

		String body = "Hello. Good Morning!!";
		twillioService.sendSms(to, from, body);
		return "message sent successfully";


	}





	@GetMapping("/makeCall")
	public String makeVoiceCall() {

		twillioService.makeCall(from, to);
		return "call initiated..";


	}

}