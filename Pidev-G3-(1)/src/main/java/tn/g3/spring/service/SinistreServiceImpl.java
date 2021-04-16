package tn.g3.spring.service;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;

import com.sun.el.parser.ParseException;

import tn.g3.spring.entity.Claim;
import tn.g3.spring.entity.Contract;
import tn.g3.spring.entity.Person;
import tn.g3.spring.entity.SinisterMotif;
import tn.g3.spring.entity.Sinistre;
import tn.g3.spring.entity.SinisterStatus;
import tn.g3.spring.repository.ClaimRepository;
import tn.g3.spring.repository.ContractRepository;
import tn.g3.spring.repository.PersonRepository;
import tn.g3.spring.repository.SinistreRepository;
@Transactional
@Service
public class SinistreServiceImpl implements ISinistreSerivce{

	@Autowired     
	SinistreRepository sinistreRepository ;

	@Autowired     
	PersonRepository personRepository ;

	@Autowired
	ContractRepository cr ;

	@Autowired
	ClaimRepository claimr ;

	@Autowired
	private SendEmailService sendEmailService;

	File file = new File("C:\\Users\\Sonia\\Desktop\\11.jpg");
	private static final Logger L = LogManager.getLogger(SinistreServiceImpl.class);

	@Override
	public Sinistre addSinistre(Sinistre s,Long id) {
		// get id user from current session
		//	String idPersonConnected = RequestContextHolder.currentRequestAttributes().getSessionId();
		Person p=personRepository.findById(id).get();
		System.out.println("idddddd"+p.getIdPerson());
		//Sinistre sinistreSaved = null;
		// Long id = sinistreSaved.getPerson().getIdPerson();  
		//Long id = (long) 1000;
		//s.getPerson().setIdPerson(id);
		
		s.setPerson(p);
		s.setStatus(SinisterStatus.EnAttente);
		sinistreRepository.save(s); /*
	user find by id  //recupere de la base luser connecter
	s.setUser */
		return s;

	}
	@Override
	public void deleteSinistre(String id) {
		long idc = Long.parseLong(id);
		
		sinistreRepository.updateidperson(idc) ;
		
		sinistreRepository.deleteById(Long.parseLong(id));
		//Sinistre s = sinistreRepository.findById(Long.parseLong(id)).get();
		

	}
	@Override
	public Sinistre updateSinistre(Sinistre s) {
		Sinistre sinistreAdded = sinistreRepository.save(s);
		return sinistreAdded;
	}

	@Override
	public Sinistre updateDescription(Long id ,String desc) {
		Sinistre s = sinistreRepository.findById(id).get();
		s.setDescription(desc);
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
		SinisterStatus status2=SinisterStatus.En_Cours;
		SinisterMotif motifF =SinisterMotif.Reglé;

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
				SinisterMotif motif=SinisterMotif.NoDocuments;
				sinsenattente.get(i).setStatus(status);
				sinsenattente.get(i).setMotifStatus(motif);
				sinistreRepository.save(sinsenattente.get(i));
				L.info("new sin 2 +++ :" + sinsenattente.get(i));
			} 
			else {
				sinsenattente.get(i).setMotifStatus(motifF);
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
				String nom = sinstreRej.get(i).getPerson().getFirstName() +  sinstreRej.get(i).getPerson().getLastName();
				String motif =sinstreRej.get(i).getMotifStatus().toString(); 
				String date =sinstreRej.get(i).getDateOccurence().toString(); 
				String mail = sinstreRej.get(i).getPerson().getEmail();
//" M, on vous informe que votre demande de remboursement"+ "de sinistre, envoyée à la date "+date+ " , . Merci pour votre compréhension. "
				sendEmailService.sendEmail( mail ,  "Sinistre rejeté" , motif,nom,date, file);	
			} 
		} 
		catch (Exception e)
		{System.out.println(e.getMessage());}
	}

	/* *********************VIE ENTIERE  ********************** */
	/* ******************** PRIME UNIQUE ********************** */
	/* *************************FEMME **************************** */

////////////FIND
	@Override
	public Sinistre FindByIdSin(Long id)
	{
		return sinistreRepository.findByIdSin(id) ;
	}

	@Override
	public void FindByIdPer(Long id) 
	{
		try {
			long idp= sinistreRepository.findByIdPerson(id) ;
			String pdf=  personRepository.findById(idp).get().getFirstName();
			L.info("PRIME+++++++++ =" + pdf)  ;
		}
		catch (Exception e)
		{System.out.println(e.getMessage());}
	}


//-----------------------------prime ?--------------------------------------**

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
	public double calculCapitalAV(double prime , int ageClient, int AgeMax, double taux){
		int n = AgeMax - ageClient;
		double val1 = (Math.pow (1 + taux , n ) -1 ) / taux ;
		double Sn= ( 1+ taux) * val1;
		double AV = prime * Sn ;
		L.info("AV +++++++++ =" + AV) ;
		return AV;

	}

	/*
	///////////////////// Rachat partiel

	@Override
	public String calculVieEntiere(double prime , int ageClient, int AgeMax, double taux, Long idsin, Long idPers){
		double res =0;
			Sinistre sin = sinistreRepository.findByIdSin(idsin);
		if  (sin.getTypeSinistre().toString().equals("DécesVieEntiere"))
			{
			res = calculCapitalfemme( prime , ageClient, AgeMax, taux);
			}
		else if  (sin.getTypeSinistre().toString().equals("RachatTotalVieEntiere"))
		{
			res=calculCapitalfemmeAV( prime , ageClient,  AgeMax, taux) ;
		}

		L.info("AV +++++++++ =" + res) ;
		return "heo";

	} */
	/* **************************HOMME	*****************           */ 

	@Override
	public double calculCapitalHomme(double prime , int ageClient, int AgeMax, double taux){
		int k;
		double capital= 0;
		for (k =0; k < AgeMax - ageClient; k++) {
			float dxk= sinistreRepository.findByDecesDxHomme(ageClient+k); 	

			float lx = sinistreRepository.findBySurvivantsLxHomme(ageClient);
			double v = Math.pow( 1/ (1+taux) ,  k + (1/2)  );

			capital = (double) ((prime /( dxk / lx) ) / v)  ;

		}
		L.info("capital +++++++++ =" + capital) ;
		return capital;
	}




/* ********************************************************************************** */

/* ********************************************************************************* */
/* **//////////////////////////////////////*PRIME PERIODIQUE***************/

////////////////////////FEMME
//	@Override
	public double calculCapitalfemmePPer(double prime , int ageClient, int AgeMax, double taux){
		int k;
		double capitaltotal= 0;
		double capital1= 0;
		double capital2= 0;
		for (k =0; k < AgeMax - ageClient; k++) {  //partie isar
		
			float lxplusk = sinistreRepository.findBySurvivantsLxFemme(ageClient+k);
			float lx = sinistreRepository.findBySurvivantsLxFemme(ageClient);
			
			
			double vk = Math.pow( 1/ (1+taux) ,  k  );
			capital1= prime * (lxplusk/ lx  ) * vk; 

		}
		for (k =0; k < AgeMax - ageClient; k++) { //partie imin
			float dxk= sinistreRepository.findByDecesDxFemme(ageClient+k); 	
			float lx = sinistreRepository.findBySurvivantsLxFemme(ageClient);
			
			double vk = Math.pow( 1/ (1+taux) , k + (1/2)  );
			capital2= prime * (dxk/ lx  ) * vk; 

		}
		capitaltotal= capital1  / capital2;

		L.info("capital +++++++++ =" + capitaltotal) ;
		return capitaltotal;
	}
	
	
	/////////////////////////////////////////////////////////////////////////
	
//////////////////////////////////*** CAPITAL DECES 
	//***************************************UNIQUE FEMME 

	@Override
	public double CapitalCasDécesFemme(double prime , double taux, int ageClient, Long idC) {
		
		int k;
		Contract  c =cr.findById(idC).get();
	long dateFin = c.getFinishContract().getYear();
	long dateStart = c.getStartContract().getYear();
	
	long dur=dateFin-dateStart;
	
	L.info("PRIME+++++++++ =" +dur) ;	
		double capital= 0;
		
		for (k =0; k < dur - 1; k++) {
		 //duree de cont
			float lx = sinistreRepository.findBySurvivantsLxFemme(ageClient);
			prime += Math.pow( 1/ (1+taux) ,  k + (1/2)  ) * ( sinistreRepository.findByDecesDxFemme(ageClient+k) / lx) ;
			L.info("PRIME+++++++++ =" +prime) ;				 
			}
		 double cd = cr.findById(idC).get().getPremiumContract() / prime ; 
		L.info("PRIME+++++++++ =" + cd) ;
		return cd;
	}
	
	
	////////////////////homme
	@Override
	public double CapitalCasDécesHomme(double prime , double taux, int ageClient, Long idC) {
		int k;
		Contract  c =cr.findById(idC).get();
	long dateFin = c.getFinishContract().getTime();
	long dateStart = c.getStartContract().getTime();
	long dur=dateFin-dateStart;
		double capital= 0;
		for (k =0; k < dur - 1; k++) {
		 //duree de cont
			float lx = sinistreRepository.findBySurvivantsLxHomme(ageClient);
			prime += Math.pow( 1/ (1+taux) ,  k + (1/2)  ) * ( sinistreRepository.findByDecesDxHomme(ageClient+k) / lx) ;
			L.info("PRIME+++++++++ =" +prime) ;				 
			}
		 double cd = cr.findById(idC).get().getPremiumContract() / prime ; 
		L.info("PRIME+++++++++ =" + cd) ;
		return cd;
	}
	
	
	 
/////////AFFECTATION

@Transactional	
public void affecterSinisterPerson(Long SinId, Long persId) {
	Person u = personRepository.findById(persId).get();
	Sinistre s = sinistreRepository.findById(SinId).get();

	if(s.getPerson() == null){

		List<Person> pers = new ArrayList<>();
		pers.add(u);
		s.setPerson(u);
	}else{

		s.setPerson(u);

	}

}



//////CREDIT SIMULATOR
 ///Calcul et coût de l’assurance bancaire
public double CreditSimulator( Long idp, Long idc, float emprunt) {

	Person u= personRepository.findById(idp).get();
	double taux =0;
	Contract  c =cr.findById(idc).get();
	//Long id=(Long)session.getAttribute("name");	 
	long dateFin = c.getFinishContract().getYear();
	long dateStart = c.getStartContract().getYear();
	long dur=dateFin-dateStart;
	if (dur < 35 ) // taux 0.00276
	 taux =0.00276;
		
	else  // tauxt 0.00042
		taux=0.00042;
	 
	double res = ( emprunt * taux ) / 12 ;
	
	 
	return res ; 

}

//////////////////////////// jointuuuure
@Override
public 	List<Sinistre> findSinisterfromClaim( Long id)
{ 
	List<Sinistre> k = sinistreRepository.findSinisterDescriptionwithUR(id);
	L.info("description +++ :" + k) ;
	return k;

}



}



