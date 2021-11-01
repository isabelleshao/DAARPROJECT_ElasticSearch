package com.daar.POC_LHOM.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.daar.POC_LHOM.model.CV;
import com.daar.POC_LHOM.services.SearchService;
import java.util.List;



@RestController
@RequestMapping("/CV")
@Api(value = "CV treatment")
@Slf4j
public class CvController {

	@Autowired
	private SearchService service;


	@ApiOperation(value = "Save CV")
	@PostMapping
	public void save(@RequestBody CV cv) {
		log.info("Save Cv is starting");
		service.save(cv);
	}

	@ApiOperation(value = "Delete CV")
	@DeleteMapping("/{id}")
	public void deleteCv(@PathVariable String id) {
		log.info("Delete Cv is starting");
		service.deleteCv(id);
	}

	@ApiOperation(value = "Returns a list of Cv")
	@GetMapping("/List/FromTo")
	public ResponseEntity<List<CV>> getCvFromTo(@RequestParam int from,@RequestParam  int to) {
		log.info("Getting Cv from to is starting");
		return ResponseEntity.ok(service.getCvFromTo(from, to));
	}

	@ApiOperation(value = "BLA")
	@GetMapping("/List/Tag")
	public ResponseEntity<List<CV>> getCvTag(@RequestParam String tag) {
		log.info("Getting Tag is starting");
		return ResponseEntity.ok(service.getCvTag(tag));
	}

	@ApiOperation(value = "Returns All Cvs")
	@GetMapping("/List")
	public ResponseEntity<List<CV>> getCvAll() {
		log.info("Getting All Cv is starting");
		return ResponseEntity.ok(service.getCvAll());
	}

	@ApiOperation(value = "Returns Cv using FirstName")
	@GetMapping("/List/FirstName")
	public ResponseEntity<List<CV>> getCvFirstName(@RequestParam String firstName) {
		log.info("Getting Cv By First Name is starting");
		return ResponseEntity.ok(service.getCvFirstName(firstName));
	}

	@ApiOperation(value = "Returns Cv using FamilyName")
	@GetMapping("/List/FamilyName")
	public ResponseEntity<List<CV>> getCvFamilyName(@RequestParam String familyName) {
		log.info("Getting Cv By Family Name is starting");
		return ResponseEntity.ok(service.getCvFamilyName(familyName));
	}

	@ApiOperation(value = "Returns Cvs which contain a specific word")
	@GetMapping("/List/ContainingWords")
	public ResponseEntity<List<CV>> searchCVByKeyWord(@RequestParam String word) {
		log.info("Getting Cvs which contain a specific word is starting");
		return ResponseEntity.ok(service.searchCVByKeyWord(word));
	}

	@ApiOperation(value = "Create Profile")
	@PostMapping("/CreateProfile")
	public void createProfile(@RequestParam MultipartFile file,@RequestParam  String familyName, @RequestParam String firstName,@RequestParam String email,@RequestParam  String phoneNumber){
		log.info("Create Profile is starting");
		service.saveCVFromFile(file, familyName, firstName, email,phoneNumber);
	}
}
