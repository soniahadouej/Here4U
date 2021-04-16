package tn.g3.spring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.g3.spring.entity.CivilStatus;
import tn.g3.spring.entity.Client;
import tn.g3.spring.entity.Contract;
import tn.g3.spring.entity.Product;
import tn.g3.spring.entity.ProductType;
import tn.g3.spring.repository.ContractOfferRepository;
import tn.g3.spring.repository.ContractRepository;
import tn.g3.spring.repository.OfferRepository;
import tn.g3.spring.repository.OfferSimulationRepository;

@Service
public class OfferSimulationServiceImpl implements IOfferSimulationService {

	@Autowired
	ContractOfferRepository contractOfferRepository;

	@Autowired
	OfferRepository offerRepository;

	@Autowired
	ContractRepository contractRepository;

	@Autowired
	OfferSimulationRepository offerSimulationRepository;

	private static final Logger L= LogManager.getLogger(OfferSimulationServiceImpl.class);



	@Override
	public float calculateGift(Long idc) throws ParseException {
		Contract contract= contractRepository.findById(idc).orElse(null);
		Client client = offerSimulationRepository.getClientFromContract(idc);
		Long idcl = client.getIdPerson();
		int age = client.getAge();
		Date startDate = client.getStartDate();
		SimpleDateFormat dateFormat= new SimpleDateFormat("MM-dd");
		Date d1 = dateFormat.parse("01-01");
		Date d2 = dateFormat.parse("24-12");
		Date d3 = dateFormat.parse("26-11");
		CivilStatus category= client.getCategory();
		int nbContracts = offerSimulationRepository.countClientContracts(idcl);
		float gift = 0;
		float premium= contract.getpremiumContract();


		if (nbContracts>3){
			if(category.equals(CivilStatus.Married)){
				if (age<25){
					if(startDate.equals(d1)||startDate.equals(d2)||startDate.equals(d3) ){
						gift= (float) (premium * 0.14)+25;
					}
					else gift= (float) (premium * 0.14);
				}
				else if (25<age && age<50){
					if(startDate.equals(d1)||startDate.equals(d2)||startDate.equals(d3) ){
						gift= (float) (premium * 0.12)+25;
					}
					else gift= (float) (premium * 0.12);
				}
				else if (age>50 ){
					if(startDate.equals(d1)||startDate.equals(d2)||startDate.equals(d3) ){
						gift= (float) (premium * 0.10)+25;
					}
					else gift= (float) (premium * 0.10);
				}
			}
			if(!category.equals(CivilStatus.Married)){
				if (age<25){
					if(startDate.equals(d1)||startDate.equals(d2)||startDate.equals(d3) ){
						gift= (float) (premium * 0.07)+25;
					}
					else gift= (float) (premium * 0.07);
				}
				else if (25<age && age<50){
					if(startDate.equals(d1)||startDate.equals(d2)||startDate.equals(d3) ){
						gift= (float) (premium * 0.06)+25;
					}
					else gift= (float) (premium * 0.06);
				}
				else if (age>50){
					if(startDate.equals(d1)||startDate.equals(d2)||startDate.equals(d3) ){
						gift= (float) (premium * 0.05)+25;
					}
					else gift= (float) (premium * 0.05);
				}
			}
		}

		else{
			if(category.equals(CivilStatus.Married)){
				if (age<25){
					if(startDate.equals(d1)||startDate.equals(d2)||startDate.equals(d3) ){
						gift= (float) (premium * 0.10)+25;
					}
					else gift= (float) (premium * 0.10);
				}
				else if (25<age && age<50){
					if(startDate.equals(d1)||startDate.equals(d2)||startDate.equals(d3) ){
						gift= (float) (premium * 0.08)+25;
					}
					else gift= (float) (premium * 0.08);
				}
				else if (age>50 ){
					if(startDate.equals(d1)||startDate.equals(d2)||startDate.equals(d3) ){
						gift= (float) (premium * 0.06)+25;
					}
					else gift= (float) (premium * 0.06);
				}
			}
			if(!category.equals(CivilStatus.Married)){
				if (age<25){
					if(startDate.equals(d1)||startDate.equals(d2)||startDate.equals(d3) ){
						gift= (float) (premium * 0.05)+25;
					}
					else gift= (float) (premium * 0.05);
				}
				else if (25<age && age<50){
					if(startDate.equals(d1)||startDate.equals(d2)||startDate.equals(d3) ){
						gift= (float) (premium * 0.04)+25;
					}
					else gift= (float) (premium * 0.04);
				}
				else if (age>50){
					if(startDate.equals(d1)||startDate.equals(d2)||startDate.equals(d3) ){
						gift= (float) (premium * 0.03)+25;
					}
					else gift= (float) (premium * 0.03);
				}
			}

		}
		L.info("GIFT+++++++++ =" + gift) ;
		return gift;
	} 


	@Override
	public float calculateDiscount(Long idc) {
		Contract contract= contractRepository.findById(idc).orElse(null);
		offerSimulationRepository.getClientFromContract(idc);
		Product p = offerSimulationRepository.getProductFromContract(idc);
		ProductType categoryProduit = p.getProductType();  
		float discount = 0;														   
		float premium= contract.getpremiumContract();
		double score = calculateScore(idc);

		if (categoryProduit.equals(ProductType.AUTO)){
			discount= (float) ( premium*(1-(score+0.02)));
		}
		else if (categoryProduit.equals(ProductType.CAPITALISATION)){
			discount= (float) (premium*(score+0.02));
		}
		else if(categoryProduit.equals(ProductType.RENTEVIAGIAIRE)){
			discount= (float) (premium*(score+0.03));
		}
		else if(categoryProduit.equals(ProductType.SANTE)){
			discount= (float) (premium*(score+0.04));
		}
		else{
			discount= (float) (premium*(score+0.05));
		}
		L.info("DISCOUNT+++++++++ =" + discount) ;
		return discount;
	}


	@Override
	public float calculateLoyalty(Long idc) {
		Contract contract= contractRepository.findById(idc).orElse(null);
		Client client = offerSimulationRepository.getClientFromContract(idc);
		offerSimulationRepository.getProductFromContract(idc);
		Calendar currentdate = Calendar.getInstance();
		Date startDate = client.getStartDate();
		Date d1= currentdate.getTime();
		float diff = (float) (d1.getTime()- startDate.getTime());
		float loyalty = 0;														   
		float premium= contract.getpremiumContract();
		double score = calculateScore(idc);
		if( diff > 5){
			loyalty= (float) (premium*(score+0.14));
			}
		else if (2<diff && diff<5){
			loyalty= (float) (premium*(score+0.08));
		}
		else{
			loyalty= (float) (premium*(score+0.02));
		}
		L.info("LOYALTY+++++++++ =" + loyalty) ;
		return loyalty;
	} 


	@Override
	public double calculateScore(Long idc) {
		contractRepository.findById(idc).orElse(null);
		Client client = offerSimulationRepository.getClientFromContract(idc);
		Long idcl = client.getIdPerson();
		int nbContracts = offerSimulationRepository.countClientContracts(idcl);  
		int nbSinistres = offerSimulationRepository.countClientSinistres(idcl);
		int age = client.getAge();
		float noteContract=0;
		float noteSinistre=0;
		float noteAge=0;
		float score=0;

		if(nbContracts>3){noteContract=16/20;}
		else if(1<nbContracts && nbContracts<3){noteContract=18/20;}
		else{noteContract=20/20;};

		if(nbSinistres>5){noteSinistre=20/20;}
		else if(1<nbSinistres && nbSinistres<5){noteSinistre=18/20;}
		else{noteSinistre=16/20;};

		if(age<25){noteAge=20/20;}
		else if(25<age && age<50){noteAge=18/20;}
		else{noteAge=16/20;};

		score= 30% noteContract+ 50% noteSinistre + 20% noteAge;

		L.info("SCORE+++++++++ =" + score) ;
		return score;
	}







}
