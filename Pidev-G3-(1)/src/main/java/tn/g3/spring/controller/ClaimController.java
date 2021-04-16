package tn.g3.spring.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.g3.spring.entity.Claim;
import tn.g3.spring.entity.ClaimType;
import tn.g3.spring.repository.ClaimRepository;

@CrossOrigin(origins = "http://localhost:8088")
@RestController
@RequestMapping("/api")

public class ClaimController {

	@Autowired
	ClaimRepository claimRepository;

	@GetMapping("/claims")
	public ResponseEntity<List<Claim>> getAllClaims(@RequestParam(required = false) ClaimType categoryClaim) {
		try {
			List<Claim> claims = new ArrayList<Claim>();

			if (categoryClaim == null)
				claimRepository.findAll().forEach(claims::add);
			else
				claimRepository.findBycategoryClaim(categoryClaim).forEach(claims::add);

			if (claims.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(claims, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/claims/{id}")
	public ResponseEntity<Claim> getClaimById(@PathVariable("id") long id) {
		Optional<Claim> claimData = claimRepository.findById(id);

		if (claimData.isPresent()) {
			return new ResponseEntity<>(claimData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/claims")
	public ResponseEntity<Claim> createClaim(@RequestBody Claim claim) {
		try {
			Claim _claim = claimRepository
					.save(new Claim(claim.getCategoryClaim(), claim.getDescriptionClaim(),claim.getDateClaim(), false));
			return new ResponseEntity<>(_claim, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/claims/{id}")
	public ResponseEntity<Claim> updateClaim(@PathVariable("id") long id, @RequestBody Claim claim) {
		Optional<Claim> claimData = claimRepository.findById(id);

		if (claimData.isPresent()) {
			Claim _claim = claimData.get();
			_claim.setCategoryClaim(claim.getCategoryClaim());
			_claim.setDescriptionClaim(claim.getDescriptionClaim());
			_claim.setStatusClaim(claim.isStatusClaim());
			return new ResponseEntity<>(claimRepository.save(_claim), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/claims/{id}")
	public ResponseEntity<HttpStatus> deleteClaim(@PathVariable("id") long id) {
		try {
			claimRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/claims")
	public ResponseEntity<HttpStatus> deleteAllClaims() {
		try {
			claimRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/claims/statusClaim")
	public ResponseEntity<List<Claim>> findBystatusClaim() {
		try {
			List<Claim> claims = claimRepository.findBystatusClaim(true);

			if (claims.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(claims, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}







}
