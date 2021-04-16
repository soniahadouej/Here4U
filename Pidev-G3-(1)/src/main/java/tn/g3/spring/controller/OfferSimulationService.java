package tn.g3.spring.controller;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.g3.spring.service.IOfferSimulationService;

@RestController

public class OfferSimulationService {

	@Autowired
	IOfferSimulationService offerSimulationService;

	// http://localhost:8080/SpringMVC/servlet/calculate-gift/{contract-id}
	@GetMapping(value = "calculate-gift/{contract-id}")
	@ResponseBody
	public float calculateGift (@PathVariable("contract-id") Long idc ) throws ParseException {

		return offerSimulationService.calculateGift(idc);
	}

	// http://localhost:8080/SpringMVC/servlet/calculate-discount/{contract-id}
	@GetMapping(value = "calculate-discount/{contract-id}")
	@ResponseBody
	public float calculateDiscount (@PathVariable("contract-id") Long idc ) {

		return offerSimulationService.calculateDiscount(idc);
	}

	// http://localhost:8080/SpringMVC/servlet/calculate-loyalty/{contract-id}
	@GetMapping(value = "calculate-loyalty/{contract-id}")
	@ResponseBody
	public float calculateLoyalty (@PathVariable("contract-id")Long idc ) {

		return offerSimulationService.calculateLoyalty(idc);
	}

	// http://localhost:8080/SpringMVC/servlet/calculate-score/{contract-id}
	@GetMapping(value = "calculate-score/{contract-id}")
	@ResponseBody
	public float calculateScore (@PathVariable("contract-id")Long idc ) {

		return offerSimulationService.calculateLoyalty(idc);
	}

}
