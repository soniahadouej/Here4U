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


	


}



