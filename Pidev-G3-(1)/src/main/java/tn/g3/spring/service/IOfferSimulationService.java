package tn.g3.spring.service;
import java.text.ParseException;
public interface IOfferSimulationService {
	
	float calculateGift(Long idc ) throws ParseException;
	float calculateDiscount(Long idc);
	float calculateLoyalty(Long idc);
	double calculateScore(Long idc);

}
