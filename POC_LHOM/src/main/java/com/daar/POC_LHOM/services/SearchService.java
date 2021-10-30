package com.daar.POC_LHOM.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daar.POC_LHOM.document.CV;
import com.daar.POC_LHOM.repository.CVRepository;


//Business rules layer
@Service
public class SearchService {

	@Autowired
	private final CVRepository repository;

	@Autowired
	public SearchService(CVRepository repository) {
		this.repository = repository;
	}
	
	public void save(final CV cv) {
		repository.save(cv);
	}
	
	    
}
