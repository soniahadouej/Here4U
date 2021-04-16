package tn.g3.spring.controller;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tn.g3.spring.entity.SinisterStatus;
import tn.g3.spring.entity.SinisterType;
import tn.g3.spring.entity.Sinistre;
import tn.g3.spring.service.ISinistreSerivce;




@RestController

public class SinistreController {
	@Autowired
	ISinistreSerivce sr;


	//AJOUUUT
	//  http://localhost:8000/SpringMVC/servlet/add-sinistre/id
	/* {
	    "dateOccurence" : "2010-03-23", 
	    "description" :"Description detaillée du sinistre", 
	    "documents" : "null",
	    "typeSinistre": "DécesVieEntiere",  "RachatTotalVieEntiere" "RachatPartielVieEntiere"
	     "status" : "EnAttente" ,  "En_Cous" "Rejetée" "Validée"

	      }		*/
	@PostMapping("/add-sinistre/{id}")
	public Sinistre addSinister(@PathVariable(value ="id") Long id, @RequestParam("typeSinistre") SinisterType type , @RequestParam("description") String description ,@RequestParam("dateOccurence") String d, @RequestParam("documents") MultipartFile documents) throws ParseException, IOException
	{
		Sinistre c1 = new Sinistre();
		c1.setDocuments(documents.getBytes());
		c1.setStatus(SinisterStatus.EnAttente);
		c1.setDescription(description);
		c1.setTypeSinistre(type);
		Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(d);  
		c1.setDateOccurence(date1);

		Sinistre contResponse = sr.addSinistre(c1 ,id);

		String fileDownloadUri1 = ServletUriComponentsBuilder.fromCurrentContextPath().path("/Media/")
				.path(String.valueOf(contResponse.getIdSinistre())).path("/image").toUriString();

	
	return c1;
}




// http://localhost:8000/SpringMVC/servlet/retrieve-All-Sinistres  
@GetMapping("/retrieve-All-Sinistres")
@ResponseBody
public List<Sinistre> getSinister() {
	List<Sinistre> sins = new ArrayList<>() ;
	sr.retrieveAllSinistres().forEach(sins::add);
	return sins;
} 

//// FIND ?
// http://localhost:8000/SpringMVC/servlet/getSinisterByAny/any
@GetMapping("/getSinisterByAny/{any}")
@ResponseBody
public List<Sinistre> getsinisterbyAny(@PathVariable(value = "any") String any) {
	List<Sinistre> sinistres =sr.findByAny(any);
	return sinistres;
} 


// http://localhost:8000/SpringMVC/servlet/retrieve-sinistre/{id_sinistre}
@GetMapping("/retrieve-sinistre/{id_sinistre}")
public Sinistre retrieveUser(@PathVariable("id_sinistre") String sinisterid) {

	return sr.retrieveSinistre(sinisterid);
}



// http://localhost:8000/SpringMVC/servlet/remove-sinistre/{sinistre-id}
@DeleteMapping("/remove-sinistre/{sinistre-id}")
public void removeSinistre(@PathVariable("sinistre-id") String sinId) {

	sr.deleteSinistre(sinId);
}


// http://localhost:8000/SpringMVC/servlet/modify-sinistre/id
/* {      "idSinistre": 5,
			    "typeSinistre": "DécesVieEntiere",  "RachatTotalVieEntiere" "RachatPartielVieEntiere"
			    "description": "Description detkkkkkkkkkkkkkkkkkkkkkkkkkkkkkinistre",
			    "dateOccurence": "2010-03-22",
			    "status": "EnAttente",
			    "documents": null } */
@PutMapping("/modify-sinistre")
@ResponseBody
public Sinistre modifySinistre(@RequestBody Sinistre s) {//, @PathVariable("sinistre-id") Sinistre sinId){
	return sr.updateSinistre(s
			);
}

//http://localhost:8000/SpringMVC/servlet/modify-Description/id/newdesc
@PutMapping("/modify-Description/{sinistre-id}/{description}")
public Sinistre modifyDescription(@PathVariable("sinistre-id") long sinId, @PathVariable(value = "description") String description) { 
	return sr.updateDescription(sinId,description);
}


//////////////////////////////////////////////////////////////////////////////////////////////////////////


///AFFECTATION
//http://localhost:8000/SpringMVC/servlet/affecter-sinistre/10/10
@PutMapping(value = "/affecter-sinistre/{idSin}/{idUser}") 
public void affecterSinistrePerson(@PathVariable("idSin")Long idSin, @PathVariable("idUser")Long idUser) {
	sr.affecterSinisterPerson(idSin, idUser);
}




/////////////////////////// *********CHECCK STATUS ++ send Mail
// http://localhost:8000/SpringMVC/servlet/check-status_SendMail
@PutMapping("/check-status_SendMail")
@ResponseBody
public void testStatus() {
	sr.CheckStatus();	
	sr.SendMail();

}

//  http://localhost:8000/SpringMVC/servlet/send-mail
@GetMapping("/send-mail")
@ResponseBody
public void testSendMail() {

}


///////////////////////////// CACUL VIE ENTIERE////////////////////////
// http://localhost:8000/SpringMVC/servlet/CalculVieEntiere/{prime}/{ageClient}/{AgeMax}/{idSin}
// http://localhost:8000/SpringMVC/servlet/CalculVieEntiere/30.354326/30/36/21
@GetMapping("/CalculVieEntiere/{prime}/{ageClient}/{AgeMax}/{idSin}")
@ResponseBody
public double testCalculFinal(@PathVariable(value = "prime") double prime, @PathVariable(value = "ageClient")int ageClient,
		@PathVariable(value = "AgeMax") int AgeMax, @PathVariable(value = "idSin") Long idSin)

{double taux = 0.0624 ; 
double res=0;

//RECUPERER LES SINISTRE En_Cours
if (sr.FindByIdSin(idSin).getPerson().getSex().toString().equals("Female") )
{  //cas Female
	if ( sr.FindByIdSin(idSin).getTypeSinistre().toString().equals("DécesVieEntiere") )
	{

		// if 
		res = sr.calculCapitalfemme(prime ,ageClient, AgeMax, taux);
		// else prime périodique
		//res = sr.calculCapitalfemmePPer(prime ,ageClient, AgeMax, taux);

	}
	else if (sr.FindByIdSin(idSin).getTypeSinistre().toString().equals("RachatTotalVieEntiere") ) // 1 seul cas de prime 
	{
		res = sr.calculCapitalAV(prime, ageClient, AgeMax, taux);
	} 
}

else  //male
{
	if ( sr.FindByIdSin(idSin).getTypeSinistre().toString().equals("DécesVieEntiere") )
	{
		res = sr.calculCapitalHomme(prime ,ageClient, AgeMax, taux);
	}
	else if (sr.FindByIdSin(idSin).getTypeSinistre().toString().equals("RachatTotalVieEntiere") )
	{
		res = sr.calculCapitalAV(prime, ageClient, AgeMax, taux);
	} 
}
return res;	


}

/////////////////////////CALCULER CAPITAL DECES
// http://localhost:8000/SpringMVC/servlet/CalculCapDeces/{prime}/{ageClient}/{idCont}/{idSin}
// http://localhost:8000/SpringMVC/servlet/CalculCapDeces/30.354326/30/1/1
@GetMapping("/CalculCapDeces/{prime}/{ageClient}/{idCont}/{idSin}")
@ResponseBody
public double testCalculCAPITALDECES(@PathVariable(value = "prime") double prime, @PathVariable(value = "ageClient")int ageClient,
		@PathVariable(value = "idCont") Long idCont, @PathVariable(value = "idSin") Long idSin)

{double taux = 0.0624 ; 
double res=0;

//RECUPERER LES SINISTRE En_Cours
if (sr.FindByIdSin(idSin).getPerson().getSex().toString().equals("Female") )
{  //cas Female
	if ( sr.FindByIdSin(idSin).getTypeSinistre().toString().equals("CapitalDeces") )
	{

		res = sr.CapitalCasDécesFemme(prime ,taux, ageClient, idCont);
	}
}
else  if (sr.FindByIdSin(idSin).getPerson().getSex().toString().equals("Male") ) //male
{
	if ( sr.FindByIdSin(idSin).getTypeSinistre().toString().equals("CapitalDeces") )
	{
		res = sr.CapitalCasDécesHomme(prime ,taux, ageClient, idCont);
	}

}
return res;	


} 




///////////////////////CREDI SIMULATOR
//assurance pret immobilier pour que je m'assure lors d'un pret realisé aupres dune banque
//si l’on souhaite avoir une idée précise du futur montant de ses mensualités, mais aussi du coût global de son assurance
//Calculer le coût de son assurance emprunteur offre aussi d’autres avantages : cela permet, entre autres, 
//d’ajuster son budget et d’anticiper le coût total de son crédit immobilier, assurance emprunteur comprise.


//  http://localhost:8000/SpringMVC/servlet/creditsimul//0/
@GetMapping("/creditsimul/{idU}/{idC}/{emprunt}")
@ResponseBody
public float creditsimul( @PathVariable("idU") Long idU , @PathVariable("idC") Long idC, @PathVariable("emprunt") float emprunt)  {
	float k = 0 ;
	k = (float) sr.CreditSimulator(idU, idC,emprunt) ; 
	return k ;

}



/////////////////////////////////////JOINTURE
//  http://localhost:8000/SpringMVC/servlet/FindSinistreDescription/1
@GetMapping("/FindSinistreDescription/{idC}")
@ResponseBody
public List<Sinistre> findSinisterfromClaim(@PathVariable("idC") Long id)
{ 
	List<Sinistre> k = sr.findSinisterfromClaim(id);
	return k;

}




}