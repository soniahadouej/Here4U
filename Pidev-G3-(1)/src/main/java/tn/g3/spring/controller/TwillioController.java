package tn.g3.spring.controller;
/*
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

}*/import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.twilio.exception.ApiException;

import tn.g3.spring.entity.Smsrequest;
import tn.g3.spring.service.Smsservice;



@Controller
public class TwillioController {

	@Autowired
   private Smsservice smsservice;
	    
	@RequestMapping("/")
	public String homepage(ModelAndView model)
	{
		return "index";
	}
	
   @PostMapping("/sendmessage")
   public ResponseEntity<Object> sendmessage(Smsrequest smsrequest)
   {
	   String status=smsservice.sendsms(smsrequest);
	   if("sent".equals(status)||"queued".equals(status))
       {
       	return new ResponseEntity<Object>("sent successfully",HttpStatus.OK);
       }
	   return new ResponseEntity<Object>("failed to send message",HttpStatus.NOT_FOUND);
   }
   
	
	
}