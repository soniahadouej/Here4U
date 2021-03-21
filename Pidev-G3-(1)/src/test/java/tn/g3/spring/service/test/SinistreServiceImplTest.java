package tn.g3.spring.service.test;
import java.io.File;
import java.text.ParseException;   
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test; 
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.event.EventListener;
import org.springframework.test.context.junit4.SpringRunner;

import tn.g3.spring.entity.Sinistre;
import tn.g3.spring.entity.SinisterStatus;
import tn.g3.spring.entity.SinisterType;
import tn.g3.spring.service.ISinistreSerivce;

import org.junit.Assert;


@RunWith(SpringRunner.class)
@SpringBootTest

public class SinistreServiceImplTest { 
	@Autowired 
	ISinistreSerivce is;
	File file = new File("C:\\Users\\Sonia\\Desktop\\11.jpg");


	/*@Test
	public void testRetrieveAllSinistres() {
		List<Sinistre> sinistres = is.retrieveAllSinistres() ;
		//Assert.assertEquals(1, sinistres.size()); }
	} 
	@Test
	public void testAddSinistre() throws ParseException    {
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		Date d = dateFormat.parse("2021-03-18");
		Sinistre s = new Sinistre (SinisterType.Santé,"Mysec sinistre",d,SinisterStatus.EnAttente, file );
		Sinistre sinistreAdded = is.addSinistre(s);
		Assert.assertEquals(s.getIdSinistre(), sinistreAdded.getIdSinistre());

	} */
	
	/*

	@Test
	public void testUpdateSinistre() throws ParseException    {
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		Date d = dateFormat.parse("2021-03-19");
		Sinistre s = new Sinistre (2L, TypeSinistre.VIE, "My first sinistre MODIFIED AGAIN",d, Status.En_Cous, null );
		Sinistre sinistreUpdated = is.updateSinistre(s);
		Assert.assertEquals(s.getDescription(), sinistreUpdated.getDescription());

	} 


	@Test
	public void testRetrieveSinistre() {
		Sinistre sinistre = is.retrieveSinistre("5"); 
		//Assert.assertEquals(5L,sinistre.getIdSinistre().longValue());
	} 
	 */
	/* @Test
	public void testDeleteSinistre() {

		is.deleteSinistre("1");
	}

	 */

	//RECHERCHES
	@Test
	public void testGetMax() {

		Long l = is.getMax();
	} 


	@Test
	public void testfindByDescription() {

		List<Sinistre> sinistres = is.findByDescription("my") ;

	} 

	@Test
	public void testfindByYear() {

		List<Sinistre> sinistres = is.findByYear("2018") ;

	} 

	@Test
	public void testfindByAny() {

		List<Sinistre> sinistres = is.findByAny("2018") ;

	} 


	//update
	//@Test
	/*public String testUpdateStatus (Long id, String newStatus){
		is.updateStatus(3L,"neww");
		 return "ggg";
	} */

	///////////////////////////////////////////////////
	
	/*@Test
	public void testStatus() {
		is.CheckStatus();	
	}
*/
	@Test
	public void testSendMail() {
		is.SendMail();
	}
	 
}







