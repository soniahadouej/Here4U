package tn.g3.spring.service;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;

import tn.g3.spring.entity.Person;
import tn.g3.spring.entity.SinisterMotif;
import tn.g3.spring.entity.Sinistre;
import tn.g3.spring.entity.SinisterStatus;
import tn.g3.spring.repository.PersonRepository;
import tn.g3.spring.repository.SinistreRepository;

@Service
public class SinistreServiceImpl implements ISinistreSerivce{

	@Autowired     
	SinistreRepository sinistreRepository ;
	
	@Autowired     
	PersonRepository personRepository ;
	
	@Autowired
	private SendEmailService sendEmailService;
	
	File file = new File("C:\\Users\\Sonia\\Desktop\\11.jpg");
	private static final Logger L = LogManager.getLogger(SinistreServiceImpl.class);

	@Override
	public Sinistre addSinistre(Sinistre s) {
		// get id user from current session
	//	String idPersonConnected = RequestContextHolder.currentRequestAttributes().getSessionId();
        
		Sinistre sinistreSaved = null;
	   // Long id = sinistreSaved.getPerson().getIdPerson();  
		Long id = (long) 1000;
		//s.getPerson().setIdPerson(id);
		
		sinistreSaved = sinistreRepository.save(s); /*
user find by id  //recupere de la base luser connecter
s.setUser */
		return sinistreSaved;

	}
	@Override
	public void deleteSinistre(String id) {
		sinistreRepository.deleteById(Long.parseLong(id));

	}
	@Override
	public Sinistre updateSinistre(Sinistre s) {
		Sinistre sinistreAdded = sinistreRepository.save(s);
		return sinistreAdded;
	}

	@Override
	public Sinistre retrieveSinistre(String id) {
		L.info("in retrieveSinistre id = " + id);
		Sinistre s = sinistreRepository.findById(Long.parseLong(id)).get();
		L.info("sinistre returned = : " + s);
		return s;
	}


	@Override
	public List<Sinistre> retrieveAllSinistres() {
		List<Sinistre> sinistres = (List<Sinistre>) sinistreRepository.findAll(); 
		for(Sinistre sin : sinistres)
		{
			L.info("sinistre +++ :" + sin);
		}

		return sinistres;
	}		


	@Override
	public Long getMax(){
		Long l;
		l = sinistreRepository.getMax();
		L.info(l);
		return(l);
	}

	//recherches
	@Override
	public List<Sinistre> findByDescription(String name) {

		List<Sinistre> sins = sinistreRepository.findByDescription(name);
		L.info("sinistre +++ :" + sins) ;
		return sins;
	} 

	@Override
	public List<Sinistre> findByYear(String year) {
		List<Sinistre> sins = sinistreRepository.findByYear(year);
		L.info("sinistre +++ :" + sins) ;
		return sins;
	}
	@Override
	public List<Sinistre> findByAny(String any) {
		List<Sinistre> sins = sinistreRepository.findByAny(any);
		L.info("sinistre +++ :" + sins) ;
		return sins;
	}

	/*@Override
	public void updateStatus (Long id, String newStatus){
		sinistreRepository.updateStatus(id,newStatus); 

	}*/

	/* ***************************************************************************** */


	@Override
	public void CheckStatus() {
		List<Sinistre> sinsenattente = sinistreRepository.findByStatusEnAttente();
		Calendar currentdate = Calendar.getInstance(); 
		Date d = currentdate.getTime();  
		
		currentdate.add(Calendar.DAY_OF_MONTH, -5);
		Date d1= currentdate.getTime();
	
	
		SinisterStatus status=SinisterStatus.Rejetée;
		SinisterStatus status2=SinisterStatus.En_Cous;
		

		for(int i=0;i<sinsenattente.size();i++)
		{ // L.info("date OCC:" + sinsenattente.get(i).getDateOccurence()) ;
		
		
			if (sinsenattente.get(i).getDateOccurence().compareTo(d1) < 0)
			{
				 L.info("BOUCLE 1:");
				 SinisterMotif motif=SinisterMotif.depasse2jours;
				sinsenattente.get(i).setStatus(status);
				sinsenattente.get(i).setMotifStatus(motif);
				 sinistreRepository.save(sinsenattente.get(i));
				 L.info("new sin +++ :" + sinsenattente.get(i)) ;

			}
			else if (sinsenattente.get(i).getDocuments() == null)
			{
				L.info("boucle 2") ;
				SinisterMotif motif=SinisterMotif.Motif2;
				sinsenattente.get(i).setStatus(status);
				sinsenattente.get(i).setMotifStatus(motif);
				 sinistreRepository.save(sinsenattente.get(i));
				 L.info("new sin 2 +++ :" + sinsenattente.get(i));
			} 
			else {
				sinsenattente.get(i).setStatus(status2);
				sinistreRepository.save(sinsenattente.get(i));
			}

		} 

	}	
	///// ************************* MAIL

	@Override
	public void SendMail() {
		try {
		List<Sinistre> sinstreRej = sinistreRepository.findByStatusRejetée();

		//SimpleMailMessage mail = new SimpleMailMessage();
		for(int i=0;i< sinstreRej.size();i++)
		{   // String email = sinstreRej.get(i).getClient().getEmail();
			//nom=  String email = sinstreRej.get(i).getClient().getNom();
			String motif =sinstreRej.get(i).getMotifStatus().toString(); 
			String date =sinstreRej.get(i).getDateOccurence().toString(); 
			
			sendEmailService.sendEmail("hadouejnadia@gmail.com", "Sinistre rejeté" , "Cher cleint monsieur M, on vous informe que votre demande de remboursement"
					+ "de sinistre, envoyée à la date "+date+ " , a été rejetée car cette demande " + motif + ". Merci pour votre compréhension. ", file);	
		} 
		} 
		catch (Exception e)
		{System.out.println(e.getMessage());}
		}
	
	/* *********************VIE ENTIERE  ********************** */
	/* ******************** PRIME UNIQUE ********************** */
	/* *************************FEMME **************************** */
	@Override
	public float calculPrimefemme(float capital , int ageClient, int AgeMax, double taux){
		int k;
		float prime = 0;
		for (k =0; k < AgeMax - ageClient; k++) {
			float dxk= sinistreRepository.findByDecesDxFemme(ageClient+k); 	
			
			float lx = sinistreRepository.findBySurvivantsLxFemme(ageClient);
		   double v = Math.pow( 1/ (1+taux) ,  k + (1/2)  );
			 
			prime = (float) (capital * v) *  ( dxk / lx) ;
			
	}

		L.info("PRIME+++++++++ =" + prime) ;
		return prime;
	}
	// 	CAPITALISATION MORT
	
	@Override
	public double calculCapitalfemme(double prime , int ageClient, int AgeMax, double taux){
		int k;
		double capital= 0;
		for (k =0; k < AgeMax - ageClient; k++) {
			float dxk= sinistreRepository.findByDecesDxFemme(ageClient+k); 	
			
			float lx = sinistreRepository.findBySurvivantsLxFemme(ageClient);
		   double v = Math.pow( 1/ (1+taux) ,  k + (1/2)  );
			 
		    capital = (double) ((prime /( dxk / lx) ) / v)  ;
			
	}

		L.info("capital +++++++++ =" + capital) ;
		return capital;
	}
	 ////////////RACHAT TOTAL == AV à terme davance
	@Override
	public double calculCapitalfemmeAV(double prime , int ageClient, int AgeMax, double taux){
		int n = AgeMax - ageClient;
		double val1 = (Math.pow (1 + taux , n ) -1 ) / taux ;
		double Sn= ( 1+ taux) * val1;
		double AV = prime * Sn ;
		L.info("AV +++++++++ =" + AV) ;
		return AV;
	
	}
	///////////////////// Rachat partiel
	
	
	@Override
	public String calculVieEntiere(double prime , int ageClient, int AgeMax, double taux, String typeSin, Long idPers){
		Sinistre sin = sinistreRepository.findByTypeSinistre(typeSin) ;
		
		L.info("AV +++++++++ =" + sin.getTypeSinistre()) ;
		return "hello";
		
	}
	/* **************************HOMME	*****************           */ 
	
	@Override
	public float calculPrimeHomme(float capital , int ageClient, int AgeMax, double taux){
		float prime=0;
		return prime;

	}
	}
	


