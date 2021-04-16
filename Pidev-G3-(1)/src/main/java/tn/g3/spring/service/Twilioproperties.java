package tn.g3.spring.service;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twilio")
public class Twilioproperties {
 	private String accountSid = "AC3724291379f971b3ebb01ac4c38712a8";
	private String authToken = "fe2b3f36801b1c0d7ea3ea96f09f653b";
	private String fromNumber = "+18509203799";
	public String getAccountSid() {
		return accountSid;
	}
	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getFromNumber() {
		return fromNumber;
	}
	public void setFromNumber(String fromNumber) {
		this.fromNumber = fromNumber;
	}
	public Twilioproperties() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}